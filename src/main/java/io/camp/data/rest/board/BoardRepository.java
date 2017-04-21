package io.camp.data.rest.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface BoardRepository extends PagingAndSortingRepository<Board, Long> {

    @RestResource(path = "starts-title")
    Page<Board> findByContentsTitleStartsWith(@Param("title") String title, Pageable pageable);
}
