function search(id){

    alert(    document.getElementById(id).value)
}

function join(element,enter){

    if(enter){
        element.style.color='#e0554b';
        element.style.background="white";
    } else{
        element.style.color='white';
        element.style.background="#e0554b";
    }
    
    console.log("color change?")
    
    
}

function sound(id){
    document.getElementById(id).play()
}