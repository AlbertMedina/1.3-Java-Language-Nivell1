package Level1Ex1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        // arraylist of months
        ArrayList<Month> months = new ArrayList<>();
        months.add(new Month("January"));
        months.add(new Month("February"));
        months.add(new Month("March"));
        months.add(new Month("April"));
        months.add(new Month("May"));
        months.add(new Month("June"));
        months.add(new Month("July"));
        months.add(new Month("September"));
        months.add(new Month("October"));
        months.add(new Month("November"));
        months.add(new Month("December"));

        // adding august at proper position
        months.add(7, new Month("August"));

        // showing months arraylist
        for (Month m : months) {
            System.out.println(m.getName());
        }

        System.out.println();

        // hashset of months
        HashSet<Month> monthsSet = new HashSet<>(months);
        monthsSet.add(new Month("January"));
        for (Month m : monthsSet) {
            System.out.println(m.getName());
        }

        System.out.println();

        // showing the months with a for loop
        for (int i = 0; i < months.size(); ++i) {
            System.out.println(months.get(i).getName());
        }

        System.out.println();

        // showing the months with an iterator
        Iterator<Month> iterator = months.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }
}
