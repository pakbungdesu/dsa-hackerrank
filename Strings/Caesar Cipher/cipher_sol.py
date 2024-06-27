
letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

def caesarCipher(s, k):
    update = s.lower()
    res = ""
    
    for i in range(len(s)):
        if re.search(r"[A-Z]", s[i]):
            idx = letters.index(update[i])
            new_idx = (idx + k) % 26
            res += letters[new_idx].upper()
        elif re.search(r"[a-z]", s[i]):
            idx = letters.index(update[i])
            new_idx = (idx + k) % 26
            res += letters[new_idx]
        else:
            res += s[i]
            
    return res
