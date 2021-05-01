package com.zerotospring.zerotospring.Anime;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import com.zerotospring.zerotospring.Anime.domain.Anime;
import com.zerotospring.zerotospring.Anime.dto.PostAnimeDto;
import com.zerotospring.zerotospring.util.DateUtil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController()
@RequestMapping("/animes")
@Log4j2
@AllArgsConstructor
public class AnimeController {
  private final DateUtil dateUtil;
  private final AnimeService animeService;

  @GetMapping("/")
  public ResponseEntity<List<Anime>> list() {
    log.info(this.dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));

    return ResponseEntity.ok(this.animeService.listAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Anime> findById(@PathVariable Long id) {
    return ResponseEntity.ok(this.animeService.findByIdOrThrow(id));
  }

  @GetMapping("/list")
  public ResponseEntity<List<Anime>> findByName(@RequestParam String name) {
    return ResponseEntity.ok(this.animeService.findByName(name));
  }

  @PostMapping("/")
  public ResponseEntity<Anime> save(@RequestBody @Valid PostAnimeDto dto) {
    return ResponseEntity.ok(this.animeService.save(dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    this.animeService.delete(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/")
  public ResponseEntity<Anime> replace(@RequestBody Anime anime) {
    return ResponseEntity.ok(this.animeService.replace(anime));
  }
}
