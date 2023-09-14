import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TextBoard {
    ArrayList<PostData> posts;

    TextBoard() {
        posts = new ArrayList<>();
    }

    void Run() {
        // test
        {
            addPost("첫번째 게시물", "테스트용입니다");
            addPost("두번째 게시물", "테스트용입니다");
            addPost("세번째 게시물", "테스트용입니다");
        }

        while (true) {
            System.out.print("명령어를 입력해주세요 : ");
            String menu = inputString();

            if (menu.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                return;
            } else if (menu.equals("add")) addPosts();
            else if (menu.equals("list")) printPostList();
            else if (menu.equals("update")) updatePost();
            else if (menu.equals("delete")) deletePost();
            else if (menu.equals("detail")) printPostDetail();
            else if (menu.equals("search")) searchPost();

        }
    }

    public void searchPost() {
        System.out.print("검색 키워드를 입력해주세요 : ");
        boolean work = printPostsByKey(inputString());
        if (!work) PostView.printNoSearchPost();
    }

    public boolean printPostsByKey(String key) {
        boolean success = false;
        for (PostData post : posts)
            if (post.getTitle().contains(key)) {
                PostView.printSimple(post);
                success = true;
            }
        return success;
    }

    public void printComments(int postIndex) {
        for (CommentData comment : posts.get(postIndex).getComments())
            PostView.printComment(comment);
    }

    public void printPostDetail() {
        System.out.print("상세보기할 게시물 번호 : ");
        int idx = getPostIdx(inputNumber());
        boolean run = true;
        while(run) {
            if (idx == -1) PostView.printNoPost();
            else {
                posts.get(idx).setViews(posts.get(idx).getViews() + 1);
                PostView.printDetail(posts.get(idx));
                printComments(idx);
                run = printDetailMenu(idx);
            }
        }
    }

    public boolean printDetailMenu(int postIdx) {
        PostView.showDetailMenu();
        int inputMenu = inputNumber();
        if (inputMenu == 1) setComment(postIdx);
        else if (inputMenu == 2) ; // todo 추천
        else if (inputMenu == 3) ; // todo 수정
        else if (inputMenu == 4) ; // todo 삭제
        else if (inputMenu == 5) {
            printPostList();
            return false;
        }
        return true;
    }

    public void setComment(int postIdx) {
        System.out.print("댓글");
        String text = getInputDetail();
        addComments(postIdx, text);
    }

    public void addComments(int postIdx, String text) {
        posts.get(postIdx).setComments(text);
        PostView.printSuccess();
    }

    public void deletePost() {
        System.out.print("삭제할 게시물 번호 : ");
        int number = inputNumber();
        int idx = getPostIdx(number);

        if (idx == -1) PostView.printNoPost();
        else {
            posts.remove(idx);
            System.out.println(number + "번 게시물이 삭제되었습니다.");
        }
    }

    public void updatePost() {
        System.out.print("수정할 게시물 번호 : ");
        int number = inputNumber();
        int idx = getPostIdx(number);

        if (idx == -1) PostView.printNoPost();
        else {
            posts.get(idx).setTitle(getInputTitle());
            posts.get(idx).setDetail(getInputDetail());
            posts.get(idx).setDate(Util.getNowTime());
            System.out.println(number + "번 게시물이 수정되었습니다.");
        }
    }

    public int getPostIdx(int postNum) {
        for (int i = 0; i < posts.size(); i++)
            if (posts.get(i).getNumber() == postNum)
                return i;
        return -1;
    }

    public void printPostList() {
        if (posts.isEmpty()) PostView.printEmptyPost();
        else for (PostData post : posts)
            PostView.printSimple(post);
    }

    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        try {
            number = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력해주세요.");
            scanner.nextLine();
        }
        return number;
    }

    public void addPost(String title, String detail) {
        PostData post = new PostData(title, detail);
        setPostNumber(post);
        posts.add(post);
    }

    public void setPostNumber(PostData post) {
        int maxIndex = posts.size() - 1;
        if (posts.isEmpty()) post.setNumber(1);
        else post.setNumber(posts.get(maxIndex).getNumber() + 1);
    }

    public void addPosts() {
        String title = getInputTitle();
        String detail = getInputDetail();
        addPost(title, detail);
        System.out.println("게시물이 등록되었습니다.");
    }

    public String getInputTitle() {
        System.out.print("제목을 입력해주세요 : ");
        return inputString();
    }

    public String getInputDetail() {
        System.out.print("내용을 입력해주세요 : ");
        return inputString();
    }
}
