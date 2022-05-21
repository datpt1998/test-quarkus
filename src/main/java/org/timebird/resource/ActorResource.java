package org.timebird.resource;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.timebird.entity.Actor;
import org.timebird.model.ResponseData;
import org.timebird.service.ActorService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/actor")
@ApplicationScoped
public class ActorResource {
  @Inject
  private ActorService actorService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/all")
  public Uni<Response> getAll() {
    return actorService.getAll()
            .collect()
            .asList()
            .onItem()
            .transform(actors ->
                    Response.ok(new ResponseData(actors, ResponseData.STATUS_SUCCESS, "Get success")).build());
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{id}")
  public Uni<Response> getById(@PathParam("id") int id) {
    return actorService.getById(id)
            .onItem()
            .transform(actor ->
                    actor == null ?
                            Response.status(400).entity(new ResponseData(null, ResponseData.STATUS_FAILED, "Not found")) :
                            Response.ok(new ResponseData(actor, ResponseData.STATUS_SUCCESS, "Found")))
            .onItem()
            .transform(Response.ResponseBuilder::build);
  }


}
