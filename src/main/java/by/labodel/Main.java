package by.labodel;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        short[] w = new short[9];
        for (int i = 0; i < w.length; i++) {
            w[i] = (short) Math.abs((i * 2) - 19);
        }
        float[] x = new float[15];
        Random random = new Random();
        for (int i = 0; i < x.length; i++) {
            x[i] = random.nextFloat() * 25f - 15f;
        }

        double[][] m = new double[9][15];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (w[i] == 13) {
                    m[i][j] = firstElement(x[j]);
                } else if (w[i] == 5 || w[i] == 11 || w[i] == 15 || w[i] == 17) {
                    m[i][j] = secondElement(x[j]);
                } else {
                    m[i][j] = thirdElement(x[j]);
                }
            }
        }
        outputMatrix(m);
    }

    public static double firstElement(float x) {
        return Math.cos(
                Math.pow(Math.log10(Math.abs(x)),
                        (0.75) * Math.sin(x))
        );
    }

    public static double secondElement(float x) {
        return Math.tan(
                Math.log10(
                        Math.pow(Math.sin(x), 2)
                )
        );
    }

    public static double thirdElement(float x) {
        return Math.exp(
                Math.pow(
                        Math.pow(Math.log10(Math.abs(x)), (0.5) * (x / 0.5)),
                        (double) 1 / 3)

        );
    }

    public static void outputMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%7.3f ", matrix[i][j]);
            }
            System.out.println();
        }
    }

}