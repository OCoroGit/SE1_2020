package org.hbrs.se.ws20.uebung4.view;

import org.hbrs.se.ws20.uebung4.model.UserStory;

public class TableUS {
   public void printTable(UserStory userStory){
       System.out.format( "%10d %30s %20d %20d %20d %20d%20d", userStory.getId(), userStory.getTitel(),userStory.getMehrwert(),userStory.getRisk(),userStory.getStrafe(),userStory.getPrio());
       System.out.println();
   }
}
