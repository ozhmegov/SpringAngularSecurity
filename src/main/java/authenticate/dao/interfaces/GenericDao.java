package authenticate.dao.interfaces;

import java.util.List;

public interface GenericDao<T> {
    /**
     * Create new entity.
     *
     * @param entity new object.
     */
    void create(T entity);

    /**
     * Gets entity by id.
     *
     * @param id id.
     * @return T.
     */
    T read(int id);

    /**
     * Update entity.
     *
     * @param entity new object.
     */
    void update(T entity);

    /**
     * Delete entity.
     *
     * @param id id.
     */
    void delete(int id);

    /**
     * Gets list of entities.
     *
     * @return List.
     */
    List<T> getAll();
}
