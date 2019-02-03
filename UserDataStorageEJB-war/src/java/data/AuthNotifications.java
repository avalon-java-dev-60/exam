
package data;

import javax.ejb.Stateless;

/**
 *
 * @author Ella
 */
@Stateless
public class AuthNotifications {
    private final static String WRONG_SIGNUP = "Такое имя уже существует";
    private final static String WRONG_SIGNIN = "Введено неверное имя";
    private final static String WRONG_EMPTY_NAME = "Имя не должно быть пустым";
    private final static String WRONG_STATUS = "alert-warning";

    
    public Notification getWrongSignUp() {
        return new Notification(WRONG_SIGNUP, WRONG_STATUS);
    }
    
    public Notification getWrongLogin() {
        return new Notification(WRONG_SIGNIN, WRONG_STATUS);
    }
    
    public Notification getWrongEmptyName() {
        return new Notification(WRONG_EMPTY_NAME, WRONG_STATUS);
    }
}
