/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes.app;

import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class MensajeService {
    public static void crearMensaje(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe tu mensaje: ");
        String mensajeContenido=sc.nextLine();
        System.out.println("Escribe tu nombre: ");
        String nombre=sc.nextLine();
        
        Mensaje mensaje=new Mensaje();
        mensaje.setMensaje(mensajeContenido);
        mensaje.setAutor_mensaje(nombre);
        MensajeDAO.crearMensajeDB(mensaje);
        
    }
    public static void listarMensaje(){
        
    }
    public static void borrarMensaje(){
        
    }
    public static void editarMensaje(){
        
    }
}
