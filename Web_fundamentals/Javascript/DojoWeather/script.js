
currtemp="c"
function changeTemp(element){
    arrnums=document.querySelectorAll(".tempNum")

    for(i=0;i<arrnums.length;i++){
        num=arrnums[i].textContent

        if(currtemp=="c"&&element.value=="f"){
            num=celsiusToFahrenheit(num)
        }   else
        if(currtemp=="f"&&element.value=="c"){
            num=fahrenheitToCelsius(num)
        }
        arrnums[i].textContent=num
    }
    currtemp=element.value
}

function celsiusToFahrenheit(cDegrees){
    return Math.round((cDegrees * 9.0 / 5.0) + 32.0)
}
function fahrenheitToCelsius(fDegrees){
    return Math.round((fDegrees-32)*(5/9))
}

function closecookie(){
    document.getElementById("cookie").remove()
}