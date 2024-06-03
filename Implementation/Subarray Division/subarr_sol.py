
def birthday(s, d, m):
    sub_s = [s[i:i + m] for i in range(0, len(s))]
    count =  0
    
    for i in sub_s:
        if len(i) == m and sum(i) == d:
            count += 1  
                     
    return count
  
