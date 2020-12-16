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
}
