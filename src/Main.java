import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Registration registration = new Registration();
        registration.Register();

        Scanner scanner = new Scanner(System.in);
        // Link the registration data to the login system
        Login login = new Login(registration.username, registration.password,
                registration.firstName, registration.lastName);

        System.out.println("Please log in now.");
        for (int i = 0; i < 3; i++) {
            System.out.println("Please enter username: ");
            String loginUser = scanner.nextLine();
            System.out.print("Please enter password: ");
            String loginPass = scanner.nextLine();

            String message = login.LoginUser(loginUser, loginPass);
            System.out.println(message);

            // Check if login was successful (case-insensitive check)
            if (message.toLowerCase().startsWith("welcome")) {
                return; // Exit program on success
            }

            if (i == 2) {
                System.out.println("Too many failed attempts. Account locked.");
            } else {
                System.out.println("Attempts remaining: " + (2 - i));
            }
        }
    }
}