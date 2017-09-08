package lagrangianinterpolation;

import static java.lang.System.err;
import java.util.ArrayList;

public class CalculatorThread extends Thread {
    private final ArrayList<DataPoint> array;
    private final int iterVal;
    private final double x;
    private double result;
    private final LagrangianInterpolation parent;
    
    public CalculatorThread(ArrayList<DataPoint> array, int iterVal, double x,
            LagrangianInterpolation parent) {
        this.array = array;
        this.iterVal = iterVal;
        this.x = x;
        this.parent = parent;
    }
    
    @Override
    public void run() {
        try {
            result = 1;
            DataPoint d;
            for(int i = 0; i < array.size(); i++) {
                d = array.get(i);
                if(i != iterVal) {
                    result *= (x - d.getX())/(array.get(iterVal).getX() - d.getX());
                }
            }
            result *= array.get(iterVal).getFX();
            parent.addValue(result);
        } catch(Exception e) {
            err.println(e.getMessage() + " " + e.toString());
        }
    }
}
