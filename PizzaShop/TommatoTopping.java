public class TommatoTopping extends Topping{

    public TommatoTopping(Pizza pizza){
        super(pizza);
    }
    
    public String prepare(){
       return super.prepare() + prepareWithTommatoTopping();
    }

    private String prepareWithTommatoTopping(){
        return "With Tommato Topping";
    }
}