package codetask.fds.model.response;

import java.io.Serializable;

public class WinnersNationalityResponse implements Serializable {

    private String driverNationality;

    private long numberOfVictorious;

    private int range;

    public WinnersNationalityResponse(String driverNationality, long numberOfVictorious, int range) {
        this.driverNationality = driverNationality;
        this.numberOfVictorious = numberOfVictorious;
        this.range = range;
    }

    public String getDriverNationality() {
        return driverNationality;
    }

    public void setDriverNationality(String driverNationality) {
        this.driverNationality = driverNationality;
    }

    public long getNumberOfVictorious() {
        return numberOfVictorious;
    }

    public void setNumberOfVictorious(long numberOfVictorious) {
        this.numberOfVictorious = numberOfVictorious;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "driverNationality='" + driverNationality + '\'' +
                ", numberOfVictorious=" + numberOfVictorious +
                ", range=" + range;
    }


}
