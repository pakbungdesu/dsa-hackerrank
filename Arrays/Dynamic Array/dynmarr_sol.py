
def dynamicArray(n, queries):
    arr = [[] for _ in range(n)]
    lastA = 0
    ans_arr = []
    for q in queries:
        if q[0] == 1:
            idx = (q[1] ^ lastA) % n
            arr[idx].append(q[2])
        elif q[0] == 2:
            idx = (q[1] ^ lastA) % n
            if len(arr[idx])!=0:
                lastA = arr[idx][q[2] % len(arr[idx])]
                ans_arr.append(lastA)
    return ans_arr
  
