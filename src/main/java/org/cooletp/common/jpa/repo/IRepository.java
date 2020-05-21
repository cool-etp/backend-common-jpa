package org.cooletp.common.jpa.repo;

import org.cooletp.common.entity.IEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IRepository<E extends IEntity> extends JpaRepository<E, Long> {
}
