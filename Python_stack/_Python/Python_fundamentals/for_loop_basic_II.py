def biggie_size(arr):
    
    for i, e in enumerate(arr):
        if(e>=0):
            arr[i]="big"

    

    return(arr)

print(biggie_size([-1,2,3,4,43])) 

def count_positives(arr):
    positives=0
    for e in arr:
        if e>0:
            positives+=1
    arr[len(arr)-1]=positives
    return arr

print(count_positives([1,6,-4,-2,-7,-2]))

def sum_total(arr):
    sum=0
    for e in arr:
        sum+=e
    return sum

print(sum_total([1,2,3,4,5,6]))

def average(arr):
    num=0
    for e in arr:
        num+=e
    return num/len(arr)

print(average([1,2,3,4,5,6]))

def Length(arr):
    return len(arr)

print(Length([12,3,12,412,4,4,134,1,4,13]))

def minimum(arr):

    num=arr[0]
    for e in arr:
        if e<num:
            num=e

    return num

print(minimum([2,3,5,1,2,5,9,0]))

def maximum(arr):

    num=arr[0]
    for e in arr:
        if e>num:
            num=e

    return num

print(maximum([2,3,5,1,2,5,9,0]))

def ultimate_analysis(arr):
    return{
        'sumtotal':sum_total(arr),
        'average':average(arr),
        'minimum':minimum(arr),
        'maximum':maximum(arr),
        'length':Length(arr)
    }

print(ultimate_analysis([37,2,1,-9]))

def reverse_list(arr):
    res =[]
    for i in range(len(arr), 0,-1):
        res.append(i)
    return res

print(reverse_list([1,2,3,4,5]))