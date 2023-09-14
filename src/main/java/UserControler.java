public class UserControler {
    UserList userList = new UserList();
    PostView postView = new PostView();

    public void signup() {
        String ID = postView.inputID();
        if (userList.exist(ID)) {
            System.out.println("해당 ID가 존재합니다.");
        } else {
            String PW = postView.inputPW();
            String Name = postView.inputName();
            userList.add(ID, PW, Name);
            System.out.println("회원가입이 완료되었습니다.");
        }
    }
}
