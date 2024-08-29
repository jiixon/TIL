public class CurrentConditionsDisplay implements Observer, DisplayElement {
    //Observer: Weather 객체로부터 변경 사항을 받으려면 구현
    //Displayment: 모든 디스플레이  항목에서 구현해야함
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    //생성자 - WeatherData 주제가 전달되며 그 객체를 써서 디스플레이에 옵저버로 등록
    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) { //update()가 호출되면 온도와 습도를 저장하고 display()를 호출
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() { //가장 최근에 받은 온도와 습도 출력
        System.out.println("현재 상태: 온도 " + temperature + "F, 습도 " + humidity + "%");
    }
}
