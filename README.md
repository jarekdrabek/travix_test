# Travix Technical Test - Jarosław Drabek

How to configure it:
1. Configure external suppliers URLs in *application.properties*:

    * *crazy.air.url* for Crazy Air supplier
    * *taughjet.url* for ToughJet supplier
2. In console execute following code: 
    ```
    mvn package && java -jar target/travix_test-1.0-SNAPSHOT.jar
    ```
3. Try it out: 
    ```
    curl localhost:8080/v1/flight?destination=KRK
    ```
Disclaimer:
   * ToughJet Supplier Response doesn't have Time of the flight. I assumed simpliest - the time is the moon of the day.
   * Since I was running out of time, I didn't write all unit tests I had in mind. 
    It would be the same as for CrazyJet supplier. 

