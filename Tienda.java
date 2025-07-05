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

    //Ejercicio 2
    public void mostrar_vencidos(){
        for(Producto p:productos_tienda){
            if(p.vencido()){
                System.out.println("nombre: "+p.getNombre() + " marca: "+p.getMarca());
            }
        }
    }



    //Ejercicio 3
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

    //Ejercicio 4
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

    //Ejercicio 6
    public void dias_para_vencer(Producto producto){

            if(producto instanceof Perecedero) {
                Perecedero p = (Perecedero) producto;
                System.out.println("para que tu producto venza faltan "+p.cuanto_falta_para_vencer() + " dias");
            }
            else {
                System.out.println("El producto es no perecedero");
            }
    }

    //Ejercicio 7
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
    }
}
