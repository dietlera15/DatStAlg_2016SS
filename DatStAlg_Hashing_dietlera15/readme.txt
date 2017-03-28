Hashing - Algorithmen

Aufgabenbeschreibung:
---------------------
Implementieren Sie den Double-Hashing und Double-Hashing mit Brent Algorithmus um Objekte in einer Hashtabelle zu organisieren


Hinweise zur Implementierung:
----------------------------

    * Die Hashtabelle ist ein Array von HashObject Objekten, die die eigentlichen Datenobjekte beinhalten können.
    * Ist das HashObject in einer Tabelleposition "null", ist der Tabellenplatz leer (Suche ist zu Ende, der Tabellenplatz steht zum Einfügen zur Verfügung).
    * Ist an der Tabellenposition ein gültiges HashObject, aber der Dateninhalt des HashObject Objectes ist "null", dann ist der Tabellenplatz
      "frei", d.h. das Element an dieser Position wurde gelöscht (Suche geht weiter, der Platz steht aber zum Einfügen zur Verfügung).
    * Die standard Java Object Methode "hashCode()" wird verwendet, um den "key" Wert der gespeicherten Objekte zu ermitteln


ToDo:
====

1) Importieren des Projektes in Eclipse (File-Import-General-Existing Projects into Workspace-Archive File-...)

2) Ausimplemtieren der fehlenden Methoden (Methoden-Stubs in Klasse vorhanden)

3) Testen der Implementierung durch ausführen der Klasse HashingTest.java oder HashingTestRunner.java

4) Exportieren des Projekts (File-Export-General-Archive File-...) als hashing_<IHR_ENCEPHALON_USERNAME>.zip

5) Upload des exportierten Files in Encephalon-Abgabeordner der Lehrveranstaltung 

