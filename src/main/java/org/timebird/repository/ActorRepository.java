package org.timebird.repository;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.mysqlclient.MySQLPool;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;
import org.timebird.entity.Actor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ActorRepository {
  @Inject
  private MySQLPool client;

  public Multi<Actor> getAll() {
    return client.query("SELECT * FROM actor")
            .execute()
            .onItem()
            .transformToMulti(rows -> Multi.createFrom().iterable(rows))
            .onItem()
            .transform(Actor::from);
  }

  public Uni<Actor> getById(int id) {
    return client.preparedQuery("SELECT * FROM actor WHERE actor_id = ?")
            .execute(Tuple.of(id))
            .onItem()
            .transform(RowSet::iterator)
            .onItem()
            .transform(ite -> ite.hasNext() ? Actor.from(ite.next()) : null);
  }

  public Uni<Integer>
}
