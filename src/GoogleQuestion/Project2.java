package GoogleQuestion;
import java.util.ArrayList;
public class Project2 {
    public static void main(String[] args) {

        String A[] = {"A", "B", "C", "D", "E", "F", "G"};
        String a[] = {"a", "b", "c", "d", "e", "f", "g"};

        ArrayList<String> listA = new ArrayList<>();
        ArrayList<String> lista = new ArrayList<>();

        int count = 0;

        int Riderm[] = {3, 1};
        int Allgrounderm[] = {2, 1};
        int Diffenderm[] = {4, 2};

        int NOR = 2;
        int NOA = 2;
        int NOD = 3;

        if (NOR > Riderm[0]) {
            System.exit(1);
        }
        if (NOA > Allgrounderm[0]) {
            System.exit(1);
        }
        if (NOD > Diffenderm[0]) {
            System.exit(1);
        }
        if (NOR < Riderm[1]) {
            System.exit(1);
        }
        if (NOA < Allgrounderm[1]) {
            System.exit(1);
        }
        if (NOD < Diffenderm[1]) {
            System.exit(1);
        }
        if (!(NOR + NOA + NOD == A.length)) {
            System.exit(1);
        }

        int Ateam[] = {NOR, NOA, NOD};
        int ateam[] = {0, 0, -1};
        int ty2 = 1;

        Task:
        for (; ; ) {

            ateam[ateam.length - 1]++;
            if (ateam[2] == 1 + NOD) {
                ateam[2 - 1]++;
                ateam[2] = 0;
            }
            if (ateam[1] == 1 + NOA) {
                ateam[1 - 1]++;
                ateam[1] = 0;
            }
            if (ateam[0] == 1 + NOR) {
                break Task;
            }
            Ateam[0] = NOR - ateam[0];
            Ateam[1] = NOA - ateam[1];
            Ateam[2] = NOD - ateam[2];

            if (Ateam[0] + Ateam[1] + Ateam[2] < 2) {
                continue;
            }

            if (Ateam[0] + Ateam[1] + Ateam[2] > 5) {
                continue;
            }

            if (ateam[0] + ateam[1] + ateam[2] < 2) {
                continue;
            }

            if (ateam[0] + ateam[1] + ateam[2] > 5) {
                continue;
            }

            System.out.print("[ " + Ateam[0] + " " + ateam[0] + " ] , [ " + Ateam[1] + " ");
            System.out.println(ateam[1] + " ] , [ " + Ateam[2] + " " + ateam[2] + " ] Thipp");


            int Rider1[] = new int[Ateam[0]];
            int Allgrounder1[] = new int[Ateam[1]];
            int Diffender1[] = new int[Ateam[2]];

            int Rider2[] = new int[ateam[0]];
            int Allgrounder2[] = new int[ateam[1]];
            int Diffender2[] = new int[ateam[2]];

            String AllGrounderlist1[] = new String[Allgrounder1.length];
            String AllGrounderlist2[] = new String[Allgrounder2.length];

            Boolean r1, r2, a1, a2, d1, d2;

            r1 = true;
            r2 = true;
            a1 = true;
            a2 = true;
            d1 = true;
            d2 = true;

            if (Ateam[0] == 0) {
                r1 = false;
            }
            if (ateam[0] == 0) {
                r2 = false;
            }
            if (Ateam[1] == 0) {
                a1 = false;
            }
            if (ateam[1] == 0) {
                a2 = false;
            }
            if (Ateam[2] == 0) {
                d1 = false;
            }
            if (ateam[2] == 0) {
                d2 = false;
            }

            //System.out.println(r1+" "+r2+" "+a1+" "+a2+" "+d1+" "+d2);

            for (int i = 0; i < Rider1.length; i++) {
                Rider1[i] = i;
            }

            try {
                Rider1[Rider1.length - 1]--;
            } catch (Exception e) {
            }
            Boolean rr1 = true;
            for (; rr1; ) {
                //System.out.print("thipp1");
                if (r1) {
                    if (Rider1[0] <= A.length - Rider1.length) {
                        listA.removeAll(listA);
                        for (int i = 0; i < A.length; i++) {
                            listA.add(A[i]);
                        }

                        Rider1[Rider1.length - 1] = Rider1[Rider1.length - 1] + 1;
                        int n;
                        for (n = Rider1.length - 1; n >= 1; n--) {
                            if (Rider1[n] >= n + A.length - Rider1.length + 1) {
                                Rider1[n - 1] = Rider1[n - 1] + 1;
                                Rider1[n] = 0;
                            }
                        }
                        for (n = 1; n < Rider1.length; n++) {
                            if (Rider1[n] == 0) {
                                Rider1[n] = Rider1[n - 1] + 1;
                            }
                        }
                        if (Rider1[0] >= A.length - Rider1.length + 1) {
                            break;
                        }

                        for (int i = 0; i < Rider2.length; i++) {
                            Rider2[i] = i;
                        }
                    }
                } else {
                    rr1 = false;
                }
                try {
                    Rider2[Rider2.length - 1]--;
                } catch (Exception e) {
                }
                Boolean rr2 = true;
                for (; rr2; ) {
                    //System.out.print("thipp2");
                    if (r2) {
                        if (Rider2[0] <= a.length - Rider2.length) {
                            lista.removeAll(lista);
                            for (int i = 0; i < A.length; i++) {
                                lista.add(a[i]);
                            }


                            Rider2[Rider2.length - 1] = Rider2[Rider2.length - 1] + 1;
                            int n1;
                            for (n1 = Rider2.length - 1; n1 >= 1; n1--) {
                                if (Rider2[n1] >= n1 + a.length - Rider2.length + 1) {
                                    Rider2[n1 - 1] = Rider2[n1 - 1] + 1;
                                    Rider2[n1] = 0;
                                }
                            }
                            for (n1 = 1; n1 < Rider2.length; n1++) {
                                if (Rider2[n1] == 0) {
                                    Rider2[n1] = Rider2[n1 - 1] + 1;
                                }
                            }
                            if (Rider2[0] >= a.length - Rider2.length + 1) {
                                break;
                            }

                            for (int i = 0; i < Allgrounder1.length; i++) {
                                Allgrounder1[i] = i;
                            }
                        }
                    } else {
                        rr2 = false;
                    }
                    try {
                        Allgrounder1[Allgrounder1.length - 1]--;
                    } catch (Exception e) {
                    }
                    Boolean aa1 = true;
                    for (; aa1; ) {
                        //System.out.print("thipp3");
                        if (a1) {
                            if (Allgrounder1[0] <= A.length - Rider1.length - Allgrounder1.length) {
                                listA.removeAll(listA);
                                for (int i = 0; i < A.length; i++) {
                                    listA.add(A[i]);
                                }

                                for (int i = 0; i < Rider1.length; i++) {
                                    listA.remove(A[Rider1[i]]);
                                }

                                Allgrounder1[Allgrounder1.length - 1] = Allgrounder1[Allgrounder1.length - 1] + 1;
                                int n2;
                                for (n2 = Allgrounder1.length - 1; n2 >= 1; n2--) {
                                    if (Allgrounder1[n2] >= n2 + A.length - Rider1.length - Allgrounder1.length + 1) {
                                        Allgrounder1[n2 - 1] = Allgrounder1[n2 - 1] + 1;
                                        Allgrounder1[n2] = 0;
                                    }
                                }
                                for (n2 = 1; n2 < Allgrounder1.length; n2++) {
                                    if (Allgrounder1[n2] == 0) {
                                        Allgrounder1[n2] = Allgrounder1[n2 - 1] + 1;
                                    }
                                }
                                if (Allgrounder1[0] >= A.length - Rider1.length - Allgrounder1.length + 1) {
                                    break;
                                }
                                for (int i = 0; i < AllGrounderlist1.length; i++) {
                                    AllGrounderlist1[i] = A[Allgrounder1[i] + Rider1.length];
                                }

                                for (int i = 0; i < Allgrounder2.length; i++) {
                                    Allgrounder2[i] = i;
                                }
                            }
                        } else {
                            aa1 = false;
                        }
                        try {
                            Allgrounder2[Allgrounder2.length - 1]--;
                        } catch (Exception e) {
                        }
                        Boolean aa2 = true;
                        for (; aa2; ) {
                            //System.out.print("thipp4");
                            if (a2) {
                                if (Allgrounder2[0] <= a.length - Rider2.length - Allgrounder2.length) {
                                    lista.removeAll(lista);
                                    for (int i = 0; i < A.length; i++) {
                                        lista.add(a[i]);
                                    }

                                    for (int i = 0; i < NOR; i++) {
                                        if (i < Rider1.length) {
                                        } else {
                                            lista.remove(a[Rider2[i - Rider1.length]]);
                                        }
                                    }
                                    Allgrounder2[Allgrounder2.length - 1] = Allgrounder2[Allgrounder2.length - 1] + 1;
                                    int n12;
                                    for (n12 = Allgrounder2.length - 1; n12 >= 1; n12--) {
                                        if (Allgrounder2[n12] >= n12 + a.length - Rider2.length - Allgrounder2.length + 1) {
                                            Allgrounder2[n12 - 1] = Allgrounder2[n12 - 1] + 1;
                                            Allgrounder2[n12] = 0;
                                        }
                                    }
                                    for (n12 = 1; n12 < Allgrounder2.length; n12++) {
                                        if (Allgrounder2[n12] == 0) {
                                            Allgrounder2[n12] = Allgrounder2[n12 - 1] + 1;
                                        }
                                    }
                                    if (Allgrounder2[0] >= a.length - Rider2.length - Allgrounder2.length + 1) {
                                        break;
                                    }


                                    for (int i = 0; i < AllGrounderlist2.length; i++) {
                                        AllGrounderlist2[i] = a[Allgrounder2[i] + Rider2.length];
                                    }

                                    for (int i = 0; i < Diffender1.length; i++) {
                                        Diffender1[i] = i;
                                    }
                                }
                            } else {
                                aa2 = false;
                            }
                            try {
                                Diffender1[Diffender1.length - 1]--;
                            } catch (Exception e) {
                            }
                            Boolean dd1 = true;
                            //System.out.println("thippggaa");
                            for (; dd1; ) {
                                //System.out.print("thipp5");
                                //System.out.println("thippgg");
                                if (d1) {
                                    if (Diffender1[0] <= A.length - Rider1.length - Allgrounder1.length - Diffender1.length) {
                                        listA.removeAll(listA);
                                        for (int i = 0; i < A.length; i++) {
                                            listA.add(A[i]);
                                        }

                                        for (int i = 0; i < NOR; i++) {
                                            if (i < Rider1.length) {
                                                listA.remove(A[Rider1[i]]);
                                            }
                                        }
                                        for (int i = 0; i < NOA; i++) {
                                            if (i < Allgrounder1.length) {
                                                listA.remove(A[Allgrounder1[i] + Rider1.length]);
                                            }
                                        }
                                        Diffender1[Diffender1.length - 1] = Diffender1[Diffender1.length - 1] + 1;
                                        int n3;
                                        for (n3 = Diffender1.length - 1; n3 >= 1; n3--) {
                                            if (Diffender1[n3] >= n3 + A.length - Rider1.length - Allgrounder1.length - Diffender1.length + 1) {
                                                Diffender1[n3 - 1] = Diffender1[n3 - 1] + 1;
                                                Diffender1[n3] = 0;
                                            }
                                        }
                                        for (n3 = 1; n3 < Diffender1.length; n3++) {
                                            if (Diffender1[n3] == 0) {
                                                Diffender1[n3] = Diffender1[n3 - 1] + 1;
                                            }
                                        }
                                        if (Diffender1[0] >= A.length - Rider1.length - Allgrounder1.length - Diffender1.length + 1) {
                                            break;
                                        }
                                        //System.out.print("thippgg11");

                                        for (int i = 0; i < Diffender2.length; i++) {
                                            Diffender2[i] = i;
                                        }
                                    }
                                } else {
                                    dd1 = false;
                                    //System.out.println("thippgg22");
                                }
                                try {
                                    Diffender2[Diffender2.length - 1]--;
                                } catch (Exception e) {
                                }
                                Boolean dd2 = true;
                                Tasks:
                                for (; dd2; ) {
                                    //System.out.print("thipp6");
                                    if (d2) {
                                        if (Diffender2[0] <= a.length - Rider2.length - Allgrounder2.length - Diffender2.length && d2) {
                                            lista.removeAll(lista);
                                            for (int i = 0; i < A.length; i++) {
                                                lista.add(a[i]);
                                            }

                                            for (int i = 0; i < NOR; i++) {
                                                if (i < Rider1.length) {
                                                } else {
                                                    lista.remove(a[Rider2[i - Rider1.length]]);
                                                }
                                            }
                                            for (int i = 0; i < NOA; i++) {
                                                if (i < Allgrounder1.length) {
                                                } else {
                                                    lista.remove(a[Allgrounder2[i - Allgrounder1.length] + Rider2.length]);
                                                }
                                            }
                                            Diffender2[Diffender2.length - 1] = Diffender2[Diffender2.length - 1] + 1;
                                            int n13;
                                            for (n13 = Diffender2.length - 1; n13 >= 1; n13--) {
                                                if (Diffender2[n13] >= n13 + a.length - Rider2.length - Allgrounder2.length - Diffender2.length + 1) {
                                                    Diffender2[n13 - 1] = Diffender2[n13 - 1] + 1;
                                                    Diffender2[n13] = 0;
                                                }
                                            }
                                            for (n13 = 1; n13 < Diffender2.length; n13++) {
                                                if (Diffender2[n13] == 0) {
                                                    Diffender2[n13] = Diffender2[n13 - 1] + 1;
                                                }
                                            }
                                            if (Diffender2[0] >= a.length - Rider2.length - Allgrounder2.length - Diffender2.length + 1) {
                                                break;
                                            }
                                        }
                                    } else {

                                        dd2 = false;
                                    }

                                    Boolean conti = true;
                                    for (int l = 0; l < Rider1.length; l++) {
                                        if (A[Rider1[l]].equals("A")) {
                                            continue;
                                        } else if (A[Rider1[l]].equals("B")) {
                                            continue;
                                        } else if (A[Rider1[l]].equals("C")) {
                                            continue;
                                        } else {
                                            conti = false;
                                            continue Tasks;
                                        }
                                    }
                                    for (int l = 0; l < Rider2.length; l++) {
                                        if (a[Rider2[l]].equals("a")) {
                                            continue;
                                        } else if (a[Rider2[l]].equals("b")) {
                                            continue;
                                        } else {
                                            conti = false;
                                            continue Tasks;
                                        }
                                    }
                                    for (int l = 0; l < Allgrounder1.length; l++) {
                                        if (AllGrounderlist1[l].equals("C")) {
                                            continue;
                                        } else {
                                            conti = false;
                                            continue Tasks;
                                        }
                                    }
                                    for (int l = 0; l < Allgrounder2.length; l++) {
                                        if (AllGrounderlist2[l].equals("c")) {
                                            continue;
                                        } else if (AllGrounderlist2[l].equals("d")) {
                                            continue;
                                        } else {
                                            conti = false;
                                            continue Tasks;
                                        }
                                    }
                                    for (int l = 0; l < Diffender1.length; l++) {
                                        if (listA.get(Diffender1[l]).equals("E")) {
                                            continue;
                                        } else if (listA.get(Diffender1[l]).equals("F")) {
                                            continue;
                                        } else if (listA.get(Diffender1[l]).equals("G")) {
                                            continue;
                                        } else {
                                            conti = false;
                                            //continue Tasks;
                                        }
                                    }
                                    for (int l = 0; l < Diffender2.length; l++) {
                                        if (lista.get(Diffender2[l]).equals("e")) {
                                            continue;
                                        } else if (lista.get(Diffender2[l]).equals("f")) {
                                            continue;
                                        } else if (lista.get(Diffender2[l]).equals("g")) {
                                            continue;
                                        } else {
                                            conti = false;
                                            //continue Tasks;
                                        }
                                    }


                                    if (conti) {
                                        System.out.print("R[ ");

                                        for (int l = 0; l < Rider1.length; l++) {
                                            System.out.print(A[Rider1[l]] + " ");
                                        }
                                        for (int l = 0; l < Rider2.length; l++) {
                                            System.out.print(a[Rider2[l]] + " ");
                                        }

                                        System.out.print("] , A[ ");

                                        for (int l = 0; l < Allgrounder1.length; l++) {
                                            System.out.print(AllGrounderlist1[l] + " ");
                                        }

                                        for (int l = 0; l < Allgrounder2.length; l++) {
                                            System.out.print(AllGrounderlist2[l] + " ");
                                        }

                                        System.out.print("] , D[ ");
                                        //System.out.print("/A ");

                                        for (int l = 0; l < Diffender1.length; l++) {
                                            System.out.print(listA.get(Diffender1[l]) + " ");
                                        }

                                        for (int l = 0; l < Diffender2.length; l++) {
                                            System.out.print(lista.get(Diffender2[l]) + " ");
                                        }

                                        System.out.print("] ");
                                        //System.out.print("/D");
                                        System.out.print(" " + ++count + "\n");

                                    }
                                    //break ;
                                }
                                //break ;
                            }
                            //break ;
                        }
                        //break ;
                    }
                    //break ;
                }
                //break ;
            }

        }

        System.out.print(count);

    }
}
