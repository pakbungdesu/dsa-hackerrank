
def sockMerchant(n, ar):

    diff = set(ar)        
    return sum([ar.count(i)//2 for i in diff])
