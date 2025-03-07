package academy.devdojo.springboot2.dominio;

public class Anime {
    private String name;
    private int ep;

    public Anime(String name, int ep) {
        this.name = name;
        this.ep = ep;
    }

    public Anime() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "name='" + name + '\'' +
                ", ep=" + ep +
                '}';
    }
}
