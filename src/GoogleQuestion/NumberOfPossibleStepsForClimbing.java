package GoogleQuestion;

public class NumberOfPossibleStepsForClimbing {
    public static void main(String[] args) {

        int number_of_steps=6;
        int[] dp=new int[number_of_steps];

        dp[number_of_steps-1]=1;
        dp[number_of_steps-2]=1;

        for (int i=dp.length-3;i>=0;i--){
            dp[i]=dp[i+1]+dp[i+2];
        }

        System.out.println(dp[0]);

    }
}
