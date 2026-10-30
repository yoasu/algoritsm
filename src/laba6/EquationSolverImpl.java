package laba6;

public class EquationSolverImpl {
    public double solve(double a){
        double left  = 0.0;
        double right = a;
        double epsil = 1e-7;
        while(right - left > epsil){
            double mid = left + (right - left) / 2.0;
            double value = f(mid);
            if(value < a){
                left = mid;
            }
            else{
                right = mid;
            }

        }
        return left;
    }
    private double f(double x){
        return x * x - x + Math.sqrt(x);
    }
}
