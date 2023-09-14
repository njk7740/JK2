public class UserControler {
    UserList userList = new UserList();
    IO io = new IO();

    public void signup() {
        System.out.println("=== 회원가입을 진행합니다 ===");
        String ID = io.inputID();
        if (userList.exist(ID)) {
            System.out.println("해당 ID가 존재합니다.");
        } else {
            String PW = io.inputPW();
            String Name = io.inputName();
            userList.add(ID, PW, Name);
            System.out.println("=== 회원가입이 완료되었습니다 ===");
        }
    }

    public void login() {
        // todo 로그인 구현
    }
}
