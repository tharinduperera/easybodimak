package lk.ijse.easybodimak_backend.entity;
import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "ad")
public class Ad{
    @Id
    private String ad_id;
    private String userid;
    private String title;
    private String ad_date;
    private String description;
    private String location;
    private String category;
    private int noOfBedrooms;
    private int noOfBathrooms;
    private double price;
    private String map;
    private String[] image;
    private String status;

    public Ad() {
    }

    public Ad(String ad_id, String userid, String title, String ad_date, String description, String location, String category, int noOfBedrooms, int noOfBathrooms, double price, String map, String[] image, String status) {
        this.ad_id = ad_id;
        this.userid = userid;
        this.title = title;
        this.ad_date = ad_date;
        this.description = description;
        this.location = location;
        this.category = category;
        this.noOfBedrooms = noOfBedrooms;
        this.noOfBathrooms = noOfBathrooms;
        this.price = price;
        this.map = map;
        this.image = image;
        this.status = status;
    }

    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setuUserid(String userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAd_date() {
        return ad_date;
    }

    public void setAd_date(String ad_date) {
        this.ad_date = ad_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNoOfBedrooms() {
        return noOfBedrooms;
    }

    public void setNoOfBedrooms(int noOfBedrooms) {
        this.noOfBedrooms = noOfBedrooms;
    }

    public int getNoOfBathrooms() {
        return noOfBathrooms;
    }

    public void setNoOfBathrooms(int noOfBathrooms) {
        this.noOfBathrooms = noOfBathrooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String[] getImage() {
        return image;
    }

    public void setImage(String[] image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "ad_id='" + ad_id + '\'' +
                ", userid='" + userid + '\'' +
                ", title='" + title + '\'' +
                ", ad_date='" + ad_date + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", category='" + category + '\'' +
                ", noOfBedrooms=" + noOfBedrooms +
                ", noOfBathrooms=" + noOfBathrooms +
                ", price=" + price +
                ", map='" + map + '\'' +
                ", image=" + Arrays.toString(image) +
                ", status='" + status + '\'' +
                '}';
    }
}
