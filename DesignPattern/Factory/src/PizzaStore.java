public abstract class PizzaStore {

    abstract Pizza createPizza(String item); //

    public Pizza orderPizza(String type) {
        Pizza pizza;

        //orderPizza() 메소드는 팩토리로 피자 객체를 만든다(주문 받을 형식 전달만 하기)
        //new 연산자 대신 팩토리 객체에 있는 create 메소드를 써서 더이상 구상 클래스의 인스턴스를 만들 필요가 없음
        //pizza = factory.createPizza(type);
        pizza = createPizza(type); //팩토리 객체가 아닌 PizzaStore에 있는 createPizza를 호출

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }


}
