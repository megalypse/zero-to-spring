package com.zerotospring.zerotospring.Animes;

import com.zerotospring.zerotospring.Anime.AnimeRepository;
import com.zerotospring.zerotospring.Anime.domain.Anime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class AnimeRepositoryTest {
  @Autowired
  private AnimeRepository animeRepository;

  @Test
  @DisplayName("Save method creates anime in database when successful")
  void save_PersistAnime_Success() {
    Anime anime = this.createAnime();
    Anime savedAnime = this.animeRepository.save(anime);

    Assertions.assertThat(savedAnime).isNotNull();
    Assertions.assertThat(savedAnime.getId()).isNotNull();
    Assertions.assertThat(savedAnime.getName()).isEqualTo(anime.getName());
  }

  @Test
  void find_FindAnime_Success() {
    Anime anime = this.createAnime();
    this.animeRepository.save(anime);
    Anime result = this.animeRepository.findByName(anime.getName()).get(0);

    Assertions.assertThat(result.getName()).isEqualTo(anime.getName());
  }

  private Anime createAnime() {
    return Anime.builder()
      .name("Re: Zero")
      .build();
  }
}
