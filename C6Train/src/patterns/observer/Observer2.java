package patterns.observer;

public class Observer2 implements Observer {
    private Subject subject;

    public Observer2(Subject s) {
        this.subject = s;
        this.subject.addObserver(this);
    }

    public void update(String type) {
        if (type.equalsIgnoreCase("price")) {
            System.out.println("subject state from o2: " + this.subject.getPrice());
        }
    }
}
