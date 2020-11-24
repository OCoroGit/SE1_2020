package org.hbrs.se.ws20.uebung3.view;

import org.hbrs.se.ws20.uebung2.ContainerException;
import org.hbrs.se.ws20.uebung2.Member;
import org.hbrs.se.ws20.uebung2.MemberKonkret;
import org.hbrs.se.ws20.uebung3.control.Container;

public class Client {

    public void addMembers(Container c) throws ContainerException {
        MemberKonkret m1= new MemberKonkret(123);
        MemberKonkret m2= new MemberKonkret(456);
        MemberKonkret m3= new MemberKonkret(789);
        c.addMember(m1);
        c.addMember(m2);
        c.addMember(m3);
    }

}
