import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join
        REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them
        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."
        Store all these 3 objects in a collection and print them
        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */
        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println(UserQuestions.askToJoin);
            String ans = input.nextLine();
            if (ans.toUpperCase().startsWith("Y")) {
                System.out.println(UserQuestions.askFirstName);
                String name = input.nextLine();
                System.out.println(UserQuestions.askLastName);
                String lName = input.nextLine();
                System.out.println(UserQuestions.askAge);
                int age = input.nextInt();
                input.nextLine();
                Permission.checkAge(age);

                System.out.println(UserQuestions.askGender);
                String gender = input.nextLine();

                System.out.println(UserQuestions.askClassName);
                String className = input.nextLine();
                Permission.checkClassName(className);


                if (className.toLowerCase().startsWith("math")) {
                    MathStudent mathStudent = new MathStudent(name, lName, age, gender, className);
                    students.add(mathStudent);
                    System.out.println("Congratulations! You are registered for " + mathStudent.getClassName() + " class.");
                }
                if (className.toLowerCase().startsWith("science")) {
                    ScienceStudent scienceStudent = new ScienceStudent(name, lName, age, gender, className);
                    students.add(scienceStudent);
                }
            }

        } while (students.size() <= 2);


        int mathCount = 0;
        int scienceCount = 0;
        for (Student student : students) {
            System.out.println(student);
            if (student.getClassName().equalsIgnoreCase("math")) mathCount++;
            else {
                scienceCount++;
            }
        }
        System.out.println("Math students = " + mathCount);
        System.out.println("Science students = " + scienceCount);

    }
}