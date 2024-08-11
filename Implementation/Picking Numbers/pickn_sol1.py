
def pickingNumbers(a):
    diff = set(a)
    a_list = [[a1, a2] for a1 in diff for a2 in diff if a2 - a1 == 1 or a1 == a2]
    
    max_ans = 0
    for obj in a_list:
        res = list(filter(lambda x: x in obj, a))
        ans = len(res)
        if ans > max_ans:
            max_ans = ans
            
    return max_ans
  
