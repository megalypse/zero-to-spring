package com.zerotospring.zerotospring.Anime;

import java.util.List;

import com.zerotospring.zerotospring.Anime.domain.Anime;
import com.zerotospring.zerotospring.Anime.dto.PostAnimeDto;
import com.zerotospring.zerotospring.Mappers.AnimeMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimeService {
  private final AnimeRepository animeRepository;

  public Page<Anime> listAll(Pageable pageable) {
    return this.animeRepository.findAll(pageable); 
  }

  public Anime findByIdOrThrow(Long id) {
    Anime user = this.animeRepository.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime ID not found"));

    return user;
  }

  public Anime save(PostAnimeDto dto) {
    return this.animeRepository.save(AnimeMapper.INSTANCE.toAnime(dto));
  }

  public ResponseEntity<Void> delete(Long id) {
    this.animeRepository.deleteById(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  public Anime replace(Anime anime) {
    Anime savedAnime = this.findByIdOrThrow(anime.getId());
    anime.setId(savedAnime.getId());

    return this.animeRepository.save(anime);
  }

  public List<Anime> findByName(String name) {
    return this.animeRepository.findByName(name);
  }
}
