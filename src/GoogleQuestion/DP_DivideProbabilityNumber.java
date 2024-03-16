package GoogleQuestion;
//() => notDivisible by divider
//[] => Divisible by divider
//number=145217 && divider=7 => [14](5)[21][7] (145)[21][7] [14](521)[7] (14521)[7] [14](5)[217] (145)[217] [14](5217) (145217)
public class DP_DivideProbabilityNumber {
    public static void main(String[] args) {


        int divider=7;
        String number="145217";
        int a[] = new int[number.length()];
        String Prefix[] = new String[a.length];

        for (int i=0;i<a.length;i++){
            a[i]=Integer.parseInt(number.substring(i,i+1));
        }

        for(int i=0;i<a.length;i++){
            String ss="";
            for (int n=0;n<=i;n++){
                ss=ss+a[n];
            }
            Prefix[i]=ss;
        }

        String[][] pro = new String[(number+"").length()][(number+"").length()*10];
        for (int i= 0;i<pro.length;i++){
            for (int n=0;n<pro[i].length;n++){
                pro[i][n]="";
            }
        }

        if(a[0]%divider==0){
            pro[0][0]="["+a[0]+"]";
        }else {
            pro[0][0]="("+a[0]+")";
        }

        for(int i=1;i<a.length;i++){
            int count=0;
                for (int j=i;j>0;j--) {
                    String got = Prefix[i].substring(j,i+1);
                    if (Long.parseLong(got) % divider == 0) {
                            int i1=j-1;{
                                for (int n1=0;!pro[i1][n1].equals("");n1++){
                                    pro[i][count++]=pro[i1][n1]+"["+got+"]";
                                }
                            }
                    }else {
                        int i1=j-1;{
                            for (int n1=0;!pro[i1][n1].equals("");n1++){
                                if(pro[i1][n1].substring(pro[i1][n1].length()-1,pro[i1][n1].length()).equals("]")) {
                                   pro[i][count++] = pro[i1][n1] + "(" + got + ")";
                                }
                            }
                        }
                    }
                }
                if(Long.parseLong(Prefix[i])%divider==0){
                    pro[i][count++]=pro[i][count]+"["+Prefix[i]+"]";
                }else {
                    pro[i][count++]=pro[i][count]+"("+Prefix[i]+")";
                }
        }
        for (int i=0;i<a.length;i++){
            for(int n=0;!pro[i][n].equals("");n++){
                System.out.print(pro[i][n]+" ");
            }
            System.out.println("");
        }
    }
}
