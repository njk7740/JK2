import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {
    Scanner scanner = new Scanner(System.in);

    public void drawLine() {
        System.out.println("===================");
    }

    public void printSimple(PostData post) {
        drawLine();
        System.out.println("번호 : " + post.getNumber());
        System.out.println("제목 : " + post.getTitle());
        drawLine();
    }

    public void printDetail(PostData post) {
        drawLine();
        System.out.println("번호 : " + post.getNumber());
        System.out.println("제목 : " + post.getTitle());
        System.out.println("내용 : " + post.getDetail());
        System.out.println("등록날짜 : " + post.getDate());
        System.out.println("조회수 : " + post.getViews());
        System.out.println("======= 댓글 =======");
    }

    public void printComment(CommentData comment) {
        System.out.println("댓글 내용 : " + comment.getText());
        System.out.println("작성일 : " + comment.getTime());
        drawLine();
    }

    public void printEmptyPost() {
        System.out.println("게시물이 없습니다.");
    }

    public void printEmptyComment() {
        System.out.println("댓글이 없습니다.");
    }

    public void printNoPost() {
        System.out.println("없는 게시물 번호입니다.");
    }

    public void printNoSearchPost() {
        System.out.println("검색된 게시물이 없습니다.");
    }

    public void showDetailMenu() {
        System.out.println("상세보기 기능을 선택해주세요");
        System.out.print("(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");
    }

    public void printSuccess() {
        System.out.println("완료되었습니다.");
    }

    public String getInputTitle() {
        System.out.print("제목을 입력해주세요 : ");
        return inputString();
    }

    public String getInputDetail() {
        System.out.print("내용을 입력해주세요 : ");
        return inputString();
    }

    public String inputString() {

        return scanner.nextLine();
    }

    public int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        while (true) {
            try {
                number = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.print("숫자만 입력해주세요 : ");
                scanner.nextLine();
            }
        }
        return number;
    }

    public void showStart() {
        System.out.println("****************************");
        System.out.println("*   Text Board (by.재경)   *");
        System.out.println("****************************");
    }

    public String inputID() {
        System.out.print("사용하실 아이디를 입력해주세요 : ");
        return scanner.nextLine();
    }

    public String inputPW() {
        System.out.print("사용하실 비밀번호를 입력해주세요 : ");
        return scanner.nextLine();
    }

    public String inputName() {
        System.out.print("사용하실 닉네임을 입력해주세요 : ");
        return scanner.nextLine();
    }
}
