package models;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer id;
    private String name;
    private String type;
    private Integer caliber;
    private String color;
    private Integer price;
    private String producer;

    public Product(Integer id, String name, String type, Integer caliber, String color, Integer price, String producer) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.caliber = caliber;
        this.color = color;
        this.price = price;
        this.producer = producer;
    }

    public Product() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCaliber() {
        return this.caliber;
    }

    public void setCaliber(Integer caliber) {
        this.caliber = caliber;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProducer() {
        return this.producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", caliber=" + caliber +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", producer='" + producer + '\'' +
                '}';
    }
}
