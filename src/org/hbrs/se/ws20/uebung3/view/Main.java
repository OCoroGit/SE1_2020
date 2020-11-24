package org.hbrs.se.ws20.uebung3.view;

import org.hbrs.se.ws20.uebung2.ContainerException;
import org.hbrs.se.ws20.uebung2.MemberKonkret;
import org.hbrs.se.ws20.uebung3.control.Container;
import org.hbrs.se.ws20.uebung3.persistence.PersistenceException;

public class Main {
    public static void main(String[] args){
        Container container=Container.getInstance();
        Client client=new Client();
        MemberView m=new MemberView();
        try {
            client.addMembers(container);
            container.store();
            container.load();
            m.dump(container.getCurrentList());
        } catch (ContainerException e) {
            e.printStackTrace();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }
}
