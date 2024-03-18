package clasesAProbar;

import java.util.Random;

public class Oscar {

  private static Random rand = new Random();

  /**
   * Genera una matriz de números aleatorios dentro de un rango especificado.
   * 
   * @param filas - El número de filas de la matriz.
   * @param columnas - El número de columnas de la matriz.
   * @param min - El valor mínimo del rango (inclusive).
   * @param max - El valor máximo del rango (inclusive).
   * @return Una matriz de números aleatorios dentro de un rango.
   */
  public static int[][] generarMatriz(int filas, int columnas, int min, int max) {

    // Crea una matriz para almacenar los números aleatorios
    int[][] matriz = new int[filas][columnas];

    // Llena la matriz con números aleatorios dentro del rango especificado
    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        matriz[i][j] = rand.nextInt((max - min) + 1) + min;
      }
    }

    return matriz;
  }


  /**
   * Calcula el determinante de matrices 3x3 aleatorias utilizando la regla de Sarrus.
   * 
   * @param min El valor mínimo del rango (inclusive).
   * @param max El valor máximo del rango (inclusive).
   * @return El determinante de la matriz.
   */
  public static double calcularDeterminanteMatrizAleatoria(int min, int max) {

    // Genera una matriz 3x3 aleatoria dentro del rango especificado
    int[][] matriz = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        matriz[i][j] = rand.nextInt((max - min) + 1) + min;
      }
    }

    // Calcular el determinante de la matriz utilizando la regla de Sarrus
    double determinante = calcularDeterminanteSarrus(matriz);

    return determinante;
  }

  /**
   * Calcula el determinante de una matriz 3x3 utilizando la regla de Sarrus
   * 
   * @param matriz La matriz 3x3 de la cual se calculará el determinante.
   * @return El determinante de la matriz.
   */
  public static double calcularDeterminanteSarrus(int[][] matriz) {
    if (matriz.length != 3 || matriz[0].length != 3) {
      throw new IllegalArgumentException("La matriz no es de tamaño 3x3");
    }
    double determinante = 0;

    double a = matriz[0][0];
    double b = matriz[0][1];
    double c = matriz[0][2];
    double d = matriz[1][0];
    double e = matriz[1][1];
    double f = matriz[1][2];
    double g = matriz[2][0];
    double h = matriz[2][1];
    double i = matriz[2][2];

    // Calcula el determinante utilizando la regla de Sarrus
    determinante = (a * e * i) + (d * h * c) + (g * b * f) - (c * e * g) - (f * h * a) - (i * b * d);

    return determinante;
  } 
}
