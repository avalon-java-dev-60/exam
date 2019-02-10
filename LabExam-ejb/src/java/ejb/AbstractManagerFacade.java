package ejb;

import javax.inject.Inject;

public abstract class AbstractManagerFacade<T> {
     @Inject
    DbManager dbmanager;
    private final Class<T> entityClass;

    public AbstractManagerFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void addNewParam(T entity) {
        dbmanager.addNewParam(entity);
    }

    public void changeParam(T entity) {
        dbmanager.changeParam(entity);
    }

    public void deleteParam(T entity) {
        dbmanager.deleteParam(entity);
    }

}
