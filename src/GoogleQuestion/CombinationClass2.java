package GoogleQuestion;

public class CombinationClass2 {
    public static void main(String[] args) {

        String A="ABCDEFG";
        String a="abcdefg";
        double Ac[] = {15,14,12.5,16,14.5,14.5,13};
        double ac[]={13,11,14.5,12.5,12,15,16};
        int sum=100;

        int count=0;
        int fromA=2;
        int froma=5;
        for(;fromA<=5;){
            int num[] = new int[fromA];
            int num2[] = new int[froma];
            for(int i=0;i<num.length;i++){
                num[i]=i;
            }
            for(int i=0;i<num2.length;i++){
                num2[i]=i;
            }
            num[num.length-1]--;
            num2[num2.length-1]--;

            for(;num[0]<=A.length()-fromA;){
                num[num.length-1]=num[num.length-1]+1;
                int n;
                for(n=num.length-1;n>=1;n--){
                    if(num[n]>=n+froma+1){
                        num[n-1]=num[n-1]+1;
                        num[n]=0;
                    }
                }
                for(n=1;n<num.length;n++){
                    if(num[n]==0){
                        num[n]=num[n-1]+1;
                    }
                }
                if(num[0]>=froma+1){
                    break;
                }

                for(int i=0;i<num2.length;i++){
                    num2[i]=i;
                }

                num2[num2.length-1]--;

                for(;num2[0]<=fromA;){ num2[num2.length-1]=num2[num2.length-1]+1;
                    int nn;
                    for(nn=num2.length-1;nn>=1;nn--){
                        if(num2[nn]>=nn+fromA+1){
                            num2[nn-1]=num2[nn-1]+1;
                            num2[nn]=0;
                        }
                    }
                    for(nn=1;nn<num2.length;nn++){
                        if(num2[nn]==0){
                            num2[nn]=num2[nn-1]+1;
                        }
                    }
                    if(num2[0]>=fromA+1){
                        break;
                    }

                    boolean issumless=false;
                    double sum1=0;
                    for(int i=0;i<(fromA+froma);i++){
                        if(i<fromA){
                            sum1+=Ac[num[i]];
                        }else {
                            sum1+=ac[num2[i-fromA]];
                        }
                    }
                    if(sum1<=sum){
                        issumless=true;

                    }else{
                        //  continue;
                        //System.out.println("Thippp");
                    }


                    for(int i=0;i<(fromA+froma)&&issumless;i++){
                        if(i<fromA){
                            System.out.print(A.charAt(num[i])+" ");
                        }else {
                            System.out.print(a.charAt(num2[i-fromA])+" ");
                        }

                    }



                    if(issumless){

                        System.out.print(sum1+" "+count);
                        System.out.println("");
                        count++;
                    }

                }
            }
            fromA++;
            froma--;
            if(fromA>=6){
                break ;
            }
        }

        System.out.println(count);
    }
}

