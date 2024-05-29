
def findDigits(n):
    txt = str(n)
    digits = [int(digit) for digit in txt if int(digit) != 0]
    res = filter(lambda digit: n % digit == 0, digits)
    
    return len(list(res))
  
