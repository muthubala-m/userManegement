import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choise = 0;
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        do {
            menu.displayMenu();
            choise = scanner.nextInt();
            menu.switchOperation(choise);
            
        } while (choise>0 && choise<6);

        scanner.close();
    }
}