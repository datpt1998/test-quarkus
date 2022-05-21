package org.timebird.entity;

import io.vertx.mutiny.sqlclient.Row;

public class Actor {
  private int id;
  private String firstName;
  private String lastName;

  public Actor() {
  }

  public Actor(int id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public static Actor from(Row row) {
    int id = row.getInteger("actor_id");
    String firstName = row.getString("first_name");
    String lastName = row.getString("last_name");
    return new Actor(id, firstName, lastName);
  }
}
