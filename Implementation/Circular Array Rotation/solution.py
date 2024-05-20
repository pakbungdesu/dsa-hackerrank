
def circularArrayRotation(a, k, queries):
    for _ in range(k):
        a.insert(0, a.pop(-1))
        
    return [a[i] for i in queries]
  
