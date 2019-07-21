
package restaurante;
import java.util.* ;
public abstract class Bodega {
    
    private Robot robot ;

    public abstract boolean descargaProducto(String nombre, int cantidad) throws Exception;


    public Bodega(Robot robot) {
        //this.inventario = new ArrayList<>() ;
        this.robot = robot;
        
    }
    
    
}
