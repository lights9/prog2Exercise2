package trafficlight.ctrl;

import trafficlight.gui.TrafficLightGui;
import trafficlight.states.State;


public class TrafficLightCtrl {

    private State greenState;

    private State redState;

    private State yellowState;

    public State currentState;

    private State previousState;

    private final TrafficLightGui gui;

    private boolean doRun = true;

    //make constructor private, so that no more instances can be created
    private TrafficLightCtrl() {
        super();
        initStates();
        gui = new TrafficLightGui(this);
        gui.setVisible(true);
        //TODO useful to update the current state
        //notify observer about current state
        currentState.notifyObserver();
    }

    //Implement controller as Singleton Pattern-> if there is no instance create one
    private static TrafficLightCtrl controller;

    public static TrafficLightCtrl getController() {
        if (controller == null) {
            controller = new TrafficLightCtrl();
        }
        return controller;
    }


    private void initStates() {
        greenState = new State() {
            @Override
            public State getNextState() {
                previousState = currentState;
                //TODO useful to update the current state and the old one
                //current state updated from green to yellow
                currentState.notifyObserver();
                yellowState.notifyObserver();

                return yellowState;
            }

            @Override
            public String getColor() {
                return "green";
            }
        };


        redState = new State() {
            @Override
            public State getNextState() {
                previousState = currentState;
                //TODO useful to update the current state and the old one
                //current state updated from red to yellow
                yellowState.notifyObserver();
                currentState.notifyObserver();


                return yellowState;
            }

            @Override
            public String getColor() {
                return "red";
            }
        };

        yellowState = new State() {
            @Override
            public State getNextState() {
                if (previousState.equals(greenState)) {
                    previousState = currentState;
                    //TODO useful to update the current state and the old one
                    //current state updated from yellow to red
                    currentState.notifyObserver();
                    redState.notifyObserver();
                    return redState;
                } else {
                    previousState = currentState;
                    //TODO useful to update the current state and the old one
                    //current state updated from yellow to green
                    currentState.notifyObserver();
                    greenState.notifyObserver();
                    return greenState;
                }
            }

            @Override
            public String getColor() {
                return "yellow";
            }
        };
        currentState = greenState;
        previousState = yellowState;
    }

    public State getGreenState() {
        return greenState;
    }

    public State getRedState() {
        return redState;
    }

    public State getYellowState() {
        return yellowState;
    }

    public void run() {
        int intervall = 1500;
        while (doRun) {
            try {
                Thread.sleep(intervall);
                nextState();
            } catch (InterruptedException e) {
                gui.showErrorMessage(e);
            }
        }
        System.out.println("Stopped");
        System.exit(0);
    }

    public void nextState() {
        currentState = currentState.getNextState();
    }

    public void stop() {
        doRun = false;
    }


    //getter for previous state
    public State getPreviousState() {
        return previousState;
    }

    //getter for current state
    public State getCurrentState() {
        return currentState;
    }

    public void setStates(State currentState, State previousState) {
        //yellow lights -> before green of red
        //green and red lights -> before yellow
        if ((currentState == yellowState && (previousState == greenState || previousState == redState)) ||
                (previousState == yellowState) && (currentState == greenState || currentState == redState)) {
            //currentState & previousState is yellow
            this.currentState = currentState;
            this.previousState = previousState;

        }
    }
}
