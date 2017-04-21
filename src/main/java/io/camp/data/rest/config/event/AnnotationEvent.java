package io.camp.data.rest.config.event;

import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class AnnotationEvent {

    @HandleBeforeCreate
    public void beforeCreate(Object entity) {}

    @HandleBeforeSave
    public void beforeSave(Object entity) {}

    @HandleBeforeDelete
    public void beforeDelete(Object entity) {}

    @HandleBeforeLinkSave
    public void beforeLinkSave(Object entity, Object linked) {}

    @HandleAfterCreate
    public void afterCreate(Object entity) {}

    @HandleAfterSave
    public void afterSave(Object entity) {}

    @HandleAfterDelete
    public void afterDelete(Object entity) {}

    @HandleAfterLinkSave
    public void afterLinkSave(Object entity, Object linked) {}

}
