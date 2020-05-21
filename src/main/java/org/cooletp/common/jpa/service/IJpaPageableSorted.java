package org.cooletp.common.jpa.service;

import org.cooletp.common.entity.IEntity;
import org.cooletp.common.service.IPageableSorted;
import org.cooletp.common.util.ParamsBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IJpaPageableSorted<E extends IEntity> extends IPageableSorted<E>, IJpaPageable<E>, IJpaSorted<E> {
    @Override
    default List<E> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder) {
        return findAllPaginatedAndSortedRow(page, size, sortBy, sortOrder).getContent();
    }

    @Override
    @Transactional(readOnly = true)
    default Page<E> findAllPaginatedAndSortedRow(final int page, final int size, final String sortBy, final String sortOrder) {
        final Sort sortInfo = ParamsBuilder.constructSort(sortBy, sortOrder);

        return getRepository().findAll(PageRequest.of(page, size, sortInfo));
    }
}
