package restaurante;

import static java.lang.Math.*;
import java.time.LocalDateTime;
import java.util.* ;
public class Produccion extends Bodega{
    
    private ArrayList<Producto> inventario ;
    private boolean moverRobotSalida ;
    
    public Produccion(Robot robot) {
        super(robot);
        this.inventario = new ArrayList<>() ;
        moverRobotSalida = false ;
    }

    @Override//EL PRODUCTO SE ELIMINA DEL SISTEMA
    public boolean descargaProducto (String nombre, int cantidad) throws Exception  {
        int pos = -1 ;
        int cant = cantidad;
        for ( int i = 0 ; i < this.getInventario().size() ; i++ ){
            if(this.getInventario().get(i).nombre.equals(nombre)){
                //producto = this.getInventario().get(i) ;
                pos = i ;
                cant = min( cantidad, this.getInventario().get(pos).cantidad ) ;//MINIMO ENTRE LO QUE HAY Y LO QUE PIDO
                for( int j = 0 ; j < cant ; j++ ){// ELIMINO LOS PRODUCTOS QUE ENTRARON PRIMERO
                    
                    this.getInventario().get(pos).cantidad-- ;
                }
                break ;
            }
        }
        if(pos != -1 ){
        	throw new Exception ("Se descargaron " +nombre+" "+ cant + " productos.");
        } else {
            return false ;
        }
    }
    
    public boolean ingresoProducto(String nombre, int cantidad, LocalDateTime ingresos, LocalDateTime vencimientos){
        int pos = -1 ;
        int cant = cantidad;
        int f = 0 ;
        for ( int i = 0 ; i < this.getInventario().size() ; i++ ){
            if(this.getInventario().get(i).nombre.equals(nombre)){
                for(int j = 0 ; j < cant ; j++ ){
                    
                    this.getInventario().get(pos).setFechaIngreso(ingresos);
                    this.getInventario().get(pos).setFechaVencimiento(vencimientos);
                    this.getInventario().get(pos).cantidad++ ;
                    f++ ;
                }
                break ;
            }
        }
        
        return f == cant;
        
    }
    
    public ArrayList<Producto> getInventario() {
        return this.inventario;
    }

    public boolean isMoverRobotSalida() {
        return moverRobotSalida;
    }

    public void setMoverRobotSalida(boolean moverRobotSalida) {
        this.moverRobotSalida = moverRobotSalida;
    }
    
}