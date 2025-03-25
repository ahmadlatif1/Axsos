def Countdown(num):
    arr =[]
    for i in range(num, -1,-1):
        arr.append(i)
    return arr


print(Countdown(8))

def print_return(arr):
    print(arr[0])
    return arr[1]

print(print_return([4,6]))

def first_plus_length(arr):
    return arr[0]+len(arr)

print(first_plus_length([1,2,3,4,5]))

def values_greater_than_second (arr):
    
    result=[]
    for x in arr:
        if x >arr[1]:
            result.append(x)
    print(len(result))
    return result

print(values_greater_than_second([5,2,3,2,1,4]))

def this_length_that_value(size,value):
    result=[]
    for x in range(size):
        result.append(value)

    return result

print(this_length_that_value(4,7))
