
public interface Subject {
    //각 옵저버를 등록/제거하는 역할
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    //주제의 상태가 변경되었을 떄, 모든 옵저버에게 변경 내용을 알리려고 호출하는 메소드
    public void notifyObservers();
}
