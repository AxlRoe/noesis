requirements: <br/>
maven 3
java 11

build application: <br/>
mvn clean install

run application <br/>
java -jar noesis-1.0.jar

E/R schema:
Reservations: keep tracks of reservations made
Accomodation: room available for reservations

REST calls:
reservation/book/{accomodationid} to book a room
search of reservation and accomodation made by location (for simplicity)
