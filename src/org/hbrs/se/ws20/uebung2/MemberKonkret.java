package org.hbrs.se.ws20.uebung2;

import java.io.Serializable;

public class MemberKonkret implements Member, Serializable {
    private Integer id;
    public MemberKonkret(Integer id){
        this.id=id;
    }
    @Override
    public Integer getID() {
        return this.id;
    }
    public void setID ( Integer id ) {
        this.id = id;
    }

    public String toString() {
        return "Member (ID = " + id + ")";
    }
}
