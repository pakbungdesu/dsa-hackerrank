
def kangaroo(x1, v1, x2, v2):
    try:
        k = (x2-x1)/(v1-v2)
        if k > 0 and k%1 == 0:
            return "YES"
        else:
            return "NO"
    except:
        return "NO"
      
