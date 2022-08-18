# DB-Systel
Für das Bewerbungsgespräch

## demo
- Aufgabe nur mit Basisklassen gelöst
- Springboot für REST-api verwendet
- MVC-Pattern angelehnt

## demo_2
- opencsv für CSV-Import 
- gson für JSON-Formatierung
- Springboot für REST-api verwendet
- MVC-Pattern angelehnt

### Aufgebenstellung

Erstellen ein Programm, das die Daten aus der CSV-Datei einliest und über einen REST-Endpoint zur Verfügung stellt. Der Endpunkt soll mit der Abkürzung einer Betriebsstelle angefragt werden und die Daten der Betriebsstelle als JSON-Objekt zurück liefern.
Zusätzlich kann die Spalte 
### Tipp

Für die Lösung dieser Aufgabe kann man sehr gut Java und SpringBoot einsetzen. Du kannst aber auch andere Technologien nutzen.

Den Code kannst Du uns gerne in einem öffentlichen git-repo (z. B. Github) zur Verfügung stellen.

Beispiel-Request:

.../betriebsstelle/aamp

Beispiel-Response:

HTTP-STATUS: 200

{

  Name: Hamburg Anckelmannsplatz      

  Kurzname: Anckelmannsplatz  

  Typ: Üst

}
