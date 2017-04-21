package io.camp.data.rest.config;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.io.Serializable;

@NoRepositoryBean
public interface ReadOnlyPagingAndSortingRepository<T, ID extends Serializable>
   extends PagingAndSortingRepository<T, ID> {

    /**
     * POST, PUT, PATCH
     */
    @RestResource(exported = false)
    @Override
    <S extends T> S save(S entity);

    /**
     * DELETE
     */
    @RestResource(exported = false)
    @Override
    void delete(ID id);
}
