public class Decaf extends Beverage {

    //생성자
    public Decaf() {
        description = "디카페인"; //생성자에서 description 변수값을 설정
    }

    @Override
    public double cost() {
        return 1.05; //디카페인 가격 리턴
    }
}
