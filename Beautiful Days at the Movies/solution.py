
def beautifulDays(i, j, k):
    res = []
    num_list = [str(num) for num in range(i, j+1)]
    
    for num in num_list:
        norm_list = []
        for ele in num:
            norm_list.append(ele)

        rev_list = norm_list[::-1]
        normal = int("".join(norm_list))
        reverse = int("".join(rev_list))
        
        ans = abs(normal-reverse)/k
        if ans % 1 == 0:
            res.append(ans)
    
    return len(res)  
