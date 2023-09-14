public class CommentData {
    private String text;
    private String time;

    CommentData(String text) {
        this.text = text;
        this.time = Util.getNowTime();
    }

    CommentData() {}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
