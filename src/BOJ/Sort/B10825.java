package BOJ.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class B10825 {
    public static Student[] students;
    public static class Student implements Comparable<Student>{
        String studentName;
        int kor, eng, math;

        public Student(String studentName, int kor, int eng, int math) {
            this.studentName = studentName;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if(this.kor != o.kor)
                return o.kor - this.kor;
            if(this.eng != o.eng)
                return this.eng - o.eng;
            if(this.math != o.math)
                return o.math - this.math;
            return this.studentName.compareTo(o.studentName);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public static void input(){
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        students = new Student[index];

        for (int i = 0; i < index; i++) {
            Student student = new Student(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            students[i] = student;
        }
    }
    public static void main(String[] args) {
        input();
        Arrays.sort(students);
        StringBuilder stringBuilder = new StringBuilder();
        for (Student student: students) {
            stringBuilder.append(student.studentName).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
