package com.amonflier.marvel.marvel.controller;
import java.util.ArrayList;
import java.util.List;

import com.amonflier.marvel.marvel.CacheHelper;
import org.ehcache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.*;
import com.amonflier.marvel.marvel.model.Character;

import javax.annotation.PostConstruct;

@RestController
public class CharacterController {
    @Autowired
    CacheHelper cache;

    private List<Character> characters;
    private List<Character> superteam;
    CharacterController() {

    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/characters")
    public List<Character> getCharacters() {
      if (this.characters==null) {
        this.characters = buildCharacters();
      }
      return this.characters;
    }

  @RequestMapping(method = RequestMethod.GET, value = "/api/superteam")
  public List<Character> getSuperteam() {
    this.superteam = buildSuperteam();
    return this.superteam;
  }

  @RequestMapping( method = RequestMethod.GET, value = "/api/superteam/add/{id}")
  public List<Character>  addToSuperteam(@PathVariable int id) {
      cache.getSuperteamCacheFromCacheManager().put(id,
        cache.getCharacterCacheFromCacheManager().get(id));
      return getSuperteam();
  }

  @RequestMapping( method = RequestMethod.GET, value = "/api/superteam/delete/{id}")
  public List<Character>  deleteFromSuperteam(@PathVariable int id) {
    cache.getSuperteamCacheFromCacheManager().remove(id);
    return getSuperteam();
  }

    List<Character> buildCharacters() {
      List<Character> chars = new ArrayList<Character>();
      for(Cache.Entry<Integer, Character> entry : cache.getCharacterCacheFromCacheManager()) {
        chars.add(entry.getValue());
      }
        return chars;
    }

  List<Character> buildSuperteam() {
    List<Character> chars = new ArrayList<Character>();
    for(Cache.Entry<Integer, Character> entry : cache.getSuperteamCacheFromCacheManager()) {
      chars.add(entry.getValue());
    }
    return chars;
  }

    Character buildCharacter(int id, String name, String thumbnail, String description) {
        Character character = new Character(id, name, thumbnail, description);
        return character;
    }
}
