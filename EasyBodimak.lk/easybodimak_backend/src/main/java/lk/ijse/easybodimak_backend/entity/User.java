package lk.ijse.easybodimak_backend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    private String id;
    private String email;
    private String name;
    private String address;
    private String tel;
    private String registerDate;
    private String password;

    public User() {
    }

    public User(String id,String email, String name, String address, String tel, String registerDate, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.registerDate = registerDate;
        this.password = password;
    }

    public User(String email, String password) {
        this.password =password;
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
        return "User{" +
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
