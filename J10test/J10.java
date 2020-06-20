import java.util.List;
import java.util.function.Function;

public class J10 implements Runnable{

    public static void main(String args[]){
        Thread t1  = new Thread(new J10());
        Thread t2  = new Thread(new J10()); 
        t1.start();
        t2.start();      
    }

    @Override
    public void run(){
         test();
    }

synchronized void test(){
    try{
        System.out.println("I am working "+ Thread.currentThread().getName());
        List<Person>  list = List.of(new Person(101, "Nayara", 19),new Person(102, "Ramesh", 19));       
        var listream = list.stream();    
         listream.forEach(c->{
                testDoer().apply(c);      
                System.out.println(" "+c.getPName()+" is eligible for task : "+c.isElgibileForTask());
        });
    }
    catch(InterruptedException ex){
        ex.printStackTrace();
    }        
 }

    /**
        function to apply for task
     */
    private static Function<Person, Boolean> testDoer(){
        return (Person p)->{
              if(p.getAge() > 18)
                  p.setIsEligible(true);            
              return  p.isElgibileForTask();
        };
    }

    static class Person{
               private long pId;
               private String pName;

               private int age;

               private boolean isEligible;

               Person(long pId, String pName, int age){
                   this.pId = pId;
                   this.pName = pName;
                   this.age = age;
               }

               public void setIsEligible(boolean isElig){
                   isEligible = isElig;
               }

               public boolean isElgibileForTask(){
                   return isEligible;
               }

               public String getPName(){
                   return pName;
               }

               public long getPID(){
                   return pId;
               }

               public int getAge(){
                   return age;
               }
    }

}