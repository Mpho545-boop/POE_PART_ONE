public class Login {
    private String username, password, firstName, lastName;

    public Login(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String LoginUser(String enteredUsername, String enteredPassword) {
        if (enteredUsername.equals(this.username) && enteredPassword.equals(this.password)) {
            return "Welcome, " + firstName + " " + lastName + "! It is great to see you again.";
        } else {
            return "Username or password incorrect. Please try again.";
        }
    }
}
