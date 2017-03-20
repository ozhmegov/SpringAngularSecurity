package authenticate.service.implementation;

import authenticate.dao.interfaces.GenericDao;
import authenticate.service.interfaces.GenericService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

abstract class GenericServiceImpl<T> implements GenericService<T> {
    /**
     * Gets dao instance.
     * @return dao instance.
     */
    abstract GenericDao<T> getDao();

    /**
     * Creates passed object to the dao layer.
     *
     * @param object new object.
     */
    @Override
    @Transactional
    public void create(T object) {
        getDao().create(object);
    }

    /**
     * Gets entity by passed id to the dao layer.
     *
     * @param id id.
     * @return T.
     */
    @Override
    @Transactional(readOnly = true)
    public T read(int id) {
        return getDao().read(id);
    }

    /**
     * Updates passed object to the dao layer.
     *
     * @param object new object.
     */
    @Override
    @Transactional
    public void update(T object) {
        getDao().update(object);
    }

    /**
     * Delete object by passed id to the dao layer.
     *
     * @param id id.
     */
    @Override
    @Transactional
    public void delete(int id) {
        getDao().delete(id);
    }

    /**
     * Gets list of entities.
     *
     * @return List.
     */
    @Override
    @Transactional(readOnly = true)
    public List<T> getAll() {
        return getDao().getAll();
    }
}
