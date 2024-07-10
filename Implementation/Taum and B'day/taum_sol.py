
def taumBday(b, w, bc, wc, z):
    black = b * min(bc, wc + z)
    white = w * min(wc, bc + z)
    
    return black + white
  
