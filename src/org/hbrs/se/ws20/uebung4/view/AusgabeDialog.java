package org.hbrs.se.ws20.uebung4.view;

import org.hbrs.se.ws20.uebung4.model.Container;
import org.hbrs.se.ws20.uebung4.model.UserStory;
import org.hbrs.se.ws20.uebung4.utils.ComparatorPrio;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AusgabeDialog {

    public void dump(){
        Container container = Container.getInstance();
        List<UserStory> ll=container.getCurrentList();
        Collections.sort(ll, new ComparatorPrio());
        System.out.println("ID  "+"Titel    "+"Aufwand  "+"Mehrwert "+"Risiko   "+"Strafe   "+"Prio ");
        for (UserStory us:ll) {
            System.out.format(us.toString());
        }
    }
    public void dumpAufwand(int n){
        TableUS tus=new TableUS();
        Container container = Container.getInstance();
        List<UserStory> liste=container.getCurrentList();
        System.out.format( "%10s %30s %20s %20s %20s %20s%20s", "ID","Titel","Aufwand","Mehrwert","Risiko ","Strafe","Prio");
        liste.stream().filter( userStory -> userStory.getAufwand() >n )   // Filter
                .sorted( new ComparatorPrio() ) // MAP
                .forEach( userStory -> tus.printTable(userStory));
    }

}
