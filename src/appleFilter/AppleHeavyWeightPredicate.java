package appleFilter;

public class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {//무거운 사과만 선택
        return apple.getWeight() > 150;
    }
}
