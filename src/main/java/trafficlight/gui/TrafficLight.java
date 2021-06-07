package trafficlight.gui;


import trafficlight.observer.Observer;

import java.awt.*;

//TrafficLight is the concrete Observer
public class TrafficLight extends Light implements Observer {

    public TrafficLight(Color color) {
        super(color);
    }

    public void turnOn(boolean a) {
        isOn = a;
        repaint();
    }

    public boolean isOn() {
        return isOn;
    }


    //method implemented from our Observer
    @Override
    public void update() {

        if (!isOn) {
            turnOn(true);
        } else {
            turnOn(false);
        }

    }

}


    //TODO implement a part of the pattern here

