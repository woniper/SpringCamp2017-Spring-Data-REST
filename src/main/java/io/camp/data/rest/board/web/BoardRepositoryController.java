package io.camp.data.rest.board.web;

import io.camp.data.rest.board.Board;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RepositoryRestController
public class BoardRepositoryController {

    @GetMapping("/boards/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Board board) {
        return ResponseEntity.ok(new Resource<>(board));
    }

    /**
     * 404 Not Found
     */
    @GetMapping("/test/boards/{id}")
    public ResponseEntity<?> test(@PathVariable("id") Board board) {
        return ResponseEntity.ok(board);
    }
}
