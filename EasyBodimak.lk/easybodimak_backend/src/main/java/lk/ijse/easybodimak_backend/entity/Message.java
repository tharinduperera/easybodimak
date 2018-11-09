package lk.ijse.easybodimak_backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    private String megid;
    private String email;
    private String date;
    private String name;
    private String subject;
    private String message;

    public Message() {
    }

    public Message(String megid, String email,String date, String name, String subject, String message) {
        this.megid = megid;
        this.email = email;
        this.date = date;
        this.name = name;
        this.subject = subject;
        this.message = message;
    }

    public Message(String email,String date, String name, String subject, String message) {
        this.email = email;
        this.date = date;
        this.name = name;
        this.subject = subject;
        this.message = message;
    }

    public String getMegid() {
        return megid;
    }

    public void setMegid(String megid) {
        this.megid = megid;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "megid='" + megid + '\'' +
                ", email='" + email + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
