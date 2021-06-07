
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trafficlight.ctrl.TrafficLightCtrl;
import trafficlight.gui.TrafficLight;


import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


public class Tests {

    @Test
    @DisplayName("Check if Singleton instance equals object")
    public void checkSingleton() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        assertEquals(trafficLight,TrafficLightCtrl.getController());
    }


    @Test
    @DisplayName("Check if light changes to green")
    public void checkGreen() {
        TrafficLight green = new TrafficLight(Color.green);
        assertFalse(green.isOn());
    }


    @Test
    @DisplayName("Check if light changes to yellow")
    public void checkYellow() {
        TrafficLight yellow = new TrafficLight(Color.yellow);
        assertFalse(yellow.isOn());
    }

    @Test
    @DisplayName("Check if light changes to red")
    public void checkRed() {
        TrafficLight red = new TrafficLight(Color.red);
        assertFalse(red.isOn());
    }


    @Test
    @DisplayName("Light goes from green to yellow? NO")
    public void checkGreenToYellow() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.setStates(trafficLight.getGreenState(),trafficLight.getYellowState());
        assertNotEquals(trafficLight.getCurrentState().getNextState(),trafficLight.getRedState());
    }

    @Test
    @DisplayName("Light goes from green to yellow? NO")
    public void checkGreenToYellow2() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.setStates(trafficLight.getGreenState(),trafficLight.getYellowState());
        assertNotEquals(trafficLight.getCurrentState().getNextState(),trafficLight.getGreenState());
    }


    @Test
    @DisplayName("Light goes from green to yellow? YES")
    public void checkGreenToYellow3() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.setStates(trafficLight.getGreenState(),trafficLight.getYellowState());
        assertEquals(trafficLight.getCurrentState().getNextState(),trafficLight.getYellowState());
    }

    @Test
    @DisplayName("Light goes from YELLOW to RED after GREEN? NO")
    public void checkYellowToRed() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.setStates(trafficLight.getYellowState(),trafficLight.getGreenState());
        assertNotEquals(trafficLight.getCurrentState().getNextState(),trafficLight.getYellowState());
    }

    @Test
    @DisplayName("Light goes from YELLOW to RED after GREEN? NO")
    public void checkYellowToRed2() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.setStates(trafficLight.getYellowState(),trafficLight.getGreenState());
        assertNotEquals(trafficLight.getCurrentState().getNextState(),trafficLight.getGreenState());

    }

    @Test
    @DisplayName("Light goes from YELLOW to RED after GREEN? YES")
    public void checkYellowToRed3() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.setStates(trafficLight.getYellowState(),trafficLight.getGreenState());
        assertEquals(trafficLight.getCurrentState().getNextState(),trafficLight.getRedState());
    }



    @Test
    @DisplayName("Light goes from RED to YELLOW? YES ")
    public void checkRedToYellow() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.setStates(trafficLight.getRedState(),trafficLight.getYellowState());
        assertEquals(trafficLight.getCurrentState().getNextState(),trafficLight.getYellowState());
    }

    @Test
    @DisplayName("Light goes from RED to YELLOW? NO ")
    public void checkRedToYellow2() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.setStates(trafficLight.getRedState(),trafficLight.getYellowState());
        assertNotEquals(trafficLight.getCurrentState().getNextState(),trafficLight.getGreenState());
    }

    @Test
    @DisplayName("Light goes from RED to YELLOW? NO ")
    public void checkRedToYellow3() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.setStates(trafficLight.getRedState(),trafficLight.getYellowState());
        assertNotEquals(trafficLight.getCurrentState().getNextState(),trafficLight.getRedState());
    }

    @Test
    @DisplayName("Light goes from YELLOW to GREEN after RED? NO ")
    public void checkYellowToGreen() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.setStates(trafficLight.getYellowState(),trafficLight.getRedState());
        assertNotEquals(trafficLight.getCurrentState().getNextState(),trafficLight.getYellowState());
    }

    @Test
    @DisplayName("Light goes from YELLOW to GREEN after RED? NO")
    public void checkYellowToGreen2() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.setStates(trafficLight.getYellowState(),trafficLight.getRedState());
        assertNotEquals(trafficLight.getCurrentState().getNextState(),trafficLight.getRedState());
    }


    @Test
    @DisplayName("Light goes from YELLOW to GREEN after RED? YES")
    public void checkYellowToGreen3() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.setStates(trafficLight.getYellowState(),trafficLight.getRedState());
        assertEquals(trafficLight.getCurrentState().getNextState(),trafficLight.getGreenState());
    }







}

