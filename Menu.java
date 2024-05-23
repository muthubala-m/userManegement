import java.sql.ResultSet;
import java.util.Scanner;

public class Menu {
    int userId;
    String userName;
    String email;
    String passWord;
    static Scanner scanner = new Scanner(System.in);
    static Database database = new Database();
    private ResultSet resultSet;

    public void displayMenu(){
        System.out.println("-----------------------------");
        System.out.println("\tUSER MANAGEMENT");
        System.out.println("-----------------------------");
        System.out.println("1.Insert a New User");
        System.out.println("2.Update a User");
        System.out.println("3.Show a Single User");
        System.out.println("4.Show all  Users");
        System.out.println("5.Delete a user");
        System.out.println("Enter Your Choise :");
    }
    public void switchOperation(int choise){
        switch (choise) {
            case 1:
                System.out.println("enter userId");
                this.userId = scanner.nextInt();
                this.getInputs();
                database.insertUser(userId, userName, email, passWord);
                break;

            case 2:
                System.out.println("enter userId");
                this.userId = scanner.nextInt();
                this.getInputs();
                database.updateUser(userId, userName, email, passWord);
                break;
            case 3:
                System.out.println("enter userId");
                this.userId = scanner.nextInt();
                this.resultSet =  database.getSingleUser(userId);
                this.displayUserDetails(resultSet,true);
                break;
            case 4:
                this.resultSet = database.getAllUsers();
                this.displayUserDetails(resultSet,false);
                break;
            case 5:
                System.out.println("enter userId");
                this.userId = scanner.nextInt();
                database.deleteUser(userId);
                break;
            default:
                System.out.println("enter a valid choise 1 to 5 ...");
                break;
        }
    }

    // get inputs from user

    public void getInputs(){
        System.out.println("enter username :");
        this.userName = scanner.next();
        System.out.println("enter email :");
        this.email = scanner.next();
        System.out.println("enter password :");
        this.passWord = scanner.next();
    }

    // displaying the user datails

    public void displayUserDetails(ResultSet resultSet,boolean isSingleRecord){
        try{
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("\tuserId\t\tuserName\t\temail\t\tpassWord");
            System.out.println("------------------------------------------------------------------------------");
            if(isSingleRecord){
                System.out.println("\t"+resultSet.getInt(1)+"\t\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4));
            }else{
                while (resultSet.next()) {
                    System.out.println("\t"+resultSet.getInt(1)+"\t\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4));
                }
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
