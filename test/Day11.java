package test;

import java.util.*;

public class Day11 {

    public static void main(String[] args) {
      Set<Integer> s = new HashSet<>();
      s.add(1);
      s.add(3);
      s.add(2);

      List<Integer> list = new LinkedList();
        for (int i = 4; i <9 ; i++) {
            list.add(i);
        }
        for (Integer value:s) {
            System.out.println(value+"set ");
        }

        for (Integer value:list) {
            System.out.println(value+"list ");
        }


        Iterator<Integer> iterator = s.iterator();
        while (iterator.hasNext()){
            int a = iterator.next();
            System.out.println("set"+a);
        }

        Iterator<Integer> iterators = list.iterator();
        while (iterators.hasNext()){
            int b = iterators.next();
            System.out.println("list"+b);
        }


        ListIterator<Integer>  l = list.listIterator();
        while (l.hasNext())
        {
            int c = l.next();
            System.out.println("fghjmk"+c);

        }
        System.out.println(l.nextIndex()+"sss"+l.previous()+"sasa"+l.previousIndex());
        l.add(1);

    }
}
