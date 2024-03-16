package GoogleQuestion.CollegeAllotment;

public class KcetClass {
    String DATA[][][] = {
            {{"CS", "1", "0"}, {"EC", "2", "0"}, {"EEE", "1", "0"}},
            {{"CS", "1", "0"}, {"EC", "1", "0"}, {"CY", "1", "0"}},
            {{"EC", "1", "0"}, {"CY", "2", "0"}, {"EEE", "2", "0"}}
    };

    public static void main(String[] args) {

        KcetClass kcet = new KcetClass();

        String DATA[][][] = {
                {{"CS", "1", "0"}, {"EC", "2", "0"}, {"EEE", "1", "0"}},
                {{"CS", "1", "0"}, {"EC", "1", "0"}, {"CY", "1", "0"}},
                {{"EC", "1", "0"}, {"CY", "2", "0"}, {"EEE", "2", "0"}}
        };
        int number_of_students_alloted_for_college = 0;
        Students[] collection_of_student = new Students[8];
        for (int i = 0; i < collection_of_student.length; i++) {

            if (i == 0) {
                collection_of_student[i] = new Students(1, "Thippe", "1CS", "2CS", "3CY");
            } else if (i == 1) {
                collection_of_student[i] = new Students(2, "swammy", "2CS", "3CS", "2CY");
            } else if (i == 2) {
                collection_of_student[i] = new Students(4, "Ashwitha", "3CY", "2CY", "1EEE");
            } else if (i == 3) {
                collection_of_student[i] = new Students(6, "Banu", "1EEE", "3EEE", "2CY");
            } else if (i == 4) {
                collection_of_student[i] = new Students(3, "Taja", "2CS", "1EEE", "1CS");
            } else if (i == 5) {
                collection_of_student[i] = new Students(5, "Ganesh", "2CY", "2CS", "2EC");
            } else if (i == 6) {
                collection_of_student[i] = new Students(8, "Goutham", "2CS", "1CS", "3CY");
            } else if (i == 7) {
                collection_of_student[i] = new Students(7, "Sunitha", "1CS", "2CY", "3CY" );
            }
        }

//
//        for (int i=0;i<DATA.length;i++){
//            for(int n=0;n<DATA[i].length;n++){
//                for(int j=0;j<DATA[i][n].length;j++){
//                    System.out.print(DATA[i][n][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//            System.out.println();
//        }

        for (int i = 1; i < collection_of_student.length; i++) {
            for (int n = 0; n < collection_of_student.length - i; n++) {
                if (collection_of_student[n].rank_of_students > collection_of_student[n + 1].rank_of_students) {
                    Students s = collection_of_student[n];
                    collection_of_student[n] = collection_of_student[n + 1];
                    collection_of_student[n + 1] = s;
                }
            }
        }

        for (int st = 0; st < collection_of_student.length; st++) {
            for (int n = 0; n < collection_of_student[st].college_code_course.length; n++) {
                if (kcet.isSeat_Empty(collection_of_student[st].college_code_course[n]+"")) {
                    collection_of_student[st].got_college = collection_of_student[st].college_code_course[n];
                    number_of_students_alloted_for_college++;
                    break;
                }
            }
        }
        for (int i = 0; i < collection_of_student.length; i++) {
            System.out.println(collection_of_student[i].name + "  " +
                    collection_of_student[i].rank_of_students + "  " +
                    collection_of_student[i].got_college);
        }
    }

    public boolean isSeat_Empty(String S) {
        boolean isEmpty = false;
        String s=S;
        if (s.length()>=1) {
        for (int i = 0; i < DATA[Integer.parseInt(s.substring(0, 1)) - 1].length; i++) {
            if (s.substring(1, s.length()).equals(DATA[Integer.parseInt(s.substring(0, 1)) - 1][i][0])) {
                if (Integer.parseInt(DATA[Integer.parseInt(s.substring(0, 1)) - 1][i][1]) > Integer.parseInt(DATA[Integer.parseInt(s.substring(0, 1)) - 1][i][2])) {
                    DATA[Integer.parseInt(s.substring(0, 1)) - 1][i][2] = DATA[Integer.parseInt(s.substring(0, 1)) - 1][i][2] + 1;
                    isEmpty = true;
                }
            }
        }
    }
        return isEmpty;
    }
}
