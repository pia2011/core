package study.spring.core.singleton;

public class StatefulService {

//    private int price; // 상태유지 필드 : stateful

    public int order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
//        this.price = price;
        return price;
    }

//    public int getPrice(){
//        return price;
//    }

}
