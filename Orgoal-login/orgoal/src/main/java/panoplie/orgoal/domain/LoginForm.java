package panoplie.orgoal.domain;

public class LoginForm {
    private String id;
    private String password;

    public LoginForm() {}

    public LoginForm(String id, String password) {
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
