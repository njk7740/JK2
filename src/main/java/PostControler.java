public class PostControler {

    PostRepository postRepository = new PostRepository();
    PostView postView = new PostView();

    public void searchPost() {
        System.out.print("검색 키워드를 입력해주세요 : ");
        boolean work = printPostsByKey(postView.inputString());
        if (!work) postView.printNoSearchPost();
    }

    public boolean printPostsByKey(String key) {
        boolean success = false;
        for (PostData post : postRepository.posts)
            if (post.getTitle().contains(key)) {
                postView.printSimple(post);
                success = true;
            }
        return success;
    }

    public void printComments(int postIndex) {
        for (CommentData comment : postRepository.posts.get(postIndex).getComments())
            postView.printComment(comment);
    }

    public void printPostDetail() {
        System.out.print("상세보기할 게시물 번호 : ");
        int idx = getPostIdx(postView.inputNumber());
        boolean run = true;
        while(run) {
            if (idx == -1) {
                postView.printNoPost();
                run = false;
            }
            else {
                postRepository.posts.get(idx).setViews(postRepository.posts.get(idx).getViews() + 1);
                postView.printDetail(postRepository.posts.get(idx));
                printComments(idx);
                run = printDetailMenu(idx);
            }
        }
    }

    public boolean printDetailMenu(int postIdx) {
        postView.showDetailMenu();
        int inputMenu = postView.inputNumber();
        if (inputMenu == 1) postRepository.setComment(postIdx);
        else if (inputMenu == 2) ; // todo 추천
        else if (inputMenu == 3) ; // todo 수정
        else if (inputMenu == 4) ; // todo 삭제
        else if (inputMenu == 5) {
            printPostList();
            return false;
        }
        return true;
    }

    public int getPostIdx(int postNum) {
        for (int i = 0; i < postRepository.posts.size(); i++)
            if (postRepository.posts.get(i).getNumber() == postNum)
                return i;
        return -1;
    }

    public void deletePost() {
        System.out.print("삭제할 게시물 번호 : ");
        int number = postView.inputNumber();
        int idx = getPostIdx(number);

        if (idx == -1) postView.printNoPost();
        else {
            postRepository.posts.remove(idx);
            System.out.println(number + "번 게시물이 삭제되었습니다.");
        }
    }

    public void updatePost() {
        System.out.print("수정할 게시물 번호 : ");
        int number = postView.inputNumber();
        int idx = getPostIdx(number);

        if (idx == -1) postView.printNoPost();
        else {
            postRepository.posts.get(idx).setTitle(postView.getInputTitle());
            postRepository.posts.get(idx).setDetail(postView.getInputDetail());
            postRepository.posts.get(idx).setDate(Util.getNowTime());
            System.out.println(number + "번 게시물이 수정되었습니다.");
        }
    }

    public void addPost(String title, String detail) {
        PostData post = new PostData(title, detail);
        setPostNumber(post);
        postRepository.posts.add(post);
    }

    public void setPostNumber(PostData post) {
        int maxIndex = postRepository.posts.size() - 1;
        if (postRepository.posts.isEmpty()) post.setNumber(1);
        else post.setNumber(postRepository.posts.get(maxIndex).getNumber() + 1);
    }

    public void addPosts() {
        String title = postView.getInputTitle();
        String detail = postView.getInputDetail();
        addPost(title, detail);
        System.out.println("게시물이 등록되었습니다.");
    }

    public void printPostList() {
        if (postRepository.posts.isEmpty()) postView.printEmptyPost();
        else for (PostData post : postRepository.posts)
            postView.printSimple(post);
    }


}