package io.camp.data.rest.member.web;

import io.camp.data.rest.member.Member;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "member", types = Member.class)
public interface MemberProjection {

    String getMemberId();

    @Value("#{target.toString()}")
    String getFullName0();

    @Value("#{target.toString().toUpperCase()}")
    String getFullName1();

    @Value("#{target.firstName}, #{target.lastName}")
    String getFullName2();

    @Value("나는 Projection 입니다!!")
    String getComment();
}
