package org.hbrs.se.ws20.uebung3.control;
import org.hbrs.se.ws20.uebung2.ContainerException;
import org.hbrs.se.ws20.uebung2.Member;
import org.hbrs.se.ws20.uebung3.persistence.PersistenceException;
import org.hbrs.se.ws20.uebung3.persistence.PersistenceStrategyStream;

import java.io.*;
import java.util.LinkedList;

public class Container implements Serializable{

    private static Container firstInstance=null;

    private LinkedList<Member> liste;

    private Container(){
    this.liste= new LinkedList<>();
    }

    public static synchronized Container getInstance() {
        if (firstInstance == null) {
            firstInstance = new Container();
            System.out.println("Objekt vom Typ Container wurde instanziiert!");
        }
        return firstInstance;
    }

    public void store()throws PersistenceException {
        try {
            PersistenceStrategyStream<Member> pss= new PersistenceStrategyStream<>();
            pss.save(liste);
        }catch(PersistenceException pe){
            pe.getStackTrace();
        }
    }

    public void load()throws PersistenceException  {
        try {
            PersistenceStrategyStream<Member> pss= new PersistenceStrategyStream<>();
            liste=(LinkedList)pss.load();
        }catch(PersistenceException pe){
            pe.getStackTrace();
        }
    }

    public int size(){
        return liste.size();
    }

    public void addMember(Member member) throws ContainerException {
        if(liste.contains(member)){
            ContainerException ex = new ContainerException();
            ex.addID ( member.getID() );
            throw ex;
        }
        liste.add(member);
    }

    public String deleteMember(Integer id) {
        Member rec = getMember( id );
        if (rec == null)
            return "Mit dieser ID(" + id +")wurde kein Member angespeichert";
        else {
            liste.remove(rec);
            return rec.toString();
        }
        /*
         Als String zuruekgegebene Fehlermeldung macht die Behandlung
         von Ausnahmen odere weitere Funktionsweise des Programms schwerer.
         Exceptions sind in diesem Fall besser.
        */
    }

    private Member getMember(Integer id) {
        for ( Member rec : liste) {
            if (id == rec.getID().intValue() ){
                return rec;
            }
        }
        return null;
    }
    public void deleteAll(){
        while(liste.iterator().hasNext()){
            liste.removeFirst();
        }
    }
    public LinkedList<Member> getCurrentList(){
        return this.liste;
    }
}
