package GoogleQuestion;

public class DP_Demo1 {
    public static void main(String[] args) {
        int num = 145217;

        int pri[] = new int[6];

        int dig = num;
        for (int i= 5;i!=-1;i--){
            pri[i]=dig;
            dig = dig/10;
        }

        for (int i = 0; i < 6; i++) {
            System.out.println(pri[i]);
        }
        
        String p[][] = new String[6][6];
        for (int n=0;n<6;n++){
            p[n][0]=pri[n]+"";
        }


        for (int i =0;i<6;i++){
            for (int n=0;n<6;n++){

            }
        }

    }
}
