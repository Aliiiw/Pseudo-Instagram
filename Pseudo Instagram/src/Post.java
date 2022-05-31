import java.util.ArrayList;

public class Post {

    private int ID;
    private static int numberOfCreatedId;

    private int numberOfLikes = 0;
    private String text;
    private String caption;
    private ArrayList<Comments> comments = new ArrayList<>();

    public ArrayList<User> getWhoLiked() {
        return likers;
    }

    public void setLikers(ArrayList<User> likers) {
        this.likers = likers;
    }

    ArrayList<User> likers = new ArrayList<>();

    public Post(String text, String caption) {
        this.setID(numberOfCreatedId++);
        this.text = text;
        this.caption = caption;
    }

    public String getText() {
        return text;
    }

    static {
        numberOfCreatedId = 0;

    }

    public void setText(String text) {
        this.text = text;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID + 1;
    }


    public static int getNumberOfCreatedId() {
        return numberOfCreatedId;
    }

    public static void setNumberOfCreatedId(int numberOfCreatedId) {
        Post.numberOfCreatedId = numberOfCreatedId;
    }


    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes + 1;
    }
    public void setUnlike(int numberOfLikes){
        this.numberOfLikes = numberOfLikes - 1;
    }

    public ArrayList<Comments> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comments> comments) {
        this.comments = comments;
    }


    public String showPost(Post post){

        StringBuilder all = new StringBuilder();

        all.append("\t").append("Post ID number: ").append(post.getID()).append("\n");
        all.append("\t").append("Post text: ").append(post.getText()).append("\n");
        all.append("\t").append("Post caption: ").append(post.getCaption()).append("\n");
        all.append("\t").append("Post Likes: ").append(post.getNumberOfLikes()).append("\n");
        all.append("\t").append("Post Comments: \n");
        int commenter = 1;
        for(Comments comments : post.getComments()){
            all.append("\t");
            all.append(commenter).append(") ").append(comments.getSender()).append(": ").append(comments.getText()).append("\n");
            commenter++;
        }
        all.append("\n");
        return all.toString();

    }
    public String showPostToEdit(Post post){

        StringBuilder all = new StringBuilder();

        all.append("\t").append("Post ID number: ").append(post.getID()).append("\n");
        all.append("\t").append("Post text: ").append(post.getText()).append("\n");
        all.append("\t").append("Post caption: ").append(post.getCaption()).append("\n");
        all.append("\t").append("Post Likes: ").append(post.getNumberOfLikes()).append("\n");
        all.append("\t").append("Post Comments: \n");
        int commenter = 1;
        for(Comments comments : post.getComments()){
            all.append("\t");
            all.append(commenter).append(") ").append(comments.getSender()).append(": ").append(comments.getText()).append("\n");
            commenter++;
        }
        all.append("\n");
        return all.toString();

    }

}
