package Ejercicio_recuperatorio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Empleado extends Persona {
    private LocalDate f_ingreso;
    private int salario;
    private ArrayList<Producto>productos_emp;


    public Empleado(){
        super("mati", "faya", LocalDate.of(2007,9,4));
        this.f_ingreso=LocalDate.of(2024,3,3);
        this.salario=223000;
        this.productos_emp= new ArrayList<>();
    }


    public Empleado(String nombre, String apellido, LocalDate f_nacimiento, LocalDate f_ingreso, int salario, ArrayList<Producto> productos_emp) {
        super(nombre, apellido, f_nacimiento);
        this.f_ingreso = f_ingreso;
        this.salario = salario;
        this.productos_emp = new ArrayList<>();
    }

    public LocalDate getF_ingreso() {
        return f_ingreso;
    }

    public void setF_ingreso(LocalDate f_ingreso) {
        this.f_ingreso = f_ingreso;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public ArrayList<Producto> getProductos_emp() {
        return productos_emp;
    }

    public void setProductos_emp(ArrayList<Producto> productos_emp) {
        this.productos_emp = productos_emp;
    }

    //Ejercicio 8
    public Long anios_en_la_empresa(){

        return ChronoUnit.YEARS.between(f_ingreso,LocalDate.now());
    }

    public static void main(String[] args) {
     }
}
