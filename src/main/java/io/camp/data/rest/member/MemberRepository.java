package io.camp.data.rest.member;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {

    Member findByUsername(String username);

}
