package pizzaloop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PizzaDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pizzaId;
    private String title;
    private String shortdesc;
    private Double rating;
    private Double price;
    private String image;
    private String status;

    //ID
    public Integer getId() {
        return pizzaId;
    }

    public void setId(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }

    //TITLE
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    //DESCRIPTION
    public String getShortdesc() {
        return shortdesc;
    }
    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    //RATING
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) { this.rating = rating; }

    //PRICE
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) { this.price = price; }


    //IMAGE
    public String getImage() {
        return image;
    }
    public void setImage(String image) { this.image = image; }

    //STATUS
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) { this.status = status; }


}