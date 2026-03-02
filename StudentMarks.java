import java.util.Scanner;

class Student {

    String name;
    int rollNo;
    int[] marks = new int[5];
    int average;
    char grade;

    static int[] subjectTotal = new int[5];
    static int studentCount = 0;

    // Default Constructor
    Student() {
        name = "";
        rollNo = 0;
        average = 0;
        grade = 'C';
    }

    // Parameterized Constructor
    Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            this.marks[i] = marks[i];
            sum += marks[i];
            subjectTotal[i] += marks[i];
        }

        average = sum / 5;

        if (average >= 75)
            grade = 'A';
        else if (average >= 60)
            grade = 'B';
        else
            grade = 'C';

        studentCount++;
    }

    void input(Scanner sc) {
        System.out.println("Enter Name:");
        name = sc.nextLine();

        System.out.println("Enter Roll No:");
        rollNo = sc.nextInt();

        System.out.println("Enter marks for 5 subjects (out of 100):");
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            marks[i] = sc.nextInt();
            sum += marks[i];
            subjectTotal[i] += marks[i];
        }

        average = sum / 5;

        if (average >= 75)
            grade = 'A';
        else if (average >= 60)
            grade = 'B';
        else
            grade = 'C';

        studentCount++;
        sc.nextLine();
    }

    void display() {
        System.out.println("\nName: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);
    }

    static void displaySubjectAverages() {
        System.out.println("\nAverage Marks for Each Subject:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Subject " + (i + 1) + ": " + (subjectTotal[i] / studentCount));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of students:");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] s = new Student[n + 1];  // +1 for the hardcoded student

        for (int i = 0; i < n; i++) {
            s[i] = new Student();  // using default constructor
            s[i].input(sc);
            s[i].display();
        }

        s[n - 1] = new Student("suhana", n, new int[]{80, 75, 85, 90, 70});
        s[n - 1].display();

        Student.displaySubjectAverages();
        sc.close();
    }
}
