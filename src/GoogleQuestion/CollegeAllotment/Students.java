package GoogleQuestion.CollegeAllotment;

public class Students {

    int rank_of_students;
    String college_code_course[] = new String[3];
    String name, got_college;

    public Students(int r, String n, String a, String b, String c) {
        rank_of_students = r;
        name = n;
        college_code_course[0] = a;
        college_code_course[1] = b;
        college_code_course[2] = c;
        got_college = "";
    }

}
