import java.util.Scanner;

public class Registration {
    String username, password, phoneNumber, firstName, lastName;

    public boolean checkuserName(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    public boolean checkPassword(String password) {
        if (password.length() < 8) return false;

        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasDigit = password.matches(".*\\d.*");
        // Fixed: Check for actual special characters (not letters/digits)
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

        return hasUppercase && hasDigit && hasSpecial;
    }

    public boolean checkphoneNumber(String phoneNumber) {
        return phoneNumber.matches("(\\+27|0)[0-9]{9}");
    }

    public void Register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        lastName = scanner.nextLine();

        do {
            System.out.println("Username (max 5 chars, must contain '_'): ");
            username = scanner.nextLine();
        } while (!checkuserName(username));

        do {
            System.out.println("Phone Number (0... or +27...): ");
            phoneNumber = scanner.nextLine();
        } while (!checkphoneNumber(phoneNumber));

        do {
            System.out.println("Password (min 8 chars, 1 Uppercase, 1 Digit, 1 Special): ");
            password = scanner.nextLine();
        } while (!checkPassword(password));

        System.out.println("Registration successful!\n");
    }
}

