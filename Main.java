import java.util.*;
import java.util.Scanner;
public class Main {
    static ArrayList<Student> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1.Add 2.View 3.Delete 4.Update 5.Search 6.Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                System.out.print("Enter Name: ");
                String name = sc.next();

                list.add(new Student(id, name));
                boolean exists = false;
                for (Student s : list) {
                    if (s.id == id) {
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    System.out.println("ID already exists");
                } else {
                    list.add(new Student(id, name));
                }
            }

            else if (choice == 2) {
                for (Student s : list) {
                    System.out.println(s);
                }
            }

            else if (choice == 3) {
                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();

                list.removeIf(s -> s.id == id);
            }
            else if (choice == 4) {
                System.out.print("Enter ID to update: ");
                int id = sc.nextInt();

                for (Student s : list) {
                    if (s.id == id) {
                        System.out.print("Enter new name: ");
                        String newName = sc.next();
                        s.name = newName;
                    }
                }
                
            }
            else if (choice == 5) {
                System.out.print("Enter ID to search: ");
                int id = sc.nextInt();

                boolean found = false;

                for (Student s : list) {
                    if (s.id == id) {
                        System.out.println(s);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Student not found");
                }
            }

            else {
                break;
            }
        }
        sc.close();
    }
}