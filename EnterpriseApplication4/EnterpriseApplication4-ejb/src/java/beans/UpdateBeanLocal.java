/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    boolean add(String name, String value);
    
    /** 
     * Удаление параметра
     * @param name - имя параметра
     * @param id - id авторизованного пользователя
     * @return - успешность выполнения операции
     */
    boolean delete(String name);
}