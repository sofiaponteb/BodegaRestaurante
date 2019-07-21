
package restaurante;

import java.time.*;
import java.util.* ;

public class Factura {
    private LocalDateTime fechaVencimiento ;
    private double valor ;
    private Proveedor proveedor ;

    public Factura( LocalDateTime fechaVencimiento, double valor, Proveedor proveedor) {
        this.fechaVencimiento = fechaVencimiento;
        this.valor = valor;
        this.proveedor = proveedor ;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    
}
