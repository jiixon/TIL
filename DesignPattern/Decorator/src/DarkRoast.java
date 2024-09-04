public class DarkRoast extends Beverage {

    //생성자
    public DarkRoast() {
        description = "다크 로스트 커피"; //생성자에서 description 변수값을 설정
    }

    @Override
    public double cost() {
        return .99; //다크 로스트 커피 가격 리턴
    }
}
