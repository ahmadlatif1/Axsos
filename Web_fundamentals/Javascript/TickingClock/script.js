
setInterval( function() {
    
    setAngles()

}, 1000);

function setAngles(){
    d=new Date()

    secondAngle=((d.getSeconds())*6)+180
    minuteAngle=(d.getMinutes()*6)+180
    hourAngle=d.getHours()*15
    
    document.getElementById("seconds").style.transform = `rotate(${secondAngle}deg)`;
    document.getElementById("minutes").style.transform = `rotate(${minuteAngle}deg)`;
    document.getElementById("hour").style.transform = `rotate(${hourAngle}deg)`;

}
