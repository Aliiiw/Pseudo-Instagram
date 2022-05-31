public class Comments {

    private String sender;
    private String receiver;
    private String text;
    private int ID;
    private static int numberOfCreatedID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID + 1;
    }

    public static int getNumberOfCreatedID() {
        return numberOfCreatedID;
    }

    public static void setNumberOfCreatedID(int numberOfCreatedID) {
        Comments.numberOfCreatedID = numberOfCreatedID;
    }




    static {
        numberOfCreatedID = 0;

    }

    public Comments(String sender, String receiver, String text) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.setID(numberOfCreatedID++);
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String show(Comments comment){

        return "\t" + "Comment ID number: " + comment.getID() + "\n" +
                "\t" + "Comment text: " + comment.getText() + "\n";

    }


}
