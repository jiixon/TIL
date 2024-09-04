public class Mocha extends  CondimentDecorator{
    //Mocha 인스턴스에는 Beverage의 레퍼런스가 들어 있음
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
        //1)감싸고자 하는 음료를 저장하는 인스턴스 변수
        //2)인스턴스 변수를 감싸고자 하는 객체로 설정한느 생성자(데코레이터의 생성자에 감싸고자 하는 음료 객체를 전달하는 방식을 사용
    }

    @Override
    public String getDescription() {
        //설명에 "음료 이름 + 첨가 아이템 이름"(예: 다크 로스트, 모카)로 표기되어야 하기에 더한 값 리턴
        return beverage.getDescription() + ", 모카";
    }

    @Override
    public double cost() {
        //마찬가지로 음료 가격에 첨가물 가격 더하여 리턴
        return beverage.cost() + 0.20;
    }
}
