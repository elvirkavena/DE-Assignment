import org.jfree.data.xy.XYSeries;

public class RungeKutta implements AbstractClass {

    public RungeKutta(){}

    //Series of method
    XYSeries series1;
    //Series of method's error
    XYSeries series2;

    public void funct(Float step, Float x, Float y, Float xf){
        //Calculating points that satisfy to Runge-Kutta's Method and adding them to the series1
        //and points that satisfy to Runge-Kutta's Method error and adding them to the series2:
        series1 = new XYSeries("Runge-Kutta's Method");
        series1.add(x, y);
        series2 = new XYSeries("Runge-Kutta's Method Error");
        series2.add(x, y);
        float k1, k2, k3, k4;
        float e = 2.71828f;
        for(float i = x+step; i < xf; i += step){
            k1 = my_function(y,x);
            k2 = my_function(y+step*k1/2, x+step/2);
            k3 = my_function(y+step*k2/2, x+step/2);
            k4 = my_function(y+step*k2, x+step);
            series1.add(i, y+step/6*(k1+2*k2+2*k3+k4));
            series2.add(i, y+step/6*(k1+2*k2+2*k3+k4) -  Math.pow((2*Math.pow(e,i)-1),2));
            y += step/6*(k1+2*k2+2*k3+k4);
            if (y>30)
                break;
        }
    }
    public float my_function(float y,float x){
        float e = 2.71828f;
        double f = 2*y+2*Math.sqrt(y);
        return (float)f;
    }
}