public abstract class Topping extends Pizza{
    private Pizza pizza;

    protected Topping(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String prepare(){
          return pizza.prepare();
    }
}