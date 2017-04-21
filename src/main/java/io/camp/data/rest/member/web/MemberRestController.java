package io.camp.data.rest.member.web;

import io.camp.data.rest.board.Board;
import io.camp.data.rest.board.Contents;
import io.camp.data.rest.board.WriteBoardService;
import io.camp.data.rest.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {

    @Autowired
    private WriteBoardService writeBoardService;

    @PostMapping("/members/{id}/board")
    public ResponseEntity<?> post(@PathVariable("id") Member member,
                                  @RequestBody Contents contents) {

        Board newBoard = writeBoardService.write(member.getUsername(), contents);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newBoard);
    }
}
