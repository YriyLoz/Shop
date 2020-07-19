package models;

public class Order {
    private Integer id;
    private Integer productsId;
    private Integer customersId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductsId() {
        return this.productsId;
    }

    public void setProductsId(Integer productsId) {
        this.productsId = productsId;
    }

    public Integer getCustomersId() {
        return this.customersId;
    }

    public void setCustomersId(Integer customersId) {

        this.customersId = customersId;
    }
}
