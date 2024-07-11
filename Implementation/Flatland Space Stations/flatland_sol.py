
def flatlandSpaceStations(n, c):
    if not c:
        return n - 1  
    if len(c) == 1:
        return max(abs(c[0] - 0), abs(c[0] - (n - 1))) 

    c.sort()
    max_distance = max(c[0], n - 1 - c[-1])

    for i in range(1, len(c)):
      # maximum of mid_distance between space stations
        mid_distance = (c[i] - c[i - 1]) // 2
        max_distance = max(max_distance, mid_distance)

    return max_distance
