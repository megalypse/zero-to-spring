package com.zerotospring.zerotospring.Mappers;

import com.zerotospring.zerotospring.Anime.domain.Anime;
import com.zerotospring.zerotospring.Anime.dto.PostAnimeDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
  public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

  public abstract Anime toAnime(PostAnimeDto dto);
}
