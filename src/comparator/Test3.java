package comparator;

import appleFilter.Apple;
import appleFilter.Color;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test3{
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<Apple>();
        list.add(new Apple(Color.RED, 150));
        list.add(new Apple(Color.GREEN, 130));
        list.add(new Apple(Color.RED, 70));
        list.add(new Apple(Color.GREEN, 200));


        Comparator<Apple> byWeight = new Comparator<Apple>() {
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o1.getWeight());
            }
        };
        //람다
        Comparator<Apple> byWeight1 = (Apple a1, Apple a2)-> a1.getWeight().compareTo(a2.getWeight());


        list.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        list.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));


    }



}
