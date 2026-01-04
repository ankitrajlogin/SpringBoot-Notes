package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2 {
    public static void main(String[] args) {
          /*
        The var keyword was introduced in Java 10. Type inference is used in
        var keyword in which it detects automatically the datatype of a variable
        based on the surrounding context.
        * */
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class) ;


        // we can pass two parameter where first one is class name and class type in second.
        Vehicle veh = context.getBean("vehicle1", Vehicle.class) ;
        System.out.println("Vehicle name from the Spring Context is : " + veh.getName()) ;


        // calling beans with other name :
        Vehicle veh2 = context.getBean("FerrariVehicle", Vehicle.class) ;
        System.out.println("Vehicle name from the Spring Context is : " + veh2.getName()) ;


        Vehicle veh3 = context.getBean("BMWVehicle", Vehicle.class) ;
        System.out.println("Vehicle name from the Spring Context is : " + veh3.getName()) ;


        // as there are many class with Vehicle . so it call primary one annotation
        Vehicle veh4 = context.getBean(Vehicle.class) ;
        System.out.println("Vehicle name from the Spring Context is : " + veh4.getName()) ;







    }
}
