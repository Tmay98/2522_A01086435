package ca.bcit.comp2522.assignments.a1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GuppyAgeComparator implements Comparator<Guppy> {
    @Override
    public int compare(Guppy o1, Guppy o2) {
        if (o1.getAgeInWeeks() < o2.getAgeInWeeks()) {
            return -1;
        } else if (o1.getAgeInWeeks() > o2.getAgeInWeeks()) {
            return 1;
        } else {
            return 0;
        }
    }
}