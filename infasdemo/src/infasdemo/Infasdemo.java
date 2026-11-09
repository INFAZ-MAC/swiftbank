package infasdemo;

class Main{
interface A{
    public void printHello();
    
    public default void printHello1(){
        System.out.println("Hello");
    }
}

class B implements A{
    
    @Override
    public void printHello(){
        System.out.println("Hi");
    }
}

   @Override
    public void printHello1(){
    System.out.println("Hi-1");
}


public class Main{
    
    public static void main(String[] args){
        System.out.println("Hi-1!");
    }
}

public class Main{
    public static void main(String[] args){
        
        A a = new B();
        a.printHello();
        a.printHello1();
    }
}
}