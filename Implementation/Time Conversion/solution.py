
def timeConversion(s):
    hh, mm, ss = map(str, s[:-2].split(":")) 
    meridiem = s[-2:]
    
    if meridiem == "PM" and hh != "12":
        hh = int(hh)+12
    if meridiem == "AM" and hh == "12":
        hh = "00"
        
    return f"{hh}:{mm}:{ss}"
  
