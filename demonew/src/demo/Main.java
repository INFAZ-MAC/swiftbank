
package demo;

Class A{
String name;
int age;
String address;

A(){
}

A(String name, int age, String address){
    this.name=name;
    this.age=age;
    this.address=address;
 }
}

class B extends A{
    String name;
    int age;
    String address;
     
    
    B(){
    }
  B(String name, int age, String address){
      super(name,age,address);
      
      this.name=name;
      this.age=age;
      this.address=address;
      
         /*super.name = name;
        super.age = age;
        super.address = address;*/

         
             public void printMyDetails() {
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.address);
    }

             
                 public void printParentDetails() {
        System.out.println(super.name);
        System.out.println(super.age);
        System.out.println(super.address);
    }
}

public class Main {
    
    public static void main(String[] args) {
        
       B b = new B("Saman", 20, "Colombo");
//       b.printMyDetails();
       b.printParentDetails();
       
    }
    
}



  }
}
