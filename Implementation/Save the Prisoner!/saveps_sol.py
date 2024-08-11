
def saveThePrisoner(n, m, s):
    result = (s-1+m) % n
  
    return n if result == 0 else result
