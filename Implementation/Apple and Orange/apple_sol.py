
def countApplesAndOranges(s, t, a, b, apples, oranges):
    count_apples = filter(lambda apple: apple + a in range(s, t+1), apples)
    count_oranges = filter(lambda orange: orange + b in range(s, t+1), oranges)
    
    print(len(list(count_apples)))
    print(len(list(count_oranges)))
  
