package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.dominio.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> retornaAnimes();
}
