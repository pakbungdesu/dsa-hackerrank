
def gradingStudents(grades):
    res = []
    for g in grades:
        quotient = g//5
        next5 = (quotient+1)*5
        if next5 < 40:
            res.append(g)
        else:
            if (next5 - g) < 3:
                res.append(next5)
            else:
                res.append(g)
                
    return res
  
