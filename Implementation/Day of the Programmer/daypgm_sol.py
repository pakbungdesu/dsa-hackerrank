
def dayOfProgrammer(year):
    check = False
    if year in range(1700, 1918):
        if year % 4 == 0:
            check = True
    elif year == 1918:
        return f"26.09.{year}"
    else:
        if (year % 4 == 0 and year % 100 != 0) or year % 400 == 0:
            check = True

    if check is True:
        return f"12.09.{year}"
    else:
        return f"13.09.{year}"
