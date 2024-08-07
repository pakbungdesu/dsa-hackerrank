
#include <set>
#include <algorithm>
#include <vector>

vector<string> weightedUniformStrings(string s, vector<int> queries) {
    
    int first = s[0] - 'a' + 1; // Convert character to numerical value
    int amount = first;
    
    set<int> weight;
    weight.insert(amount);
    
    for(int i = 1; i < s.size(); i++){
        
        if(s[i] == s[i-1]){
            amount += first;
            weight.insert(amount);
        } else {
            first = s[i] - 'a' + 1; // Convert character to numerical value
            amount = first;
            weight.insert(first);
        }
    }
    
    vector<string> res;
    
    for (int q: queries){
        if (weight.count(q)) {
            res.push_back("Yes");
        } else {
            res.push_back("No");
        }
    }
    
    return res;
}
