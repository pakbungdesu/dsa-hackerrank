def funnyString(s):
    nor = list(s)
    rev = nor[::-1]
    
    ord_nor = [ord(ele) for ele in nor]
    ord_rev = [ord(ele) for ele in rev]
    
    ord_nor = [abs(ord_nor[i] - ord_nor[i-1]) for i in range(1, len(ord_nor))]
    ord_rev = [abs(ord_rev[i] - ord_rev[i-1]) for i in range(1, len(ord_rev))]
    
    return "Funny" if ord_nor == ord_rev else "Not Funny"
