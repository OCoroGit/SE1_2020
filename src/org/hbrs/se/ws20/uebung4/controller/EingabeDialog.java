package org.hbrs.se.ws20.uebung4.controller;

import org.hbrs.se.ws20.uebung4.model.Container;
import org.hbrs.se.ws20.uebung4.model.ContainerException;
import org.hbrs.se.ws20.uebung4.model.UserStory;
import org.hbrs.se.ws20.uebung4.view.AusgabeDialog;

import java.util.Scanner;

public class EingabeDialog {
    Container container = Container.getInstance();
    /*
     * Diese Methode realisiert eine Eingabe ueber einen Scanner
     * Alle Exceptions werden an den aufrufenden Context (hier: main) weitergegeben (throws)
     * Das entlastet den Entwickler zur Entwicklungszeit und den Endanwender zur Laufzeit
     */

    public void startEingabe() throws ContainerException {

        String strInput = null;

        // Initialisierung des Eingabe-View
        Scanner scanner = new Scanner( System.in );

        // Ausgabe eines Texts zur Begruessung
        System.out.println("Geben Sie 'help' ein, um weitere Befehle zu sehen: ");

        while ( true ) {
            System.out.print( "> "  );

            strInput = scanner.nextLine();

            // Extrahiert ein Array aus der Eingabe
            String[] strings = strInput.split(" ");

            // 	Falls 'help' eingegeben wurde, werden alle Befehle ausgedruckt
            switch(strings[0]){
                case("help"):
                System.out.println("Folgende Befehle stehen zur Verfuegung: help, dump, exit, load, store, enter");
            break;

            // Auswahl der bisher implementierten Befehle:
                case("dump"):
                    AusgabeDialog ad = new AusgabeDialog();
                     if(strings.length>1){
                        if(strings[1].equals("aufwand")) {
                         ad.dumpAufwand(Integer.parseInt(strings[2]));
                        }
                     }else{
                         ad.dump();
                     }
                break;

            // Auswahl der bisher implementierten Befehle:
                case("enter"):
                    System.out.println("Geben Sie bitte ID ein");
                    int id=scanner.nextInt();
                    System.out.println("Geben Sie bitte Titel ein");
                    scanner.nextLine();
                    String titel=scanner.nextLine();
                    System.out.println("Mehrwert:");
                    int mehrwert=scanner.nextInt();
                    System.out.println("Strafe:");
                    int strafe=scanner.nextInt();
                    System.out.println("Aufwand:");
                    int aufwand=scanner.nextInt();
                    System.out.println("Risk:");
                    int risk=scanner.nextInt();
                    enter(id,titel,mehrwert,strafe,aufwand,risk);
                break;

                case("store"):
                container.store();
                break;

                case("load"):
                    System.out.println("merge oder force?");
                    String s=scanner.next();
                    if(s.equals("merge"))
                        container.mergeLoad();
                    else if (s.equals("force"))
                        container.load();
                break;

                case("exit"):
                    System.exit(0);
                break;
            }
        } // Ende der Schleife

    }
    public void enter(int id, String titel, int mehrwert, int strafe, int aufwand,int risk){
        if(mehrwert<1||strafe<1||risk<1||aufwand<0){
            throw new IllegalArgumentException("ungueltige Eingabe");
        }
        UserStory us= new UserStory(id,titel,mehrwert,strafe,aufwand,risk);
        try {
            container.addUserStory(us);
            System.out.println("User Story:"+us.toString()+"wurde gespeichert");
        } catch (ContainerException e) {
            e.printStackTrace();
        }
    }

}
