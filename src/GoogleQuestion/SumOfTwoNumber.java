package GoogleQuestion;

//[1,2,6,8,9] ,sum=8 => True because (2+6) is "8"

public class SumOfTwoNumber {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,5,6,7,8,9,10};

        int sum=10;
        boolean sum_of_elements_present=false;
        int start=0,end=a.length-1;
        for(;start<end;){
            if (a[start]+a[end]==sum){
                sum_of_elements_present=true;
                System.out.println(a[start] + " " + a[end]);
                start=start+1;
                end=end-1;
            }
            if(a[start]+a[end]>sum){
                end=end-1;
            }
            if(a[start]+a[end]<sum){
                start=start+1;
            }
        }
        System.out.println(sum_of_elements_present);
    }
}
