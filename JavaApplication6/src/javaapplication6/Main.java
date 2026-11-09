package JavaApplication6;

abstract class Student {
    
    Student() {
        System.out.println("I'm Student Constructor");
    }
    
    Student(String name) {
    
    }
    
    public abstract void sayHi();
    
    public void sayHello() {
        System.out.println("Helloooooooo!");
    }
}

class BioStudent extends Student {    
    
    BioStudent() {
        super();
    }
    
    @Override
    public void sayHi() {
        System.out.println("Hi! Bio Student");
    }
}


public class Main {
    
    public static void main(String[] args) {
       
        BioStudent b = new BioStudent();
        b.sayHi();
        b.sayHello();
        
    }
    
}


