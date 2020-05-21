package org.cooletp.common.jpa.service;

import org.cooletp.common.entity.IEntity;
import org.cooletp.common.service.IPageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IJpaPageable<E extends IEntity> extends IPageable<E>, IJpaBase<E> {
    @Override
    default List<E> findAllPaginated(int page, int size) {
        return findAllPaginatedRow(page, size).getContent();
    }

    @Override
    @Transactional(readOnly = true)
    default Page<E> findAllPaginatedRow(int page, int size) {
        return getRepository().findAll(PageRequest.of(page, size));
    }
}