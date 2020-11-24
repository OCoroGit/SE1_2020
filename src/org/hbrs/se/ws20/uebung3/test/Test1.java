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

import static org.junit.jupiter.api.Assertions.assertEquals;


class Test1 {
    Container store;
    Member r1 = new MemberKonkret(12);
    Member r2 = new MemberKonkret(32);
    Member r3 = new MemberKonkret(112);
    Member r4 = new MemberKonkret(1211);


    @BeforeEach
    void setUp() {
        store= Container.getInstance();

    }
    @AfterEach
    void tearDown() throws PersistenceException {
        store.deleteAll();
        store.store();
    }

    @Test
    void newContainerTest() {
        Container store1 =Container.getInstance();
        Container store2 =Container.getInstance();
        assertEquals(store1.hashCode(),store2.hashCode());
    }
    @Test
    void addMember() {

        assertEquals ( 0 , store.size()  );

        try {
            store.addMember( r1 );
            store.addMember( r2 );
            store.addMember( r3 );
            store.addMember( r4 );

        } catch (ContainerException e) {
            e.printStackTrace();
        }
        assertEquals ( 4 , store.size() );

    }

    @Test
    void StoreLoadTest(){
        try {
            store.load();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        assertEquals(0,store.size());

        try {
            store.addMember(r1);
            store.addMember(r2);
            store.addMember(r3);
            store.store();
            store.addMember(r4);
            assertEquals(4,store.size());
            store.load();
            assertEquals(3,store.size());
            /**
             * r4 wurde geaddet, aber nicht mit store() gespeichert
             * also nach load werden nur r1,r2,r3 in der liste sein
             */
            store.deleteMember(r1.getID());
            store.deleteMember(r2.getID());
            store.deleteMember(r3.getID());
            assertEquals(0,store.size());
            store.load();
            assertEquals(3,store.size());
            /**
             * 3 Members wurden im vorherigen Schritt persistent gespeichert.
             * Nach dem deleteMember() wurde neue leere Liste nicht mit store() gespeichert
             * also man kann die alte Liste wiederstellen.
             */
            store.deleteAll();
            store.store();
            store.load();
            assertEquals(0,store.size());


        } catch (ContainerException | PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void ClientTest() {
        assertEquals(0,store.size());
        Client client=new Client();
        try {
            client.addMembers(store);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        assertEquals(3,store.size());
    }

    @Test
    void memberViewTest() throws ContainerException {
        MemberView mv=new MemberView();
        store.addMember(r1);
        mv.dump(store.getCurrentList());
        store.addMember(r2);
        mv.dump(store.getCurrentList());

    }
    @Test
    void deleteTest(){
        try {
            store.addMember(r1);
            store.addMember(r2);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        assertEquals(2, store.size());
        assertEquals(r2.toString(), store.deleteMember(r2.getID()));
        assertEquals(1, store.size());
        assertEquals(r1.toString(), store.deleteMember(r1.getID()));
        assertEquals(0, store.size());
        assertEquals("Mit dieser ID(" + r3.getID() + ")wurde kein Member angespeichert", store.deleteMember(r3.getID()));
    }
}

