import re

def marsExploration(s):
    count = 0
    
    for i in range(0, len(s), 3):
        x = re.match("[A-Z]{3}", s[i: i+3]).group(0)
        
        if x[0] != "S":
            count += 1
        if x[1] != "O":
            count += 1
        if x[2] != "S":
            count += 1
        
    return count
  
