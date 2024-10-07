// Package: train
package train;

public interface ITrain {
    String getTrainNumber();
    void setTrainNumber(String trainNumber);
    String getName();
    void setName(String name);
    String getSource();
    void setSource(String source);
    String getDestination();
    void setDestination(String destination);
    String getTrainInfo();
}

public class Train implements ITrain {
    String trainNumber;
    String name;
    String source;
    String destination;

    public Train(String trainNumber, String name, String source, String destination) {
        this.trainNumber = trainNumber;
        this.name = name;
        this.source = source;
        this.destination = destination;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTrainInfo() {
        return "Train " + trainNumber + " (" + name + ") from " + source + " to " + destination;
    }
}