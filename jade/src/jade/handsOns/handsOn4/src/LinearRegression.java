package jade.handsOns.handsOn4.src;

/*
 * Linear Regression class
 */

public class LinearRegression {

    static DataSet dataSet = new DataSet();
    static DiscretMaths dm = new DiscretMaths();
    static LinearAlgebra la = new LinearAlgebra();

    private int[][] dataMatrix = dataSet.getDataMatrix();
    private double error = 0;
    private double beta0 = 0;
    private double beta1 = 0;
    private double[] yHat = new double[dataMatrix[0].length];
    private int[] y = new int[dataMatrix[0].length];
    private int[] x = new int[dataMatrix[0].length];


    private int numPredictions = 10;

    public double[] predictions() {
        double[] predictions = new double[numPredictions];
        for (int i = 0; i < numPredictions; i++) {
            predictions[i] = beta0 + beta1 * (dataMatrix[0][8] + ((i + 1) * 2));
        }
        return predictions;
    }


    public void calculateBeta0() {
        double sumY = dm.RiemmanSum(la.getColumn(dataMatrix, 1));
        double sumX = dm.RiemmanSum(la.getColumn(dataMatrix, 0));
        double sumXY = dm.multiply(dataMatrix);
        double sumX2 = la.powVector(la.getColumn(dataMatrix, 0), 2);

        beta0 = (sumY * sumX2 - sumX * sumXY) / (dataMatrix[0].length * sumX2 - sumX * sumX);
    }

    public void calculateBeta1() {
        double sumY = dm.RiemmanSum(la.getColumn(dataMatrix, 1));
        double sumX = dm.RiemmanSum(la.getColumn(dataMatrix, 0));
        double sumXY = dm.multiply(dataMatrix);
        double sumX2 = la.powVector(la.getColumn(dataMatrix, 0), 2);
        
        beta1 = (dataMatrix[0].length * sumXY - sumX * sumY) / (dataMatrix[0].length * sumX2 - sumX * sumX);
    }



    public void calculateYHat() {
        for (int i = 0; i < dataMatrix[0].length; i++) {
            yHat[i] = beta0 + beta1 * dataMatrix[0][i];
        }
    }

    public void calculateError() {
        for (int i = 0; i < dataMatrix[0].length; i++) {
            error += (dataMatrix[1][i] - yHat[i]) * (dataMatrix[1][i] - yHat[i]);
        }
    }

    public void calculateY() {
        for (int i = 0; i < dataMatrix[0].length; i++) {
            y[i] = dataMatrix[1][i];
        }
    }

    public void calculateX() {
        for (int i = 0; i < dataMatrix[0].length; i++) {
            x[i] = dataMatrix[0][i];
        }
    }

    public double getBeta0() {
        return beta0;
    }

    public double getBeta1() {
        return beta1;
    }

    public double[] getyHat() {
        return yHat;
    }

    public int[] getY() {
        return y;
    }

    public int[] getX() {
        return x;
    }

    public double getError() {
        return error;
    }

    
    @Override
    public String toString() {
        
        System.out.println("Y = " + beta0 + " + " + beta1 + "X");
        System.out.println("Error: " + error);

        System.out.println("============ TABLA DE RESULTADOS ============");

        System.out.println("| X\t| Y\t| YHat\t| Error");
        
        for(int i = 0; i < dataMatrix[0].length; i++) {
            System.out.println("| " + dataMatrix[0][i] + "\t| " + dataMatrix[1][i] + "\t| " + yHat[i] + "\t| " + (dataMatrix[1][i] - yHat[i]));
        }

        System.out.println("============ PREDICCIONES ============");

        System.out.println("| X\t| YHat\t|");

        double[] predictions = predictions();
        for(int i = 0; i < numPredictions; i++) {
            System.out.println("| " + (dataMatrix[0][8] + ((i + 1) * 2)) + "\t| " + predictions[i] + "\t|");
        }

        return "";

    }


}