import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Instagram {
    static Scanner input = new Scanner(System.in);

    HashMap<String, String> allUserNameAndPasswords = new HashMap<>();
    ArrayList<User> allUsers = new ArrayList<>();
    ArrayList<Groups> groups = new ArrayList<>();




    public static void main(String[] args) {
        Instagram insta = new Instagram();
        insta.start();
    }

    private void start() {
        boolean isAppRunning = true;
        while (isAppRunning){
            printFirstMenu();

            int chooseToDoInFirstsMenu = input.nextInt();
            input.nextLine();

             switch (chooseToDoInFirstsMenu){
                 case 1:
                     //login user
                     if (allUsers.isEmpty()){
                         System.out.println("*** No account available ***\n");
                         break;
                     }

                     System.out.print("Please enter your username: ");
                     String enteredUsername = input.nextLine();


                     System.out.print("Please enter your password: ");
                     String enteredPassword = input.nextLine();

                     boolean isLogging = true;

                     while (isLogging) {
                         boolean flag = false;

                         for (Map.Entry<String, String> val : allUserNameAndPasswords.entrySet()) {
                             String savedUsername = val.getKey();
                             String savedPassword = val.getValue();

                             if (enteredUsername.equals(savedUsername) && enteredPassword.equals(savedPassword)) {
                                 System.out.println("You have been login successfully\n");
                                 flag = true;

                                 printUserCanDoAfterLogin();

                                 //ArrayList<String> Posts = new ArrayList<>();


                                 int chooseToDoAfterLogin = input.nextInt();
                                 input.nextLine();

                                 switch (chooseToDoAfterLogin){
                                     case 1:
                                         //see home page

                                         for (User user : allUsers){
                                             if (user.getUsername().equals(enteredUsername)){
                                                 if (user.getFollowings().isEmpty()){
                                                     System.out.println("\n*** You have no following ***\n");
                                                     break;
                                                 }else{
                                                     for (User following : user.getFollowings()){
                                                         for (Post post : following.getPosts()){
                                                             System.out.println("\tPost from: " + following.getUsername() + "\n");
                                                             System.out.println(post.showPost(post));
                                                         }
                                                     }
                                                     System.out.println("What do you want to do?");
                                                     System.out.println("1) Like");
                                                     System.out.println("2) Comment");
                                                     System.out.println("3) Delete comment");
                                                     System.out.println("4) Go back");

                                                     int order = input.nextInt();
                                                     input.nextLine();

                                                     if (order == 1){
                                                         //liking
                                                         System.out.print("Which user you want to like his/her post: ");
                                                         String name = input.nextLine();

                                                         for (User following : user.getFollowings()){
                                                             if (following.getUsername().equals(name)){
                                                                 System.out.print("Which post do you want to like enter ID: ");
                                                                 int id = input.nextInt();
                                                                 input.nextLine();

                                                                 for (Post post : following.getPosts()){
                                                                     boolean haveLiked = false;
                                                                     if (post.getWhoLiked().isEmpty()){
                                                                         System.out.println("No one liked this post before, Do you want to like? 'yes' to continue: ");
                                                                         String orders = input.nextLine();
                                                                         if (orders.contains("yes")){
                                                                             post.setNumberOfLikes(post.getNumberOfLikes());
                                                                             System.out.println("liked by you");
                                                                             post.getWhoLiked().add(user);
                                                                         }
                                                                         break;
                                                                     }
                                                                     for (User liker : post.getWhoLiked()){
                                                                         if (liker.getUsername().equals(enteredUsername)){
                                                                             haveLiked = true;
                                                                         }
                                                                         if (post.getID() == id && haveLiked){
                                                                             System.out.println("You have liked this post before you want to unlike? 'yes' to continue: ");
                                                                             String toUnlike = input.nextLine();
                                                                             if (toUnlike.contains("yes")){
                                                                                 post.setUnlike(post.getNumberOfLikes());
                                                                                 System.out.println("Liked has been gone");
                                                                                 post.getWhoLiked().remove(user);
                                                                             }
                                                                             break;

                                                                         }else if (post.getID() == id){
                                                                             post.setNumberOfLikes(post.getNumberOfLikes());
                                                                             System.out.println("\nYou have liked this post\n");
                                                                             post.getWhoLiked().add(user);
                                                                         }
                                                                     }
                                                                 }
                                                             }
                                                         }
                                                     }else if (order == 2){
                                                         //commenting

                                                         System.out.print("Which user you want to comment on his/her post: ");
                                                         String name = input.nextLine();
                                                         for (User following : user.getFollowings()){
                                                             if (following.getUsername().equals(name)){
                                                                 System.out.print("Which post do you want to comment enter ID: ");
                                                                 int id = input.nextInt();
                                                                 input.nextLine();

                                                                 for (Post post : following.getPosts()){
                                                                     if (post.getID() == id){
                                                                         System.out.print("Your comment: ");
                                                                         String enteredComment = input.nextLine();
                                                                         Comments comment = new Comments(user.getUsername(), following.getUsername(), enteredComment);
                                                                         post.getComments().add(comment);
                                                                         System.out.print("\n*** Comment added successfully ***\n");
                                                                     }
                                                                 }
                                                             }
                                                         }
                                                     }else if (order == 3){
                                                         System.out.print("Which user you want to delete comment on his/her post: ");
                                                         String nameToDelete = input.nextLine();
                                                         for (User following : user.getFollowings()){
                                                             if (following.getUsername().equals(nameToDelete)){
                                                                 System.out.print("Which post do you want to delete comment enter ID: ");
                                                                 int idToDelete = input.nextInt();
                                                                 input.nextLine();

                                                                 for (Post post : following.getPosts()){
                                                                     if (post.getID() == idToDelete){
                                                                         System.out.println(post.showPost(post));

                                                                         for (Comments comments : post.getComments()){
                                                                             if (comments.getSender().equals(enteredUsername)){
                                                                                 System.out.println(comments.show(comments));

                                                                                 System.out.println("\nWhich comment you want to be deleted?, enter comment ID: ");
                                                                                 int commentId = input.nextInt();
                                                                                 input.nextLine();

                                                                                 for (Comments comments1 : post.getComments()){
                                                                                     if (comments1.getID() == commentId){
                                                                                         post.getComments().remove(comments1);
                                                                                         System.out.println("\n*** Comment removed ***\n");
                                                                                     }
                                                                                 }
                                                                             }
                                                                         }
                                                                     }
                                                                 }
                                                             }
                                                         }
                                                     }else{
                                                         break;
                                                     }
                                                 }
                                             }
                                         }
                                     break;
                                     case 2:
                                         //see your page
                                         boolean InPage = true;
                                         while (InPage){
                                             printUserCanDoInHisOrHerPage();

                                             int chooseInPage = input.nextInt();
                                             input.nextLine();

                                             switch (chooseInPage){
                                                 case 1:
                                                     //make post
                                                     System.out.println("\t*** Making Post ***");
                                                     System.out.print("Please enter text for your post: ");
                                                     String text = input.nextLine();

                                                     System.out.print("Please enter caption for your post: ");
                                                     String caption = input.nextLine();

                                                     Post post = new Post(text, caption);
                                                     for (User user : allUsers){
                                                         if (user.getUsername().equals(enteredUsername)){
                                                             user.getPosts().add(post);
                                                             System.out.println("\nYour post has been successfully added\n");
                                                             break;
                                                         }
                                                     }
                                                     System.out.println("\n");
                                                 break;
                                                 case 2:
                                                     //delete post
                                                     for (User user : allUsers){
                                                         if (user.getUsername().equals(enteredUsername)){
                                                             if (user.getPosts().isEmpty()){
                                                                 System.out.println("\n*** You don't have any post ***");
                                                                 break;
                                                             }

                                                             int counterPost = 1;
                                                             for (Post postToDelete : user.getPosts()){
                                                                 System.out.println("Post no. " + counterPost + ":");
                                                                 System.out.println(postToDelete.showPost(postToDelete));
                                                                 counterPost++;
                                                             }

                                                             System.out.print("Please enter ID post that you want to delete: ");
                                                             int selectPostToDelete = input.nextInt();
                                                             input.nextLine();

                                                             for (Post postToBeDelete : user.getPosts()){
                                                                 if (selectPostToDelete == postToBeDelete.getID()){
                                                                     user.getPosts().remove(postToBeDelete);
                                                                     System.out.println("\nPost has been deleted successfully\n");
                                                                     break;
                                                                 }else{
                                                                     System.out.println("\n*** No such a option ***");
                                                                 }
                                                             }
                                                         }
                                                     }
                                                 break;
                                                 case 3:
                                                     //see all your post ok
                                                     int counter = 1;
                                                     for (User user : allUsers){
                                                         if (user.getUsername().equals(enteredUsername)){
                                                             if (user.getPosts().isEmpty()){
                                                                 System.out.println("*** You have no post yet! ***\n");
                                                                 break;
                                                             }else{
                                                                 for (Post postToShow : user.getPosts()) {
                                                                     System.out.println("Post no. " + counter + ": ");
                                                                     System.out.println(postToShow.showPost(postToShow));
                                                                     counter++;
                                                                 }
                                                             }
                                                         }
                                                     }
                                                 break;
                                                 case 4:
                                                     //see info ok
                                                     for (User user : allUsers){
                                                         if (user.getUsername().equals(enteredUsername)){
                                                             System.out.println(user.showInfo());
                                                             break;
                                                         }
                                                     }
                                                 break;
                                                 case 5:
                                                     //edit info ok
                                                     boolean isEditing = true;
                                                     for (User user : allUsers){
                                                         if (user.getUsername().equals(enteredUsername)){
                                                             while (isEditing){
                                                                 System.out.println(user.showInfoToEdit());
                                                                 System.out.print("Which one do you want to edit, choose number: ");
                                                                 int selectEdit = input.nextInt();
                                                                 input.nextLine();

                                                                 switch (selectEdit){
                                                                     case 1://ok
                                                                         // edit bio
                                                                         System.out.print("Please enter new bio: ");
                                                                         String newBio = input.nextLine();

                                                                         for (User userBio : allUsers) {
                                                                             if (userBio.getUsername().equals(enteredUsername)) {
                                                                                 userBio.setBio(newBio);
                                                                                 System.out.println("Bio has been changed successfully");
                                                                                 break;
                                                                             }
                                                                         }
                                                                     break;
                                                                     case 2://ok
                                                                         //edit gmail
                                                                         System.out.print("Please enter new email: ");
                                                                         String newEmail = input.nextLine();
                                                                         for (User userEmail : allUsers) {
                                                                             if (userEmail.getUsername().equals(enteredUsername)) {
                                                                                 userEmail.setEmail(newEmail);
                                                                                 System.out.println("Email has been changed successfully");
                                                                                 break;
                                                                             }
                                                                         }
                                                                     break;
                                                                     case 3: //ok
                                                                         isEditing = false;
                                                                     break;
                                                                     default:
                                                                         System.out.println("*** Wrong input ***");
                                                                     break;
                                                                 }
                                                             }
                                                         }
                                                     }
                                                 break;
                                                 case 6:
                                                     //go back ok
                                                     InPage = false;
                                                 break;
                                                 default:
                                                     System.out.println("*** Wrong input ***");
                                                 break;
                                             }
                                         }
                                     break;
                                     case 3:
                                         //search
                                         ArrayList<User> helpUsers = new ArrayList<>(allUsers);

                                         for (User user : allUsers){
                                             if (user.getUsername().equals(enteredUsername)){
                                                 helpUsers.remove(user);
                                                 break;
                                             }
                                         }
                                         if (helpUsers.isEmpty()){
                                             System.out.println("\n*** No other user available ***\n");
                                             break;
                                         }
                                         boolean isSearching = true;
                                         while (isSearching){

                                             int countUsers = 1;
                                             for (User user : helpUsers){
                                                 System.out.println(countUsers +") " + user.getUsername());
                                                 countUsers++;
                                             }

                                             System.out.println("\nDo you want to follow/unfollow someone?");
                                             System.out.println("1) Follow");
                                             System.out.println("2) Unfollow");
                                             String order = input.nextLine();

                                             if (order.contains("1")) {
                                                 System.out.print("Please enter username that you want to follow: ");
                                                 String userToFollow = input.nextLine();

                                                 for (User user : allUsers){
                                                     boolean followed = false;
                                                     if (user.getUsername().equals(enteredUsername)){
                                                         User helpUser = new User("help");
                                                         user.getFollowings().add(helpUser);
                                                         for (User userFollowing : user.getFollowings()){
                                                             if (userFollowing.getUsername().equals(userToFollow)){
                                                                 System.out.println("\nYou have followed this user before\n");
                                                                 followed = true;
                                                                 isSearching = false;
                                                                 break;
                                                             }
                                                         }if(!followed){
                                                             for (User user1 : allUsers){
                                                                 if (user1.getUsername().equals(userToFollow)){
                                                                     user.getFollowings().add(user1);
                                                                     System.out.println("\nyou have followed " + user1.getUsername());
                                                                     System.out.println("\n");
                                                                     break;
                                                                 }else{
                                                                     System.out.println("\n***No such an option ***\n");
                                                                 }
                                                             }
                                                             isSearching = false;
                                                         }

                                                     }
                                                 }
                                             }else if (order.contains("2")){
                                                 System.out.print("Please enter username that you want to Unfollow: ");
                                                 String userToUnFollow = input.nextLine();

                                                 for (User user : allUsers){
                                                     if (user.getUsername().equals(enteredUsername)){
                                                         for (User toUnFollow : user.getFollowings()){
                                                             if (toUnFollow.getUsername().equals(userToUnFollow)){
                                                                 user.getFollowings().remove(toUnFollow);
                                                                 System.out.println("\nYou have unfollowed " + toUnFollow.getUsername() + "\n");
                                                                 break;
                                                             }else{
                                                                 System.out.println("\n*** No such an option ***\n");
                                                             }
                                                         }
                                                     }
                                                     break;
                                                 }
                                                 isSearching = false;
                                             }else {
                                                 isSearching = false;
                                             }
                                         }
                                     break;
                                     case 4:
                                         //message

                                         printUserCanDoInMessages();

                                         System.out.print("Choose an option: ");
                                         int order = input.nextInt();
                                         input.nextLine();

                                         boolean isInMessaging = true;
                                         while (isInMessaging){
                                             switch (order){
                                                 case 1:
                                                     //private
                                                     String userSender = "";
                                                     ArrayList<User> helpUsers1 = new ArrayList<>(allUsers);
                                                     for (User userToCheck : allUsers){
                                                         if (userToCheck.getUsername().equals(enteredUsername)){
                                                             userSender = userToCheck.getUsername();
                                                             helpUsers1.remove(userToCheck);
                                                             break;
                                                         }
                                                     }
                                                     if (helpUsers1.isEmpty()){
                                                         System.out.println("\n*** No other user available ***\n");
                                                         isInMessaging = false;
                                                         break;
                                                     }
                                                     int countUsers = 1;
                                                     for (User user : helpUsers1){
                                                         System.out.println(countUsers +") " + user.getUsername());
                                                         countUsers++;
                                                     }

                                                     System.out.println("\nWho do you want to send a message: ");

                                                     String personToSendMessage = input.nextLine();

                                                     for (User userToSendMessage : helpUsers1){
                                                         if (userToSendMessage.getUsername().equals(personToSendMessage)){
                                                             System.out.print("Please enter your message: ");
                                                             String text = input.nextLine();

                                                             User sender = findUser(userSender);
                                                             User receiver = findUser(personToSendMessage);

                                                             Message message = new Message(sender, receiver, text);

                                                             assert sender != null;
                                                             sender.getPrivateMessages().add(message);
                                                             assert receiver != null;
                                                             receiver.getPrivateMessages().add(message);
                                                             System.out.println("\n*** Message sent ***\n");
                                                             break;
                                                         }
                                                     }
                                                     isInMessaging = false;
                                                 break;
                                                 case 2:
                                                     //group
                                                     boolean inGroup = true;
                                                     while (inGroup){

                                                         System.out.println("\t*** Group Part ***");
                                                         System.out.println("1) Create group");
                                                         System.out.println("2) All groups");
                                                         System.out.println("3) Back to first menu\n");

                                                         System.out.print("Choose: ");
                                                         int chooseInGroups = input.nextInt();
                                                         input.nextLine();

                                                         switch (chooseInGroups){
                                                             case 1:
                                                                 //create group
                                                                 ArrayList<User> helpUsers3 = new ArrayList<>(allUsers);
                                                                 System.out.println("Please enter group name: ");
                                                                 String groupName = input.nextLine();

                                                                 for (User user : allUsers) {
                                                                     if (user.getUsername().equals(enteredUsername)) {
                                                                         user.setUserType(UserType.ADMIN);
                                                                         helpUsers3.remove(user);
                                                                         break;
                                                                     }
                                                                 }

                                                                 if (helpUsers3.isEmpty()){
                                                                     System.out.println("\n*** No other user available ***\n");
                                                                     break;
                                                                 }



                                                                 //boolean isAdding = true;
                                                                 ArrayList<User> members = new ArrayList<>();

                                                                 int countUsersToShow = 1;
                                                                 for (User user : helpUsers3){
                                                                     System.out.println(countUsersToShow +") " + user.getUsername());
                                                                     countUsersToShow++;
                                                                 }

                                                                 while (true){

                                                                     for (User user : allUsers){
                                                                         if (user.getUsername().equals(enteredUsername)){
                                                                             members.add(user);

                                                                             System.out.print("Who do you want to add in your group: ");
                                                                             String toAdd = input.nextLine();

                                                                             for (User userCheck : helpUsers3){
                                                                                 if (userCheck.getUsername().equals(toAdd)){
                                                                                     members.add(user);
                                                                                     System.out.println("\n*** User has been added to group successfully ***\n");
                                                                                 }
                                                                             }

                                                                             Groups group = new Groups(members, groupName, members.size());
                                                                             groups.add(group);
                                                                             System.out.println("\n*** Group created successfully ***\n");

                                                                         }
                                                                     }
                                                                     break;
                                                                 }
                                                                 isInMessaging = false;

                                                             break;
                                                             case 2:
                                                                 //gp part
                                                                 for (User user : allUsers){
                                                                     if (user.getUsername().equals(enteredUsername)){
                                                                         for (Groups group : groups){
                                                                             for (User userToCheck : group.getUsers()){
                                                                                 if (userToCheck.getUsername().equals(user.getUsername())){
                                                                                     System.out.println(group.showGroupInfo(group));

                                                                                     System.out.println("\n1) See chats");
                                                                                     System.out.println("2) Send message in chat");
                                                                                     System.out.println("3) Go back");

                                                                                     System.out.print("\nNow what to do: ");
                                                                                     int orderGroup = input.nextInt();
                                                                                     input.nextLine();

                                                                                     switch (orderGroup){
                                                                                         case 1:
                                                                                             if (group.getGroupMessages().isEmpty()){
                                                                                                 System.out.println("*** There is no chat ***");
                                                                                                 break;
                                                                                             }else {
                                                                                                 for (Message message : group.getGroupMessages()) {
                                                                                                     System.out.println(message.showMessage(message));
                                                                                                 }
                                                                                             }
                                                                                         break;
                                                                                         case 2:
                                                                                             //send message
                                                                                             for (Message message : group.getGroupMessages()){
                                                                                                 System.out.println(message.showMessage(message));
                                                                                             }
                                                                                             System.out.print("Do you want to send message? 'yes' to continue: ");
                                                                                             String sendingMessage = input.nextLine();

                                                                                             if (sendingMessage.contains("yes")){
                                                                                                 User userSendMessage = findUser(enteredUsername);

                                                                                                 System.out.print("Write your message: ");
                                                                                                 String text = input.nextLine();

                                                                                                 Message message = new Message(userSendMessage, text);
                                                                                                 group.getGroupMessages().add(message);
                                                                                                 System.out.println("message sent");
                                                                                                 break;
                                                                                             }
                                                                                         break;
                                                                                         case 3:
                                                                                         break;
                                                                                         default:
                                                                                             System.out.println("*** Wrong input ***");
                                                                                         break;
                                                                                     }
                                                                                     break;
                                                                                 }
                                                                             }
                                                                         }
                                                                     }
                                                                 }
                                                                 isInMessaging = false;
                                                             break;
                                                             case 3:
                                                                 isInMessaging = false;
                                                             break;
                                                         }
                                                         inGroup = false;
                                                     }
                                                 break;
                                                 case 3:
                                                     //see all private

                                                     ArrayList<User> helpUsers2 = new ArrayList<>(allUsers);
                                                     for (User userToCheck : allUsers){
                                                         if (userToCheck.getUsername().equals(enteredUsername)){
                                                             helpUsers2.remove(userToCheck);
                                                             break;
                                                         }
                                                     }
                                                     if (helpUsers2.isEmpty()){
                                                         System.out.println("\n*** No other user available ***\n");
                                                         isInMessaging = false;
                                                         break;
                                                     }

                                                     int count = 1;
                                                     for (User user : helpUsers2){
                                                         System.out.println(count +") " + user.getUsername());
                                                         count++;
                                                     }

                                                     System.out.print("Which user chat do you want to see: ");
                                                     String person = input.nextLine();

                                                     for (User user : allUsers){
                                                         if (user.getUsername().equals(enteredUsername)){
                                                             for (Message message : user.getPrivateMessages()){
                                                                 if ((message.getReceiver().getUsername().equals(person) || message.getSender().getUsername().equals(person))){
                                                                     System.out.println(message.showMessage(message));
                                                                 }
                                                             }
                                                         }
                                                         isInMessaging = false;
                                                     }
                                                 break;
                                                 case 4:
                                                     isInMessaging = false;
                                                 break;
                                                 default:
                                                     System.out.println("*** Wrong input ***");
                                                 break;
                                             }
                                         }
                                     break;
                                     case 5:
                                         isLogging = false;
                                     break;
                                 }
                                 break;
                             }

                         }
                         if (!flag) {
                             System.out.println("*** Username or Password may be Wrong! ***\n");

                             System.out.print("Please enter your username: ");
                             enteredUsername = input.nextLine();

                             System.out.print("Please enter your password: ");
                             enteredPassword = input.nextLine();
                         }
                     }
                 break;
                 case 2:
                     //sign up user ok
                     System.out.println("*** Sign Up part ***");
                     SignUpUsers signUpUsers = new SignUpUsers();
                     signUpUsers.signUpUser(allUsers, allUserNameAndPasswords);
                 break;
                 case 3:
                     //exit ok
                     isAppRunning = false;
                 break;
                 default:
                     System.out.println("*** Wrong input ***\n");
                 break;
             }
        }
    }

    private void printFirstMenu () {
        System.out.println("\t*** First Menu ***");
        System.out.println("What do you want to do\tPlease select an option: ");
        System.out.println("\n");
        System.out.println("1) Login");
        System.out.println("2) SignUp");
        System.out.println("3) Exit\n");
    }

    private void printUserCanDoAfterLogin () {
        System.out.println("\t*** Login Menu ***");
        System.out.println("What do you want to do\tPlease select an option: ");
        System.out.println("\n");
        System.out.println("1) See Homepage");
        System.out.println("2) See your page");
        System.out.println("3) See other users(search)");
        System.out.println("4) See Messages");
        System.out.println("5) Exit\n");
    }

    private void printUserCanDoInHisOrHerPage () {
        System.out.println("\t*** Your Page ***");
        System.out.println("What do you want to do\tPlease select an option: ");
        System.out.println("\n");
        System.out.println("1) Make post");
        System.out.println("2) Delete post");
        System.out.println("3) See all your posts");
        System.out.println("4) See all information");
        System.out.println("5) Edit your information");
        System.out.println("6) Back to first menu\n");
    }

    private void printUserCanDoInMessages(){
        System.out.println("\t*** Message Part ***");
        System.out.println("1) Send message in Private");
        System.out.println("2) Send message in Groups");
        System.out.println("3) See all private messages");
        System.out.println("4) Go to first menu\n");

    }

    private User findUser(String username){
        for (User user : allUsers){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }


}
