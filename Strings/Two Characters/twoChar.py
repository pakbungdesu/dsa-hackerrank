import re
import itertools

def alternate(s):

    letters = set(s)
    num_letters = len(letters)
    if num_letters == 1 and len(s) == 1:
        return 0
    elif num_letters == 1:
        return 0
    elif len(s) == 2 and num_letters == 2:
        return 2
    else:
        maximum = 0
        pattern = re.compile(r'^(\w)(?!\1)(\w)(\1\2)*\1?$')
        for removals in itertools.combinations(letters, num_letters-2):
            string = s
            for letter in removals:
                string = string.replace(letter, "")
                if pattern.match(string):
                    maximum = max(maximum, len(string))
                    
        return maximum
