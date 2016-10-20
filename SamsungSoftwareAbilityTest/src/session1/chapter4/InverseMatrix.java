package session1.chapter4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by dasom on 2016-10-20.
 */
public class InverseMatrix {
    public static final int N = 3;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("SamsungSoftwareAbilityTest\\data\\InverseMatrixInputData.txt"));

        float[][] targetMatrix = new float[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                targetMatrix[i][j] = sc.nextInt();
            }
        }

        float[] resultMatrix = new float[N];
        for (int i = 0; i < N; i++) {
            resultMatrix[i] = sc.nextInt();
        }

        float[][] inverseMatrix = {
                {1.0f, 0.0f, 0.0f},
                {0.0f, 1.0f, 0.0f},
                {0.0f, 0.0f, 1.0f}
        };


        printMatrix(targetMatrix);
        System.out.println();
        printMatrix(inverseMatrix);
        System.out.println();
        System.out.println();


        subtraction(targetMatrix, inverseMatrix, 1, 0);
        printMatrix(targetMatrix);
        System.out.println();
        printMatrix(inverseMatrix);
        System.out.println();
        System.out.println();

        subtraction(targetMatrix, inverseMatrix, 2, 1);
        printMatrix(targetMatrix);
        System.out.println();
        printMatrix(inverseMatrix);
        System.out.println();

        subtraction(targetMatrix, inverseMatrix, 0, 1);
        printMatrix(targetMatrix);
        printMatrix(inverseMatrix);
        System.out.println();
        System.out.println();

        multiple(targetMatrix, inverseMatrix, 1, 0.5f);
        printMatrix(targetMatrix);
        System.out.println();
        printMatrix(inverseMatrix);
        System.out.println();
        System.out.println();

        multipleAndsubtraction(targetMatrix, inverseMatrix, 1, 2, 2.0f);
        printMatrix(targetMatrix);
        System.out.println();
        printMatrix(inverseMatrix);
        System.out.println();
        System.out.println();

        float[] outcomeMatrix = getResult(inverseMatrix, resultMatrix);

        printMatrix(inverseMatrix);
        printMatrix(outcomeMatrix);
    }

    public static float[] getResult(float[][] targetMatrix, float[] resultMatrix) {
        float[] outcomeMatrix = new float[N];

        for (int i = 0; i < N; i++) {
            float result = 0.0f;
            for (int j = 0; j < N; j++) {
                result += (targetMatrix[i][j] * resultMatrix[j]);
            }
            outcomeMatrix[i] = result;
        }

        return outcomeMatrix;
    }

    public static void subtraction(float[][] targetMatrix, float[][] inverseMatrix, int targetRow, int subRow) {
        for (int i = 0; i < N; i++) {
            targetMatrix[targetRow][i] = targetMatrix[targetRow][i] - targetMatrix[subRow][i];
            inverseMatrix[targetRow][i] = inverseMatrix[targetRow][i] - inverseMatrix[subRow][i];
        }
    }

    public static void multiple(float[][] targetMatrix, float[][] inverseMatrix, int targetRow, float multipleNum) {
        for (int i = 0; i < N; i++) {
            targetMatrix[targetRow][i] *= multipleNum;
            inverseMatrix[targetRow][i] *= multipleNum;
        }
    }

    public static void multipleAndsubtraction(float[][] targetMatrix, float[][] inverseMatrix, int targetRow, int subRow, float multipleNum) {
        for (int i = 0; i < N; i++) {
            targetMatrix[targetRow][i] = targetMatrix[targetRow][i] - (multipleNum * targetMatrix[subRow][i]);
            inverseMatrix[targetRow][i] = inverseMatrix[targetRow][i] - (multipleNum * inverseMatrix[subRow][i]);
        }
    }

    public static void printMatrix(float[][] matrix) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrix(float[] matrix) {
        for (int i = 0; i < N; i++) {
            System.out.print(matrix[i] + " ");
        }
        System.out.println();
    }
}
