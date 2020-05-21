package org.cooletp.common.jpa.service;

import org.cooletp.common.entity.IEntity;
import org.cooletp.common.jpa.repo.IRepository;

public interface IJpaBase<E extends IEntity> {
    IRepository<E> getRepository();
}
