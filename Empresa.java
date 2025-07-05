package Ejercicio_recuperatorio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Empresa {
    private ArrayList<Producto> productos_fabricados;
    private String domicilio;
    private String nombre;
    private ArrayList<Empleado>empleados;


    public Empresa(){
        this.productos_fabricados=new ArrayList<>();
        this.domicilio="lavalle 3223";
        this.nombre="la serenisima co";
        this.empleados=new ArrayList<>();
    }

    public Empresa(ArrayList<Producto> productos_fabricados, String domicilio, String nombre, ArrayList<Empleado> empleados) {
        this.productos_fabricados = productos_fabricados;
        this.domicilio = domicilio;
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public ArrayList<Producto> getProductos_fabricados() {
        return productos_fabricados;
    }

    public void setProductos_fabricados(ArrayList<Producto> productos_fabricados) {
        this.productos_fabricados = productos_fabricados;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    //Ejercicio 5
    public int sueldos_a_pagar(){
        int total=0;

        for(Empleado e:empleados){
            total+=e.getSalario();
        }
        return total;
    }

    //Ejercicio 10
    public void empleados_mayores_60 (){
        ArrayList<Empleado> empleados_60=new ArrayList<>();
        for (Empleado e: empleados){
            if(ChronoUnit.YEARS.between(e.getF_nacimiento(),LocalDate.now())>=60){
                empleados_60.add(e);
            }
        }
        System.out.println("Se tendran que contratar "+empleados_60.size()+" empleado/s");
    }


    public static void main(String[] args) {

    }
}
