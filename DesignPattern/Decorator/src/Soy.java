public class Soy extends  CondimentDecorator{
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        //설명에 "음료 이름 + 첨가 아이템 이름"(예: 다크 로스트, 모카)로 표기되어야 하기에 더한 값 리턴
        return beverage.getDescription() + ", 두유";
    }

    @Override
    public double cost() {
        //마찬가지로 음료 가격에 첨가물 가격 더하여 리턴
        return beverage.cost() + 0.15;
    }
}
