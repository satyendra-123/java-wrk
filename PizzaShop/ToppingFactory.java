public class ToppingFactory{

    public Pizza getTopping(String topping, Pizza pizza){        
        if(ToppingType.TOMMATO.value().equalsIgnoreCase(topping)){
                return new TommatoTopping(pizza);
        }else if(ToppingType.CHICKEN.value().equalsIgnoreCase(topping)){
            return new ChickenTopping(pizza);
        }
        return null;
    }
}