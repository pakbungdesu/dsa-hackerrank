
def pickingNumbers(a):
    freq = {}
    for num in a:
        freq[num] = freq.get(num, 0) + 1

    max_len = 0
    for num in freq:
        max_len = max(max_len, freq[num] + freq.get(num + 1, 0))

    return max_len
