import java.util.ArrayList;

public class PostRepository {
    ArrayList<PostData> posts = new ArrayList<>();
    PostView postView = new PostView();

    public void setComment(int postIdx) {
        System.out.print("댓글");
        String text = postView.getInputDetail();
        addComments(postIdx, text);
    }

    public void addComments(int postIdx, String text) {
        posts.get(postIdx).setComments(text);
        postView.printSuccess();
    }


}
