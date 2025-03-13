package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.dominio.Anime;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.requests.AnimePutRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnimeService {
    private AnimeRepository animeRepository;

    public List<Anime> retornaAnimes() {
        return animeRepository.findAll();
    }
    public Anime findByIdOrThrowBadRequest(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "id nao encontrado"));
    }
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        Anime anime = Anime.builder().name(animePostRequestBody.getName()).ep(animePostRequestBody.getEps()).build();
        return animeRepository.save(anime);
    }
    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequest(id));
    }
    public void replace(AnimePutRequestBody animePutRequestBody) {
        findByIdOrThrowBadRequest(animePutRequestBody.getId());
        Anime anime = Anime.builder()
                .name(animePutRequestBody.getName())
                .ep(animePutRequestBody.getEps())
                .id(animePutRequestBody.getId())
                .build();
        animeRepository.save(anime);
    }
}
