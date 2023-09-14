import java.util.ArrayList;

public class PostList {
    ArrayList<PostData> posts = new ArrayList<>();
    IO io = new IO();

    public void setComment(int postIdx) {
        System.out.print("댓글");
        String text = io.getInputDetail();
        addComments(postIdx, text);
    }

    public void addComments(int postIdx, String text) {
        posts.get(postIdx).setComments(text);
        io.printSuccess();
    }


}
