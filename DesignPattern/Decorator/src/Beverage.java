public abstract class Beverage {
    //추상클래스 - getDescription(), cost() 메소드
    //getDescription()는 이미 구현되어있음. cost()는 서브클래스에서 구현해야함.
    String description = "제목 없음";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}