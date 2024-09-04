public class HouseBlend extends Beverage {

    //생성자
    public HouseBlend() {
        description = "하우스 블렌드 커피"; //생성자에서 description 변수값을 설정
    }

    @Override
    public double cost() {
        return .89; //하우스 블렌드 커피 가격 리턴
    }
}
