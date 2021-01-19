package org.hbrs.se.ws20.uebung8.control;

import org.hbrs.se.ws20.uebung8.model.ReiseAnbieter;
import org.hbrs.se.ws20.uebung8.model.ReiseAnbieterExact;
import org.hbrs.se.ws20.uebung8.model.HotelSucheInterface;
import org.hbrs.se.ws20.uebung8.view.QueryObject;
import org.hbrs.se.ws20.uebung8.view.QueryResult;
import org.hbrs.se.ws20.uebung8.view.SuchAuftrag;
import org.hbrs.se.ws20.uebung8.view.SuchErgebnis;

public class ReiseAnbieterAdapter implements HotelSucheInterface {
    ReiseAnbieter ras= new ReiseAnbieterExact();

 public SuchErgebnis suche(SuchAuftrag sa){
     QueryObject qo=transformInput(sa);
     QueryResult qr= ras.executeQuery(qo);
     SuchErgebnis se=transformAusgabe(qr);
     return se;
 }
private QueryObject transformInput(SuchAuftrag sa){
     QueryObject queryObject=null;
    return queryObject;
}
private SuchErgebnis transformAusgabe(QueryResult qr){
     SuchErgebnis suchErgebnis=null;
    return suchErgebnis;
}

}
