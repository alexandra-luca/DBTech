package shopifyadvanced.dao;


import org.springframework.context.annotation.Profile;

@Profile("user")
public class UserSession {

     public static int userSession_id;

    public UserSession() {
    }

    public int getUserSession_id() {
        return userSession_id;
    }

    public UserSession setUserSession_id(int userSession_id) {
        this.userSession_id = userSession_id;
        return this;
    }
}
