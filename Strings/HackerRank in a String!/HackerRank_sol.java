
class Result {

    public static String hackerrankInString(String s) {
    
    int idx_h, idx_a1, idx_c, idx_k1, idx_e, idx_r1, idx_r2, idx_a2, idx_n, idx_k2;
    
    idx_h = s.indexOf("h");
    idx_a1 = s.indexOf("a", idx_h + 1);
    idx_c = s.indexOf("c", idx_a1 + 1);
    idx_k1 = s.indexOf("k", idx_c + 1);
    idx_e = s.indexOf("e", idx_k1 + 1);
    idx_r1 = s.indexOf("r", idx_e + 1);
    idx_r2 = s.indexOf("r", idx_r1 + 1);
    idx_a2 = s.indexOf("a", idx_r2 + 1);
    idx_n = s.indexOf("n", idx_a2 + 1);
    idx_k2 = s.indexOf("k", idx_n + 1);
    
    return (idx_h != -1 && idx_a1 != -1 && idx_c != -1 && idx_k1 != -1 && idx_e != -1 && idx_r1 != -1 && idx_r2 != -1 && idx_a2 != -1 && idx_n != -1 && idx_k2 != -1) ? "YES" : "NO";
    
    }

}
