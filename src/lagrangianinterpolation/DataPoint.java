package lagrangianinterpolation;

public class DataPoint {
    private double x;
    private double fx;
    
    public DataPoint() {
        x = fx = 0;
    }
    
    public DataPoint(double x, double fx) {
        this.x = x;
        this.fx = fx;
    }
    
    public void setX(double x) { this.x =x; }
    public void setFX(double fx) { this.fx = fx; }
    public double getX() { return x; }
    public double getFX() { return fx; }
}
