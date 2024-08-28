public interface Observer {
    //모든 Observer 클래스에서 구현해야함 == 모든 옵저버는 update() 메소드 구현해야함
    public void update(float temp, float humidity, float pressure);
}
