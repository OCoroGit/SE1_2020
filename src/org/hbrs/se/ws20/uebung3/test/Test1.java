package org.hbrs.se.ws20.uebung3.test;

import org.hbrs.se.ws20.uebung3.control.Container;
import org.hbrs.se.ws20.uebung2.ContainerException;
import org.hbrs.se.ws20.uebung2.Member;
import org.hbrs.se.ws20.uebung2.MemberKonkret;
import org.hbrs.se.ws20.uebung3.persistence.PersistenceException;
import org.hbrs.se.ws20.uebung3.view.Client;
import org.hbrs.se.ws20.uebung3.view.MemberView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;


class Test1 {
    Container container;
    Member r1 = new MemberKonkret(121);
    Member r2 = new MemberKonkret(222);
    Member r3 = new MemberKonkret(323);


    @BeforeEach
    void setUp() {
        container= Container.getInstance();

    }
    @AfterEach
    void tearDown() throws PersistenceException {
        container.deleteAll();
        container.store();
    }

    @Test
    void newContainerTest() {
        Container store1 =Container.getInstance();
        Container store2 =Container.getInstance();
        assertEquals(store1.hashCode(),store2.hashCode());
    }


    // Leere Liste


    // Die Liste mit einem Member
    @Test
    void StoreLoadEinsTest() {
        try {
            container.addMember(r1);
            container.store();
            container.deleteMember(r1.getID());
            container.load();
            assertEquals(1, container.size());
        } catch (ContainerException | PersistenceException e) {
            e.printStackTrace();
        }
    }
        // Die Liste mit mehreren Members
    @Test
    void StoreLoadMehrereTest(){
        try {
            container.addMember(r1);
            container.addMember(r2);
            container.addMember(r3);
            container.store();
            container.deleteAll();
            container.load();
            assertEquals(3,container.size());
        } catch (ContainerException | PersistenceException e) {
            e.printStackTrace();
        }
    }
    @Test
    void LoadLeerTest() {
        try {
            FileOutputStream f=new FileOutputStream("objectsToSave.xml");
            ObjectOutputStream o=new ObjectOutputStream(f);
            container.load();
        } catch (PersistenceException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(0, container.size());
    }
    @Test
    void ClientTest() {
        assertEquals(0,container.size());
        Client client=new Client();
        try {
            client.addMembers(container);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        assertEquals(3,container.size());
    }

    @Test
    void memberViewTest() throws ContainerException {
        MemberView mv=new MemberView();
        container.addMember(r1);
        mv.dump(container.getCurrentList());
        container.addMember(r2);
        mv.dump(container.getCurrentList());

    }

}

