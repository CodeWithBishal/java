package station;

public interface IStation {
    String getName();
    void setName(String name);
    String getCity();
    void setCity(String city);
    int getNumberOfPlatforms();
    void setNumberOfPlatforms(int numberOfPlatforms);
    void addPlatform();
    void removePlatform();
}

public class Station implements IStation {
    String name;
    String city;
    int numberOfPlatforms;

    public Station(String name, String city, int numberOfPlatforms) {
        this.name = name;
        this.city = city;
        this.numberOfPlatforms = numberOfPlatforms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumberOfPlatforms() {
        return numberOfPlatforms;
    }

    public void setNumberOfPlatforms(int numberOfPlatforms) {
        this.numberOfPlatforms = numberOfPlatforms;
    }

    public void addPlatform() {
        this.numberOfPlatforms++;
    }

    public void removePlatform() {
        if (this.numberOfPlatforms > 0) {
            this.numberOfPlatforms--;
        }
    }
}