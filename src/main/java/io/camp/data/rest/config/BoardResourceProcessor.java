package io.camp.data.rest.config;

import io.camp.data.rest.board.Board;
import io.camp.data.rest.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Component
public class BoardResourceProcessor
        implements ResourceProcessor<Resource<Board>> {

    @Autowired
    private RepositoryEntityLinks entityLinks;

    @Override
    public Resource<Board> process(Resource<Board> resource) {
        Board board = resource.getContent();

        if(!resource.hasLinks()) {

            // self : /boards/{id}
            resource.add(entityLinks
                    .linkForSingleResource(Board.class, board.getBoardId())
                    .withSelfRel());

            // board : /api/boards/{id}
            resource.add(entityLinks
                    .linkToSingleResource(Board.class, board.getBoardId()));

            // member : /boards/{id}/member
            String memberName = Member.class.getSimpleName().toLowerCase();
            resource.add(entityLinks
                    .linkForSingleResource(Board.class, board.getBoardId())
                    .slash(memberName)
                    .withRel(memberName));

        }

        return resource;
    }
}
