import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Main {
    static int running = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("Create a new user or log in or exit? (1/2/3) : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter your user name: ");
                String name = sc.next();
                System.out.println("Enter the password: ");
                String password = sc.next();
                User u = new User(name, password);

                int flag = 1;
                for (User check : User.users) {
                    if (check.username.equals(name)) {
                        System.out.println("Username already exists. Please try again.");
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1)
                    User.users.add(u);

            } else if (choice == 2) {
                System.out.println("Enter your user name: ");
                String name = sc.next();
                System.out.println("Enter the password: ");
                String password = sc.next();

                int flag = 1;
                for (User u : User.users) {
                    if (u.username.equals(name) && u.password.equals(password)) {
                        System.out.println("Welcome " + name);
                        flag = 0;
                        running = 0;
                        JFrame jFrame = new JFrame();
                        jFrame.setTitle("CHOOSING PAGE");

                        Add a = new Add();
                        Container cPane = jFrame.getContentPane();
                        Newclass template = new Newclass(a, cPane);
                        jFrame.setSize(template.getSize());
                        jFrame.setResizable(false);
                        cPane.add(template);

                        jFrame.setVisible(true);
                        jFrame.setLocationRelativeTo(null);
                        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    }
                }

                if (flag == 1) {
                    System.out.println("Sorry !! " + name + " \nEither username or password is wrong ");
                }

            } else {
                System.out.println("Thank you for using our application");
                running = 0;
            }

            sc.nextLine();

        } while (running == 1);
        sc.close();

    }

}
