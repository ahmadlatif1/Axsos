function alwayshungry(arr) {
    var nofood = true
    for (i = 0; i < arr.length; i++) {
        if (arr[i] == "food") {
            nofood = false
            console.log("yummy");
        }
    }
    if (nofood) {
        console.log("im hungry")
    }
}


function highPass(arr, cutoff) {
    var filteredArr = [];
    for (i = 0; i < arr.length; i++) {
        if (arr[i] > cutoff) {
            filteredArr.push(arr[i])
        }

    }

    return filteredArr;
}




function betterThanAverage(arr) {
    var sum = 0;
    var count = 0;
    for (i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    sum = sum / arr.length;
    for (i = 0; i < arr.length; i++) {
        if (arr[i] > sum) {
            count++;
        }

    }

    return count;
}



function reverse(arr) {
    var revarray = []
    for (i = arr.length-1; i >= 0; i--) {
        revarray.push(arr[i])
    }
    return revarray;
}


function fibonacciarray(n){
    var fibarr=[0,1];
    for(i=2;i<n;i++){
        fibarr.push((fibarr[i-1]+fibarr[i-2]))

    }
    return fibarr;
}







alwayshungry([3.14, "food", "pie", true, "food"]);


alwayshungry([4, 1, 5, 7, 2]);


console.log("high pass is " + highPass([6, 8, 3, 10, -2, 5, 9], 5));



console.log(" better than average " + betterThanAverage([6, 8, 3, 10, -2, 5, 9]));


console.log("reverse"+reverse([1, 2, 3, 4, 5]));

console.log(fibonacciarray(10));
