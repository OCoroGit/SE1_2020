package org.hbrs.se.ws20.uebung1.control;

public class Factory {
    public static GermanTranslator createGermanTranslator(){
        return new GermanTranslator();
    }
}
