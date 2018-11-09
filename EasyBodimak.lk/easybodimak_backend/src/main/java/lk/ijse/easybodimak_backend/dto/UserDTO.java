package lk.ijse.easybodimak_backend.dto;

public class UserDTO {
    private String id;
    private String email;
    private String name;
    private String address;
    private String tel;
    private String registerDate;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String id,String email, String name, String address, String tel, String registerDate, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.registerDate = registerDate;
        this.password = password;
    }

    public UserDTO(String id,String email, String name, String address, String tel, String registerDate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.registerDate = registerDate;
    }

    public UserDTO(String email,String password) {
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
