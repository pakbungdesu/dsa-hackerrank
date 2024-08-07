#include <cstdlib>

int theLoveLetterMystery(string s) {
    int res = 0, i = 0;
    int id = s.size()-1;
    long add = s.size() % 2;
    long mid = (s.size() + add)/2;
    
    while (i < mid){
        res += abs(int(s[i]) - int(s[id--]));
        i++;
    }
    return res;
}
