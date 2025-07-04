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

    public int sueldos_a_pagar(){
        int total=0;

        for(Empleado e:empleados){
            total+=e.getSalario();
        }
        return total;
    }

    public void empleados_mayores_60 (){
        ArrayList<Empleado> empleados_60=new ArrayList<>();
        for (Empleado e: empleados){
            if(ChronoUnit.YEARS.between(e.getF_nacimiento(),LocalDate.now())>=60){
                empleados_60.add(e);
            }
        }
        System.out.println("Se tendran que contratar "+empleados_60.size()+" empleados");
    }


    public static void main(String[] args) {
    Empresa e=new Empresa();
    Empleado emp1=new Empleado();
    Empleado emp2=new Empleado("luca","seijas", LocalDate.of(1965,4,2),LocalDate.of(2025,4,2),600000,new ArrayList<>());
    Producto p1=new Perecedero();
    Producto p2=new No_perecedero();
    emp1.getProductos_emp().add(p1);
    emp2.getProductos_emp().add(p1);
    emp2.getProductos_emp().add(p2);

    e.empleados.add(emp1);
    e.empleados.add(emp2);

    System.out.println("La empresa tiene que pagar: $" + e.sueldos_a_pagar());

    e.empleados_mayores_60();



    }
}
