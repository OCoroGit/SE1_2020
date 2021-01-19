package org.hbrs.se.ws20.uebung8.model;

import org.hbrs.se.ws20.uebung8.view.QueryObject;
import org.hbrs.se.ws20.uebung8.view.QueryResult;

public interface ReiseAnbieter {
    QueryResult executeQuery(QueryObject s);
}
