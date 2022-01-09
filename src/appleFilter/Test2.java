package appleFilter;

import java.util.ArrayList;
import java.util.List;

import static appleFilter.Color.GREEN;
import static appleFilter.Color.RED;

public class Test2 {
    //1. 첫번째 시도 : 녹색 사과 필터링
    public static List<Apple> filterGreenApples(List<Apple>inventory){
        List<Apple> result = new ArrayList<>();//사과 누적 리스트
        for(Apple apple : inventory){
            if(GREEN.equals(apple.getColor())){//녹색 사과만 선택
                result.add(apple);
            }
        }
        return result;
    }

    //2. 두번째 시도 : 색을 파라미터화
    public static List<Apple> fileterAppleByColor(List<Apple>inventory, Color color){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(apple.getColor().equals(color)){
                result.add(apple);
            }
        }
        return result;
    }

    //2. 두번째 시도 : 무게를 파라미터화
    public static List<Apple> filterAppleByWeight(List<Apple>inventory, int weight){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(apple.getWeight() > weight){
                result.add(apple);
            }
        }
        return result;
    }
    //3. 세번째 시도 : 가능한 모든 속성으로 필터링(만류)
    public static List<Apple> filterApplesAll(List<Apple>inventory, Color color, int weight, boolean flag){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if((flag && apple.getColor().equals(color))||(!flag && apple.getWeight() > weight)){
                result.add(apple);
            }
        }
        return result;
    }
    //4. 네번째 시도 : 추상적 조건으로 필터링
    public static List<Apple> filterApples(List<Apple>inventory, ApplePredicate p){
        List<Apple>result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    //7. 일곱번째 시도 : 리스트 형식으로 추상화
    public static <T> List<T> filter(List<T> list, Predicate<T>p){
        List<T> result = new ArrayList<>();
        for(T t : list){
            if(p.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple(GREEN, 100));
        list.add(new Apple(Color.RED, 200));
        list.add(new Apple(Color.RED, 140));
        list.add(new Apple(Color.RED, 160));

        //1. 첫번째 시도 : 녹색 사과 필터링 - 구현부
        List<Apple> results1 = filterGreenApples(list);
        for(Apple a : results1) {
            System.out.println("초록 사과 = " + a.getColor() + " " + a.getWeight());
        }
        System.out.println("---------------------------------------");

        //2. 두번째 시도 : 색을 파라미터화 - 구현부
        List<Apple> greenApples = fileterAppleByColor(list, GREEN);
        for(Apple green : greenApples ){
            System.out.println(green.getColor());
        }
        System.out.println("---------------------------------------");
        List<Apple> redApples = fileterAppleByColor(list, RED);
        for(Apple red : redApples ){
            System.out.println(red.getColor());
        }
        System.out.println("---------------------------------------");

        //2. 두번째 시도 : 무게를 파라미터화 - 구현부
        List<Apple> weightAppels = filterAppleByWeight(list, 150);
        for(Apple weight : weightAppels){
            System.out.println(weight.getWeight());
        }

        System.out.println("---------------------------------------");
        //3. 세번째 시도 : 가능한 모든 속성으로 필터링(만류)
        List<Apple> greenApplesAll = filterApplesAll(list, GREEN, 0, true);
        for(Apple all : greenApplesAll){
            System.out.println(all.getWeight()+" "+ all.getColor());
        }
        System.out.println("---------------------------------------");
        List<Apple> redApplesAll = filterApplesAll(list, null, 150, false);
        for(Apple all : redApplesAll){
            System.out.println(all.getWeight()+" "+ all.getColor());
        }
        //4. 네번째 시도 : 추상적 조건으로 필터링
        System.out.println("---------------------------------------");
        List<Apple> results = filterApples(list, new AppleRedAndHeavyPredicate());
        for(Apple a : results) {
            System.out.println("무게:150, 색:빨강 = " + a.getColor() + " " + a.getWeight());
        }

        System.out.println("---------------------------------------");
        //익명클래스 활용
        List<Apple> redApples_ = filterApples(list, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });
        for(Apple a : redApples_){
            System.out.println(a.getColor()+" " +a.getWeight());
        }

        System.out.println("---------------------------------------");
        //람다표현식
        List<Apple> result = filterApples(list, (Apple apple) -> RED.equals(apple.getColor()));
        for(Apple a : result){
            System.out.println(a.getColor()+" " +a.getWeight());
        }

        System.out.println("---------------------------------------");
        //7. 일곱번째 시도 : 리스트 형식으로 추상화 구현부
        List<Apple> redApples___ = filter(list, (Apple apple) ->GREEN.equals(apple.getColor()));
        for(Apple a : redApples___){
            System.out.println(a.getColor()+" " +a.getWeight());
        }

        System.out.println("---------------------------------------");
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i<11; i++){
            numbers.add(i);
        }

        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i%2 ==0 );
        for(int i : evenNumbers){
            System.out.println(i);
        }
    }
}
