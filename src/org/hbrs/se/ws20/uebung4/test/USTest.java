package org.hbrs.se.ws20.uebung4.test;

import org.hbrs.se.ws20.uebung4.controller.EingabeDialog;
import org.hbrs.se.ws20.uebung4.model.Container;
import org.hbrs.se.ws20.uebung3.persistence.PersistenceException;
import org.hbrs.se.ws20.uebung4.model.ContainerException;
import org.hbrs.se.ws20.uebung4.model.UserStory;
import org.hbrs.se.ws20.uebung4.view.AusgabeDialog;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class USTest {
    Container container;

    @BeforeEach
    void setUp() {
        container= Container.getInstance();

    }
    @AfterEach
    void tearDown() throws PersistenceException {
        try {
            container.getCurrentList().clear();
            container.store();
        } catch (ContainerException e) {
            e.printStackTrace();
        }
    }
    @Test
    void enterTest(){
        /** Wir nehmen an, wir haben die Daten über eine Kommandozeile engegeben
         * Wir wollen ueberpruefen, ob das Programm user UserStory speichert
         */
        assertEquals(0,container.getCurrentList().size());
        UserStory us1=new UserStory(34,"Eingabe von Daten",1,2,3,4);
        EingabeDialog ed= new EingabeDialog();
        ed.enter(us1.getId(),us1.getTitel(),us1.getMehrwert(),us1.getStrafe(),us1.getAufwand(),us1.getRisk());
        assertEquals(1,container.getCurrentList().size());
    }
    @Test
    void StoreLoadTest(){
        assertEquals(0,container.getCurrentList().size());
        EingabeDialog ed= new EingabeDialog();
        ed.enter(34,"Eingabe von Daten",1,2,3,4);
        try {
            container.store();
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        container.getCurrentList().clear();
        container.load();
        assertEquals(1,container.getCurrentList().size());
    }
    @Test
    void MergeLoadTest(){
        assertEquals(0,container.getCurrentList().size());
        EingabeDialog ed= new EingabeDialog();
        ed.enter(34,"Eingabe von Daten",1,2,3,4);
        ed.enter(38,"Loeschen von Daten",3,4,4,3);
        try {
            container.store();
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        ed.enter(25,"Bearbeiten von Daten",1,3,2,4);
        container.mergeLoad();
        assertEquals(3,container.getCurrentList().size());
    }
    @Test
    void DumpTest(){
        EingabeDialog ed= new EingabeDialog();
        ed.enter(34,"Eingabe von Daten",1,2,3,4);
        ed.enter(38,"Loeschen von Daten",3,4,4,3);
        ed.enter(25,"Bearbeiten von Daten",1,3,2,4);
        AusgabeDialog ag= new AusgabeDialog();
        ag.dump();
    }
    @Test
    void DumpAufwandTest(){
        /**
         * User Stories mit Aufwänden < 3 würden nicht mehr angezeigt werden
         */
        EingabeDialog ed= new EingabeDialog();
        ed.enter(34,"Eingabe von Daten",1,2,3,4);
        ed.enter(38,"Loeschen von Daten",3,4,4,3);
        ed.enter(25,"Bearbeiten von Daten",1,3,2,4);
        AusgabeDialog ag= new AusgabeDialog();
        ag.dumpAufwand(3);
    }
}