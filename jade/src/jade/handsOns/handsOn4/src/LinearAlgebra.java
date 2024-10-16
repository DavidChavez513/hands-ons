package jade.handsOns.handsOn4.src;

public class LinearAlgebra {

    private double[][] minor(double[][] matrix, int row, int column) {
        double[][] minor = new double[matrix.length - 1][matrix[0].length - 1];
        int minorRow = 0;
        int minorColumn = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i == row) {
                continue;
            }
            minorColumn = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == column) {
                    continue;
                }
                minor[minorRow][minorColumn] = matrix[i][j];
                minorColumn++;
            }
            minorRow++;
        }
        return minor;
    }

    public double[][] transpose(double[][] matrix) {
        double[][] transpose = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[0].length; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }
        return transpose;
    }

    public double[] getRow(double[][] matrix, int row) {
        double[] rowVector = new double[matrix.length];
        for (int i = 0; i < rowVector.length; i++) {
            rowVector[i] = matrix[i][row];
        }
        return rowVector;
    }

    public double[] getColumn(int[][] dataMatrix2, int column) {
        double[] columnVector = new double[dataMatrix2[0].length];
        for (int i = 0; i < columnVector.length; i++) {
            columnVector[i] = dataMatrix2[column][i];
        }
        return columnVector;
    }

    public double determinant(double[][] matrix) {
        double determinant = 0;
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        if (matrix.length == 2) {
            determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            return determinant;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            determinant += Math.pow(-1, i) * matrix[0][i] * determinant(minor(matrix, 0, i));
        }
        return determinant;
    }

    public double[][] inverse(double[][] matrix) {
        double[][] inverse = new double[matrix.length][matrix[0].length];
        double determinant = determinant(matrix);
        if (matrix.length == 1) {
            inverse[0][0] = 1 / matrix[0][0];
            return inverse;
        }
        if (matrix.length == 2) {
            inverse[0][0] = matrix[1][1] / determinant;
            inverse[0][1] = -matrix[0][1] / determinant;
            inverse[1][0] = -matrix[1][0] / determinant;
            inverse[1][1] = matrix[0][0] / determinant;
            return inverse;
        }
        for (int i = 0; i < inverse.length; i++) {
            for (int j = 0; j < inverse[0].length; j++) {
                inverse[i][j] = Math.pow(-1, i + j) * determinant(minor(matrix, i, j)) / determinant;
            }
        }
        inverse = transpose(inverse);
        return inverse;
    }


    public double[][] cramer(double[][] matrix, double[] vector) {
        double[][] cramer = new double[matrix.length][matrix[0].length];
        double determinant = determinant(matrix);
        double[][] temp = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < cramer.length; i++) {
            for (int j = 0; j < cramer[0].length; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < cramer.length; i++) {
            for (int j = 0; j < cramer[0].length; j++) {
                temp[j][i] = vector[j];
            }
            cramer[i][0] = determinant(temp) / determinant;
            for (int k = 0; k < cramer.length; k++) {
                for (int l = 0; l < cramer[0].length; l++) {
                    temp[k][l] = matrix[k][l];
                }
            }
        }
        return cramer;
    }

    public double[][] gaussJordan(double[][] matrix) {
        double[][] gaussJordan = new double[matrix.length][matrix[0].length];
        double[][] temp = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < gaussJordan.length; i++) {
            for (int j = 0; j < gaussJordan[0].length; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < gaussJordan.length; i++) {
            for (int j = 0; j < gaussJordan[0].length; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < gaussJordan.length; k++) {
                    for (int l = 0; l < gaussJordan[0].length; l++) {
                        temp[k][l] = matrix[k][l];
                    }
                }
                for (int k = 0; k < gaussJordan[0].length; k++) {
                    temp[j][k] = matrix[j][k] * matrix[i][i] - matrix[i][k] * matrix[j][i];
                }
                for (int k = 0; k < gaussJordan.length; k++) {
                    for (int l = 0; l < gaussJordan[0].length; l++) {
                        matrix[k][l] = temp[k][l];
                    }
                }
            }
        }
        for (int i = 0; i < gaussJordan.length; i++) {
            for (int j = 0; j < gaussJordan[0].length; j++) {
                gaussJordan[i][j] = matrix[i][j] / matrix[i][i];
            }
        }
        return gaussJordan;
    }

    public double powVector(double[] vector, int power) {
        double powVector = 0;
        for (int i = 0; i < vector.length; i++) {
            powVector += Math.pow(vector[i], power);
        }
        return powVector;
    }

}