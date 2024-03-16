package GoogleQuestion;

public class BinarySearch {
    public static void main(String[] args) {

        int[] a= new int[100000000];

        for (int i=0;i<a.length;i++){
            a[i]=i;
        }

        int search= 90000000,NumberOfTimes=0;
        int start = 0 ,end=a.length-1,mid;
        boolean isPresent = false;

        for (;start<=end;){
            NumberOfTimes++;
            mid=(start+end)/2;
            if(a[mid]==search){
                isPresent=true;
                break;
            }
            if(a[mid]>search){
                end=mid-1;
            }
            if(a[mid]<search){
                start=mid+1;
            }
        }
        System.out.println(isPresent+"  "+NumberOfTimes);
    }
}
