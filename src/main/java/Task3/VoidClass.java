package Task3;

public class VoidClass {
    private int param;


    // returns link on class
    VoidClass setParam(int param){
        this.param = param;
        return this;
    }

    boolean compareWith10(){
        return param == 10;
    }

    public static void main(String[] args) {
        VoidClass instance = new VoidClass();
        System.out.println(instance.setParam(10).compareWith10());
        System.out.println(instance.setParam(10).setParam(5).compareWith10());
//        ArrayList<String> list = new ArrayList<>();
//        boolean c = list.add("str");
//        System.out.println(c);
    }
}
