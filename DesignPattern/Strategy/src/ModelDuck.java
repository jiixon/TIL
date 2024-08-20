public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay(); //날지 못하는 오리
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("저는 모형 오리입니다.");
    }
}
