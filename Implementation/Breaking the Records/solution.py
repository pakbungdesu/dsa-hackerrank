
def breakingRecords(scores):

    highest = [scores[0]]
    lowest = [scores[0]]

    for i in scores:
        if i > max(highest):
            highest.append(i)
        if i < min(lowest):
            lowest.append(i)
            
    return [len(highest)-1, len(lowest)-1]
  
