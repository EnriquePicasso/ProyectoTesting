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

    //Crea una matriz para almacenar los números aleatorios
    int[][] matriz = new int[filas][columnas];

    //Llena la matriz con números aleatorios dentro del rango especificado
    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        matriz[i][j] = rand.nextInt((max - min) + 1) + min;
      }
    }

    return matriz;
  }
  
  
  /**
   * Calcula el determinante de matrices 3x3 aleatorias.
   * 
   * @param min El valor mínimo del rango (inclusive).
   * @param max El valor máximo del rango (inclusive).
   * @return El determinante de la matriz.
   */
  public static double calcularDeterminanteMatrizAleatoria(int min, int max) {
      
      //Genera una matriz 3x3 aleatoria dentro del rango especificado
      int[][] matriz = new int[3][3];
      for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
              matriz[i][j] = rand.nextInt((max - min) + 1) + min;
          }
      }
      
      // Calcular el determinante de la matriz
      double determinante = calcularDeterminante(matriz);
      
      return determinante;
  }

  /**
   * Calcula el determinante de una matriz 3x3 utilizando el método general.
   * 
   * @param matriz La matriz 3x3 de la cual se calculará el determinante.
   * @return El determinante de la matriz.
   */
  private static double calcularDeterminante(int[][] matriz) {
      double determinante = matriz[0][0] * (matriz[1][1] * matriz[2][2] - matriz[1][2] * matriz[2][1])
                          - matriz[0][1] * (matriz[1][0] * matriz[2][2] - matriz[1][2] * matriz[2][0])
                          + matriz[0][2] * (matriz[1][0] * matriz[2][1] - matriz[1][1] * matriz[2][0]);
      return determinante;
  }
  
}
