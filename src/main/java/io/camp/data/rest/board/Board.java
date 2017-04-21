package io.camp.data.rest.board;

import io.camp.data.rest.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@ToString
@Entity
public class Board {

    @Id @GeneratedValue
    private Long boardId;

    @Embedded
    private Contents contents;

    /**
     * 필수 연관관계 매핑
     */
    @ManyToOne(optional = false)
    private Member member;

    public Board(Contents contents, Member member) {

        this.contents = contents;
        this.member = member;
    }

    public void update(Contents contents) {
        this.contents = contents;
    }
}
