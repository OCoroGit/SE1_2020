package org.hbrs.se.ws20.uebung4.model;

import org.hbrs.se.ws20.uebung3.persistence.PersistenceException;
import org.hbrs.se.ws20.uebung4.controller.EingabeDialog;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Container {

    // Interne ArrayList zur Abspeicherung der Objekte
    private List<UserStory> liste = null;

    // Statische Klassen-Variable, um die Referenz
    // auf das einzige Container-Objekt abzuspeichern
    private static Container instance = new Container();

    // URL der Datei, in der die Objekte gespeichert werden
    final static String LOCATION = "userstories1.ser";

    /**
     * Liefert ein Singleton zurück. Diese Methode ist thread-safe (oder...?) --> RICHTIG
     * Nachteil: ggf. hoher Speicherbedarf, da Singleton zu Programmstart schon erzeugt
     * @return
     */
    public static synchronized Container getInstance() {
        if (instance == null) {
            instance = new Container();
            System.out.println("Objekt vom Typ Container wurde instanziiert!");
        }
        return instance;
    }

    /**
     * Vorschriftsmäßiges Ueberschreiben des Konstruktors (private) gemaess Singleton-Pattern
     */
    private Container(){
        liste = new ArrayList<UserStory>();
    }

    /**
     * Start-Methoden zum Starten des Programms
     * (hier koennen ggf. weitere Initialisierungsarbeiten gemacht werden spaeter)
     *
    */
    public void startEingabe() throws ContainerException {
        EingabeDialog ed= new EingabeDialog();
        ed.startEingabe();
    }


    /*
     * Methode zum Speichern der Liste. Es wird die komplette Liste
     * inklusive ihrer gespeicherten UserStory-Objekte gespeichert.
     *
     */
    public void store() throws ContainerException {

        Stream str= new Stream();

        try {
            str.save(this.getCurrentList());

        } catch (PersistenceException e) {
            throw new ContainerException("Fehler im Laden");
        }
    }

    /*
     * Methode zum Laden der Liste. Es wird die komplette Liste
     * inklusive ihrer gespeicherten UserStory-Objekte geladen.
     *
     */
    public void load() {
        Stream str= new Stream();
        try {
            this.liste=str.load();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }
    public void mergeLoad(){
        Stream str= new Stream();
        List<UserStory> temp = null;
        try {
            temp=str.load();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        for (UserStory e:temp) {
            if(!this.contains(e)) {
                try {
                    this.addUserStory(e);
                } catch (ContainerException containerException) {
                    containerException.printStackTrace();
                }
            }
        }
    }

    /**
     * Methode zum Hinzufügen einer Story unter Wahrung der Schlüsseleigenschaft
     * @param r
     * @throws ContainerException
     */
    public void addUserStory ( UserStory r ) throws ContainerException {
        if ( contains(r) == true ) {
            ContainerException ex = new ContainerException("ID bereits vorhanden!");
            throw ex;
        }
        liste.add(r);

    }

    /**
     * Prüft, ob eine Story bereits vorhanden ist
     * @param r
     * @return
     */
    private boolean contains(UserStory r) {
        int ID = r.getId();
        for ( UserStory rec : liste) {
            if ( rec.getId() == ID ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ermittlung der Anzahl von internen UserStory-Objekten
     * @return
     */
    public int size(){
        return liste.size();
    }

    /**
     * Methode zur Rückgabe der aktuellen Liste mit Stories
     * Findet aktuell keine Anwendung bei Hr. P.
     * @return
     */
    public List<UserStory> getCurrentList() {
        return this.liste;
    }

    /**
     * Liefert eine bestimmte Story zurück
     * @param id
     * @return
     */
    private UserStory getUserStory(int id) {
        for ( UserStory rec : liste) {
            if (id == rec.getId() ){
                return rec;
            }
        }
        return null;
    }



}
