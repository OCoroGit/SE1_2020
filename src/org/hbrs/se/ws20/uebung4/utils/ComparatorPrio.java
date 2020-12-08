package org.hbrs.se.ws20.uebung4.utils;

import org.hbrs.se.ws20.uebung4.model.UserStory;

import java.util.Comparator;

public class ComparatorPrio implements Comparator<UserStory> {

    @Override
    public int compare(UserStory u1, UserStory u2) {
        return u1.compareTo(u2);
    }
}
