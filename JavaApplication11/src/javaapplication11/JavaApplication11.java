/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication11;


public class JavaApplication11 {
    
    public static void sum(int x, String name, int...a, double y){
        
        int tot = 0;
        for(int i:a){
            tot+=i;
        }
        System.out.println(tot);
    }

    public static void Main(String[] args){
        
        sum(10,"Hello",20,30,40,50,60,70,80,90,100);
    }
  
    public static void Main(String[] args) {
        
        
    }
    
}
