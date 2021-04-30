package com.zerotospring.zerotospring.Anime;

import java.util.List;

import com.zerotospring.zerotospring.Anime.domain.Anime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimeService {
  private final AnimeRepository animeRepository;

  public List<Anime> listAll() {
    return this.animeRepository.findAll(); 
  }

  public Anime findById(Long id) {
    Anime user = this.animeRepository.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime ID not found"));

    return user;
  }

  public Anime save(Anime anime) {
    return this.animeRepository.save(anime);
  }

  public ResponseEntity<Void> delete(Long id) {
    this.animeRepository.deleteById(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  public Anime replace(Anime animeDto) {
    Anime anime = this.findById(animeDto.getId());
    anime = animeDto;
    this.delete(anime.getId());
    

    return this.save(anime);
  }
}
