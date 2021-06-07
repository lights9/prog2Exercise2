import trafficlight.ctrl.TrafficLightCtrl;


public class MCP {
    public static void main(String[] args) {
        //implemented Singleton
        TrafficLightCtrl ctrl = TrafficLightCtrl.getController();
        ctrl.run();
    }
}