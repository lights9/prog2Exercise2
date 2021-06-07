package trafficlight.observer;

import java.util.ArrayList;

//concreteSubject is State
public abstract class Subject {

    private ArrayList<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer newObserver) {
        this.observerList.add(newObserver);
    }

    public void removeObserver(Observer newObserver) {

        this.observerList.remove(newObserver);
    }
    public void notifyObserver(){
        for (Observer newObserver : this.observerList){
            newObserver.update();
        }
    }
}



