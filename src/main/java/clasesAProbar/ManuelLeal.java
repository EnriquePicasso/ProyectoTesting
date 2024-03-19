package clasesAProbar;

public class ManuelLeal {

	/**
	 * Esta funcion sirve para obtener la diagonal de una matriz.
	 * @param matrizCuadrada es la matriz de la que vamos a extraer la diagonal.
	 * @return Se devuelve un array con la diagonal de la matriz.
	 */
	public static int[] diagonal(int[][] matrizCuadrada) {
		
		if(matrizCuadrada.length == matrizCuadrada[0].length) {
			int diagonal[] = new int[matrizCuadrada.length];
		
			for(int i = 0; i < matrizCuadrada.length; i++) {
				diagonal[i] = matrizCuadrada[i][i];
			}
			
			return diagonal;
		} else {
			System.out.println("ERROR. DEBE INTRODUCIR UNA MATRIZ CUADRADA");
		}
		return null;
		
	}
	
	/**
	 * Obtiene la diagonal invertida de una matriz cuadrada.
	 * @param matrizCuadrada Matriz a la que se extrae la diagonal invertida
	 * @return Array con la diagonal invertida de matrizCuadrada
	 * @throws Exception Si la matriz no es cuadrada lanza excepción.
	 */
	private static int[] diagonalInvertida(int[][] matrizCuadrada) throws Exception {
		if (matrizCuadrada.length == matrizCuadrada[0].length) {
			int[] diagonalInv = new int[matrizCuadrada.length];
			int ultimaPosicionArray = matrizCuadrada.length - 1;

			for (int i = 0; i < diagonalInv.length; i++) {
				diagonalInv[i] = matrizCuadrada[i][ultimaPosicionArray--];
			}

			return diagonalInv;
		} else {
			throw new Exception("La matriz no es cuadrada.");
		}
	}
	
	/**
	 * Esta funcion imprime un array.
	 * @param arrayAImprimir Es el array que vamos a imprimir.
	 */
	public static void imprimirArray(int[] arrayAImprimir) {
		
		System.out.println("[");
		for(int i = 0; i < arrayAImprimir.length; i++) {
			if (i < arrayAImprimir.length-1) {
				System.out.println(arrayAImprimir[i]+",");
			} else {
				System.out.println(arrayAImprimir[i]);
			}
		}
		System.out.println("]");
	}
	
	/**
	 * Esta función nos permite rotar una matriz hacia la derecha
	 * @param matrizCuadrada Matriz cuyos elementos vamos a rotar hacia la derecha
	 * @return Devuelve la matriz ya rotada
	 */
	public static int[][] rotarDerecha(int[][] matrizCuadrada){
		
		int filas = matrizCuadrada.length;
		int columnas = matrizCuadrada[0].length;
		
		int[][] matrizRotada = new int[columnas][filas];
		
		for (int i = 0; i < matrizRotada.length; i++) {
			for(int j = 0; j < matrizRotada[i].length; j++) {
				matrizRotada[i][j] = matrizCuadrada[matrizCuadrada.length - 1 - j][i];
			}
		}
		
		return matrizRotada;
	}

}
