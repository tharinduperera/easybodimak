package lk.ijse.easybodimak_backend.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
    @Id
    private String aemail;
    private String aname;
    private String aaddress;
    private String atel;
    private String password;

    public Admin() {
    }

    public Admin(String aemail, String aname, String aaddress, String atel, String password) {
        this.aemail = aemail;
        this.aname = aname;
        this.aaddress = aaddress;
        this.atel = atel;
        this.password = password;
    }

    public Admin(String aemail, String aname, String aaddress, String atel) {
        this.aemail = aemail;
        this.aname = aname;
        this.aaddress = aaddress;
        this.atel = atel;
    }

    public String getAemail() {
        return aemail;
    }

    public void setAemail(String aemail) {
        this.aemail = aemail;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAaddress() {
        return aaddress;
    }

    public void setAaddress(String aaddress) {
        this.aaddress = aaddress;
    }

    public String getAtel() {
        return atel;
    }

    public void setAtel(String atel) {
        this.atel = atel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aemail='" + aemail + '\'' +
                ", aname='" + aname + '\'' +
                ", aaddress='" + aaddress + '\'' +
                ", atel='" + atel + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
