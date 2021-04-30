package com.zerotospring.zerotospring.Anime;

import com.zerotospring.zerotospring.Anime.domain.Anime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long>{}
