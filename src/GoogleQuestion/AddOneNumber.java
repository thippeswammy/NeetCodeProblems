package GoogleQuestion;

//        [4,5,7,3,6] => [4,5,7,3,7]
//        [2,8,9] => [2,9,0]
//        [9,9,9] => [1,0,0,0]


public class AddOneNumber {
    public static void main(String[] args) {
        int[] a={9,9,9,9};
        int[] anew= new int[a.length+1];
        int  add =1;
        for(int i=a.length-1;i>=0;i--){
           int sum = a[i]+add;
           if(sum==10){
               add=1;
               anew[i+1]=0;
           }else {
               add=0;
               anew[i+1]=sum;
           }
        }
        anew[0]=add;
        int i = 1;
        if(a[0]+1==10){
            i=0;
        }
        for (; i < anew.length; i++) {
            System.out.println(anew[i]);
        }
    }
}
