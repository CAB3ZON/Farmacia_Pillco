/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Medicamento;
import vista.Mensaje_confirmacion;
import vista.Pantalla_ingreso;

/**
 *
 * @author USUARIO
 */
public class Controller_p_i {

    
    private Pantalla_ingreso view;
    private Medicamento model;
   public static ArrayList<Medicamento> lista = new ArrayList<>();

    public Controller_p_i(Pantalla_ingreso view, Medicamento model) {
        this.view = view;
        this.model = model;
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
        iniciar_control();
    }
    
    public void iniciar_control(){
        view.getBtn_ok().addActionListener(l->aceptar());
    }
    
    public void validacion(){
        if (view.getTxtnombre().getText().isEmpty()==true||view.getTxtcantidad().getText().isEmpty()==true||view.getRb_cofarma().isSelected()==false&&view.getRbcemefar().isSelected()==false&&view.getRbempshar().isSelected()==false) {
            JOptionPane.showMessageDialog(view, "COMPLETE EL FORMULARIO PORFAVOR");
        }
    }
    
    
    public void aceptar(){
        
        if (view.getTxtnombre().getText().isEmpty()==true||view.getTxtcantidad().getText().isEmpty()==true||view.getRb_cofarma().isSelected()==false&&view.getRbcemefar().isSelected()==false&&view.getRbempshar().isSelected()==false) {
            JOptionPane.showMessageDialog(view, "COMPLETE EL FORMULARIO PORFAVOR");
        }else{
    String nombre=view.getTxtnombre().getText();
    String tipo=view.getCombo_tipo().getSelectedItem().toString();
    String cantidad=view.getTxtcantidad().getText();
    String distribuidor="";
            
            if (view.getRb_cofarma().isSelected()==true) {
            distribuidor="COFARMA";
        }else{
                if (view.getRbcemefar().isSelected()==true) {
                    distribuidor="CEMEFAR";
                }else{
                    if (view.getRbempshar().isSelected()==true) {
                        distribuidor="EMPSEPHAR";
                    }
                }
            }
            
    String sucursal="";
        if (view.getChboxprincipal().isSelected()==true&&view.getChboxsecundaria().isSelected()==true) {
            sucursal="PRINCIPAL Y SECUNDARIA";
        }else{
        if (view.getChboxprincipal().isSelected()==true) {
            sucursal="PRINCIPAL";
        }else{
            if (view.getChboxsecundaria().isSelected()==true) {
                sucursal="SECUNDARIA";
            }
        }
        
        }
        
        //hacer que solo pueda ingresar numeros enteros en cantidad
        int cantidadx=Integer.parseInt(cantidad);
        
        Medicamento med=new Medicamento();
        med.setCantidad(cantidadx);
        med.setDistribuidor(distribuidor);
        med.setNombre(nombre);
        med.setSucursal(sucursal);
        med.setTipo(tipo);
        lista.add(med);
        
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).getNombre());
            }
            Mensaje_confirmacion mc=new Mensaje_confirmacion();
                        controller_mensaje cm=new controller_mensaje(mc,lista);

            mc.setVisible(true);
            
            
        System.out.println(">>>>>"+sucursal);
         }
    }
    
}
