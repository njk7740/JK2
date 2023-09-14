public class PostView {
    public static void printSimple(PostData post) {
        System.out.println("===============");
        System.out.println("번호 : " + post.getNumber());
        System.out.println("제목 : " + post.getTitle());
        System.out.println("===============");
    }

    public static void printDetail(PostData post) {
        System.out.println("===============");
        System.out.println("번호 : " + post.getNumber());
        System.out.println("제목 : " + post.getTitle());
        System.out.println("내용 : " + post.getDetail());
        System.out.println("등록날짜 : " + post.getDate());
        System.out.println("조회수 : " + post.getViews());
        System.out.println("===== 댓글 =====");
    }

    public static void printComment(CommentData comment) {
        System.out.println("댓글 내용 : " + comment.getText());
        System.out.println("작성일 : " + comment.getTime());
        System.out.println("===============");
    }

    public static void printEmptyPost() {
        System.out.println("게시물이 없습니다.");
    }

    public static void printEmptyComment() {
        System.out.println("댓글이 없습니다.");
    }

    public static void printNoPost() {
        System.out.println("없는 게시물 번호입니다.");
    }

    public static void printNoSearchPost() {
        System.out.println("검색된 게시물이 없습니다.");
    }

    public static void showDetailMenu() {
        System.out.println("상세보기 기능을 선택해주세요");
        System.out.print("(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");
    }

    public static void printSuccess() {
        System.out.println("완료되었습니다.");
    }
}
