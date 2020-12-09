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
        TableUS tus=new TableUS();
        tus.printTable(ll);
    }
    public void dumpAufwand(int n){
        TableUS tus=new TableUS();
        Container container = Container.getInstance();
        List<UserStory> liste=container.getCurrentList();
        List<UserStory> ll= new LinkedList<UserStory>();
        for(UserStory us:liste){
            if(us.getAufwand()>=n){
                ll.add(us);
            }
        }
        Collections.sort(ll, new ComparatorPrio());
        tus.printTable(ll);
    }

}
