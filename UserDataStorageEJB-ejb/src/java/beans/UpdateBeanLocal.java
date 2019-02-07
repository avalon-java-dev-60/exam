package beans;

import javax.ejb.Local;

/**
 *
 * @author Ella
 */
@Local
public interface UpdateBeanLocal {
    /**
     * Добавление и редактирование параметра
     *
     * @param name - имя параметра
     * @param value - значение параметра
     * @param id - id авторизованного пользователя
     * @return - успешность выполнения операции
     */
    boolean add(String name, String value, long id);
    
    /** 
     * Удаление параметра
     * @param name - имя параметра
     * @param id - id авторизованного пользователя
     * @return - успешность выполнения операции
     */
    boolean delete(String name, long id);
}
