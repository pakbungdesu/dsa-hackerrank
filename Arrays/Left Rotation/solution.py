
def rotateLeft(d, arr):
    res = [0 for _ in range(len(arr))]
    for i in range(len(arr)):
        index = i-d
        new_item = arr[i]
        res[index] = new_item
        
    return res
  
