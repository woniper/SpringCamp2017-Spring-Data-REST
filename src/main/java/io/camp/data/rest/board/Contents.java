package io.camp.data.rest.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Contents {

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "body", nullable = false)
    private String body;

}
