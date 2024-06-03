
def pageCount(n, p):
    if n % 2 == 0:
        if p % 2 == 0:
            flip = min(p//2, (n-p)//2)
        else:
            flip = min((p-1)//2, math.ceil((n-p)/2))
    else:
        if p % 2 == 0:
            flip = min(p//2, (n-p)//2)
        else:
            flip = min((p-1)//2, math.floor((n-p)/2))
  
    return int(flip)
  
