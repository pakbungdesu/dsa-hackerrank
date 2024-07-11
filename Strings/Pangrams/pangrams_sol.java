
class Result {

    public static String pangrams(String s) {

    String txt = s.toLowerCase();
    String[] letter = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q" ,"r", "s", "t", "u", "v", "w", "x", "y", "z"};
    
    for(String x: letter){
        int index = txt.indexOf(x);
        if(index == -1){
            return "not pangram";
        }
    }
    return "pangram";
}
}
