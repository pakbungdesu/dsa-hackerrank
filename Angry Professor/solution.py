
def angryProfessor(k, a):
    ontime = len(list(filter(lambda x: x <= 0, a)))
    
    if ontime >= k:
        return "NO"
    else:
        return "YES"
      
