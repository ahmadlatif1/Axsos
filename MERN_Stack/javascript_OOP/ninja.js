class Ninja{


    constructor(name,strength=3,speed=3,health=100){
        this.name=name
        this.speed=speed
        this.strength=strength
        this.health=health
    }

    sayName=()=> {
        console.log(this.name)
    }
    showStats=()=> {
        console.log(this)
    }
    
    drinkSake=()=> {
        if(health+10>100)
            health=100;
        else health+=10
    }

}

class Sensei extends Ninja{

    constructor(name,strength=10,speed=10,health=200,wisdom=10){
        this.name=name
        this.speed=speed
        this.strength=strength
        this.health=health
        this.wisdom=10
    }

    drinkSake=()=> {
        if(health+10>200)
            health=200;
        else health+=10
    }

    speakWisdom=()=> {
        this.drinkSake()
        console.log("i think hamburger goes well with fries")
        this.wisdom++
    }


}

new Ninja("john").showStats()