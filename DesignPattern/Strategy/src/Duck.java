public abstract class Duck {

    //같은 패키지에 속하는 모든 서브 클래스에서 이 변수를 상속
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly(); //행동 클래스에 위임
    }

    public void performQuack() {
        quackBehavior.quack(); //행동 클래스에 위임
    }

    public void swim() {
        System.out.println("모든 오리는 물에 뜹니다. 가짜 오리도 뜨죠");
    }

    //아래의 두 메서드로 언제든지 오리 행동을 바꿀 수 있음
    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }
    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

}
