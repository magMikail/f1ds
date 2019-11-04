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


The average time of pit stops
The average time of pit stops by constructors in a determined year considering a threshold
•	Threshold value is the maximum accepted average pit stop time in seconds.
Example: threshold = 25, only show averages of 25 seconds and less.
•	Tie-break should be the constructor with fastest pit stop time.

Inputs
•	Year
•	Threshold

Response
•	Response must contain following fields:
o	Rank (1 to X)
o	Constructor name
o	Average pit stop time
o	Fastest pit stop time
o	Slowest pit stop time
•	If invalid input, you should return 400 (Bad Request) with comprehensive error message.
•	If no data for the given year, or the threshold excludes all data, you should return HTTP status 204 (No content), with no data.


