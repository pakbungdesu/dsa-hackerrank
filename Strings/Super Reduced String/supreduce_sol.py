
def superReducedString(s):
    if not s:
        return "Empty String"
        
    for i in range(len(s) - 1):
        if s[i] == s[i+1]:
            res = s[:i] + s[i+2:] 
            return superReducedString(res)
            
    return s
  
