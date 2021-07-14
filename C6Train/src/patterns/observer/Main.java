package patterns.observer;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer1 observer = new Observer1(subject);
        Observer2 o2 = new Observer2(subject);

        subject.setName("holograf");
        subject.setPrice(10.5f);
        subject.setName("holograf+altii");
    }
}
