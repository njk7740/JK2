import java.util.ArrayList;

public class UserList {
    ArrayList<User> users = new ArrayList<>();

    public void add(String ID, String PW, String name) {
        User user = new User(ID, PW, name);
        users.add(user);
    }

    public boolean exist(String ID) {
        for (User user : users)
            if (user.getID().equals(ID)) return true;
        return false;
    }
}
