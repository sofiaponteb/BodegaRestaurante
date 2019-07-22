package restaurante;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.* ;

public class Restaurante {
    
    private ArrayList<Proveedor> proveedores = new ArrayList<>() ;
    ///*static */private ArrayList<Producto> productos ;
    /*static */private Almacen almacen ;
    /*static */private Produccion produccion ;
    private ArrayList<Robot> robots ;
    public LocalDateTime hoy ;
    private ArrayList<Producto> entradaProductos ;
    private ArrayList<Producto> cambioDeBodega ;
    private ArrayList<Producto> salidaProductos ;
    public int cnt ;
    public Double ventas ;
    
    /*
    static Proveedor proveedorAbarrotes ;
    static Proveedor proveedorCarnes ;
    static Proveedor proveedorLacteosGranja ;
    static Proveedor proveedorBebidasAlcoholicas ;
    static Proveedor proveedorBebidasNoAlcoholicas ;
    static Proveedor proveedorFruver ;
    */
    
    public Proveedor proveedorAbarrotes ;
    public Proveedor proveedorCarnes ;
    public Proveedor proveedorLacteosGranja ;
    public Proveedor proveedorBebidasAlcoholicas ;
    public Proveedor proveedorBebidasNoAlcoholicas ;
    public Proveedor proveedorFruver ;

    public Restaurante() {
        this.hoy = LocalDateTime.now() ;
        
        Robot robot1 = new Robot(100, 30, 300) ;
        Robot robot2 = new Robot(100, 30, 300) ;
        //this.productos = new ArrayList<>();
        this.almacen = new Almacen(7000000, robot1) ;
        this.produccion = new Produccion(robot2) ;
        this.robots = new ArrayList<>();
        this.entradaProductos = new ArrayList<>() ;
        
        this.proveedorAbarrotes = new Proveedor("Olimpica", 890107487, 7500500) ;
        this.proveedorCarnes = new Proveedor("Carnes_calidad", 310782928, 7438623) ;
        this.proveedorLacteosGranja = new Proveedor("Alpina", 532709690, 7650650) ;
        this.proveedorBebidasAlcoholicas = new Proveedor("Bavaria", 385080684, 7305636) ;
        this.proveedorBebidasNoAlcoholicas = new Proveedor("Postobon", 227480936, 8070647) ;
        this.proveedorFruver = new Proveedor("Surtifruver", 247385569, 8069368) ;
        
        proveedores.add(proveedorAbarrotes) ;
        proveedores.add(proveedorBebidasAlcoholicas) ;
        proveedores.add(proveedorBebidasNoAlcoholicas) ;
        proveedores.add(proveedorCarnes) ;
        proveedores.add(proveedorFruver) ;
        proveedores.add(proveedorLacteosGranja) ;
        
        almacen.getProveedores().add(proveedorAbarrotes) ;
        almacen.getProveedores().add(proveedorCarnes) ;
        almacen.getProveedores().add(proveedorLacteosGranja) ;
        almacen.getProveedores().add(proveedorBebidasAlcoholicas) ;
        almacen.getProveedores().add(proveedorBebidasNoAlcoholicas) ;
        almacen.getProveedores().add(proveedorFruver) ;
        
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
/*
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }*/

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }

    public ArrayList<Robot> getRobots() {
        return robots;
    }

    public void setRobots(ArrayList<Robot> robots) {
        this.robots = robots;
    }

    public Proveedor getProveedorAbarrotes() {
        return proveedorAbarrotes;
    }

    public void setProveedorAbarrotes(Proveedor proveedorAbarrotes) {
        this.proveedorAbarrotes = proveedorAbarrotes;
    }

    public Proveedor getProveedorCarnes() {
        return proveedorCarnes;
    }

    public void setProveedorCarnes(Proveedor proveedorCarnes) {
        this.proveedorCarnes = proveedorCarnes;
    }

    public Proveedor getProveedorLacteosGranja() {
        return proveedorLacteosGranja;
    }

    public void setProveedorLacteosGranja(Proveedor proveedorLacteosGranja) {
        this.proveedorLacteosGranja = proveedorLacteosGranja;
    }

    public Proveedor getProveedorBebidasAlcoholicas() {
        return proveedorBebidasAlcoholicas;
    }

    public void setProveedorBebidasAlcoholicas(Proveedor proveedorBebidasAlcoholicas) {
        this.proveedorBebidasAlcoholicas = proveedorBebidasAlcoholicas;
    }

    public Proveedor getProveedorBebidasNoAlcoholicas() {
        return proveedorBebidasNoAlcoholicas;
    }

    public void setProveedorBebidasNoAlcoholicas(Proveedor proveedorBebidasNoAlcoholicas) {
        this.proveedorBebidasNoAlcoholicas = proveedorBebidasNoAlcoholicas;
    }

    public Proveedor getProveedorFruver() {
        return proveedorFruver;
    }

    public void setProveedorFruver(Proveedor proveedorFruver) {
        this.proveedorFruver = proveedorFruver;
    }
    
    
    /*
    public Object[][] getSalidaProducto() {
        Object [] []res = new Object[productos.size()][2];
        for(int i=0;i< productos.size();++i)
        	res[i]=productos.get(i).getSalidaProducto();
        return res;
    }
    public Object[][] getIngresoPedido(Categoria a) {
        
        int cant = 0;
        for(int i=0;i< productos.size();++i)
        	if (productos.get(i).getCategoria()==a)
        		cant++;
        Object [][]res = new Object[cant][2];
        for(int i=0;i< productos.size();++i)
        	if (productos.get(i).getCategoria()==a)
        	{
        		res[--cant]=productos.get(i).getSalidaProducto();
        	}
        return res;
    }*/

    public LocalDateTime getHoy() {
        return hoy;
    }

    public void setHoy(LocalDateTime hoy) {
        this.hoy = hoy;
    }

    public ArrayList<Producto> getEntradaProductos() {
        return entradaProductos;
    }

    public void setEntradaProductos(ArrayList<Producto> entradaProductos) {
        this.entradaProductos = entradaProductos;
    }

    public ArrayList<Producto> getCambioDeBodega() {
        return cambioDeBodega;
    }

    public void setCambioDeBodega(ArrayList<Producto> cambioDeBodega) {
        this.cambioDeBodega = cambioDeBodega;
    }

    public ArrayList<Producto> getSalidaProductos() {
        return salidaProductos;
    }

    public void setSalidaProductos(ArrayList<Producto> salidaProductos) {
        this.salidaProductos = salidaProductos;
    }
    
}
