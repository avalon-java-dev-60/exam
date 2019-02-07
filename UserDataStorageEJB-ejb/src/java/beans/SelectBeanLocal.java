package beans;

import database.Params;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ella
 */
@Local
public interface SelectBeanLocal {

    /**
     * Поиск всех параметров, введённых пользователем
     *
     * @param id - ID авторизованного пользователя
     * @return - список найденных параметров
     */
    List<Params> findAll(long id);

    /**
     * Поиск параметров, введённых пользователем, по указанному шаблону
     *
     * @param pattern - шаблон. Может содержать буквы, цифры и нижнее
     * подчёркивание
     * @param id - ID авторизованного пользователя
     * @return - список найденных параметров
     */
    List<Params> findByPattern(String pattern, long id);

    /**
     * Поиск параметров, введённых пользователем, по указанному интервалу
     * значений
     *
     * @param start - значение "от"
     * @param end - значение "до"
     * @param id - ID авторизованного пользователя
     * @return - список найденных параметров
     */
    List<Params> findByInterval(int start, int end, long id);
}
