package patterns.observer;

import java.util.ArrayList;

public class Subject {
    private ArrayList<Observer> observers;
    private String name;
    private float price;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers("nume");
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
        notifyObservers("price");
    }

    public void notifyObservers(String type) {
        for (Observer o : observers) {
            o.update(type);
        }
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }
}
