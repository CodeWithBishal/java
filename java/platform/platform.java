// Package: platform
package platform;

import train.Train;
import java.time.LocalDateTime;

public interface IPlatform {
    int getPlatformNumber();
    boolean isOccupied();
    Train getCurrentTrain();
    LocalDateTime getOccupiedSince();
    LocalDateTime getScheduledDeparture();
    void occupyPlatform(Train train, LocalDateTime departureTime);
    void vacatePlatform();
    boolean isAvailableAt(LocalDateTime time);
    String getStatus();
}

public class Platform implements IPlatform {
    int platformNumber;
    boolean isOccupied;
    Train currentTrain;
    LocalDateTime occupiedSince;
    LocalDateTime scheduledDeparture;

    public Platform(int platformNumber) {
        this.platformNumber = platformNumber;
        this.isOccupied = false;
        this.currentTrain = null;
        this.occupiedSince = null;
        this.scheduledDeparture = null;
    }

    public int getPlatformNumber() {
        return platformNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Train getCurrentTrain() {
        return currentTrain;
    }

    public LocalDateTime getOccupiedSince() {
        return occupiedSince;
    }

    public LocalDateTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void occupyPlatform(Train train, LocalDateTime departureTime) {
        if (!isOccupied) {
            this.isOccupied = true;
            this.currentTrain = train;
            this.occupiedSince = LocalDateTime.now();
            this.scheduledDeparture = departureTime;
            System.out.println("Platform " + platformNumber + " is now occupied by train " + train.getTrainNumber());
        } else {
            System.out.println("Platform " + platformNumber + " is already occupied.");
        }
    }

    public void vacatePlatform() {
        if (isOccupied) {
            this.isOccupied = false;
            System.out.println("Train " + currentTrain.getTrainNumber() + " has departed from platform " + platformNumber);
            this.currentTrain = null;
            this.occupiedSince = null;
            this.scheduledDeparture = null;
        } else {
            System.out.println("Platform " + platformNumber + " is already vacant.");
        }
    }

    public boolean isAvailableAt(LocalDateTime time) {
        return !isOccupied || (scheduledDeparture != null && time.isAfter(scheduledDeparture));
    }

    public String getStatus() {
        if (isOccupied) {
            return "Platform " + platformNumber + " is occupied by train " + currentTrain.getTrainNumber() +
                   " since " + occupiedSince + ". Scheduled departure: " + scheduledDeparture;
        } else {
            return "Platform " + platformNumber + " is vacant.";
        }
    }
}