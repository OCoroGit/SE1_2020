package org.hbrs.se.ws20.uebung2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container c1;
    Member m1= ()->(123);
    Member m2= ()->(456);
    Member m3= ()->(789);

    @BeforeEach
    void setUp(){
        c1=new Container();
    }
    @AfterEach
    void tearDown(){
        c1=null;
    }
    @Test
    void newContainerTest(){
        Container cont= new Container();
        assertEquals(0,cont.size());
    }
    @Test
    void AddTest() throws ContainerException {
        assertEquals(0,c1.size());
        c1.addMember(m1);
        assertEquals(1, c1.size());
        c1.addMember(m2);
        assertEquals(2, c1.size());
        c1.addMember(m3);

        assertEquals(3, c1.size());
        assertThrows(ContainerException.class,()->c1.addMember(m1));

    }
    @Test
    void deleteTest() throws ContainerException {
        c1.addMember(m1);
        c1.addMember(m2);
        assertEquals(2, c1.size());
        assertEquals(m2.toString(), c1.deleteMember(m2.getID()));
        assertEquals(1, c1.size());
        assertEquals(m1.toString(), c1.deleteMember(m1.getID()));
        assertEquals(0, c1.size());
        assertEquals("Mit dieser ID(" + m3.getID() + ")wurde kein Member angespeichert", c1.deleteMember(m3.getID()));
    }
}