package GoogleQuestion;

public class ArrayProduct {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        int[] b= new int[a.length];
        int i, pro = 1;
        for (i = 0; i < a.length; i++) {
            pro = pro * a[i];
        }
        for (i = 0; i < a.length; i++) {
            b[i] = pro / a[i];
        }
        for (i = 0; i < a.length; i++) {
            System.out.print(b[i]+" ");
        }


    }
}