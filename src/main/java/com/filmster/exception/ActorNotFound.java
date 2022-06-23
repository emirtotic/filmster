package com.filmster.exception;

public class ActorNotFound extends ApplicationException{

    public ActorNotFound(Long actorId) {
        super(String.format("Actor id=[%s] not found", actorId));
    }

    public ActorNotFound(String actorName) {
        super(String.format("Actor name=[%s] not found", actorName));
    }

}
