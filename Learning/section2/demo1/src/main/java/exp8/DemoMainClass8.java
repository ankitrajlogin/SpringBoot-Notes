package exp8;


import exp8.beans.Coffee;
import exp8.beans.CoffeeShop;
import exp8.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoMainClass8 {
    public static void main(String[] args){


        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var CoffeeShop = context.getBean(CoffeeShop.class) ;
        Coffee coffee = CoffeeShop.getCoffee() ;

        System.out.println(coffee.makeCoffee()) ;


    }

}
