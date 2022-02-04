/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class MensajeDAO {
    public static void crearMensajeDB(Mensaje mensaje){
        Conexion db_conect=new Conexion();
        try(Connection conexion=db_conect.getConnection()){
            PreparedStatement ps=null;
          
            String query="INSERT INTO mensajes (mensaje,autor_mensaje) VALUES (?,?)";
            ps=conexion.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getAutor_mensaje());
            ps.executeUpdate();
            System.out.println("Mensaje Creado!!!");
            
        }catch(SQLException e){
            System.out.println(e);    
        }
    }
   public static ArrayList<Mensaje> leerMensajesDB(){
       ArrayList listaMensajes=new ArrayList();
       Conexion db_conect=new Conexion();
       PreparedStatement ps=null;
       ResultSet rs=null;
        
       try(Connection conexion=db_conect.getConnection()){
            String query="SELECT * FROM mensajes ";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();
            
            while(rs.next()){
                int idMsg=rs.getInt("id_mensaje");
                String msg=rs.getString("mensaje");
                String autor=rs.getString("autor_mensaje");
                String fecha=rs.getString("fecha_mensaje");
                
                Mensaje ms=new Mensaje(idMsg, msg, autor, fecha);
                listaMensajes.add(ms);
            }
            System.out.println("Mensajes Recibidos!!!");
            
        }catch(SQLException e){
            System.out.println("No se pudieron recuperar los mensajes.");
            System.out.println(e);    
        }
       return listaMensajes;
    }
   public static void borrarMensajesDB(int idMensaje){
       Conexion db_conect=new Conexion();
       PreparedStatement ps=null;
        try(Connection conexion=db_conect.getConnection()){
            String query="DELETE FROM mensajes WHERE mensajes.id_mensaje= ?";
            ps=conexion.prepareStatement(query);
            ps.setInt(1, idMensaje);
            int countRowsUpdated = ps.executeUpdate();
            if (countRowsUpdated != 0) {
                  System.out.println("Mensaje con el id="+idMensaje+" eliminado");
            }else {
                  System.out.println("No fue encontrado el mensaje con id="+idMensaje);
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("No se pudo borrar el mensaje.");
        }
    }
   public static void actualizarMensajesDB(Mensaje mensaje){
       Conexion db_conect=new Conexion();
       PreparedStatement ps=null;
        try(Connection conexion=db_conect.getConnection()){
            String query="UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
            ps=conexion.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setInt(2,mensaje.getId_mensaje());
            int countRowsUpdated = ps.executeUpdate();
            if (countRowsUpdated != 0) {
                  System.out.println("Mensaje con el id="+mensaje.getId_mensaje()+" actualizado");
            }else {
                  System.out.println("No fue encontrado el mensaje con id="+mensaje.getId_mensaje());
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("No se pudo actualizar el mensaje.");
        }
    }
   
   
}
