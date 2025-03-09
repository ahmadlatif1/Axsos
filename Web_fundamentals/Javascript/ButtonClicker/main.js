
function login(element){
    element.value=="login"? element.value="logout" : element.value="login"
}

function definition(element){
    element.style.display="none"
}

function like(element){
    element.value=Number(element.value.split(" ")[0])+1+" likes"
    alert("ninja was liked  ")
}