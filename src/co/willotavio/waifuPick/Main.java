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
                User user = control.generateUser(userEmail, userName, userPassword);
                control.insertUser(user);
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
                System.out.println("Enter your waifu name:");
                String waifuName = input.nextLine();
                System.out.println("Enter your waifu rank:");
                String waifuRank = input.nextLine();
                System.out.println("Enter your waifu review:");
                String waifuReview = input.nextLine();
                Waifu waifu = user.addWaifu(waifuName, waifuRank, waifuReview);
                user.insertWaifu(waifu);
            }
            else if(op.equals("L")){
                user.listWaifu();
            }
            else if(op.equals("A")) {
                try {
                    user.listWaifu();
                    System.out.println("Enter the waifu ID you want to access:");
                    int waifuId = input.nextInt();
                    input.nextLine();
                    Waifu waifu = user.accessWaifu(waifuId);
                    if (waifu != null) {
                        System.out.println(waifu.getWaifuName());
                        System.out.println("Choose an option" +
                                "\nU.Update Waifu" +
                                "\nD.Delete Waifu" +
                                "\nE.Exit");
                        op = input.nextLine().toUpperCase();
                        if(op.equals("U")){
                            System.out.println("Which attribute would you want to update?" +
                                    "\n1.Name: " + waifu.getWaifuName() +
                                    "\n2.Rank: " + waifu.getWaifuRank() +
                                    "\n3.Review: " + waifu.getWaifuReview());
                            int attribute = input.nextInt();
                            input.nextLine();
                            if(attribute > 4){
                                System.out.println("Choose an valid option");
                                break;
                            }
                            else{
                                System.out.println("Enter the new attribute value:");
                                String newValue = input.nextLine();
                                if(!user.updateWaifu(waifuId, attribute, newValue)){
                                    System.out.println("Error");
                                }
                                else{
                                    System.out.println("Waifu updated!");
                                }
                            }
                        }
                        else if(op.equals("D")){
                            System.out.println("sla vei");
                        }
                        else if(op.equals("E")){
                            operateAccount(user);
                        }
                        else{
                            System.out.println("Invalid option!" +
                                    "\nTry again");
                        }
                    } else {
                        System.out.println("This ID doesn't exist!");
                    }
                } catch (Exception e) {
                    System.out.println("Enter a valid ID number!");
                    input.nextLine();
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
}