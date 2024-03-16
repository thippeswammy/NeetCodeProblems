package GoogleQuestion;
import java.util.ArrayList;

public class RiderAllGrounderDiffender2 {

    public static void main(String[] args) {

        String A[]={"A","B","C","D","E","F","G"};
        String a[]={"a","b","c","d","e","f","g"};

        ArrayList<String> listA = new ArrayList<>();
        ArrayList<String> lista = new ArrayList<>();

        for(int i=0;i<A.length;i++){
            listA.add(A[i]);
            lista.add(a[i]);
        }

        int count=0;

        int Riderm[]={3,1};
        int Allgrounderm[]={2,1};
        int Diffenderm[]={4,2};

        int norider=5;
        int noallgrounder=4;
        int nodiffender=5;

        int Rider1[]=new int[Riderm[0]];
        int Allgrounder1[]=new int[Allgrounderm[0]];
        int Diffender1[]=new int[A.length-Rider1.length-Allgrounder1.length];


        int Rider2[]=new int[norider-Riderm[0]];
        int Allgrounder2[]=new        int[noallgrounder-Allgrounderm[0]];
        int Diffender2[]=new int[nodiffender-Diffender1.length];


        for(int i=0;i<Rider1.length;i++){
            Rider1[i]=i;
        }

        for(int i=0;i<Diffender1.length;i++){
            Diffender1[i]=i;
        }


        for(int i=0;i<Diffender2.length;i++){
            Diffender2[i]=i;
        }


        Rider1[Rider1.length-1]--;
        Allgrounder1[Allgrounder1.length-1]--;
        Diffender1[Diffender1.length-1]--;



        try {
            Rider2[Rider2.length-1]--;
            Allgrounder2[Allgrounder2.length-1]--;
            Diffender2[Diffender2.length-1]--;
        }catch (Exception e){}




        for(;Rider1[0]<=listA.size()-Rider1.length;){

            listA.removeAll(listA);
            lista.removeAll(lista);
            for(int i=0;i<A.length;i++){
                listA.add(A[i]);
                lista.add(a[i]);
            }

            Rider1[Rider1.length-1]=Rider1[Rider1.length-1]+1;
            int n;
            for(n=Rider1.length-1;n>=1;n--){
                if(Rider1[n]>=n+listA.size()-Rider1.length+1){
                    Rider1[n-1]=Rider1[n-1]+1;
                    Rider1[n]=0;
                }
            }
            for(n=1;n<Rider1.length;n++){
                if(Rider1[n]==0){
                    Rider1[n]=Rider1[n-1]+1;
                }
            }
            if(Rider1[0]>=listA.size()-Rider1.length+1){
                break;
            }


            for(int i=0;i<Rider2.length;i++){
                Rider2[i]=i;
            }
            try {
                Rider2[Rider2.length-1]--;
            }catch (Exception e){}
            for(;Rider2[0]<=lista.size()-Rider2.length;){

                Rider2[Rider2.length-1]=Rider2[Rider2.length-1]+1;
                int n1;
                for(n1=Rider2.length-1;n1>=1;n1--){
                    if(Rider2[n1]>=n1+lista.size()-Rider2.length+1){
                        Rider2[n1-1]=Rider2[n1-1]+1;
                        Rider2[n1]=0;
                    }
                }
                for(n1=1;n1<Rider2.length;n1++){
                    if(Rider2[n1]==0){
                        Rider2[n1]=Rider2[n1-1]+1;
                    }
                }
                if(Rider2[0]>=lista.size()-Rider2.length+1){
                    break;
                }











                for(int i=0;i<Allgrounder1.length;i++){
                    Allgrounder1[i]=i;
                }
                Allgrounder1[Allgrounder1.length-1]--;


                for(;Allgrounder1[0]<=listA.size()-Allgrounder1.length;){



                    Allgrounder1[Allgrounder1.length-1]=Allgrounder1[Allgrounder1.length-1]+1;
                    int n2;
                    for(n2=Allgrounder1.length-1;n2>=1;n2--){
                        if(Allgrounder1[n2]>=n2+listA.size()-Allgrounder1.length+1){
                            Allgrounder1[n2-1]=Allgrounder1[n2-1]+1;
                            Allgrounder1[n2]=0;
                        }
                    }
                    for(n2=1;n2<Allgrounder1.length;n2++){
                        if(Allgrounder1[n2]==0){
                            Allgrounder1[n2]=Allgrounder1[n2-1]+1;
                        }
                    }
                    if(Allgrounder1[0]>=listA.size()-Allgrounder1.length+1){
                        break;
                    }


                    for(int i=0;i<Allgrounder2.length;i++){
                        Allgrounder2[i]=i;
                    }
                    try {
                        Allgrounder2[Allgrounder2.length-1]--;
                    }catch (Exception e){}
                    for(;Allgrounder2[0]<=lista.size()-Allgrounder2.length;){

                        Allgrounder2[Allgrounder2.length-1]=Allgrounder2[Allgrounder2.length-1]+1;
                        int n12;
                        for(n12=Allgrounder2.length-1;n12>=1;n12--){
                            if(Allgrounder2[n12]>=n12+lista.size()-Allgrounder2.length+1){
                                Allgrounder2[n12-1]=Allgrounder2[n12-1]+1;
                                Allgrounder2[n12]=0;
                            }
                        }
                        for(n12=1;n12<Allgrounder2.length;n12++){
                            if(Allgrounder2[n12]==0){
                                Allgrounder2[n12]=Allgrounder2[n12-1]+1;
                            }
                        }
                        if(Allgrounder2[0]>=lista.size()-Allgrounder2.length+1){
                            break;
                        }













                        for(int i=0;i<Diffender1.length;i++){
                            Diffender1[i]=i;
                        }
                        Diffender1[Diffender1.length-1]--;


                        for(;Diffender1[0]<=listA.size()-Diffender1.length;){



                            Diffender1[Diffender1.length-1]=Diffender1[Diffender1.length-1]+1;
                            int n3;
                            for(n3=Diffender1.length-1;n3>=1;n3--){
                                if(Diffender1[n3]>=n3+listA.size()-Diffender1.length+1){
                                    Diffender1[n3-1]=Diffender1[n3-1]+1;
                                    Diffender1[n3]=0;
                                }
                            }
                            for(n3=1;n3<Diffender1.length;n3++){
                                if(Diffender1[n3]==0){
                                    Diffender1[n3]=Diffender1[n3-1]+1;
                                }
                            }
                            if(Diffender1[0]>=listA.size()-Diffender1.length+1){
                                break;
                            }


                            for(int i=0;i<Diffender2.length;i++){
                                Diffender2[i]=i;
                            }
                            try {
                                Diffender2[Diffender2.length-1]--;
                            }catch (Exception e){}
                            for(;Diffender2[0]<=lista.size()-Diffender2.length;){

                                Diffender2[Diffender2.length-1]=Diffender2[Diffender2.length-1]+1;
                                int n13;
                                for(n13=Diffender2.length-1;n13>=1;n13--){
                                    if(Diffender2[n13]>=n13+lista.size()-Diffender2.length+1){
                                        Diffender2[n13-1]=Diffender2[n13-1]+1;
                                        Diffender2[n13]=0;
                                    }
                                }
                                for(n13=1;n13<Diffender2.length;n13++){
                                    if(Diffender2[n13]==0){
                                        Diffender2[n13]=Allgrounder2[n13-1]+1;
                                    }
                                }
                                if(Diffender2[0]>=lista.size()-Diffender2.length+1){
                                    break;
                                }










                                System.out.print(Rider1[0]+" "+Rider1[1]+" "+Rider1[2]+" "+Rider2[0]+" "+Rider2[1]+" /R "+Allgrounder1[0]+" "+Allgrounder1[1]+" "+ Allgrounder2[0]+" "+Allgrounder2[1]+" /A "+Diffender1[0]+" "+Diffender1[1]+" "+
                                        Diffender2[0]+" "+Diffender2[1]+" "+Diffender2[2]+" /D  ");


                                System.out.print(" "+ ++count+" \n ");




                            }}}}}}











    }

}
