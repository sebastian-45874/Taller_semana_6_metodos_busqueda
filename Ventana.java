import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel panel;
    private JList list1;
    private JTextField txtId;
    private JButton btnId;
    private JTextField txtNombre;
    private JButton btnNombre;
    private JTextField txtActualizarPrecio;
    private JButton btnActualizarPrecio;
    private JComboBox cboMes;
    private JTextField txtCantidad;
    private JButton btnMostrar;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblActualizarPrecio;
    private JLabel lblRegistrarVenta;
    private JLabel lblMes;
    private JLabel lblCantidad;

    Tienda tienda = new Tienda();

    public void llenarLista(){
        DefaultListModel dlm = new DefaultListModel();
        for(Producto p : tienda.getProductos()){
            dlm.addElement(p);
        }
        list1.setModel(dlm);
    }

    public Ventana() {


        llenarLista();

        btnId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(txtId.getText());
                    Producto encontrado = tienda.buscarPorId(id);

                    DefaultListModel dlm = new DefaultListModel();
                    if(encontrado != null){
                        dlm.addElement(encontrado);
                        JOptionPane.showMessageDialog(null,"Producto encontrado");
                        list1.setModel(dlm);
                    }else {
                        JOptionPane.showMessageDialog(null,"Producto no encontrado");
                    }
                } catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Ingrese un ID valido");
                }
            }
        });


        btnNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText().trim();
                if(nombre.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Ingrese un  nombre");
                    return;
                }

                Producto encontrado = tienda.buscarPorNombre(nombre);

                DefaultListModel dlm = new DefaultListModel();
                if(encontrado != null){
                    dlm.addElement(encontrado);
                    JOptionPane.showMessageDialog(null,"Producto encontrado");
                    list1.setModel(dlm);
                } else{
                    JOptionPane.showMessageDialog(null,"Producto no encontrado");
                }
            }
        });

        btnActualizarPrecio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Producto producto = null;

                    if (!txtId.getText().trim().isEmpty()) {
                        int id = Integer.parseInt(txtId.getText());
                        producto = tienda.buscarPorId(id);
                    } else if (!txtNombre.getText().trim().isEmpty()) {
                        String nombre = txtNombre.getText().trim();
                        producto = tienda.buscarPorNombre(nombre);
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un ID o un Nombre");
                        return;
                    }

                    if (producto != null) {
                        float nuevoPrecio = Float.parseFloat(txtActualizarPrecio.getText());

                        if (tienda.actualizarPrecio(producto.getId(), nuevoPrecio)) {
                            JOptionPane.showMessageDialog(null, "¡Precio actualizado correctamente!");
                            llenarLista();
                            txtActualizarPrecio.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un precio válido");
                }
            }
        });


        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtCantidad.getText().trim().isEmpty()) {
                    try {
                        Producto producto = null;

                        String idTexto = txtId.getText().trim();
                        String nombreTexto = txtNombre.getText().trim();

                        if (!idTexto.isEmpty()) {
                            int id = Integer.parseInt(idTexto);
                            producto = tienda.buscarPorId(id);
                        } else if (!nombreTexto.isEmpty()) {
                            producto = tienda.buscarPorNombre(nombreTexto);
                        }

                        if (producto != null) {
                            String mesTexto = cboMes.getSelectedItem().toString();
                            int mes = Integer.parseInt(mesTexto.replace("Mes ", "").replace("MES ", "").trim());
                            int cantidad = Integer.parseInt(txtCantidad.getText());

                            if (tienda.registrarVenta(producto.getId(), mes, cantidad)) {
                                JOptionPane.showMessageDialog(null,
                                        "Venta registrada correctamente\n" +
                                                "Producto: " + producto.getNombre() + "\n" +
                                                "Mes: " + mes + "\n" +
                                                "Cantidad agregada: " + cantidad);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Producto no encontrado. Ingrese ID o Nombre valido");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Error: Verifique que los datos sean validos");
                    }
                }
                llenarLista();

                txtId.setText("");
                txtNombre.setText("");
                txtActualizarPrecio.setText("");
                txtCantidad.setText("");
            }
        });
    }

    private void setContentPane(JPanel panel) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
