
def stones(n, a, b):
    if a == b:
        return [(n - 1) * a]
    
    if a > b:
        a, b = b, a
    
    return [a * (n - 1 - i) + b * i for i in range(n)]
