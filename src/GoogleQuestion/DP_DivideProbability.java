package GoogleQuestion;

public class DP_DivideProbability {
    public static void main(String[] args) {
        //() => notDivisible
        //[] => Divisible
        int divider=7;
        int number=145217;
        int a[] = new int[(number+"").length()];
        String Prefix[] = new String[a.length];
        for (int i=0;i<a.length;i++){
            a[i]=Integer.parseInt((number+"").substring(i,i+1));
        }
        for(int i=0;i<a.length;i++){
            String ss="";
            for (int n=0;n<=i;n++){
                ss=ss+a[n];
            }
            Prefix[i]=ss;
            System.out.println(Prefix[i]);
        }

//        for(int i=0;i<a.length;i++) {
//            String ss = "";
//            for (int n = 0; n <= i; n++) {
//                if(a[n]%divider==0){
//                    ss=ss+"["+a[n]+"]";
//                }else {
//                    ss=ss+"("+a[n]+")";
//                }
//            }
//
//            possible[i]=ss;
//            System.out.println(ss);
//        }



        String poss[][] = new String[10][10];
        for (int i=0;i<poss.length;i++){
            for (int n=0;n<poss[i].length;n++){
                poss[i][n]="";
            }
        }
        poss[0][0]="(1)";

        int yes=0;
        for(int i=1;i<a.length;i++) {
            int n = 0;
            for (; !poss[i-1][n].equals(""); n++) {
                String hh = "";
                 {
                    hh = a[i]+"";
                    int hg=Integer.parseInt(hh);
                    String ss = poss[i-1][n];
                if (yes == 10) {
                    yes = 0;
                    int v = 1;
                    try {
                        System.out.println(Prefix[Prefix.length - 1].substring(i + 1, i + 3) + " QQQQ " + i);
                        v = Integer.parseInt(Prefix[Prefix.length - 1].substring(i + 1, i + 3));
                        if (v % divider == 0) {
                            ss = ss + "[" + v + "]";
                        }
                        poss[i + 1][n] = ss;
                    } catch (Exception e) {
                    }
                }
                if (hg % divider == 0) {

                    if (hg % divider == 0) {
                        ss = ss + "[" + hg + "]";
                    } else {
                        ss = ss + "(" + hg + ")";
                    }
                    poss[i][n] = ss;
                    continue;
                } else {
                    String aaa = ss.substring(ss.length() - 1, ss.length());
                    if (!aaa.equals(")")) {
                        ss = ss + "(" + hg + ")";
                        System.out.println(ss + " Thippe11");
                        poss[i][n] = ss;
                        continue;
                    } else {
                        System.out.println(ss + "AAAAAAAAAAAAAAAAAAAAA111");
                        ss = ss.substring(0, ss.length() - 1) + "" + hg + ")";
                        System.out.println(ss + "AAAAAAAAAAAAAAAAAAAAA2222");
                        if ((ss.substring(0, 1) + ss.substring(ss.length() - 1, ss.length())).equals("()") && (!ss.contains("]"))) {
                            int se = Integer.parseInt(ss.substring(1, ss.length() - 1));
                            if (se % divider == 0) {
                                ss = "[" + ss.substring(1, ss.length() - 1) + "]";
                            }
                        }
                        poss[i][n] = ss;
                        continue;
//                        if (ss.substring(ss.length() - 1, ss.length()).equals(")")) {
//                            yes = 1;
//                        }
                    }
//                    if(!ss.substring(1,ss.length()-1).equals(s[i])){
//                        System.out.println(ss.substring(1,ss.length()-1)+" Thipp33");
//                        yes=1;
//                        System.out.println(ss+" Thippe22");
//
//                    }
//                    if(poss[i][n+1].equals("")) {
//                        break;
//                    }else {
//                        n++;
//                    }
                }
            }
        }
            if(Integer.parseInt(Prefix[i])%divider==0){
            }else {
                poss[i+1][n+1]="("+Prefix[i]+")";
            }
        }

        for(int i=0;i<poss.length;i++){
            for(int n=0;n<poss[i].length;n++){
                System.out.print(poss[i][n]+" ");
            }
            System.out.println();
        }

    }
}
