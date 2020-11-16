package org.hbrs.se.ws20.uebung1.test;
import org.hbrs.se.ws20.uebung1.control.GermanTranslator;
import org.hbrs.se.ws20.uebung1.view.Client;

public class Test {
    private static String test1(int n){
       GermanTranslator tr=new GermanTranslator();
       return tr.translateNumber(n);
    }
    private static void test2(int n){
        Client c1=new Client();
        c1.display(n);
    }

    public static void main(String[] args){
        System.out.println("GermanTranslator Test\n");
        System.out.println("Input: -3; SollOutput:\"Übersetzung der Zahl -3 nicht möglich (1.0)\";\n IstOtput:"+test1(-3));
        System.out.println("Input: 15; SollOutput:\"Übersetzung der Zahl 15 nicht möglich (1.0)\";\n IstOtput:"+test1(15));
        System.out.println("Input: 0; SollOutput:\"Übersetzung der Zahl 0 nicht möglich (1.0)\";\n IstOtput:"+test1(0));
        System.out.println("Input: 7; SollOutput:\"sieben\";\n IstOtput:"+test1(7));
        System.out.println();
        System.out.println("Client Test\n");
        System.out.print("Input: -3; SollOutput:\"Das Ergebnis der Berechnung: Übersetzung der Zahl -3 nicht möglich (1.0)\";\n IstOtput:");
        test2(-3);
        System.out.print("Input: 15; SollOutput:\"Das Ergebnis der Berechnung: Übersetzung der Zahl 15 nicht möglich (1.0)\";\n IstOtput:");
        test2(15);
        System.out.print("Input: 0; SollOutput:\"Das Ergebnis der Berechnung: Übersetzung der Zahl 0 nicht möglich (1.0)\";\n IstOtput:");
        test2(0);
        System.out.print("Input: 7; SollOutput:\"Das Ergebnis der Berechnung:sieben\";\n IstOtput:");
        test2(7);




    }
}
