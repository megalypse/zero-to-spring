package com.zerotospring.zerotospring.Anime;

import java.util.List;

import com.zerotospring.zerotospring.Anime.domain.Anime;

import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository {
  List<Anime> listAll();
}
