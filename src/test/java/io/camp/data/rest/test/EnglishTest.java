package io.camp.data.rest.test;

import io.camp.data.rest.board.Board;
import io.camp.data.rest.member.Member;
import org.atteo.evo.inflector.English;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 엔티티를 복수 URL로 만드는 library
 */
public class EnglishTest {

    @Test
    public void test_단어_복수_생성() throws Exception {
        assertThat(English.plural("apple")).isEqualTo("apples");
        assertThat(English.plural("dirty")).isEqualTo("dirties");
    }

    @Test
    public void test_entity_복수_생성() throws Exception {
        String board = Board.class.getSimpleName().toLowerCase();
        assertThat(English.plural(board)).isEqualTo("boards");

        String member = Member.class.getSimpleName().toLowerCase();
        assertThat(English.plural(member)).isEqualTo("members");
    }
}
