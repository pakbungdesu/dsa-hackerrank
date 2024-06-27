
def minimumNumber(n, password):
    uniq = []
    atleast = 4
    
    if re.search(r"[A-Z]", password) : uniq.append(1)
    if re.search(r"[a-z]", password): uniq.append(2)
    if re.search("[0-9]", password): uniq.append(3)
    if re.search("[-!@#$%^&*()+]", password): uniq.append(4)
            
    add = atleast - len(uniq)
    res = n + add
    
    return max(add, 6 -n)
