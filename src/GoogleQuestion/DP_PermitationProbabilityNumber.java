package GoogleQuestion;
// s="CAT" => {CAT,CTA,ACT,ATC,TCA,TAC}
public class DP_PermitationProbabilityNumber {
    public static void main(String[] args) {
        String s = "LION";
        int pr = 1;
        for (int i = 1; i <= s.length(); i++) {
            pr = i * pr;
        }
        String[] Total = new String[pr];
        String[] Total1 = new String[pr];
        for (int n = 0; n < pr; n++) {
            Total1[n] = "";
        }

        Total1[0] = s.substring(0, 1);
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(i, i + 1);
            int count = 0;
            for (int pro = 0; pro < pr; pro++) {
                if (!Total1[pro].equals("")) {
                    for (int n = 0; n <= i; n++) {
                        Total[count] = Total1[pro].substring(0, n) + s1 + Total1[pro].substring(n);
                        count++;
                    }
                }
            }
            count--;
            for (;count >= 0; count--) {
                Total1[count] = Total[count];
            }
        }
        for (String sq : Total) {
            System.out.println(sq);
        }
    }
}
