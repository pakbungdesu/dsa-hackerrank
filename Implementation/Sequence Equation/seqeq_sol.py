
def permutationEquation(p):
    pos = [p.index(p.index(ele) + 1) + 1 for ele in p]
    ans = [0 for _ in range(len(p))]
    for i in range(len(p)):
        new = pos[i]
        ans[p[i]-1] = new
    
    return ans
  
