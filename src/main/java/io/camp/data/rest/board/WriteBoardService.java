package io.camp.data.rest.board;

import io.camp.data.rest.member.Member;
import io.camp.data.rest.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WriteBoardService {

    private BoardRepository boardRepository;
    private MemberRepository memberRepository;

    @Autowired
    public WriteBoardService(BoardRepository boardRepository, MemberRepository memberRepository) {
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Board write(String username, Contents contents) {
        Member writer = memberRepository.findByUsername(username);
        Board newBoard = boardRepository.save(new Board(contents, writer));
        writer.writeBoard(newBoard);

        return newBoard;
    }

}
