import java.util.ArrayList;
import java.util.Scanner;

class Course {

    int courseId;
    String courseName;
    String instructor;
    int credits;

    // Constructor
    Course(int courseId, String courseName, String instructor, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
    }

    // Display Method
    void display() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructor);
        System.out.println("Credits: " + credits);
        System.out.println("----------------------------------");
    }
}

public class Main {

    static ArrayList<Course> courses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // CREATE
    static void addCourse() {

        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Instructor Name: ");
        String instructor = sc.nextLine();

        System.out.print("Enter Credits: ");
        int credits = sc.nextInt();

        Course c = new Course(id, name, instructor, credits);
        courses.add(c);

        System.out.println("Course Added Successfully!");
    }

    // READ
    static void viewCourses() {

        if (courses.isEmpty()) {
            System.out.println("No Courses Found!");
            return;
        }

        for (Course c : courses) {
            c.display();
        }
    }

    // UPDATE
    static void updateCourse() {

        System.out.print("Enter Course ID to Update: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Course c : courses) {

            if (c.courseId == id) {

                sc.nextLine();

                System.out.print("Enter New Course Name: ");
                c.courseName = sc.nextLine();

                System.out.print("Enter New Instructor Name: ");
                c.instructor = sc.nextLine();

                System.out.print("Enter New Credits: ");
                c.credits = sc.nextInt();

                System.out.println("Course Updated Successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Course Not Found!");
        }
    }

    // DELETE
    static void deleteCourse() {

        System.out.print("Enter Course ID to Delete: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Course c : courses) {

            if (c.courseId == id) {
                courses.remove(c);
                System.out.println("Course Deleted Successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Course Not Found!");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Update Course");
            System.out.println("4. Delete Course");
            System.out.println("5. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addCourse();
                    break;

                case 2:
                    viewCourses();
                    break;

                case 3:
                    updateCourse();
                    break;

                case 4:
                    deleteCourse();
                    break;

                case 5:
                    System.out.println("Program Exited.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);
    }
}