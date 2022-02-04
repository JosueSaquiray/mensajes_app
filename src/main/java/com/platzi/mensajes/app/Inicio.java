/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes.app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class Inicio {
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int opcion=0;
      
      do{
          mostrarMenu();
          opcion=sc.nextInt();
          switch (opcion) {
              case 1:
                  MensajeService.crearMensaje();
                  break;
              case 2:
                  MensajeService.listarMensaje();
                  break;    
              case 3:
                  MensajeService.borrarMensaje();
                  break;
              case 4:
                  MensajeService.editarMensaje();
                  break;
              default:
                  break;
          }
      }while(opcion!=5);
    }
    private static void mostrarMenu(){
        System.out.println("--------------");
        System.out.println("Aplicacion de mensajes");
        System.out.println("1.Crear mensaje");
        System.out.println("2.Listar mensaje");
        System.out.println("3.Eliminar mensaje");
        System.out.println("4.Editar mensaje");
        System.out.println("5.Salir");
    }
}
