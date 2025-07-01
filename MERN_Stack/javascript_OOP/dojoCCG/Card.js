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

        console.log("\n"+this.name+" attacks "+target.name+" with "+this.power+" power!")
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
        console.log("\napplied "+this.name+" on "+target.name+"!")
        console.log("before: resilience:"+target.resilience+", power: "+target.power)
        target.resilience+=this.resilienceEffect;
        target.power+=this.powerEffect;
        console.log("after: resilience:"+target.resilience+", power: "+target.power)
    }


}

redninja=new Unit("Red belt ninja",3,4,3)
blackninja=new Unit("Black belt ninja",4,4,5)


hardalgo=new Effect("Hard Algorithm",2,3)
promisereject=new Effect("Unhandled Promise Rejection",1,-2)
pairprogram=new Effect("Pair Programming",3,0,2)



hardalgo.play(redninja)

promisereject.play(redninja)

pairprogram.play(redninja)

redninja.attack(blackninja)
