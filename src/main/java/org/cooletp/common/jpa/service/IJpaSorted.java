package org.cooletp.common.jpa.service;

import org.cooletp.common.entity.IEntity;
import org.cooletp.common.service.ISorted;
import org.cooletp.common.util.ParamsBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IJpaSorted<E extends IEntity> extends ISorted<E>, IJpaBase<E> {
    @Override
    @Transactional(readOnly = true)
    default List<E> findAllSorted(String sortBy, String sortOrder) {
        final Sort sortInfo = ParamsBuilder.constructSort(sortBy, sortOrder);

        return getRepository().findAll(sortInfo);
    }
}