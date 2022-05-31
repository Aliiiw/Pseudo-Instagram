import java.util.ArrayList;

public class Groups {
    private ArrayList<User> users = new ArrayList<>();
    private String groupName;
    private int groupMembers;
    private static int numberOfCreatedGroups;
    private User admin;
    private ArrayList<Message> groupMessages = new ArrayList<>();

    public static int getNumberOfCreatedGroups() {
        return numberOfCreatedGroups;
    }

    public static void setNumberOfCreatedGroups(int numberOfCreatedGroups) {
        Groups.numberOfCreatedGroups = numberOfCreatedGroups;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    static {
        numberOfCreatedGroups = 0;
    }


    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID + 1;
    }

    private int groupID = 0;






    public ArrayList<Message> getGroupMessages() {
        return groupMessages;
    }

    public void setGroupMessages(ArrayList<Message> groupMessages) {
        this.groupMessages = groupMessages;
    }

    public Groups(ArrayList<User> users, String groupName, int groupMembers) {
        this.users = users;
        this.groupName = groupName;
        this.groupMembers = groupMembers;
        this.setGroupID(numberOfCreatedGroups++);

    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(int groupMembers) {
        this.groupMembers = groupMembers + 1;
    }

    public User findAdmin(Groups group){
        for (User user : group.getUsers()){
            if (user.getUserType() == UserType.ADMIN){
                return user;
            }
        }
        return null;
    }

    public String showMessagesInGroup(Groups group){
        StringBuilder all = new StringBuilder();
        all.append("\t").append("Group name: ").append(group.getGroupName()).append("\n");
        all.append("\t").append("Group ID number: ").append(group.getGroupID()).append("\n");
        all.append("\t").append("Group Members: ").append("\n");
        all.append("\t");
        for (User user : group.getUsers()){
            all.append(user.getUsername()).append("\n");
        }

        all.append("\t");
        for (Message message : groupMessages){
            all.append(message.showMessage(message)).append("\n");
        }
        return all.toString();
    }

    public String showGroupInfo(Groups group){


        return "\t" + "Group name: " + group.getGroupName() + "\n" +
                "\t" + "Group ID number: " + group.getGroupID() + "\n" +
                "\t" + "Group Admin: " + findAdmin(group).getUsername() + "\n" +
                "\t" + "Group Members: " + group.getGroupMembers() + "\n";
    }
}
