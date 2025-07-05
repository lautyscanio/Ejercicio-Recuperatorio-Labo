package Ejercicio_recuperatorio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Perecedero extends Producto {
    private LocalDate vencimiento;
    private int dias_para_consumir_luego_de_vencimiento;


    public Perecedero(){
        super(223,"leche","la serenisima", new Empresa(),LocalDate.of(2023,3,4),1000);
        this.vencimiento=LocalDate.of(2025,7,2);
        this.dias_para_consumir_luego_de_vencimiento=7;
    }

    public Perecedero(int codigo, String nombre, String marca, Empresa fabricante, LocalDate fecha_envasado, int precio, LocalDate vencimiento, int dias_para_consumir_luego_de_vencimiento) {
        super(codigo, nombre, marca, fabricante, fecha_envasado, precio);
        this.vencimiento = vencimiento;
        this.dias_para_consumir_luego_de_vencimiento = dias_para_consumir_luego_de_vencimiento;
    }

    public LocalDate getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(LocalDate vencimiento) {
        this.vencimiento = vencimiento;
    }

    public int getDias_para_consumir_luego_de_vencimiento() {
        return dias_para_consumir_luego_de_vencimiento;
    }

    public void setDias_para_consumir_luego_de_vencimiento(int dias_para_consumir_luego_de_vencimiento) {
        this.dias_para_consumir_luego_de_vencimiento = dias_para_consumir_luego_de_vencimiento;
    }

    //Ejercicio 2
    @Override
    public boolean vencido() {
        if (LocalDate.now().isAfter(vencimiento)) {
            return true;
        }
        else {
            return false;
        }
    }


    //Ejercicio 6
    public Long cuanto_falta_para_vencer(){
        if(vencido()){
            return (long) -1;
        }

            return ChronoUnit.DAYS.between(LocalDate.now(),getVencimiento());

    }

    //Ejercicio 9
    public void seguir_consumiendo(){
        if (!vencido()){
            System.out.println("el producto no vencio");
            return;
        }
        LocalDate fecha_nueva=vencimiento.plusDays(dias_para_consumir_luego_de_vencimiento);
         if (fecha_nueva.isAfter(LocalDate.now())){
            long dias_para_consumir= ChronoUnit.DAYS.between(LocalDate.now(),fecha_nueva);
            System.out.println("te quedan "+ dias_para_consumir+" dias para consumir este producto");
        }
        else {
             System.out.println("Ya no se puede consumir");
        }
    }

    public static void main(String[] args) {
    }
}