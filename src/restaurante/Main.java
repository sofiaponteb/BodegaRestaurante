/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.io.*;
import java.util.*;

import Vista.Sistema;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 *
 * @author DELL
 */
public class Main {
    public Restaurante restaurante ;
    //public static LocalDateTime hoy ;

    public Main(Restaurante restaurante) {
        this.restaurante = restaurante;
        //this.hoy = LocalDateTime.now() ;
    }
    
    public static void main(String[] args) throws IOException {
        Restaurante laCocinaDeAna = new Restaurante() ;
        
        //LocalDateTime vencimiento = LocalDateTime.of(2019, 07, 17, 0, 0) ;
        //LocalDateTime today = LocalDateTime.now() ;
        //long days = ChronoUnit.DAYS.between(today, vencimiento) ;
 
        Main iniciar ;
        iniciar = new Main(laCocinaDeAna);
        Main.leerProductos(laCocinaDeAna);
        Main.leer(laCocinaDeAna);
        //Main.llenarCocina(laCocinaDeAna) ;
        
        Sistema sis= new Sistema(laCocinaDeAna);
        sis.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                try { 
                    escribir(laCocinaDeAna);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.exit(0);
            }
        });

        //escribir(laCocinaDeAna);
       
//        for(int i = 0 ; i < laCocinaDeAna.getProductos().size() ; i++ ){
//            System.out.println(laCocinaDeAna.getProductos().get(i).getNombre());
//        }
    }
    
    public static void escribir(Restaurante restaurante) throws FileNotFoundException{
        File file = new File("actualizar1.txt") ;
        PrintStream s = new PrintStream(file) ;
        s.println(restaurante.cnt + "," + restaurante.ventas);
        for( int i = 0 ; i < restaurante.getAlmacen().getInventario().size() ; i++ ){
            s.println(restaurante.getAlmacen().getInventario().get(i).nombre + "," + restaurante.getAlmacen().getInventario().get(i).cantidad);
            s.flush();
        }
        s.close();
    }
    
    public static void leer (Restaurante restaurante) throws NumberFormatException, IOException{//agrego a productos y almacen
            FileReader file ;
            file = new FileReader("actualizar.txt") ;
            BufferedReader archivo = new BufferedReader (file) ;
            String linea;
            linea = archivo.readLine() ;
            String [] dividido = linea.split(",");
            restaurante.cnt = Integer.parseInt(dividido[0]) ;
            restaurante.ventas = Double.parseDouble(dividido[1]) ;
            while((linea = archivo.readLine())!= null){
            	dividido = linea.split(",");
                String nombre = dividido[0] ;
                int cantidad = Integer.parseInt(dividido[1]) ;
                LocalDateTime fechaven = LocalDateTime.of(Integer.parseInt(dividido[2]),Integer.parseInt(dividido[3]), Integer.parseInt(dividido[4]), 0, 0) ;
                for ( int i = 0 ; i < restaurante.getAlmacen().getInventario().size() ; i++ ){
                    if(restaurante.getAlmacen().getInventario().get(i).getNombre().equals(nombre)){
                        //restaurante.getProductos().get(i).setCantidad(cantidad);
                        restaurante.getAlmacen().getInventario().get(i).addProducto(restaurante.hoy, fechaven, cantidad);
                        //restaurante.getProduccion().getInventario().get(i).setCantidad(0);
                        break ;
                    }
                }
            }
            archivo.close();
        
    }
    
    public static void llenarCocina(Restaurante restaurante){
       for( int i = 0 ; i < restaurante.getProduccion().getInventario().size() ; i++) 
           restaurante.getProduccion().getInventario().get(i).setCantidad(0);
    }
    

    public static void leerProductos (Restaurante restaurante) throws NumberFormatException, IOException{

        FileReader file = new FileReader("productos.txt");
        BufferedReader archivo = new BufferedReader (file) ;
        String linea;
        while((linea = archivo.readLine())!= null){
        	String [] dividido = linea.split(",");
            String nombre = dividido[0] ;
            double peso = Double.parseDouble(dividido[1]) ;
            
            Categoria categoria = null ;
            String s = dividido[2] ;
            Proveedor proveedor = null ;
            if(s.equals("carnes")){
                categoria =  Categoria.carnes ;
                proveedor = restaurante.proveedorCarnes ;
            }
            if(s.equals("abarrotes")){
                categoria = Categoria.abarrotes ;
                proveedor = restaurante.proveedorAbarrotes ;
            }
            if(s.equals("lacteosgranja")){
                categoria = Categoria.lacteosGranja ;
                proveedor = restaurante.proveedorLacteosGranja ;
            }
            if(s.equals("bebidasAlcoholicas")){
                categoria = Categoria.bebidasAlcoholicas ;
                proveedor = restaurante.proveedorBebidasAlcoholicas ;
            }
            if(s.equals("bebidasNoAlcoholicas")){
                categoria = Categoria.bebidasNoAlcoholicas ;
                proveedor = restaurante.proveedorBebidasNoAlcoholicas ;
            }
            if(s.equals("fruver")){
                categoria = Categoria.fruver ;
                proveedor = restaurante.proveedorFruver ;
            }
            
            double precio = Double.parseDouble(dividido[3]) ;
            boolean refri = Boolean.parseBoolean(dividido[4]) ;
            boolean cong = Boolean.parseBoolean(dividido[5]) ;
            boolean tamb = Boolean.parseBoolean(dividido[6]) ;
            int smin = Integer.parseInt(dividido[7]) ;
            int smax = Integer.parseInt(dividido[8]) ;
            Producto producto1 = new Producto(nombre, peso, precio, smin, smax, refri, cong, tamb, categoria, proveedor) ;
            Producto producto2 = new Producto(nombre, peso, precio, smin, smax, refri, cong, tamb, categoria, proveedor) ;
            //restaurante.getProductos().add(producto) ;
            restaurante.getAlmacen().getInventario().add(producto1) ;
            restaurante.getProduccion().getInventario().add(producto2) ;
            
            
        }

    }

}
