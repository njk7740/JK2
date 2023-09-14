import java.util.ArrayList;

public class PostData {
    private String title;
    private String detail;
    private int number;
    private String date;
    private int views;
    private ArrayList<CommentData> comments;

    PostData(String title, String detail) {
        this.title = title;
        this.detail = detail;
        this.number = 0;
        this.date = Util.getNowTime();
        this.views = 0;
        comments = new ArrayList<>();
    }

    PostData() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public ArrayList<CommentData> getComments() {
        return comments;
    }

    public void setComments(String text) {
        CommentData comment = new CommentData(text);
        comments.add(comment);
    }
}
