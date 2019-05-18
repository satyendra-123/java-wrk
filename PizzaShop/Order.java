public class Order{

    private Integer id;

    private String pizzType;

    private String toppingType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPizzType() {
        return pizzType;
    }

    public void setPizzType(String pizzType) {
        this.pizzType = pizzType;
    }

    public String getToppingType() {
        return toppingType;
    }

    public void setToppingType(String toppingType) {
        this.toppingType = toppingType;
    }
    
    public static Order getOrder(){
        return new Order();
    }
}