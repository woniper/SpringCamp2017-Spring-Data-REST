package io.camp.data.rest.config.event;

import io.camp.data.rest.board.Board;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerEvent
        extends AbstractRepositoryEventListener<Board> {

    @Override
    protected void onBeforeCreate(Board entity) {}

    @Override
    protected void onAfterCreate(Board entity) {}

    @Override
    protected void onBeforeSave(Board entity) {}

    @Override
    protected void onAfterSave(Board entity) {}

    @Override
    protected void onBeforeLinkSave(Board parent, Object linked) {}

    @Override
    protected void onAfterLinkSave(Board parent, Object linked) {}

    @Override
    protected void onBeforeLinkDelete(Board parent, Object linked) {}

    @Override
    protected void onAfterLinkDelete(Board parent, Object linked) {}

    @Override
    protected void onBeforeDelete(Board entity) {}

    @Override
    protected void onAfterDelete(Board entity) {}
}
