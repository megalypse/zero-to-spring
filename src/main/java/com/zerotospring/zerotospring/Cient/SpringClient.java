package com.zerotospring.zerotospring.Cient;

import java.util.List;

import com.zerotospring.zerotospring.Anime.domain.Anime;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class SpringClient {
  public static void main(String[] args) {
    // Adquire todas as informações da resposta
    new RestTemplate().getForEntity("http://localhost:8080/animes/2", Anime.class);

    // Adquire apenas o body da resposta
    new RestTemplate().getForObject("http://localhost:8080/animes/2", Anime.class);

    // Adquire apenas o body da resposta
    // O método abaixo retorna um array
    new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);

    // O método abaixo retorna uma lista
    new RestTemplate().exchange(
      "http://localhost:8080/animes/all",
      HttpMethod.GET,
      null,
      new ParameterizedTypeReference<List<Anime>>() {}
    );

    // Um exemplo de exchange POST
    Anime reZero = Anime.builder().name("Re: Zero").build();
    
    new RestTemplate().exchange(
      "http://localhost:8080/animes/", 
      HttpMethod.POST,
      new HttpEntity<>(reZero),
      Anime.class
    );
  }
}
