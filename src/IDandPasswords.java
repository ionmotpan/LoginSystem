import java.util.HashMap;

public class IDandPasswords {
    HashMap<String, String> loginInfo = new HashMap<String, String>();
    IDandPasswords(){
        loginInfo.put("John", "pizza");
        loginInfo.put("Doe", "123");
    }

    protected HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }
}
