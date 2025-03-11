package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.dominio.Anime;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
public class AnimeController {
    private DateUtil dateUtil;
    private AnimeService animeService;
    public AnimeController(DateUtil dateUtil, AnimeService animeService) {
        this.dateUtil = dateUtil;
        this.animeService = animeService;
    }
    //localhost:8080/anime/list
    @GetMapping
    public ResponseEntity<List<Anime>> list() {
        log.info(dateUtil.formatDate(LocalDateTime.now()));
        return new ResponseEntity<>(animeService.retornaAnimes(), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id) {
        return new ResponseEntity<>(animeService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody Anime anime) {
        AnimeService.save(anime);
    }
}
