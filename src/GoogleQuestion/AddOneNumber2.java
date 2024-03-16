package GoogleQuestion;


//        [4,5,7,3,6] => [4,5,7,3,7]
//        [2,8,9] => [2,9,0]
//        [9,9,9] => [1,0,0,0]



public class AddOneNumber2 {
    public static void main(String[] args) {
        int[] a = {9,9,9};

        int TN=0;
        for(int i=0;i<a.length;i++){
            TN=TN*10+a[i];
        }

        TN++;

        int newA[]= new int[(TN+"").length()];

        for (int i = (TN+"").length()-1;i>=0;i--){
            newA[i]=TN%10;
            TN=TN/10;
        }

        for (int i = 0;i<newA.length;i++){
            System.out.println(newA[i]);
        }

    }
}
