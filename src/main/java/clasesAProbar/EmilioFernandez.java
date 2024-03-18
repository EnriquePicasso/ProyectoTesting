package clasesAProbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EmilioFernandez {
  private String marca;
  private String modelo;
  private int anyo;
  private double valor;
  private List<String> listaMarcasCoche;

  Calendar calendario = Calendar.getInstance();
  int anyoActual = calendario.get(Calendar.YEAR);

  /**
   * 
   * @param marca  Marca del coche. Tiene que ser alguno de los que esten en la
   *               lista
   * @param modelo Modelo del coche
   * @param año    Año de matriculacion. No puede ser anterior a 1950
   * @param valor  Valor del coche. Tiene que ser mayor que 0
   */
  public EmilioFernandez(String marca, String modelo, int anyo, double valor) {
    anyadirCoches();
    if (listaMarcasCoche.contains(marca)) {
      this.marca = marca;
    } else {
      throw new IllegalArgumentException();
    }
    this.modelo = modelo;

    if (anyo > 1950 && anyo <= anyoActual) {
      this.anyo = anyo;
    } else {
      throw new IllegalArgumentException();
    }

    if (valor > 0) {
      this.valor = valor;
    } else {
      throw new IllegalArgumentException();
    }

  }

  /**
   * Metodo para obtener información del coche
   * 
   * @return Cadena con la información del coche
   */
  public String obtenerInformacion() {
    return "Marca: " + marca + ", Modelo: " + modelo + ", Año: " + anyo;
  }

  /**
   * Metodo para ver la antigüedad del coche
   * 
   * @return True si tiene mas de 10 años, false si tiene menos de 10 años
   */
  public boolean esAntiguo() {
    return anyoActual - anyo >= 10;
  }

  /**
   * Metodo que calcula el impuesto que se debe pagar anualmente por tener el
   * coche
   * 
   * @return El impuesto total
   */
  public double calcularImpuestoAnual() {
    int antiguedad = anyoActual - anyo;
    double impuestoBase = 100;
    double impuestoPorAnyo = 50;

    // Calcular el impuesto adicional basado en la antigüedad del automóvil
    double impuestoAdicional = impuestoPorAnyo * antiguedad;

    // Calcular el impuesto total sumando el impuesto base y el impuesto adicional
    double impuestoTotal = impuestoBase + impuestoAdicional;

    // Aplicar un descuento del 10% si el automóvil es antiguo
    if (esAntiguo()) {
      impuestoTotal *= 0.9;
    }
    return impuestoTotal;
  }

  private void anyadirCoches() {
    listaMarcasCoche = new ArrayList<>();
    listaMarcasCoche.add("Alfa Romeo");
    listaMarcasCoche.add("Mazda");
    listaMarcasCoche.add("Renault");
    listaMarcasCoche.add("Mercedes");
    listaMarcasCoche.add("Kia");
    listaMarcasCoche.add("Hyundai");
    listaMarcasCoche.add("Honda");
    listaMarcasCoche.add("Volkswagen");
    listaMarcasCoche.add("McLaren");
    listaMarcasCoche.add("Ferrari");
    listaMarcasCoche.add("Lamboghini");
    listaMarcasCoche.add("Dacia");
    listaMarcasCoche.add("SEAT");
    listaMarcasCoche.add("Peugeot");
    listaMarcasCoche.add("Toyota");
    listaMarcasCoche.add("Citroën");
  }
}
