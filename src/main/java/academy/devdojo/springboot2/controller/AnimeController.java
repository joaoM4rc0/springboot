package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.dominio.Anime;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("anime")
@Log4j2
public class AnimeController {
    private DateUtil dateUtil;

    public AnimeController(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    //localhost:8080/anime/list
    @GetMapping(path = "list")
    public List<Anime> list() {
        log.info(dateUtil.formatDate(LocalDateTime.now()));
        return List.of(new Anime("DBZ", 300), new Anime("berserk", 200));
    }
    @GetMapping(path = "list2")
    public List<Anime> list2() {
        log.info(dateUtil.formatDate(LocalDateTime.now()));
        return List.of(new Anime("naruto", 700), new Anime("boku no hero", 200), new Anime("jujutsu kaisen", 80));
    }
}
