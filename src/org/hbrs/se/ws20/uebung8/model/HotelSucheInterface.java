package org.hbrs.se.ws20.uebung8.model;

import org.hbrs.se.ws20.uebung8.view.SuchAuftrag;
import org.hbrs.se.ws20.uebung8.view.SuchErgebnis;

public interface HotelSucheInterface {
    SuchErgebnis suche(SuchAuftrag sa);
}
