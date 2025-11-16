import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Producto> productos;

    public Tienda() {
        productos = new ArrayList<Producto>();
        predefinir();
    }

    //agregamos los productos predeterminados con sus respectivos datos
    public void predefinir() {
        Producto p1 = new Producto(10,"Refrigeradora",400.50f,15,20,18);
        Producto p2 = new Producto(11,"Television",399.99f,45,38,52);
        Producto p3 = new Producto(14,"Cocina",680.00f,22,19,25);
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
    }

    //Agregamos un nuevo producto
    public void agregarProducto(Producto p){
        productos.add(p);
    }

    //Aplicamos la busqueda lineal por ID
    public Producto buscarPorId(int id){
        for(Producto p : productos){
            if(p.getId()==id){
                return p;
            }
        }
        return null;
    }

    //Hacemos lo mismo pero para la busqueda por nombre
    public Producto buscarPorNombre(String nombre){
        for(Producto p : productos){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            }
        }
        return null;
    }

    //Actualizamos el precio de un producto
    public boolean actualizarPrecio(int id, float nuevoPrecio){
        Producto p = buscarPorId(id);
        if(p!=null){
            p.setPrecio(nuevoPrecio);
            return true;
        }
        return false;
    }

    //Registrar la venta en un mes seleccionado
    public boolean registrarVenta(int id, int mes, int cantidad){
        Producto p = buscarPorId(id);
        if(p !=null && mes >= 1 && mes <=3){
            switch(mes){
                case 1:
                    p.setVentasMes1(p.getVentasMes1()+cantidad);
                    break;
                case 2:
                    p.setVentasMes2(p.getVentasMes2()+cantidad);
                    break;
                case 3:
                    p.setVentasMes3(p.getVentasMes3()+cantidad);
                    break;
            }
            return true;
        }
        return false;
    }


    public List<Producto> getProductos() {
        return productos;
    }
}
