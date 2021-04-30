package com.zerotospring.zerotospring.Anime;

import java.util.ArrayList;
import java.util.List;

import com.zerotospring.zerotospring.Anime.domain.Anime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AnimeService {
  private static List<Anime> animes;

  static {
    animes = new ArrayList<>(List.of(new Anime(1L, "Re: Zero"), new Anime(2L, "Jujutsu Kaisen")));
  }

  public List<Anime> listAll() {
    return animes; 
  }

  public Anime findById(Long id) {
    return animes.stream().filter(anime -> anime.getId().equals(id))
      .findFirst()
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime ID not found."));
  }

  public Anime save(Anime anime) {
    animes.add(anime);
    
    return anime;
  }

  public void delete(Long id) {
    animes.remove(this.findById(id));
  }

  public Anime replace(Anime anime) {
    this.delete(anime.getId());
    animes.add(anime);

    return anime;
  }
}
