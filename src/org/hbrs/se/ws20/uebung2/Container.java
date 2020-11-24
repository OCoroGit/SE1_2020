package org.hbrs.se.ws20.uebung2;
import java.util.*;
public class Container {
    private LinkedList<Member> liste;

    public Container(){
    this.liste= new LinkedList<>();
    }
    public int size(){
        return liste.size();
    }
    public void addMember(Member member) throws ContainerException{
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
            return "Mit dieser ID(" + id + ")wurde kein Member angespeichert"; else {
            liste.remove(rec);
            return rec.toString();
        }
        /*
         Als String zuruekgegebene Fehlermeldung macht die Behandlung
         von Ausnahmen odere weitere Funktionsweise des Programms schwerer.
         Exceptions sind in diesem Fall besser.
        */
    }
    public void dump(){
        for(Member m :liste){
           System.out.println(m.toString());
        }
    }
    private Member getMember(Integer id) {
        for ( Member rec : liste) {
            if (id == rec.getID().intValue() ){
                return rec;
            }
        }
        return null;
    }
}
