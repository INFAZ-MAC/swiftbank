package Main.java;

interface A {
    public void printHello();
}

class B implements A {
    @Override
    public void printHello() {
        System.out.println("Hi!");
    }
}

public class Main {
    
    public static void main(String[] args) {
       
        A a = new B();
        a.printHello();
        
    }
    
}



