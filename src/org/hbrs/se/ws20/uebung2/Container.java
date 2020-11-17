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
        if (liste.contains(member)){
            throw new ContainerException("Das Member-Objekt mit der ID "+member.getID()+"ist bereits vorhanden!");
        }
        liste.add(member);
    }
    public String deleteMember(Integer id){
        for(int i=0;i<liste.size();i++) {
            if(liste.get(i).getID().equals(id))
                return liste.remove(i).toString();
        }
        return "Mit dieser ID(" + id + ")wurde kein Member angespeichert";
        /*
         Als String zuruekgegebene Fehlermeldung macht die Behandlung
         von Ausnahmen odere weitere Funktionsweise des Programms schwerer.
         Exceptions sind in diesem Fall besser.
        */
    }
    public void dump(){
        Container clone=new Container();
        clone.liste=this.liste;
        while(clone.size()!=0) {
            System.out.println(clone.toString());
            clone.liste.removeFirst();
        }
    }
    @Override
    public String toString() {
            return "Member (ID = " + liste.getFirst().getID() + ")";
    }
}
