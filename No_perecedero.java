package Ejercicio_recuperatorio;

import java.time.LocalDate;

public class No_perecedero extends Producto{
    private int peso;
    private Unidad unidad_de_peso;
    private boolean envoltorio_reciclable;

    public No_perecedero(){
        super(10, "leche en polvo","la serenisima",new Empresa(),LocalDate.of(2025,4,3),2000);
        this.peso=1;
        this.unidad_de_peso=Unidad.KILO;
        this.envoltorio_reciclable=true;
    }


    public No_perecedero(int codigo, String nombre, String marca, Empresa fabricante, LocalDate fecha_envasado, int precio, int peso,Unidad unidad_de_peso, boolean envoltorio_reciclable) {
        super(codigo, nombre, marca, fabricante, fecha_envasado, precio);
        this.peso = peso;
        this.unidad_de_peso=unidad_de_peso;
        this.envoltorio_reciclable = envoltorio_reciclable;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean isEnvoltorio_reciclable() {
        return envoltorio_reciclable;
    }

    public void setEnvoltorio_reciclable(boolean envoltorio_reciclable) {
        this.envoltorio_reciclable = envoltorio_reciclable;
    }

    @Override
    public boolean vencido() {
        return false;
    }
}
