package Busqueda;

public class Vehiculo {
  private String nombre;
  private String marca;

  public Vehiculo(String nombre, String marca) {
    this.nombre = nombre;
    this.marca = marca;
  }

  public String getNombre() {
    return nombre;
  }

  public String getMarca() {
    return marca;
  }

  @Override
  public String toString() {
    return "Vehiculo [nombre=" + nombre + ", marca=" + marca + "]";
  }
}
