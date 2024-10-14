package jade.handsOns.handsOn4.src;
import java.util.Random;


/**
 * DataSet
 */


public class DataSet {

    private int[][] weatherData;
    private int[][] dataMatrix;
    private int[][] hurricaneData;

    private void generateHurricaneData() {
        Random rand = new Random();
        hurricaneData = new int[10][5]; // Assuming 5 attributes per year
        for (int i = 0; i < hurricaneData.length; i++) {
            for (int j = 0; j < hurricaneData[i].length; j++) {
                hurricaneData[i][j] = rand.nextInt(100); // Random values between 0 and 99
            }
        }
    }

    public int[][] getHurricaneData() {
        return hurricaneData;
    }
    
    public DataSet() {
        Random rand = new Random();
        weatherData = new int[10][11];
        for (int i = 0; i < weatherData.length; i++) {
            for (int j = 0; j < weatherData[i].length; j++) {
                weatherData[i][j] = rand.nextInt(100); // Random values between 0 and 99
            }
        }

        dataMatrix = new int[2][9];
        for (int i = 0; i < dataMatrix.length; i++) {
            for (int j = 0; j < dataMatrix[i].length; j++) {
                dataMatrix[i][j] = rand.nextInt(100); // Random values between 0 and 99
            }
        }

        generateHurricaneData();
    }


    public int[][] getWeatherData() {
        return weatherData;
    }
    

    public int[][] getDataMatrix() {
        return weatherData;
    }
}
