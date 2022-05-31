import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private String email;
    private String bio;
    private UserType userType;

    private ArrayList<Post> posts = new ArrayList<>();
    private ArrayList<User> followers = new ArrayList<>();
    private ArrayList<User> followings = new ArrayList<>();
    private ArrayList<Message> privateMessages = new ArrayList<>();
    private ArrayList<Message> groupMessages = new ArrayList<>();

    public ArrayList<Groups> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(ArrayList<Groups> userGroups) {
        this.userGroups = userGroups;
    }

    ArrayList<Groups> userGroups = new ArrayList<>();

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userType = UserType.MEMBER;
    }

    public ArrayList<Message> getPrivateMessages() {
        return privateMessages;
    }

    public void setPrivateMessages(ArrayList<Message> privateMessages) {
        this.privateMessages = privateMessages;
    }

    public ArrayList<Message> getGroupMessages() {
        return groupMessages;
    }

    public void setGroupMessages(ArrayList<Message> groupMessages) {
        this.groupMessages = groupMessages;
    }


    public User(String username){
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    private int numberOfPosts = 0;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }







    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPosts(int numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }
    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    public ArrayList<User> getFollowings() {
        return followings;
    }

    public void setFollowings(ArrayList<User> followings) {
        this.followings = followings;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }




    public String showInfo(){

        return "\nUsername: " + getUsername() + "\n" + "Bio: " + getBio() + "\n" + "Email: " + getEmail() + "\n";
    }
    public String showInfoToEdit(){

        return "\n1) Bio: " + getBio() + "\n" + "2) Email: " + getEmail() + "\n" + "3) go back" + "\n";

    }
}
