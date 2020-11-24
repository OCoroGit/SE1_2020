package org.hbrs.se.ws20.uebung3.view;


import org.hbrs.se.ws20.uebung2.Member;
import org.hbrs.se.ws20.uebung3.*;

import java.util.List;

public class MemberView {
    public void dump(List<Member> liste){
        for(Member member: liste)
        System.out.println(member.toString());
    }
}
