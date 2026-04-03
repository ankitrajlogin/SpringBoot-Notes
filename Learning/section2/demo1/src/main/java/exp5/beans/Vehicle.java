package exp5.beans;


public class Vehicle {
    private String name ;

    public Vehicle(){
        System.out.println("Vehicle bean created") ;
    }

    public String getName(){
        return name ;
    }

    public void setName(String name){
        this.name = name ;
    }

    public void about(){
        System.out.println("this is a about section") ;
    }


    @Override
    public String toString(){
        return "Vehicle(" + "name=" + name + '\'' + "}" ;
    }





}