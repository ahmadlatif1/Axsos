class Card{

    constructor(name,cost){
        this.name=name
        this.cost=cost
    }
}

class Unit extends Card{

    constructor(name,cost, resilience,power){
        super(name,cost)
        this.resilience=resilience
        this.power=power
    }

    attack(target){
        if(!(target instanceof Unit))throw new Error("Target must be a unit!")

        console.log(this.name+" attacks "+target.name+" with "+this.power+" power!")
        console.log("before: resilience:"+target.resilience+", power: "+target.power)
        target.resilience-=this.power;
        console.log("after: resilience:"+target.resilience+", power: "+target.power)

    }

}

class Effect extends Card{


    constructor(name,cost=0, resilienceEffect=0,powerEffect=0){
        super(name,cost)
        this.resilienceEffect=resilienceEffect
        this.powerEffect=powerEffect
        
    }

    getDescription(){
        message=""
        if(this.powerEffect<0)message+="decrease the target's power by"+this.powerEffect+".\n"
        if(this.powerEffect>0)message+="increase the target's power by"+this.powerEffect+".\n"

        if(this.resilienceEffect<0)message+="decrease the target's resilience by"+this.resilienceEffect+".\n"
        if(this.resilienceEffect>0)message+="increase the target's resilience by"+this.resilienceEffect+".\n"

    }

    play(target) {
        
        if(!(target instanceof Unit))throw new Error("Target must be a unit!")
        console.log("applied "+this.name+" on "+target.name+"!")
        console.log("before: resilience:"+target.resilience+", power: "+target.power)
        target.resilience+=this.resilienceEffect;
        target.power+=this.powerEffect;
        console.log("after: resilience:"+target.resilience+", power: "+target.power)
    }


}

orc=new Unit("orc",1,5,4)
trebuchet=new Unit("trebuchet",1,2,12)
goblin=new Unit("goblin",1,2,2)

resbuff=new Effect("resilience buff",1,1)
powerbuff=new Effect("power buff",1,0,1)

poison=new Effect("poison debuff",1,-1)
weakness=new Effect("weakening debuff",1,0,-1)


resbuff.play(trebuchet)

goblin.attack(trebuchet)