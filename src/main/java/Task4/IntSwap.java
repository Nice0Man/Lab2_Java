package Task4;


public class IntSwap {
    //при передаче в метод int, будет изменяться локальная копия
    public static void swapInteger(Integer a, Integer b){
        Integer c = a;
        a = b;
        b = c;
        System.out.println(STR."Param 'a' in method \{a}");
        System.out.println(STR."Param 'b' in method \{b}");
    }

    //Integer - неизменяемый класс
    public static void main(String[] args) {
        Integer a = 5;
        Integer b = 7;
        swapInteger(a,b);
        System.out.println(STR."Param 'a' in main \{a}");
        System.out.println(STR."Param 'b' in main \{b}");
    }
}
