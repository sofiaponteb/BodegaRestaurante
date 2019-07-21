package restaurante;

import java.time.LocalDateTime;
import java.util.* ;

public class Producto {
    private LocalDateTime fechaIngreso ;
    private LocalDateTime fechaVencimiento ;
    private double peso ;
    private int stockMinimo ;
    private int stockMaximo ;
    public boolean refrigerado ;
    public boolean congelado ;
    public boolean tempAmbiente ;
    public int cantidad ;
    public String nombre ;
    private Categoria categoria ;
    private Proveedor proveedor ;
    private double precio ;

    public Producto( String nombre, double peso, double precio, int stockMinimo, int stockMaximo,
            boolean refrigerado, boolean congelado, boolean tempAmbiente, Categoria categoria, Proveedor proveedor ) {
        this.peso = peso;
        this.precio = precio ;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.refrigerado = refrigerado;
        this.congelado = congelado;
        this.tempAmbiente = tempAmbiente;
        this.cantidad = 0;
        this.nombre = nombre;
        this.categoria = categoria ;
        this.proveedor = proveedor ;
        this.fechaIngreso = null ;
        this.fechaVencimiento = null ;
    }
    
    public void addProducto(LocalDateTime fechaIngreso, LocalDateTime fechaVencimiento, int cantidad){
        this.cantidad += cantidad ;
        this.fechaIngreso = fechaIngreso;
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    public boolean isCongelado() {
        return congelado;
    }

    public void setCongelado(boolean congelado) {
        this.congelado = congelado;
    }

    public boolean isTempAmbiente() {
        return tempAmbiente;
    }

    public void setTempAmbiente(boolean tempAmbiente) {
        this.tempAmbiente = tempAmbiente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

   

 

  

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    public Object[] getSalidaProducto() {
        Object [] res = new Object[2];
        res[0]=nombre;
        res[1]="0";
        return res;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}