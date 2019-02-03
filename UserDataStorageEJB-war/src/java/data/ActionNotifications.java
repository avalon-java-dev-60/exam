package data;

import javax.ejb.Stateless;

/**
 *
 * @author Ella
 */
@Stateless
public class ActionNotifications {
    private final static String SUCCESS_ADD = "Новый параметр успешно внесён";
    private final static String SUCCESS_UPDATE = "Параметр успешно обновлён";
    private final static String SUCCESS_DELETE = "Параметр успешно удалён";
    private final static String WRONG_NAME_IS_EMPTY = "Имя параметра не задано";
    private final static String WRONG_MAX_LENGTH = "Длина имени превышает ? символов";
    private final static String WRONG_VALUE_IS_EMPTY = "Значение параметра не задано";
    private final static String WRONG_INT = "Значение параметра невозможно привести к типу int";
    private final static String WRONG_DB = "Произошла ошибка при подключении к базе данных";
    private final static String WRONG_PATTERN = "Шаблон может содержать только буквы, цифры и нижнее подчёркивание";
    private final static String WRONG_RANGE = "Указан неверный диапазон";
    private final static String WRONG_STATUS = "alert-warning";
    private final static String SUCCESS_STATUS = "alert-success";
    
    public Notification getSuccessAdd() {
        return new Notification(SUCCESS_ADD, SUCCESS_STATUS);
    }
    
    public Notification getSuccessUpdate() {
        return new Notification(SUCCESS_UPDATE, SUCCESS_STATUS);
    }
    
    public Notification getSuccessDelete() {
        return new Notification(SUCCESS_DELETE, SUCCESS_STATUS);
    }
    
    public Notification getWrongNameIsEmpty() {
        return new Notification(WRONG_VALUE_IS_EMPTY, WRONG_STATUS);
    }
    
    public Notification getWrongValueIsEmpty() {
        return new Notification(WRONG_NAME_IS_EMPTY, WRONG_STATUS);
    }
    
    public Notification getWrongInt() {
        return new Notification(WRONG_INT, WRONG_STATUS);
    }
    
    public Notification getWrongPattern() {
        return new Notification(WRONG_PATTERN, WRONG_STATUS);
    }
    
    public Notification getWrongRange() {
        return new Notification(WRONG_RANGE, WRONG_STATUS);
    }
    
    public Notification getWrongDb() {
        return new Notification(WRONG_DB, WRONG_STATUS);
    }
    
    public Notification getWrongLength(int maxLength) {
        String wrongMessage = WRONG_MAX_LENGTH.replaceFirst("\\?", String.valueOf(maxLength));
        return new Notification(wrongMessage, WRONG_STATUS);
    }  
}
