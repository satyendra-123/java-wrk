public class PizzaFactory{

    public Pizza getPizza(String pizza){        
        if(PizzaType.VEG_PIZZA.value().equalsIgnoreCase(pizza)){
                return new VegPizza();
        }else if(PizzaType.NONVEG_PIZZA.value().equalsIgnoreCase(pizza)){
            return new NonVegPizza();
        }
        return null;
    }
}