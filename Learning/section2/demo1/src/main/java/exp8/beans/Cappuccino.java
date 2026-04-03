package exp8.beans;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("cappuccino")
@Primary
public class Cappuccino implements Coffee{

    public Cappuccino(){
        System.out.println("Cappuccino constructor called");

    }

    @Override
    public String makeCoffee() {
        return "Cappuccino Coffee";
    }
}
