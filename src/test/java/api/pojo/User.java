
package api.pojo;



public class User {

    private String email;
    private String firstName;
    private int id;
    private String lastName;
    private String password;
    private String phone;
    private int userStatus;
    private String username;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getUserStatus() {
        return userStatus;
    }
    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", userStatus=" + userStatus +
                ", username='" + username + '\'' +
                '}';
    }
}
