
package restaurante;


public class Robot {
    private double nivelCarga ;
    private int posicionX ;
    private int posicionY ;
    private int inicioX ;
    private int inicioY ;
    public static int recargaX = 0 ;
    public static int recargaY = 0 ;
    
    public boolean recargar(){
        //SE MUEVE AL PUNTO DE RECARGA
        
        return this.posicionX == recargaX && this.posicionY == recargaY ;
    }
    
    public boolean volverAlInicio(){
        
        return this.posicionX == this.inicioX && this.posicionY == this.inicioY ;
    }

    public Robot(double nivelCarga, int posicionX, int posicionY) {
        this.nivelCarga = nivelCarga;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public double getNivelCarga() {
        return nivelCarga;
    }

    public void setNivelCarga(double nivelCarga) {
        this.nivelCarga = nivelCarga;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
    
    
}
