package codetask.fds.model;

import java.io.Serializable;

public class WinnersNationality implements Serializable {

    String driverNationality;

    int numberOfVictorious;

    public String getDriverNationality() {
        return driverNationality;
    }

    public void setDriverNationality(String driverNationality) {
        this.driverNationality = driverNationality;
    }

    public int getNumberOfVictorious() {
        return numberOfVictorious;
    }

    public void setNumberOfVictorious(int numberOfVictorious) {
        this.numberOfVictorious = numberOfVictorious;
    }

}
