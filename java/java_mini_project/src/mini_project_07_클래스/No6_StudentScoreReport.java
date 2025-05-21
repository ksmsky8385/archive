package mini_project_07_클래스;

public class No6_StudentScoreReport {
    public static void main(String[] args) {
        No6_Student[] student = new No6_Student[10];

        student[0] = new No6_Student(100, 70, 80);
        student[1] = new No6_Student(70, 80, 60);
        student[2] = new No6_Student(80, 70, 70);
        student[3] = new No6_Student(60, 80, 80);
        student[4] = new No6_Student(50, 60, 70);
        student[5] = new No6_Student(70, 50, 60);
        student[6] = new No6_Student(90, 90, 50);
        student[7] = new No6_Student(90, 80, 90);
        student[8] = new No6_Student(80, 70, 90);
        student[9] = new No6_Student(100, 80, 90);

        System.out.println("### Score Report ###");
        System.out.println("국어  영어  수학   |    종합  평균");
        System.out.println("---------------------------------------");

        for (int i = 0; i < student.length; i++) {
            System.out.printf("%-3d\t%-3d\t%-3d\t\t|\t%-3d\t  %d%n", 
                student[i].getScoreKor(), student[i].getScoreEng(), student[i].getScoreMath(),
                student[i].sum(), student[i].avg());
        }
    }
}