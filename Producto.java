public class Producto {
    private int id;
    private String nombre;
    private float precio;
    private int ventasMes1;
    private int ventasMes2;
    private int ventasMes3;
    //Constructores
    public Producto(int id, String nombre, float precio, int ventasMes1, int ventasMes2, int ventasMes3) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ventasMes1 = ventasMes1;
        this.ventasMes2 = ventasMes2;
        this.ventasMes3 = ventasMes3;
    }
    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getVentasMes1() {
        return ventasMes1;
    }

    public void setVentasMes1(int ventasMes1) {
        this.ventasMes1 = ventasMes1;
    }

    public int getVentasMes2() {
        return ventasMes2;
    }
    
    public void setVentasMes2(int ventasMes2) {
        this.ventasMes2 = ventasMes2;
    }

    public int getVentasMes3() {
        return ventasMes3;
    }

    public void setVentasMes3(int ventasMes3) {
        this.ventasMes3 = ventasMes3;
    }
    // Calcula el total de ventas en los tres meses
    public int getTotalVentas() {
        return ventasMes1 + ventasMes2 + ventasMes3;
    }
    // Devuelve la informacion del producto 
    @Override
    public String toString() {
        return "ID: " + id + " | " + nombre + " | $" + precio +
                " | Ventas: M1=" + ventasMes1 + " M2=" + ventasMes2 +
                " M3=" + ventasMes3 + " | Total: " + getTotalVentas();
    }
}
