package opAux;

public class ClaseAuxiliar {

	  /**
	   * Dada una base y un exponente, devuelve la potencia.
	   *
	   * @param base      base de la potencia
	   * @param exponente exponente de la potencia
	   * @return          n�mero resultante de elevar la base a la potencia indicada
	   */
	  public static double potencia(int base, int exponente) {
	    if (exponente == 0) {
	      return 1;
	    }

	    if (exponente < 0) {
	      return 1/potencia(base, -exponente);
	    }

	    int n = 1;

	    for (int i = 0; i < Math.abs(exponente); i++) {
	      n = n * base;
	    }

	    return n;
	  }

	  /**
	   * Cuenta el n�mero de d�gitos de un n�mero entero.
	   *
	   * @param x n�mero al que se le quieren contar los d�gitos
	   * @return  n�mero de d�gitos que tiene el n�mero que se pasa como par�metro
	   */
	  public static int digitos(long x) {
	    if (x < 0) {
	      x = -x;
	    }

	    if (x == 0) {
	      return 1;
	    } else {
	      int n = 0;
	      while (x > 0) {
	        x = x / 10; // se le quita un d�gito a x
	        n++; // incrementa la cuenta de d�gitos
	      }
	      return n;
	    }
	  }

	  /**
	   * Cuenta el n�mero de d�gitos de un n�mero entero.
	   *
	   * @param x n�mero al que se le quieren contar los d�gitos
	   * @return  n�mero de d�gitos que tiene el n�mero que se pasa como par�metro
	   */
	  public static int digitos(int x) {
	    return digitos((long)x);
	  }

	  /**
	   * Le da la vuelta a un n�mero.
	   *
	   * @param x n�mero al que se le quiere dar la vuelta
	   * @return  n�mero volteado (al rev�s)
	   */
	  public static long voltea(long x) {
	    if (x < 0) {
	      return -voltea(-x);
	    }

	    long volteado = 0;

	    while (x > 0) {
	      volteado = (volteado * 10) + (x % 10);
	      x = x / 10;
	    }

	    return volteado;
	  }

	  /**
	   * Le da la vuelta a un n�mero.
	   *
	   * @param x n�mero al que se le quiere dar la vuelta
	   * @return  n�mero volteado (al rev�s)
	   */
	  public static int voltea(int x) {
	    return (int)voltea((long)x);
	  }

	  /**
	  /* Devuelve el d�gito que est� en la posici�n <code>n</code> de un n�mero
	   * entero. Se empieza contando por el 0 y de izquierda a derecha.
	   *
	   * @param x n�mero entero
	   * @param n posici�n dentro del n�mero <code>x</code>
	   * @return  d�gito que est� en la posici�n n del n�mero <code>x</code>
	   *          empezando a contar por el 0 y de izquierda a derecha
	   */
	  public static int digitoN(long x, int n) {
	    x = voltea(x);

	    while (n-- > 0) {
	      x = x / 10;
	    }

	    return (int)(x % 10);
	  }

	  /**
	  /* Devuelve el d�gito que est� en la posici�n n de un n�mero entero. Se
	   * empieza contando por el 0 y de izquierda a derecha.
	   *
	   * @param x n�mero entero
	   * @param n posici�n dentro del n�mero <code>x</code>
	   * @return  d�gito que est� en la posici�n n del n�mero <code>x</code>
	   *          empezando a contar por el 0 y de izquierda a derecha
	   */
	  public static int digitoN(int x, int n) {
	    return digitoN((long)x, n);
	  }

	  /**
	   * Da la posici�n de la primera ocurrencia de un d�gito dentro de un n�mero
	   * entero. Si no se encuentra, devuelve -1.
	   *
	   * @param x n�mero entero
	   * @param d d�gito a buscar dentro del n�mero
	   * @return  posici�n de la primera ocurrencia del d�gito dentro del n�mero o
	   *          -1 si no se encuentra
	   */
	  public static int posicionDeDigito(long x, int d) {
	    int i;

	    for (i = 0; (i < digitos(x)) && (digitoN(x, i) != d); i++) {};

	    if (i == digitos(x)) {
	      return -1;
	    } else {
	      return i;
	    }
	  }

	  /**
	   * Da la posici�n de la primera ocurrencia de un d�gito dentro de un n�mero
	   * entero. Si no se encuentra, devuelve -1.
	   *
	   * @param x n�mero entero
	   * @param d d�gito a buscar dentro del n�mero
	   * @return  posici�n de la primera ocurrencia del d�gito dentro del n�mero o
	   *          -1 si no se encuentra
	   */
	  public static int posicionDeDigito(int x, int d) {
	    return posicionDeDigito((long)x, d);
	  }

}
