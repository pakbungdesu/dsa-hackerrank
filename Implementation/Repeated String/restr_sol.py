
def repeatedString(s, n):
    multiply = n//len(s)
    reminder = n - (multiply*len(s))
    
    reminder = s[:reminder].count("a")
    res = s.count("a") * multiply
    
    return res + reminder
  
