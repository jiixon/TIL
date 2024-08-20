public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack(); //MallardDuck에서 상속받은 performQuack() 메서드 호출 -> quackBehavior 레퍼런스의 quack() 메서드 호출
        mallard.performFly();

        //출력
        /* 꽥
        * 날고 있어요!!
        */

        Duck model = new ModelDuck();
        model.performFly(); //ModelDuck()의 flyBehavior, 즉 FlyNoWay 인스턴스의 fly() 메서드가 호출(== 저는 못 날아요.)
        model.setFlyBehavior(new FlyRocketPowered()); //상속받은 행동 세터 메소드가 호출 -> 로켓 추진력으로 날게 된 오리
        model.performFly(); //구현 코드가 Duck클래스안에 있으면 불가능했음

        //출력
        /* 저는 못 날아요.
        * 로켓 추진으로 날아갑니다.
        * */
    }
}
