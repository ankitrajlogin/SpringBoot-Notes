package exp8.beans;

import org.springframework.stereotype.Component;

@Component("expresso")
public class Expresso implements Coffee{

    public Expresso(){
        System.out.println("Expresso constructor called");
    }

    @Override
    public String makeCoffee() {
        return "Expresso Coffee";
    }
}
