package codetask.fds.model.response;

public class PitStopTimeResponse {

    private int rank;
    private String driver;
    private double averagePitStopTime;
    private double fastestPitStopTime;
    private double slowestPitStopTime;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public double getAveragePitStopTime() {
        return averagePitStopTime;
    }

    public void setAveragePitStopTime(double averagePitStopTime) {
        this.averagePitStopTime = averagePitStopTime;
    }

    public double getFastestPitStopTime() {
        return fastestPitStopTime;
    }

    public void setFastestPitStopTime(double fastestPitStopTime) {
        this.fastestPitStopTime = fastestPitStopTime;
    }

    public double getSlowestPitStopTime() {
        return slowestPitStopTime;
    }

    public void setSlowestPitStopTime(double slowestPitStopTime) {
        this.slowestPitStopTime = slowestPitStopTime;
    }


    @Override
    public String toString() {
        return "{" +
                "rank=" + rank +
                ", driver='" + driver + '\'' +
                ", averagePitStopTime=" + averagePitStopTime +
                ", fastestPitStopTime=" + fastestPitStopTime +
                ", slowestPitStopTime=" + slowestPitStopTime +
                '}';
    }
}
