package homework_17.utils.rest_assured;

public class RegisterRequest {
    String email;
    String password;

    RegisterRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RegisterRequest(String email) {
        this.email = email;
    }
}