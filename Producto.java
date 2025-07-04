package Ejercicio_recuperatorio;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Producto {
    private int codigo;
    private String nombre;
    private String marca;
    private Empresa fabricante;
    private LocalDate fecha_envasado;
    private int precio;

    public Producto(){
        this.codigo=243;
        this.nombre="yogurt";
        this.marca="la serenisima";
        this.fabricante=new Empresa();
        this.fecha_envasado=LocalDate.of(2023,2,3);
        this.precio=1233;
    }

    public Producto(int codigo, String nombre, String marca, Empresa fabricante, LocalDate fecha_envasado, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.fabricante = fabricante;
        this.fecha_envasado = fecha_envasado;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Empresa getFabricante() {
        return fabricante;
    }

    public void setFabricante(Empresa fabricante) {
        this.fabricante = fabricante;
    }

    public LocalDate getFecha_envasado() {
        return fecha_envasado;
    }

    public void setFecha_envasado(LocalDate fecha_envasado) {
        this.fecha_envasado = fecha_envasado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public abstract boolean vencido();

    public static void main(String[] args) {

    }
}
