package Level1Ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        // creating two lists
        List<Integer> firstList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        List<Integer> secondList = new ArrayList<>();

        // using the iterator to iterate the first list in reverse order and fill the second list
        ListIterator<Integer> iterator = firstList.listIterator(firstList.size());
        while (iterator.hasPrevious()) {
            secondList.add(iterator.previous());
        }

        // show the lists
        System.out.println(firstList);
        System.out.println(secondList);
    }
}
