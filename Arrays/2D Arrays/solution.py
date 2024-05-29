
def hourglassSum(arr):
    maximum = -63
    for j in range(1, len(arr)-1):
        for i in range(1, len(arr[j])-1):
            cen = arr[j][i]
            above = sum(arr[j-1][i-1:i+2])
            below = sum(arr[j+1][i-1:i+2])
            new = cen + above + below
            if new > maximum:
                maximum = new
        
    return maximum 
