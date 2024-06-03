
def getTotalX(a, b):
    st = a[-1]
    end = b[0]
    lcmA = 1
    for i in a:
        lcmA = lcmA*i//math.gcd(lcmA, i)

    step1 = []
    for num in range(st, end+1):
        if num % lcmA == 0:
            step1.append(num)
    
    
    count = 0
    for ele in step1:
        mylist = []
        for num in b:
            mylist.append(num % ele == 0)
        x = all(mylist)
        if x is True:
            count += 1
    
    return count
  
