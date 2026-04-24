package exp9.beans;


// as we not craeted this bean using component, then while creating this vehiclce class we need to pass engine class

public class Vehicle {
    private String name ;
    private Engine engine ;

    public Vehicle(Engine engine){
        this.engine = engine ;
        System.out.println("Vehicle bean created") ;
    }

    public Engine getEngine(){
        return engine ;
    }

    public String getName(){
        return name ;
    }

    public void setName(String name){
        this.name = name ;
    }

    @Override
    public String toString(){
        return "Vehcile{"
                + "name=" + name + '\'' + "}" ;
    }
}

