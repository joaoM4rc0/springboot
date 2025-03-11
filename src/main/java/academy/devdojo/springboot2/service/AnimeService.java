package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.dominio.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {
    private static final List<Anime> animes;
    static {
        animes = new ArrayList<>(List.of(new Anime(1L, "naruto", 850),
                new Anime(2L, "boku no hero", 200),
                new Anime(3L, "jujutsu kaisen", 80)));
    }
    public List<Anime> retornaAnimes() {
        return animes;
    }
    public Anime findById(long id) {
        return animes.stream()
                .filter(anime -> Objects.equals(anime.getId(), id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "id nao encontrado"));
    }
    public static Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(4, 100000));
        animes.add(anime);
        return anime;
    }
}
