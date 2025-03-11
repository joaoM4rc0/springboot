package academy.devdojo.springboot2.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;
public class Anime {
    private long id;
    private String name;
    private int ep;

    public Anime(long id, String name, int ep) {
        this.id = id;
        this.name = name;
        this.ep = ep;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ep=" + ep +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, ep);
    }

    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
