package com.amonflier.marvel.marvel.model;
import java.io.Serializable;
public class Character implements Serializable {
    private static final long serialVersionUID = -8809089768201955649L;
    private int id;
    private String name;
    private String thumbnail;
    private String description;
    public Character(){}
    public Character(int id, String name, String thumbnail, String description) {
        super();
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.description = description;
    }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public String getDescription() {
    return description;
  }
}
