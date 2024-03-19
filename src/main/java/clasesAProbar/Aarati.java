package clasesAProbar;

public class Aarati {

  // Esta expresión regular verifica si un string tiene el formato correcto de un NIF
  private static final String FORMATO_NIF = "[0-9]{8}[ABCDEFGHJLMNPQRSTVWXYZ]";
  // Este array define todas las letras válidas que pueden aparecer como parte del NIF
  private static final char[] LETRAS_NIF = {
      'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
      'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
    };
  
  // Atributos
  //Nif del cliente
  private String nif;
  //Apellidos del cliente
  private String apellido; 
  // Nombre del cliente
  private String nombre;
  // Número de empleados
  private int edad;

  /**
   * Constructor
   * @param nif Debe constar de 8 números y una letra mayúscula que debe ser 
   * la que le corresponde según el algoritmo del gobierno  
   * @param nombre No puede ser nulo ni vacilo
   * @param apellido Mismo que el nombre
   * @param edad Debe ser mayor o igual que 0
   * @throws IllegalArgumentException Si alguno de estos no son validos
   */
  public Aarati(String nif, String nombre, String apellido, int edad) {

    // Si alguno de estos no es valido tira IllegalArgumentException.
    if (esNieValido(nif) && validarNombre(nombre) && validarApellido(apellido) && validarEdad(edad)) {
      this.nif = nif;
      this.nombre = nombre;
      this.apellido = apellido;
      this.edad = edad;
      
    } else {
      throw new IllegalArgumentException();
    }
    
  }
  
  /**
   * Devuelve nif
   * @return Nif 
   */
  public String getNif() {
    return nif;
  }


  /**
   * Devuelve apellido
   * @return Apellido
   */
  public String getApellido() {
    return apellido;
  }


  /**
   * Devuelve el nombre
   * @return Nombre
   */
  public String getNombre() {
    return nombre;
  }
  
  /**
   * Devuelve la edad
   * @return Edad
   */
  public int getEdad() {
    return edad;
  }
  
  
  /**
   * Validar el nombre
   * @param nombre
   * @return develve true si no es nulo ni vacio
   */
  private boolean validarNombre(String nombre) {
    return nombre != null && !nombre.isEmpty();
  }
  
  /**
   * Validar el apellido
   * @param nombre
   * @return develve true si no es nulo ni vacio
   */
  private boolean validarApellido(String apellido) {
    return apellido != null && !apellido.isEmpty();
  }
  
  /**
   * Validar edad de una persona
   * @return True si la edad es mayor o igual que 0, si no False
   */
  private Boolean validarEdad(int edad) {
    return edad >= 0;
  }

  /**
   * Validar NIF 
   * @param nif NIF 
   * @return Devuelve true si es valido or false si no es valido
   */
  private boolean esNieValido(String nif) {
    
    if(nif != null) {
      // Si un nie valido
      if (nif.matches(FORMATO_NIF)) {
        // Devuelve true si el nif tiene lletra valido
        return validaLetraNIF(nif);
      } else {
        // devuelve falso si es un formato no válido
        return false;
      }
    } else {
      // Si es null tira IllegalArgumentException
      throw new IllegalArgumentException();
    }
    
  }
  
  // Validar letras del NIF
  private boolean validaLetraNIF(String nif) {
    // Converte los primeros 8 caracteres de nif en un numero entero
    int numero = Integer.parseInt(nif.substring(0, 8));
    // Calculamos el resto
    int resto = numero % 23;
    /**
     * verifica si la letra en la posición 9 del NIF (índice 8) 
     * coincide con la letra obtenida a partir del resto
     */
    return nif.charAt(8) == LETRAS_NIF[resto];
  }

}
