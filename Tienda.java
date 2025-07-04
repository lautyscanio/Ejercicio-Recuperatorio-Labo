package Ejercicio_recuperatorio;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Tienda {
    private ArrayList<Producto> productos_tienda;
    private ArrayList<Empresa> proveedores;

    public Tienda(){
        this.productos_tienda=new ArrayList<>();
        this.proveedores=new ArrayList<>();
    }

    public ArrayList<Producto> getProductos_tienda() {
        return productos_tienda;
    }

    public void setProductos_tienda(ArrayList<Producto> productos_tienda) {
        this.productos_tienda = productos_tienda;
    }

    public ArrayList<Empresa> getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList<Empresa> proveedores) {
        this.proveedores = proveedores;
    }

    public void mostrar_vencidos(){
        for(Producto p:productos_tienda){
            if(p.vencido()){
                System.out.println("nombre: "+p.getNombre() + " marca: "+p.getMarca());
            }
        }
    }




    public void regalos(Empresa empresa){
        ArrayList<Producto>productos_a_entregar=new ArrayList<>();
        for(Empleado e: empresa.getEmpleados()){
            for(Producto p:e.getProductos_emp()){
                productos_a_entregar.add(p);
            }
        }

        for(int i=0; i<productos_a_entregar.size();i++){
            Producto p_actual=productos_a_entregar.get(i);

            boolean ya_mostrado=false;
            for(int j=0;j<i;j++){
                Producto p_contado=productos_a_entregar.get(j);
                if(p_contado.equals(p_actual)){
                    ya_mostrado=true;
                    break;
                }
            }
            if(!ya_mostrado){
                int contador=0;
                    for(int k=0;k<productos_a_entregar.size();k++){
                        Producto producto=productos_a_entregar.get(k);
                        if(producto.equals(p_actual)){
                            contador++;
                        }
                    }
                System.out.println("Nombre: "+ p_actual.getNombre() + ". Cantida requerida: "+contador);
            }
        }
    }


    public Empresa proveedor_con_mas_variedad(){
        int cant_prods_max=0;
        Empresa empresa_aux=proveedores.getFirst();
        for(Empresa e:proveedores) {
            int cantidad = e.getProductos_fabricados().size();
            if (cantidad > cant_prods_max) {
                cant_prods_max = cantidad;
                empresa_aux=e;
            }
        }
          return empresa_aux;
    }

    public void dias_para_vencer(Producto producto){

            if(producto instanceof Perecedero) {
                Perecedero p = (Perecedero) producto;
                System.out.println("para que tu producto venza faltan "+p.cuanto_falta_para_vencer() + " dias");
            }
            else {
                System.out.println("El producto es no perecedero");
            }
    }

    public String aplica_impuestos(){
        double suma=0;
        double porcentaje=productos_tienda.size()*0.45;
        String texto="";
        for(Producto producto:productos_tienda){
            if(producto instanceof No_perecedero){
                No_perecedero p= (No_perecedero) producto;
                if(p.isEnvoltorio_reciclable()){
                    suma++;
                }
            }
        }
        if(suma>=porcentaje){

             texto="Tu tienda tiene beneficio sobre impuestos";
             return texto;
        }
        else{
            texto="Tu tienda no tiene beneficio sobre impuestos";
            return texto;
        }
    }

    public static void main(String[] args) {
        Tienda t=new Tienda();
        Empresa e=new Empresa();
        Empleado emp1=new Empleado();
        Empleado emp2=new Empleado("luca","seijas", LocalDate.of(2007,4,2),LocalDate.of(2025,4,2),600000,new ArrayList<>());
        Producto p1=new Perecedero();
        Producto p2=new No_perecedero();
        emp1.getProductos_emp().add(p1);
        emp2.getProductos_emp().add(p1);
        emp2.getProductos_emp().add(p2);
        Perecedero p4=new Perecedero(1,"galletitas","chips",e,LocalDate.of(2025,4,2),1000,LocalDate.of(2026,6,3),7);
        t.productos_tienda.add(p4);
        t.productos_tienda.add(p2);
        t.dias_para_vencer(p4);

        System.out.println(t.aplica_impuestos());
    }
}
