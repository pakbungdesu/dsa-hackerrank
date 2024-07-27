
def gemstones(arr):
    
    res = [set(ele) for ele in arr]
    check = res[0]
    ans = len(check)
    res = res[1:]
    
    for ele in res:
        intersect = check.intersection(ele)
        check = intersect
               
    return len(intersect)
  
