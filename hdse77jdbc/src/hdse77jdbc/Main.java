package hdse77jdbc;

import java.util.Scanner;
import hdse77jdbc.view.MainMenuView;


public class Main {
    
    
   private static final Scanner scanner = new Scanner(System.in);
   static MainMenuView MainMenuView=new MainMenuView();

    public static void main(String[] args) {
        MainMenuView.loadMainMenu();
    }
}