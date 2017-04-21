package io.camp.data.rest.test;

import io.camp.data.rest.board.Board;
import io.camp.data.rest.board.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class BoardRestRepositoryTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BoardRepository boardRepository;

    private final static String ROOT_URL = "/boards";

    @Test
    public void test_id로_게시글_조회() throws Exception {
        Board board = boardRepository.findOne(1L);

        ResponseEntity<Resource<Board>> responseEntity = restTemplate.exchange(ROOT_URL + "/1",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<Resource<Board>>() {});

        Resource<Board> boardResource = responseEntity.getBody();
        Board getBoard = boardResource.getContent();

        assertThat(board.getBoardId()).isEqualTo(getBoard.getBoardId());
    }

    @Test
    public void test_게시글_리스트_조회() throws Exception {
        ResponseEntity<Resource<Page<Resource<Board>>>> responseEntity = restTemplate.exchange(ROOT_URL,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<Resource<Page<Resource<Board>>>>() {});

        Resource<Page<Resource<Board>>> boards = responseEntity.getBody();
        System.out.println(boards.getContent().getContent().size());
    }
}
