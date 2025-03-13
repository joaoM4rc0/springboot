package academy.devdojo.springboot2.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Builder
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
