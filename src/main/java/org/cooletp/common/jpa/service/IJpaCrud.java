package org.cooletp.common.jpa.service;

import org.cooletp.common.entity.IEntity;
import org.cooletp.common.service.ICrud;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IJpaCrud<E extends IEntity> extends ICrud<E>, IJpaBase<E> {
    @Override
    @Transactional(readOnly = true)
    default Optional<E> findOneById(final Long id) {
        return getRepository().findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    default List<E> findAll() {
        return getRepository().findAll();
    }

    @Override
    @Transactional
    default void create(final E entity) {
        if(entity == null) {
            throw new NullPointerException();
        }

        getRepository().save(entity);
    }

    @Override
    @Transactional
    default Optional<E> update(final E entity) {
        if(entity == null) {
            throw new NullPointerException();
        }

        getRepository().save(entity);

        return getRepository().findById(entity.getId());
    }

    @Override
    @Transactional
    default void delete(final Long id) {
        final Optional<E> entity = getRepository().findById(id);

        entity.ifPresent(e -> getRepository().delete(e));
    }

    @Override
    @Transactional(readOnly = true)
    default long count() {
        return getRepository().count();
    }
}
