package Ejercicio_recuperatorio;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    private ArrayList<Tienda> tiendas;

    public Main() {
        this.tiendas = new ArrayList<>();
    }

    public ArrayList<Tienda> getTiendas() {
        return tiendas;
    }

    public void setTiendas(ArrayList<Tienda> tiendas) {
        this.tiendas = tiendas;
    }

    public static void main(String[] args) {
        Tienda t=new Tienda();
        Empresa e=new Empresa();
        Empresa e2=new Empresa(new ArrayList<>(),"pareja 2313","Sancor co",new ArrayList<>());
        Producto p5=new Perecedero(4,"yogurt","sancor", e2,LocalDate.of(2025,2,2),2333,LocalDate.of(2026,3,3),4);
        e2.getProductos_fabricados().add(p5);

        Empleado emp1=new Empleado();
        Empleado emp2=new Empleado("luca","seijas", LocalDate.of(1965,4,2),LocalDate.of(2025,4,2),600000,new ArrayList<>());

        Producto p1=new Perecedero();
        Producto p2=new No_perecedero();

        emp1.getProductos_emp().add(p1);
        emp2.getProductos_emp().add(p1);
        emp2.getProductos_emp().add(p2);

        Perecedero p4=new Perecedero(1,"galletitas","chips",e,LocalDate.of(2025,4,2),1000,LocalDate.of(2026,6,3),7);
        Perecedero p3=new Perecedero(2,"Chocolatada","cindor",e,LocalDate.of(2024,4,2),1000,LocalDate.of(2025,7,3),7);

        t.getProductos_tienda().add(p4);
        t.getProductos_tienda().add(p2);
        t.getProductos_tienda().add(p3);

        e.getEmpleados().add(emp1);
        e.getEmpleados().add(emp2);

        t.getProveedores().add(e);

        //TIENDA
        System.out.println("Productos vencidos:"); t.mostrar_vencidos();
        t.dias_para_vencer(p4);

        System.out.println("La empresa tendra que regalar los siguientes productos con sus correspondientes cantidades: ");
        t.regalos(e);

        System.out.println("El proovedor que ofrece mas variedad de productos es: "+t.proveedor_con_mas_variedad().getNombre());

        System.out.println(t.aplica_impuestos());

        //EMPRESA
        System.out.println("La empresa tiene que pagar: $" + e.sueldos_a_pagar());
        e.empleados_mayores_60();

        //EMPLEADO
        System.out.println("Este empleado lleva "+emp1.anios_en_la_empresa()+ " anio/s en la empresa");

        //PERECEDERO
        p3.seguir_consumiendo();
    }
}
