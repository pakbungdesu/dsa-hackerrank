
    # 3 + 6 = 9
    # 6 * 2 = 12
    
    # 9 + 12 = 21
    # 12 * 2 = 24
    
    # 21 + 24 = 45
    # 24 * 2 = 48

def strangeCounter(t):

    if t in range(1, 4):
        return 4 - t
            
    x = 3
    y = 6
  
    for _ in range(t):
        new_x = x + y
        y = y * 2
        if t in range(x+1, new_x+1):
            return new_x - t + 1
                  
        x = new_x
