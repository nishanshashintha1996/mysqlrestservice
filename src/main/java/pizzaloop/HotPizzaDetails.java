package pizzaloop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class HotPizzaDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer hotPizzaId;
    private String title;
    private String shortdesc;
    private Double rating;
    private Double price;
    private String image;
    private String status;


    public Integer getHotPizzaId() {
        return hotPizzaId;
    }

    public void setHotPizzaId(Integer hotPizzaId) {
        this.hotPizzaId = hotPizzaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
