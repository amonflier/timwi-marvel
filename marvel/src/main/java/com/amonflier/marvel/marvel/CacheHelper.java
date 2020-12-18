package com.amonflier.marvel.marvel;

import com.amonflier.marvel.marvel.model.Character;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CacheHelper {

  private CacheManager cacheManager;
  private Cache<Integer, Character> charactersCache;
  private Cache<Integer, Character> superteamCache;

  public CacheHelper() {
    cacheManager = CacheManagerBuilder
      .newCacheManagerBuilder().build();
    cacheManager.init();

    charactersCache = cacheManager
      .createCache("characters", CacheConfigurationBuilder
        .newCacheConfigurationBuilder(
          Integer.class, Character.class,
          ResourcePoolsBuilder.heap(10)));

    superteamCache = cacheManager
      .createCache("superteam", CacheConfigurationBuilder
        .newCacheConfigurationBuilder(
          Integer.class, Character.class,
          ResourcePoolsBuilder.heap(10)));
  }

  public Cache<Integer, Character> getCharacterCacheFromCacheManager() {
    return cacheManager.getCache("characters", Integer.class, Character.class);
  }

  public Cache<Integer, Character> getSuperteamCacheFromCacheManager() {
    return cacheManager.getCache("superteam", Integer.class, Character.class);
  }

  //standard getters and setters
}
