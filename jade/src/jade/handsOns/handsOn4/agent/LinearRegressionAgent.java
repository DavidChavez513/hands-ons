package jade.handsOns.handsOn4.agent;

import jade.core.Agent;

public class LinearRegressionAgent extends Agent {
    
    int step = 0;

    protected void setup(){
        System.out.println("Hi, this us a Linear Regression Agent: " + getAID().getName() + " is my name!");
    }

    protected void takeDown() {
        System.out.println(" I go to sleep brou: " + getAID().getName() + "");
    }

}
