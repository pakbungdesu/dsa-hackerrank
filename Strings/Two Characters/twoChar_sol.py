import re
from itertools import combinations

def alternate(s):
    
    letters = set(s)
    n = len(letters)
  
    if n == 1:
        return 0
    else:
        a = combinations(letters, n-2)
        max_value = 0
        
        for ele1 in a:
            x = s
            for ele2 in ele1:
                x = x.replace(ele2, "")
            res = re.search(r"^(\w)(?!\1)(\w)(\1\2)*\1?$", x)
            if res:
                max_value = max(max_value, len(x))
            
        return max_value
