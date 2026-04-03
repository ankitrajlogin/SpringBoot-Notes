package exp8.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CoffeeShop {


    private final Coffee coffee;

    // NOTE : If a class has only ONE constructor, Spring will automatically use it for dependency injection — even without @Autowired.

//    @Autowired
//    public CoffeeShop(Coffee coffee) {
//        System.out.println("CoffeeShop constructor called");
//        this.coffee = coffee;
//    }

    // if we want to call specific coffee implementation , we can use qualifier
    @Autowired
    public CoffeeShop(@Qualifier("expresso") Coffee coffee){
        System.out.println("CoffeeShop constructor is called");
        this.coffee = coffee ;

    }


    public Coffee getCoffee() {
        return coffee ;
    }
}
