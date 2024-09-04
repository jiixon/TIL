public class Espresso extends Beverage {

    //생성자
    public Espresso() {
        description = "에스프레소"; //생성자에서 description 변수값을 설정
    }

    //반드시 오버라이드해야함 확장했기 때문
    @Override
    public double cost() {
        return 1.99; //에스프레소 가격 리턴
    }
}
