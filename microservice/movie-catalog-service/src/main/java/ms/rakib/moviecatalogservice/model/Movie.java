package ms.rakib.moviecatalogservice.model;

public class Movie {

    private String modieId;
    private String name;

    public Movie() {
    }

    public Movie(String modieId, String name) {
        this.modieId = modieId;
        this.name = name;
    }

    public String getModieId() {
        return modieId;
    }

    public void setModieId(String modieId) {
        this.modieId = modieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
