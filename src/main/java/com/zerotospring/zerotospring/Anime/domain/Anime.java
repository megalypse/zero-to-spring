package com.zerotospring.zerotospring.Anime.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.zerotospring.zerotospring.Anime.dto.PostAnimeDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class Anime {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;


  public static Anime fromDto(PostAnimeDto dto) {
    Anime anime = new Anime();
    anime.name = dto.getName();

    return anime;
  }
}
