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

    operator = op;
    afterOperator = true;
    displaynum(nums[0] + op)
}


function calculate() {

    switch (operator) {
        case '/': displaynum((nums[0] / nums[1]).toFixed(6));
            break;
        case '*': displaynum(nums[0] * nums[1]);
            break;
        case '-': displaynum(nums[0] - nums[1]);
            break;
        case '+': displaynum(nums[0] + nums[1]);
            break;
    }

    nums = [0]

}
function clr() {
    nums = [0]
    displaynum(0)
}

function displaynum(input) {

    currentnum = input

    document.getElementById("display").innerText = currentnum
}