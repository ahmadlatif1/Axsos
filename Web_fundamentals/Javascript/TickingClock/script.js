function getSecondsSinceStartOfDay() {
    return new Date().getSeconds() + 
      new Date().getMinutes() * 60 + 
      new Date().getHours() * 3600;
}

second=0
minute=0    
hour=0

secondAngle=0
minuteAngle=0
hourAngle=0

setInterval( function() {
    var time = getSecondsSinceStartOfDay();
    console.log(time);
    // your code here


    setAngles()

}, 1000);

function setAngles(){
    d=new Date()

    secondAngle=(d.getSeconds())*6
    minuteAngle=d.getMinutes()*6
    hourAngle=d.getHours()*15
    
    document.getElementById("seconds").style.transform = `rotate(${secondAngle}deg)`;
    document.getElementById("minutes").style.transform = `rotate(${minuteAngle}deg)`;
    document.getElementById("hour").style.transform = `rotate(${hourAngle}deg)`;

}
