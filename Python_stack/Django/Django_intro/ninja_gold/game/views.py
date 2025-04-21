

from random import Random
from django.shortcuts import render

class Location():

    def __init__(self,name='place',gold={'min':1,'max':10},exp=0,difficulty=0,isquest=False):
        self.name=name
        self.gold=gold # min,max
        self.exp=exp
        self.difficulty=difficulty
        self.isquest=isquest
        

    def get_gold(self):
        rand=Random()
        return rand.randint(self.gold['min'],self.gold['max'])
    
    def get_exp(self):
        rand=Random()
        return rand.randint(self.exp,self.exp+5)
    
    
    def fight(self,player):
        rand=Random()
        if rand.randint(0,(self.difficulty)+player.diff)>player.level:
            if self.isquest:
                return {'gold':player.gold*-1,'exp':0}
            return {'gold':(self.get_gold()*player.area)*-1,'exp':  0} # level fail
        else:
            return {'gold':(self.get_gold()*player.area),'exp':self.get_exp()*player.area} # level win
        

    def getdiff(self,player):
        return self.difficulty+(player.area*5)
        
    

class Player():

    def __init__(self,gold=0,level=1,exp=0,area=1,missionlog=[]):
        self.gold=gold
        self.level=level
        self.exp=exp
        self.area=area
        self.missionlog=missionlog
        self.diff=self.diff=(5*(self.area-1))


    

    def addExp(self,exp):
        margin=100 + (self.level*100)
        self.exp+=exp
        if self.exp>margin:

            if self.level<self.area*5:
                self.exp-=margin
                self.level+=1
                self.missionlog.insert(0,{'success':False,'message':f"You've leveled up to Level {self.level}!"})
            else:
                self.exp=margin

    
    def fightmission(self,location):
        fightresult=location.fight(self)
        print("fightresult",fightresult)
        newgold=fightresult['gold']
        newexp=fightresult['exp']

        if location.isquest:
            if newgold>=0:
                self.area+=1
                self.missionlog.insert(0,{'success':True,'message':(f"You completed a {location.name} and earned {newgold} Gold and {newexp} EXP !")})
                self.missionlog.insert(0,{'success':False,'message':f"You've reached area {self.area}. prepare for harder battles!"})

            else:
                if self.area >1: 
                    self.area-=1
                    self.missionlog.insert(0,{'success':False,'message':f"You've gone down to area {self.area}. maybe level up first!?"})
                self.missionlog.insert(0,{'success':False,'message':(f"You failed a {location.name} and LOST {newgold} Gold and {newexp} EXP !")})
        else:
            if newgold>0:
                self.missionlog.insert(0,{'success':True,'message':(f"You entered a {location.name} and earned {newgold} Gold and {newexp} EXP !")})
            else:
                self.missionlog.insert(0,{'success':False,'message':(f"You failed in {location.name} and LOST {newgold} Gold and {newexp} EXP !")})

        self.diff=(5*(self.area-1))
        self.gold+=newgold
        self.addExp(newexp)

            

def index(request):

    player=Player()
    locations=[
            Location(name='Farm',gold={'min':5,'max':10},difficulty=1,exp=5),
            Location(name='Cave',gold={'min':1,'max':20},difficulty=2,exp=20),
            
            Location(name='House',gold={'min':5,'max':30},difficulty=4,exp=30),
            Location(name='Quest',gold={'min':10,'max':20},difficulty=5,exp=100,isquest=True),
    ]

    if 'player' not in request.session:
        request.session['player']={
            'gold':player.gold,
            'level':player.level,
            'area':player.area,
            'exp':player.exp,
            'missionlog':player.missionlog,
            'diff':player.diff
        }
    elif 'player' in request.session:
        info=request.session['player']
        player=Player(info['gold'],info['level'],info['exp'],info['area'],info['missionlog'])

    
    if request.method=="POST":
        for level in locations:
            if request.POST['placename'] == level.name:
                player.fightmission(level)
    

    context={
        'player':player,
        'locations':locations,
    }
    request.session['player']={
            'gold':player.gold,
            'level':player.level,
            'area':player.area,
            'exp':player.exp,
            'missionlog':player.missionlog,
            'diff':player.diff
    }
    return render(request,'index.html',context)

