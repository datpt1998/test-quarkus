package org.timebird.service;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.timebird.entity.Actor;
import org.timebird.repository.ActorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ActorService {
  @Inject
  private ActorRepository actorRepository;

  public Multi<Actor> getAll() {
    return actorRepository.getAll();
  }

  public Uni<Actor> getById(int id) {
    return actorRepository.getById(id);
  }
}
