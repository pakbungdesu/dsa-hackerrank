
def pangrams(s):
    
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    string = s.lower()
    
    for letter in alphabet:
        if letter not in string:
            return "not pangram"
            
    return "pangram"
  
