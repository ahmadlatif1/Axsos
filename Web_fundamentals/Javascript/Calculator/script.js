console.log("script loaded")
var nums = [0]
var isdecimal = false
var afterOperator = false
var operator = "+"
var currentnum = 0
function press(num) {


    if (num === '.') {
        isdecimal = true
        displaynum(currentnum += num)

    } else if (isdecimal) {
        nums[nums.length - 1] = Number(nums[nums.length - 1] + '.' + num)
        isdecimal = false
        displaynum(nums[nums.length - 1])
    } else
        if (!afterOperator) {
            nums[nums.length - 1] = Number(nums[nums.length - 1] + '' + num)
            displaynum(nums[nums.length - 1])

        } else {
            
            nums.push(num)
            afterOperator = false

            displaynum(nums[0] + operator + nums[1])

        }

}

function setOp(op) {

    if(nums.length==2){
        calculate()
    }
    nums[0]=currentnum
    operator = op;
    afterOperator = true;
    displaynum(nums[0] + op)
}


function calculate() {
    var toshow
    switch (operator) {
        case '/': displaynum(Number((nums[0] / nums[1]).toFixed(6)));
            break;
        case '*': displaynum(Number((nums[0] * nums[1]).toFixed(6)));
            break;
        case '-': displaynum(Number((nums[0] - nums[1]).toFixed(6)));
            break;
        case '+': displaynum(Number((nums[0] + nums[1]).toFixed(6)));
            break;
    }

    nums = [0]

}
function clr() {
    nums = [0]
    displaynum(0)
    isdecimal = false
    afterOperator = false
    operator = "+"

}

function displaynum(input) {

    currentnum = input

    document.getElementById("display").innerText = currentnum
}