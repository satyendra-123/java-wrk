import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PizzaShop{

    private static final Logger LOGGER = Logger.getLogger(PizzaShop.class.getName());

    private static final PizzaFactory pizzaFactory = new PizzaFactory();
    private static final ToppingFactory tFactory = new ToppingFactory();

    public static void main(String[] args) {
        openPizzaShop();
    }

    private static void openPizzaShop(){
        PizzaShop pizShop = new PizzaShop();
        List<Order> orderToBePlaced = pizShop.collectOrder();
        var orderStream = orderToBePlaced.stream();
        orderStream.forEach(c->{
            pizShop.placeOrder(c, pizzaFactory, tFactory);
        });
    }

    private List<Order> collectOrder(){
        Order order1 = Order.getOrder();
        order1.setId(001);
        order1.setPizzType("vegpizza");
        order1.setToppingType("tomatoo");

        Order order2 = Order.getOrder();
        order2.setId(002);
        order2.setPizzType("nonvegpizza");
        order2.setToppingType("chicken,tomatoo");


        return List.of(order1, order2);       
    }

    private void placeOrder(Order order, PizzaFactory pizzaFactory,ToppingFactory tFactory){
        LOGGER.info(LOGGER.getName()+ ".placeOrder For Order Id {} " + order.getId());
        String[] toppings = null;
        if(order.getToppingType().trim().contains(",")){
            toppings = order.getToppingType().trim().split(",");
        }else{
            toppings = new String[1];
            toppings[0] = order.getToppingType();
        }
        Pizza pizzaTopping = null;
        for(String s: toppings){
            if(pizzaTopping == null){
                pizzaTopping = tFactory.getTopping(s, pizzaFactory.getPizza(order.getPizzType()));
            }else{
                pizzaTopping = tFactory.getTopping(s, pizzaTopping);
            }
        }        
        LOGGER.info(LOGGER.getName()+ ".placeOrder Order is here {} " +   pizzaTopping.prepare());
    }
}