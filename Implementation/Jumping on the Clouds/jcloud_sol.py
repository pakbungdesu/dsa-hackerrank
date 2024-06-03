
def jumpingOnClouds(c, k):
    e = 100
    n = len(c)
    i = 0
    while True:
        e -= ( 3 if c[i] == 1 else 1)
        i = (i + k) % n
        if i == 0:
            break                       
    return e
  
