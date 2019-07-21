package restaurante;

import static java.lang.Math.min;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.* ;

public class Almacen extends Bodega {
    private double dineroDisp ;
    private ArrayList<Proveedor> proveedores ;
    private ArrayList<Factura> facturas ;
    private LocalDateTime ingreso ;
    private LocalDateTime vencimiento ;
    private ArrayList<Producto> inventario ;
    private boolean moverRobotsalida ;
    private boolean moverRobotentrada ;

    public Almacen(double dineroDisp, Robot robot) {
        super(robot) ;
        this.dineroDisp = dineroDisp;
        this.proveedores = new ArrayList<>();//al crear un proveedor hay que agregarlo con addProveedor
        this.facturas = new ArrayList<>() ;
        ingreso = null ;
        vencimiento = null ;
        this.inventario = new ArrayList<>() ;
        moverRobotsalida = false ;
        moverRobotentrada = false ;
    }

    @Override//EL PRODUCTO ES AGREGADO AL INVENTARIO DE PRODUCCION
    public boolean descargaProducto(String nombre, int cantidad) {
        int pos = -1 ;
        int cant = cantidad;
        
        for ( int i = 0 ; i < this.getInventario().size() ; i++ ){
            if(this.getInventario().get(i).nombre.equals(nombre)){
                pos = i ;
                cant = min( cantidad, this.getInventario().get(pos).cantidad ) ;//MINIMO ENTRE LO QUE HAY Y LO QUE PIDO
                for(int j = 0 ; j < cant ; j++ ){//los quito de aca y los agrego al inventario de produccion
                    LocalDateTime ingreso = this.getInventario().get(pos).getFechaVencimiento() ;
                    LocalDateTime vencimiento = this.getInventario().get(pos).getFechaIngreso() ;
                    this.ingreso = ingreso ;
                    this.vencimiento=vencimiento ;
                    this.getInventario().get(pos).cantidad-- ;
                }
                break ;
            }
        }
        if(pos != -1 ){
            System.out.println("Se descargaron " + cant + " productos.");
            return true ;
        } else {
            System.out.println("Producto no disponible");
            return false ;
        }
    }
    
    public boolean hacerPedido (ArrayList<String> productos, ArrayList<Integer> cantidades, LocalDateTime ingreso, LocalDateTime vencimiento){
        boolean f = true ;
        if(productos.size() != cantidades.size()){
            System.out.println("Las cantidades no coinciden");
            return false ;
        }
        for (int m = 0 ; m < productos.size() ; m++ ) {
            String producto = productos.get(m);
            int cantidad = cantidades.get(m) ;
            int pos = -1 ;
            for( int i = 0 ; i < this.getInventario().size() ; i++ ){
                if(this.getInventario().get(i).nombre.equals(producto)){
                    pos = i ;
                    break ;
                }
            }
            if(pos != -1){
                this.getInventario().get(pos).addProducto(ingreso, vencimiento, cantidad);
            }
            else{
                System.out.println("El producto " + producto + "no existe en el sistema");
                f = false ;
            }
        }
        return f ;
    }
    
    public ArrayList<Producto> consultarProxVencimiento(LocalDateTime hoy){
        ArrayList<Producto> porVencer = new ArrayList<>() ;
        for( int i = 0 ; i < this.inventario.size() ; i++ ){
            Producto producto = this.inventario.get(i) ;
            //System.out.println(producto.nombre);
            if(producto.getCantidad() > 0 ){
                long days = ChronoUnit.DAYS.between(hoy, producto.getFechaVencimiento()) ;
                long tiempo = 5 ;
                //System.out.println(days);
                if(days <= tiempo){
                    porVencer.add(producto);
                } 
            }
            
            
        }
        return porVencer ;
    }
    
    public ArrayList<Producto> consultarProxAcabar(){
        ArrayList<Producto> acabar = new ArrayList<>() ;
        for( Producto producto : this.getInventario()){
            if(producto.cantidad <= 3) acabar.add(producto) ;
        }
        return acabar ;
    }
    
    public ArrayList<Factura> listaFacturas(){
        return this.facturas ;
    }
    
    public boolean pagarFactura(Factura factura){
        return this.facturas.remove(factura) ;
    }
    
    public boolean addFactura( LocalDateTime fechaVencimiento, double valor, Proveedor proveedor){
        Factura factura = new Factura(fechaVencimiento, valor, proveedor) ;
        return this.facturas.add(factura) ;
    }

    public double getDineroDisp() {
        return dineroDisp;
    }

    public void setDineroDisp(double dineroDisp) {
        this.dineroDisp = dineroDisp;
    }


    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public boolean addProveedor(Proveedor proveedor) {
        return this.proveedores.add(proveedor);
    }   

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    public LocalDateTime getIngreso() {
        return ingreso;
    }

    public void setIngreso(LocalDateTime ingreso) {
        this.ingreso = ingreso;
    }

    public LocalDateTime getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(LocalDateTime vencimiento) {
        this.vencimiento = vencimiento;
    }

   
    
    public ArrayList<Producto> getInventario() {
        return this.inventario;
    }

    public boolean isMoverRobotsalida() {
        return moverRobotsalida;
    }

    public void setMoverRobotsalida(boolean moverRobotsalida) {
        this.moverRobotsalida = moverRobotsalida;
    }

    public boolean isMoverRobotentrada() {
        return moverRobotentrada;
    }

    public void setMoverRobotentrada(boolean moverRobotentrada) {
        this.moverRobotentrada = moverRobotentrada;
    }
    
}