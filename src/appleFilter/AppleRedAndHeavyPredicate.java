package appleFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static appleFilter.Color.GREEN;
import static appleFilter.Color.RED;

public class AppleRedAndHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return RED.equals(apple.getColor()) && apple.getWeight() > 150;
    }

}


