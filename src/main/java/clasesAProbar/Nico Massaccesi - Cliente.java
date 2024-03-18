package prog.unidad05.gestionclientes.core;

/**
 * Información sobre un cliente
 */
public class Cliente {
	// LETRAS_NIF: Posibles letras que puede tener un NIF.
	private static final String[] LETRAS_NIF = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J",
			"Z", "S", "Q", "V", "H", "L", "C", "K", "E" };
	// DIVISOR_NIF: Divisor del algoritmo para calcular la letra que le corresponde
	// a un NIF.
	private static final int DIVISOR_NIF = 23;

	// La descripcion de los atributos es la misma que en el constructor.
	private String nif;
	private String apellidos;
	private String nombre;
	private int empleados;
	private double facturacion;
	private boolean nacionalUe;

	/**
	 * Constructor con toda la información Ningún parámetro puede ser null.
	 * 
	 * @param nif         - NIF del cliente. Debe constar de 8 números y una letra
	 *                    mayúscula que debe ser la que le corresponde según el
	 *                    algoritmo del gobierno
	 * @param apellidos   - Apellidos del cliente. No puede estar vacío o contener
	 *                    sólo blancos y la primera letra de cada palabra debe ser
	 *                    mayúscula
	 * @param nombre      - Nombre del cliente. Mismas restricciones que apellido
	 * @param empleados   - Número de empleados. Debe ser superior a cero
	 * @param facturacion - Facturación anual del cliente. Debe ser superior a cero
	 * @param nacionalUe  - true si el cliente es nacional de un pais de la UE.
	 *                    false si no lo es
	 * @throws IllegalArgumentException - Si alguno de los parámetros no es válido
	 */
	public Cliente(String nif, String apellidos, String nombre, int empleados, double facturacion, boolean nacionalUe) {
		// Se crea el objeto si, y solo si, cumple con las validaciones necesarias.
		if (validarNombreApellido(apellidos) && validarNombreApellido(nombre) && validarNif(nif) && empleados > 0
				&& facturacion > 0) {
			this.apellidos = apellidos;
			this.nombre = nombre;
			this.nif = nif;
			this.empleados = empleados;
			this.facturacion = facturacion;
			this.nacionalUe = nacionalUe;

		} else {
			throw new IllegalArgumentException();
		}
	};

	/**
	 * Devuelve el NIF del cliente
	 * 
	 * @return NIF del cliente
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * Obtiene los apellidos del cliente
	 * 
	 * @return Apellidos del cliente
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Obtiene el nombre del cliente
	 * 
	 * @return Nombre del cliente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene el número de empleados del cliente
	 * 
	 * @return Número de empleados del cliente
	 */
	public int getEmpleados() {
		return empleados;
	}

	/**
	 * Obtiene la facturación del cliente
	 * 
	 * @return Facturacion del cliente, en euros
	 */
	public double getFacturacion() {
		return facturacion;
	}

	/**
	 * Obtiene si el cliente es nacional de un pais de la UE o no
	 * 
	 * @return true si el cliente es nacional de un pais de la UE, false si no lo es
	 */
	public boolean isNacionalUe() {
		return nacionalUe;
	}

	/*
	 * Valida que una cadena no sea nula o vacia.
	 * 
	 * @return true si la cadena es valida, false si no lo es
	 */
	public boolean validarCadena(String cadena) {
		if (cadena == null || cadena.isBlank()) {
			return false;
		}
		return true;
	};

	/*
	 * Valida que un nombre o apellido no sea nulo o vacio, y que cada palabra
	 * empiece en mayuscula.
	 * 
	 * @return true si el nombre o apellido es valido, false si no lo es
	 */
	public boolean validarNombreApellido(String nombre) {
		// Se usa el metodo validarCadena() para comprobar que no sea nulo o vacio.
		if (!validarCadena(nombre)) {
			return false;
		}
		// Se corta la cadena en palabras y se comprueba que la primera letra de c/u sea
		// mayuscula.
		for (String palabra : nombre.split(" ")) {
			if (!palabra.substring(0, 1).equals(palabra.substring(0, 1).toUpperCase())) {
				return false;
			}
		}
		return true;

	}

	/*
	 * Valida que un NIF no sea nulo o vacio y que cumpla las especificaciones del
	 * algoritmo.
	 * 
	 * @return true si el nif es valido, false si no lo es
	 */
	public boolean validarNif(String nif) {
		if (
				// Que el NIF no sea nulo o vacio.
				validarCadena(nif)
				// Que el nif tenga un tamaño de 9 caracteres.
				&& nif.length() == 9
				// Que el nif contenga 8 caracteres numericos seguidos de una letra que
				// pertenezca al conjunto.
				&& nif.matches("\\d{8}[TRWAGMYFPDXBNJZSQVHLCKE]")
				// Que el numero de la parte numerica tenga su letra correspondiente.
				&& LETRAS_NIF[(Integer.parseInt(nif.substring(0, 8))) % DIVISOR_NIF].equals(nif.substring(8))) {
			return true;
		}
		return false;
	}
	
	// Sobreescribo el toString de la clase.
	@Override
	public String toString() {
		return String.format("%s: %s, %s\n", this.getNif(), this.getApellidos(), this.getNombre());
	}
}
