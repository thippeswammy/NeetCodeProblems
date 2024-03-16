package GoogleQuestion;

    //{{12,15},{1,5},{32,34}}
    //if ram = 11
    //output => 33

public class RangeList {
    public static void main(String[] args) {

        int[][] a ={{12,15},{1,5},{32,34}};
        int ram = 11;
        int[] diff = new int[a.length];

        for (int i=0;i<a.length;i++){
            diff[i]=a[i][1]-a[i][0]+1;
        }

        for(int i= 0;i< diff.length;i++){
            if(ram<=diff[i]){
                System.out.println(a[i][0]+ram-1);
                break;
            }else {
                ram=ram- diff[i];
            }
        }
    }
}
