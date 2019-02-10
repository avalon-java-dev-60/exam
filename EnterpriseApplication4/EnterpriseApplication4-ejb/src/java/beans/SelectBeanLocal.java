/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import parambase.Parameters;

/**
 *
 * @author ulll
 */
public interface SelectBeanLocal {

    /**
     * Поиск всех параметров, введённых пользователем
     *
     * @return - список найденных параметров
     */
    List<Parameters> findAll();

    /**
     * Поиск параметров, введённых пользователем, по указанному шаблону
     *
     * @param pattern - шаблон. Может содержать буквы, цифры и нижнее
     * подчёркивание
     * @return - список найденных параметров
     */
    List<Parameters> findByPattern(String pattern);

    /**
     * Поиск параметров, введённых пользователем, по указанному интервалу
     * значений
     *
     * @param start - значение "от"
     * @param end - значение "до"
     * @return - список найденных параметров
     */
    List<Parameters> findByInterval(int start, int end);
}
