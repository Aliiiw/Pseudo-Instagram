import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SignUpUsers {

    static Scanner input = new Scanner(System.in);

    public void signUpUser(ArrayList<User> allUsers, HashMap<String, String> usersUserNameAndPassword){


        System.out.print("Please enter username for your account: ");
        String username = input.nextLine().toLowerCase();                                 //get username and check that not repeated

        while (usersUserNameAndPassword.containsKey(username)){
            System.out.println("*** It has been chosen before ***");
            System.out.println("Please enter another username: ");
            username = input.nextLine().toLowerCase();
        }


        System.out.print("Please enter password for your account: ");
        String password = input.nextLine();

        System.out.print("Please enter valid email for your account: ");
        String email = input.nextLine();


        System.out.println("\n");
        System.out.println("*** It's done, your account was created successfully ***");
        System.out.println("\n");
        User userAccount = new User(username, password, email);                                         //make the user

        allUsers.add(userAccount);                                                                      //add user to list of all users in program
        usersUserNameAndPassword.put(username, password);
    }
}