package database;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 *
 * @author Ella
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    public UsersFacade() {
        super(Users.class);
    }

    public Users findUser(String name) {
        try {
            return (Users) manager
                    .getNamesQuery("Users-findByName")
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Users signUp(String name) {
        try {
            Users user = (Users) getEntityClass().newInstance();
            user.setName(name);
            create(user);
            System.out.println("NEW USER ID: " + user.getId());
            return user;
        } catch (InstantiationException | IllegalAccessException ie) {
            ie.printStackTrace(System.err);
            return null;
        }
    }
}
