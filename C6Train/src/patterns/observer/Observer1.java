package patterns.observer;

public class Observer1 implements Observer {
    private Subject subject;

    public Observer1(Subject s) {
        this.subject = s;
        this.subject.addObserver(this);
    }

    public void update(String type) {
        if (type.equalsIgnoreCase("nume")) {
            System.out.println("subject state from o1: " + this.subject.getName());
        }
    }
}
