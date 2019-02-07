package beans;

import database.Users;
import database.UsersFacade;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Ella
 */
@Stateful
public class AutorisationBean implements AutorisationBeanLocal {

    private boolean logged = false;
    private String userName;
    private long id;
    @EJB
    UsersFacade userFacade;

    @Override
    public boolean login(String name) {
        logged = false;
        Users user = userFacade.findUser(name);
        if (user != null) {
            userName = user.getName();
            id = user.getId();
            logged = true;
        }
        return isLogged();
    }

    @Override
    public boolean signUp(String name) {
        logged = false;
        Users user = userFacade.findUser(name);
        if (user == null) {
            Users newUser = userFacade.signUp(name);
            System.out.println("AUTH_BEAN user " + newUser);
            if (newUser != null) {
                userName = newUser.getName();
                id = newUser.getId();
                logged = true;
            }
        }
        return isLogged();
    }

    @Override
    public boolean isLogged() {
        return logged;
    }

    @Override
    public String getName() {
        return userName;
    }

    @Override
    public long getId() {
        return id;
    }
}
