package Ejercicio_recuperatorio;

import java.time.LocalDate;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private LocalDate f_nacimiento;

    public Persona(){
        this.nombre = "pepo";
        this.apellido = "de santis";
        this.f_nacimiento = LocalDate.of(2005,3,3);
    }

    public Persona(String nombre, String apellido, LocalDate f_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.f_nacimiento = f_nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(LocalDate f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }
}
