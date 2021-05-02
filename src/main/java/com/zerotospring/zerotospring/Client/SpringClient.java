package com.zerotospring.zerotospring.Client;

import com.zerotospring.zerotospring.Anime.domain.Anime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SpringClient {
  public static void main(String[] args) {
    ResponseEntity<Anime> forEntity = new RestTemplate().getForEntity("http://localhost:8080/animes/2", Anime.class);
    log.info(forEntity);
  }
}
