import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    //인스턴스 변수 선언
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    //Observer 객체들을 저장하는 ArrayList 추가 후 생성자가 그 객체를 생성
    public WeatherData() {
        observers = new ArrayList<>();
    }

    //Subject 인터페이스 오버라이드 구현 부분
    @Override
    public void registerObserver(Observer o) {
        observers.add(o); //옵저버가 등록 요청시, 목록 맨 뒤 추가
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o); //옵저버가 탈퇴 요청시, 목록에서 빼기
    }

    //옵저버에게 상태 변화를 알려주는 메서드
    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers(); //기상 스테이션으로부터 갱신된 측정값을 받으면 옵저버에게 알림
    }
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }


}
