package GoogleQuestion;
//Longest Increases Sequence in array
public class DP_LIS {
    public static void main(String[] args) {

        int a[]={5,1,8,2,3,4,9,1};
        int NA[]={1,1,1,1,1,1,1,1};

        for (int i=1;i<a.length;i++){
            int SubPro[]={0,0,0,0,0,0,0,0};
            for (int k=0;k<i;k++){
                if(a[k]<a[i]){
                    SubPro[k]=NA[k];
                }
            }
            int max=0;
            for(int l=0;l<a.length;l++){
                if(SubPro[l]>max){
                    max=SubPro[l];
                }
            }
            NA[i]=max+1;
        }

        int max=0;

        for(int l=0;l<a.length;l++){
            if(NA[l]>max){
                max=NA[l];
            }
            //System.out.println(NA[l]);
        }
        System.out.println(max);
    }
}
