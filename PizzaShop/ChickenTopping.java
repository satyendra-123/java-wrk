public class ChickenTopping extends Topping{

    public ChickenTopping(Pizza pizza){
        super(pizza);
    }
    
    public String prepare(){
       return super.prepare() + prepareWithChickenTopping();
    }

    private String prepareWithChickenTopping(){
        return "With chicken Topping";
    }
}