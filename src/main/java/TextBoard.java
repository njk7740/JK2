public class TextBoard {

    PostList postList = new PostList();
    PostControler postControler = new PostControler();
    PostView postView = new PostView();
    UserControler userControler = new UserControler();

    void Run() {
        // test
        {
            postControler.addPost("첫번째 게시물", "테스트용입니다");
            postControler.addPost("두번째 게시물", "테스트용입니다");
            postControler.addPost("세번째 게시물", "테스트용입니다");
        }
        postView.showStart();

        while (true) {
            System.out.print("명령어를 입력해주세요 : ");
            String menu = postView.inputString();

            if (menu.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                return;
            } else if (menu.equals("add")) postControler.addPosts();
            else if (menu.equals("list")) postControler.printPostList();
            else if (menu.equals("update")) postControler.updatePost();
            else if (menu.equals("delete")) postControler.deletePost();
            else if (menu.equals("detail")) postControler.printPostDetail();
            else if (menu.equals("search")) postControler.searchPost();
            else if (menu.equals("signup")) userControler.signup();

        }
    }
}
