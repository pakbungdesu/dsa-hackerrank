
def cavityMap(grid):
    n = len(grid[0])

    for y in range(1, len(grid)-1):
        ele = grid[y]
        res = ele[0]
        for x in range(1, n-1):
            num = ele[x]
            if all([num>ele[x-1], num>ele[x+1], num>grid[y-1][x], num>grid[y+1][x]]):
                res += "X"
            else:
                res += num
        
        res += ele[-1]
        grid[y] = res
        
    return grid
