package io.camp.data.rest.test;

import io.camp.data.rest.board.Board;
import io.camp.data.rest.board.Contents;
import io.camp.data.rest.board.WriteBoardService;
import io.camp.data.rest.config.BoardResourceProcessor;
import io.camp.data.rest.member.Member;
import io.camp.data.rest.member.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardResourceProcessorTest {

    @Autowired
    private BoardResourceProcessor resourceProcessor;

    @Autowired
    private WriteBoardService boardService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testAddResource() throws Exception {
        // given
        Member member = memberRepository.save(new Member("test-user", "woniper", "lee"));
        Board testBoard = boardService.write(member.getUsername(), new Contents("test title", "test body"));

        // when
        Resource<Board> boardResource = resourceProcessor.process(new Resource<>(testBoard));

        // then
        assertThat(boardResource.hasLink(Link.REL_SELF)).isTrue();
        assertThat(boardResource.hasLink("board")).isTrue();
        assertThat(boardResource.hasLink("member")).isTrue();

        assertThat(boardResource.getLink(Link.REL_SELF).getHref())
                .endsWith("/boards/" + testBoard.getBoardId());
        assertThat(boardResource.getLink("board").getHref())
                .endsWith("/boards/" + testBoard.getBoardId() );
        assertThat(boardResource.getLink("member").getHref())
                .endsWith("/boards/" + testBoard.getBoardId() + "/member");
    }
}
