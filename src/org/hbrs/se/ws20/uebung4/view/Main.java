package org.hbrs.se.ws20.uebung4.view;

import org.hbrs.se.ws20.uebung4.model.Container;

public class Main {
    public static void main (String[] args) throws Exception  {
        Container con = Container.getInstance();
        con.startEingabe();
    }
}
