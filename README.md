# Travix Technical Test - Jarosław Drabek

How to configure it:
1. Configure external suppliers URLs in *application.properties*. 
One for Crazy Air supplier (*crazy.air.url*) and one for ToughJet supplier (*taughjet.url*)
2. In console execute following code: 
    ```
    mvn package && java -jar target/travix_test-1.0-SNAPSHOT.jar
    ```
3. Try it out: 
    ```
    curl localhost:8080/v1/flight?destination=KRK
    ```
    

