package test;

import java.util.Set;
import java.util.TreeSet;

public class Day12 {
    public static void main(String[] args) {
        Set s = new TreeSet();
        s.add(40);
        s.add(13);
        s.add(18);
        s.add(100);

        for (Object value:s) {
            System.out.println(s+"");
        }

    }
}
