
def camelcase(s):
    count = 1
    s = list(s)
    for ele in s:
        if ele.isupper():
            count += 1
            
    return count
