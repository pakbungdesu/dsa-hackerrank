
def kaprekarNumbers(p, q):
    res = []
    for ele in range(p, q+1):
        sqr = str(ele * ele)
    
        d = math.floor(len(sqr)/2)
        try:
            left = int(sqr[:d])
            right = int(sqr[d:])
        except:
            left = int(sqr)
            right = 0
    
        if left + right == ele:
            res.append(ele)
    
    if len(res) == 0:
        print("INVALID RANGE")
    else:
        for ele in res:
            print(ele, end=' ')
          
