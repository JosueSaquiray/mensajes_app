/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hp
 */
public class Conexion {
    public Connection getConnection(){
        Connection connection=null;
        if(connection==null){
            try{
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        return connection;
    }
}
