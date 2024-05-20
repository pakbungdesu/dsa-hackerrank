
def divisibleSumPairs(n, k, ar):
    res = []
    for i in range(len(ar)):
        j = i+1
        for ele in ar[j:]:
            new = [ar[i], ele]
            if (sum(new)/k)%1 == 0:
                res.append(new)
                
    return len(res)
  
