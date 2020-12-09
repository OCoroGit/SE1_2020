package org.hbrs.se.ws20.uebung4.view;

import org.hbrs.se.ws20.uebung4.model.Container;
import org.hbrs.se.ws20.uebung4.model.UserStory;

import java.util.List;

public class TableUS {
   public void printTable(List<UserStory> liste){

       System.out.format( "%15s %15s %15s %15s %15s %15s%15s", "ID","Titel","Aufwand","Mehrwert","Risiko ","Strafe","Prio");
       System.out.println();
       for(UserStory userStory: liste){
            System.out.format("%15s %15s %15s %15s %15s %15s%15s",""+userStory.getId(), ""+userStory.getTitel(),""+userStory.getAufwand(),""+ userStory.getMehrwert(),""+ userStory.getRisk(),""+ userStory.getStrafe(),""+ userStory.getPrio());
            System.out.println();
        }
   }
}
