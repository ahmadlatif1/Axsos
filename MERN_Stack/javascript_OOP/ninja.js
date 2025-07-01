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
        else health++
    }

}

new Ninja("john").showStats()