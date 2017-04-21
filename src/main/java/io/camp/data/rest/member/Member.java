package io.camp.data.rest.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.camp.data.rest.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id @GeneratedValue
    private Long memberId;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Board> boards = new ArrayList<>();

    public Member(String username,
                  String firstName,
                  String lastName) {

        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s",
                getFirstName(), getLastName());
    }

    /**
     * member가 작성한 board(게시글) 연관관계 매핑
     */
    public void writeBoard(Board newBoard) {
        addBoard(newBoard);
    }

    private void addBoard(Board newBoard) {
        this.boards.add(newBoard);
    }
}
