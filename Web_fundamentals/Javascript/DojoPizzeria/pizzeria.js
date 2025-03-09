function pizzaOven(dough,sauce,cheeses,toppings ){
    return {
        "dough":dough,
        "sauce":sauce,
        "cheeses":cheeses,
        "toppings":toppings
    }
}

function printPizza(pizza){
    result="A "+pizza.dough+" Pizza with "+pizza.sauce+" sauce, with "+pizza.cheeses.toString().replaceAll(","," and ")+" cheese, and with "+pizza.toppings.toString().replaceAll(",",", ")+". Ready for pickup!"
    console.log(result)
}



function randomPizza(){

    function getRandomInt(max) {
        return Math.floor(Math.random() * max);
    }

    doughs=["Sourdough","Shortbread","Deep-dish","Hand-tossed","Bread","Puff pastry","Pita","Crepe","flatbread","Baguette","Stuffed Crust"]
    sauces=["Marinara","Traditional","BBQ","Alfredo","Bolognese","Raw tomato","Ketchup"]
    cheeses=["Mozzarella","Low-fat Mozzarella","cheddar","Feta","Gouda","Provolone","Halloumi","Vegan alternative"]
    toppings=["Sausage","Nduja Sausage","Tomato Slices","Onion slices","Pepperoni","Salami","Olives","Mushroom","Basil","Pesto","Cold Mozzarella","Pineapple","Zucchini","Chicken"]


    doughPick=doughs[getRandomInt(doughs.length-1)]
    saucePick=sauces[getRandomInt(sauces.length-1)]
    cheeseNumber=getRandomInt(4)
    cheesePick=[]
    for(i=0;i<cheeseNumber;i++){
        cheesePick.push(cheeses[getRandomInt(cheeses.length)])
    }
    toppingNumber=getRandomInt(5)
    toppingsPick=[]
    for(i=0;i<toppingNumber;i++){
        toppingsPick.push(toppings[getRandomInt(toppings.length-1)])
    }
    return pizzaOven(doughPick,saucePick,cheesePick,toppingsPick)
}


printPizza(pizzaOven("Deep-dish", "Traditional", ["Mozzarella"], ["Pepperoni", "Sausage"]))
printPizza(pizzaOven("Hand tossed", "Marinara", ["Mozzarella", "Feta"], ["Mushroom", "Olives", "Onions"]))

printPizza(pizzaOven("Potato", "Ground Beef", ["Cheddar"],["Mushroom","Peas","Carrots"])) //is a shepherds pie close enough
printPizza(pizzaOven("Sourdough","Marinara",["Low-fat Mozzarella","Paremsan"],["Mushroom","Jalapeno","Sausage","Onion"]))

printPizza(randomPizza())