
package modelo;

/**
 *
 * @author DELL
 */
public class Proveedor {
    int id_proveedor;
    String nombre_Proveedor;
    String direccion;
    int telefono;

    public Proveedor() {
    }

    public Proveedor(int id_proveedor, String nombre_Proveedor, String direccion, int telefono) {
        this.id_proveedor = id_proveedor;
        this.nombre_Proveedor = nombre_Proveedor;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_Proveedor() {
        return nombre_Proveedor;
    }

    public void setNombre_Proveedor(String nombre_Proveedor) {
        this.nombre_Proveedor = nombre_Proveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
}
