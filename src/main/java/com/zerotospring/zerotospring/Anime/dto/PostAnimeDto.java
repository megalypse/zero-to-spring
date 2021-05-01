package com.zerotospring.zerotospring.Anime.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PostAnimeDto {
  @NotEmpty(message = "Anime name must not be empty")
  @NotNull(message = "Anime name must not be null")
  private String name;
}
