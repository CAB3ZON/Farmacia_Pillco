/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Medicamento;
import vista.Mensaje_confirmacion;
import vista.Pantalla_ingreso;

/**
 *
 * @author USUARIO
 */
public class controller_mensaje {
 private Mensaje_confirmacion view;
    ArrayList<Medicamento> listax = new ArrayList<>();

    public controller_mensaje() {
    }

    public controller_mensaje(Mensaje_confirmacion view,ArrayList<Medicamento>lista) {
        listax=lista;
        this.view = view;
        this.view.setVisible(true);
                this.view.setLocationRelativeTo(null);
                
        iniciar_control();
    }

    
public void iniciar_control(){
    view.getLabel_numero().setText(Controller_p_i.lista.size()+"");
        view.getBtn_enviar().addActionListener(l->enviar());
        view.getBtncancelar().addActionListener(l->cancelar());
            view.getLabel_medicamento().setText(listax.get(0).getNombre());
             String cantidadx=String.valueOf(listax.get(0).getCantidad());
            view.getLabel_cantidad().setText(cantidadx);
            view.getLabel_tipo().setText(listax.get(0).getTipo());
            view.getLabel_distribuidor().setText(listax.get(0).getDistribuidor());
            String sucursal_seleccionada=listax.get(0).getSucursal();
                    String direccion="";
                    
            if (sucursal_seleccionada=="PRINCIPAL Y SECUNDARIA") {
        direccion="Para la  farmacia situada en Calle de la Rosa n.28 y para la situada en Calle Alcazabilla n.3";
    }
            if (sucursal_seleccionada=="PRINCIPAL") {
                direccion="Para la  farmacia situada en Calle de la Rosa n.28";
        
    }
            if (sucursal_seleccionada=="SECUNDARIA") {
                direccion="Para la  farmacia situada en Calle Alcazabilla n.3";
    }
            view.getLabel_direccion().setText(direccion);
           

    } 
public void enviar(){
    JOptionPane.showMessageDialog(view, "Pedido Enviado");
    this.view.dispose();
    Pantalla_ingreso pi=new Pantalla_ingreso();
        Medicamento me=new Medicamento();
        
        Controller_p_i contro=new Controller_p_i(pi, me);
        
}
public void cancelar(){
    this.view.dispose();
    Pantalla_ingreso pi=new Pantalla_ingreso();
        Medicamento me=new Medicamento();
        
        Controller_p_i contro=new Controller_p_i(pi, me);
}
}
