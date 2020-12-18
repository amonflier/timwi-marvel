package com.amonflier.marvel.marvel;

import com.amonflier.marvel.marvel.model.Character;
import org.apache.commons.io.IOUtils;
import org.ehcache.CacheManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;

@Component("applicationListener")
@Order(0)
class MarvelApplicationListener
  implements ApplicationListener<ApplicationReadyEvent> {

  @Autowired
  private Environment env;

  @Autowired
  private CacheHelper cache;

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {

    try {
      JSONArray json = new JSONArray(IOUtils.toString(
        new URL(env.getProperty("marvel.api.characters.url")),
        Charset.forName("UTF-8")));
      for (int i=0; i < json.length(); i++) {
        addCharacterToCache(json.getJSONObject(i));
      }

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void addCharacterToCache(JSONObject json){
    int id = json.getInt("id");
    String name = json.getString("name");
    String thumbnail = json.getJSONObject("thumbnail").getString("path");
    String description = json.getString("description");

    Character character = new Character(id, name, thumbnail, description);
    cache.getCharacterCacheFromCacheManager().put(id, character);

  }

}
