package jade.handsOns.handsOn4.src;

/**
 * DataSet
 */


 public class DataSet {
    private int[][] dataMatrix = {{1, 2, 3,4,5,6,7,8,9}, {4, 8, 12,16,20,24,28,32,36}};
 
    private int[][] testingUnit = {{651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518 }, {23, 26, 30, 34, 43, 48, 52, 57, 58}};
    
    public int[][] getDataMatrix() {
        return dataMatrix;
    }

    public int[][] getTestingUnit() {
        return testingUnit;
    }
}