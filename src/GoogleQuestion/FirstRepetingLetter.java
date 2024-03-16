package GoogleQuestion;

//ABCA => A
//BCABA => B
//BCAABC => A

public class FirstRepetingLetter {
    public static void main(String[] args) {
        String  str="abcba";
        int i,j;
        String  letter="";
        for(i=0;i<str.length();i++)
        {
            for(j=i+1;j<str.length();j++)
            {
                if((str.charAt(i)+"").equals(str.charAt(j)+""))
                {
                    letter=str.charAt(i)+"";
                    str=str.substring(i+1,j);
                    i=-1;
                    break;
                }
            }
        }
        System.out.println(letter);
    }
}

