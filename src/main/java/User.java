public class User {
    private String ID;
    private String PW;
    private String name;

    User(String ID, String PW, String name) {
        this.ID = ID;
        this.PW = PW;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
