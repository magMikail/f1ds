package codetask.fds.model.response;

import java.io.Serializable;

public class WinnersNationalityResponse implements Serializable {

    private String driverNationality;

    private long numberOfVictorious;


    public String getDriverNationality() {
        return driverNationality;
    }

    public void setDriverNationality(String driverNationality) {
        this.driverNationality = driverNationality;
    }

    public long getNumberOfVictorious() {
        return numberOfVictorious;
    }

    public void setNumberOfVictorious(int numberOfVictorious) {
        this.numberOfVictorious = numberOfVictorious;
    }

}
