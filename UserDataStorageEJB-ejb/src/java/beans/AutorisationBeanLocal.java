package beans;

import javax.ejb.Local;

/**
 *
 * @author Ella
 */
@Local
public interface AutorisationBeanLocal {

    /**
     * Авторизация пользователя
     *
     * @param name - имя пользователя (логин)
     * @return - успешность выполнения операции
     */
    boolean login(String name);

    /**
     * Регистрация пользователя
     *
     * @param name - имя пользователя (логин)
     * @return - успешность выполнения операции
     */
    boolean signUp(String name);

    /**
     * Проверка, что пользователь авторизован
     *
     * @return - успешность выполнения операции
     */
    boolean isLogged();

    /**
     * Получение имени авторизованного пользователя
     *
     * @return - имея авторизованного пользователя
     */
    String getName();

    /**
     * Получение ID авторизованного пользователя
     *
     * @return - ID авторизованного пользователя
     */
    long getId();
}
