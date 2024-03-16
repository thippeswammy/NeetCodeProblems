package GoogleQuestion;

public class DP_PermitationProbability {
    public static void main(String[] args) {
        String s="LION";
        String AS[]=new String[s.length()];
        String ASC[]=new String[s.length()];
        int[] count = new int[s.length()];

        for (int i=0;i<count.length;i++){
            count[i]=0;
            AS[i]=s.substring(i,i+1);
            ASC[i]=s.substring(i,i+1);
        }
        //System.out.println(s);
         for (;count[0]!=s.length();){
             for (int i=0;i<s.length();i++){
                 System.out.print(AS[i]);
             }
             System.out.println("");
             count[s.length()-1]=count[s.length()-1]+1;
             for (int n=s.length()-1;n>00;n--) {
                 if (count[n] >= s.length()-n) {
                     //if(!(count[n] >(s.length()-n)))
                     {
//                         for(int i1=0;i1<s.length();i1++){
//                             AS[i1]=ASC[i1];
//                         }
//                         String s1 = AS[n];
//                         String s2 = AS[count[n]+n-1];
//                         AS[count[n]+n-1] = s1;
//                         AS[n] = s2;
                     }
                     count[n] = 0;
                     count[n - 1] = count[n - 1] + 1;
                 }

             }
             for(int i1=0;i1<s.length();i1++){
                 AS[i1]=ASC[i1];
             }
             for(int n=s.length()-1;n>0;n--) {
                 if(count[n]!=0) {
                     String s1 = AS[n];
                     String s2 = AS[count[n] + n];
                     AS[count[n] + n ] = s1;
                     AS[n] = s2;
                 }
             }

         }
    }
}
