public class Message {

    private User sender;
    private User receiver;
    private String text;

    public Message(User sender, User receiver, String text) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
    }
    public Message(User sender, String text){
        this.sender = sender;
        this.text = text;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String showMessage(Message message) {


        return "Message from: " + message.getSender().getUsername()+ "\t" + "Text: " + message.getText() + "\n";
    }


}

