package Comparator_;

import appleFilter.Apple;
import appleFilter.Color;

import java.util.ArrayList;
import java.util.List;

public class Test3{
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<Apple>();
        list.add(new Apple(Color.RED, 150));
        list.add(new Apple(Color.GREEN, 130));
        list.add(new Apple(Color.RED, 70));
        list.add(new Apple(Color.GREEN, 200));

        /*
        compareTo오류 확인할 것
        list.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());

            }
        });

        //람다
        list.sort((Apple a1, Apple a2)->a1.getWeight().compareTo(a2.getWeight()));
         */
    }

}
