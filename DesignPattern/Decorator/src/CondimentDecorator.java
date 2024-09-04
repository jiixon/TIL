public abstract class CondimentDecorator extends Beverage {
    Beverage beverage; //데코레이터가 감쌀 음료를 나타내는 Beverage 객체를 여기서 지정
    public abstract String getDescription(); //모든 첨가물 데코레이터에 getDescription()메소드 새로 구현해서 만들 예정
}
