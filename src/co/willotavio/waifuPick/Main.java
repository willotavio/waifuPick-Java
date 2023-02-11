package co.willotavio.waifuPick;

import java.util.Scanner;

public class Main {
    static Control control = new Control();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        while(true){
            System.out.println("Waifu Pick" +
                    "\nChoose an option" +
                    "\nC.Create Account" +
                    "\nL.Login" +
                    "\nE.Exit");
            String op = input.nextLine().toUpperCase();
            if (op.equals("C")) {
                System.out.println("Enter your email:");
                String userEmail = input.nextLine();
                System.out.println("Enter your user name:");
                String userName = input.nextLine();
                System.out.println("Enter your password:");
                String userPassword = input.nextLine();
                control.generateUser(userEmail, userName, userPassword);
                control.listUsers();
            }
            else if(op.equals("L")){
                System.out.println("Enter your email:");
                String userEmail = input.nextLine();
                System.out.println("Enter your password:");
                String userPassword = input.nextLine();
                User result = control.login(userEmail, userPassword);
                if (result != null){
                    operateAccount(result);
                }
                else{
                    System.out.println("Invalid credentials!");
                }
            }
            else if(op.equals("E")){
                break;
            }
            else{
                System.out.println("Invalid option!" +
                        "\nTry again");
            }
        }


    }

    public static void operateAccount(User user){

        while(true){
            System.out.println("Hello " + user.getUserName() + "!" +
                    "\nChoose an option:" +
                    "\nN.New Waifu" +
                    "\nL.List Waifus" +
                    "\nA.Access Waifu" +
                    "\nE.Exit");
            String op = input.nextLine().toUpperCase();
            if(op.equals("N")){
                System.out.println("sla vei");
            }
            else if(op.equals("L")){
                System.out.println("sla vei");
            }
            else if(op.equals("A")){
                System.out.println("sla vei");
            }
            else if(op.equals("E")){
                break;
            }
            else{
                System.out.println("Invalid option!" +
                        "\nTry again");
            }
        }
    }
}