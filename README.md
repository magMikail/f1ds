**HOW TO Use:**

A simple test can be look like this.

`cd f1ds`

`mvn clean install`

`cd target/`

`java -jar formula-one-ds-0.0.1-SNAPSHOT.jar`

Now we can consume results from F1 history

1. To request 10 most victorious nationalities in grand-prixs in 2008 year:

`GET http://localhost:8080/topWinners/2008/2008`
```
[
    {"driverNationality":"Brazilian","numberOfVictorious":6,"range":1},
    {"driverNationality":"British","numberOfVictorious":5,"range":2},
    {"driverNationality":"Finnish","numberOfVictorious":3,"range":3},
    {"driverNationality":"German","numberOfVictorious":1,"range":4},
    {"driverNationality":"Polish","numberOfVictorious":1,"range":5},
    {"driverNationality":"Spanish","numberOfVictorious":2,"range":6}
]
```

Next request will return 10 most victorious nationalities in grand-prixs between 2008 and 2010 years.

`GET http://localhost:8080/topWinners/2008/2010`

```
[
    {"driverNationality":"Australian","numberOfVictorious":6,"range":1},
    {"driverNationality":"Brazilian","numberOfVictorious":8,"range":2},
    {"driverNationality":"British","numberOfVictorious":18,"range":3},
    {"driverNationality":"Finnish","numberOfVictorious":4,"range":4},
    {"driverNationality":"German","numberOfVictorious":10,"range":5},
    {"driverNationality":"Polish","numberOfVictorious":1,"range":6},
    {"driverNationality":"Spanish","numberOfVictorious":7,"range":7}
]
```
2. **To request The average time of pit stops 2012 year with a threshold limit 22 sec**:
`GET http://localhost:8080/pitStopTime/2012/22`

```
[
    {"rank":1,"driver":"michael_schumacher","averagePitStopTime":21.99210344827586,"fastestPitStopTime":13.199,"slowestPitStopTime":30.879},
    {"rank":2,"driver":"vettel","averagePitStopTime":21.888375,"fastestPitStopTime":15.008,"slowestPitStopTime":29.117},
    {"rank":3,"driver":"alonso","averagePitStopTime":21.92447619047619,"fastestPitStopTime":17.57,"slowestPitStopTime":29.557},
    {"rank":4,"driver":"button","averagePitStopTime":21.95572,"fastestPitStopTime":17.867,"slowestPitStopTime":30.019},
    {"rank":5,"driver":"ambrosio","averagePitStopTime":21.962,"fastestPitStopTime":21.962,"slowestPitStopTime":21.962}
]
```
3. **To request data in CSV format**:

`GET http://localhost:8080/topWinners/2008/2010/csv`
`GET http://localhost:8080/pitStopTime/2012/22/csv`