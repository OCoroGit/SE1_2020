package org.hbrs.se.ws20.uebung8.view;

import org.hbrs.se.ws20.uebung8.model.HotelSucheInterface;
import org.hbrs.se.ws20.uebung8.control.ReiseAnbieterAdapter;

public class HotelSuche {
    HotelSucheInterface adapter= new ReiseAnbieterAdapter();

    public SuchErgebnis hotelSuche(SuchAuftrag sa){
    SuchErgebnis mySE= adapter.suche(sa);
    return mySE;
    }
}
