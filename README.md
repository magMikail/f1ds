**HOW TO Use:**

A simple test can be look like this.

`cd f1ds`

`mvn clean install`

`cd target/`

`java -jar formula-one-ds-0.0.1-SNAPSHOT.jar`

Now we can consume results from F1 history

To request 10 most victorious nationalities in grand-prixs in 2008 year:

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