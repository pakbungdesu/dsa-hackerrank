
from itertools import combinations

def acmTeam(topic): 
    max_len = len(topic[0])
    max_topic = 0
    counter = 0

    for team in combinations(topic, 2):
        sum_team = str(sum([int(_) for _ in team]))
        find0 = sum_team.count("0")
        not0 = max_len - find0

        if not0 > max_topic:
            max_topic = not0
            counter = 1   # reset when counter new max value
        elif not0 == max_topic:
            counter += 1  # add when counter same max value

    return max_topic, counter
  
