
def repeatedString(s, n):
    multiply = n//len(s)
    reminder = n - (multiply*len(s))
    
    reminder = s[0:reminder].count("a")
    res = s.count("a") * multiply
    
    return res + reminder
  
