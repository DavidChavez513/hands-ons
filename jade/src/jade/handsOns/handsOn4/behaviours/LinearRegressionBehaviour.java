package jade.handsOns.handsOn4.behaviours;

import jade.core.behaviours.OneShotBehaviour;
import jade.handsOns.handsOn4.src.DataSet;
import jade.handsOns.handsOn4.src.LinearRegression;

public class LinearRegressionBehaviour extends OneShotBehaviour{
    
    int step = 0;
    int[][] data = null;

    LinearRegression lr = new LinearRegression();


    @Override
    public void action() {
        // TODO Auto-generated method stub
        
        switch (step) {
            case 0:
                DataSet dataSet = new DataSet();
                data = dataSet.getTestingUnit();
                step++;
                break;
            case 1:
                

            break;
        
            default:
                break;
        }

    }



}
