package lagrangianinterpolation;

import java.util.ArrayList;
import java.util.LinkedList;

public class LagrangianInterpolation {
    private double result;
    private final ArrayList<DataPoint> array;
    private final LinkedList<CalculatorThread> threads;
    
    public LagrangianInterpolation() {
        array = new ArrayList<>();
        threads = new LinkedList<>();
        result = 0;
    }
    
    private void deployLikeABoss(double x) {
        CalculatorThread t;
        int iterVal = 0;
        for(DataPoint d : array) {
            t = new CalculatorThread(array, iterVal++, x, this);
            threads.add(t);
            t.start();
        }
    }
    
    protected void addValue(double res) {
        result += res;
    }
    
    public double estimate(double x) throws InterruptedException {
        result = 0;
        deployLikeABoss(x);
        for(CalculatorThread t : threads) {
            t.join();
        }
        return result;
    }
    
    public void addDataPoint(double x, double fx) {
        DataPoint d = new DataPoint(x, fx);
        array.add(d);
    }
    
    public static void main(String[] args) {
        DisplayBox.mainDeploy();
    }
}
