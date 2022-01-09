package appleFilter;

import static appleFilter.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {//녹색 사과만 선택

        return GREEN.equals(apple.getColor());
    }
}
