import org.jfree.data.xy.XYSeries;

public class ImprovedEuler implements AbstractClass{

    public ImprovedEuler(){}

    //Series of method
    XYSeries series1;
    //Series of method's error
    XYSeries series2;

    public void funct(Float step, Float x, Float y, Float xf){
        //Calculating points that satisfy to Improved Euler's Method and adding them to the series1
        //and points that satisfy to Improved Euler's Method error and adding them to the series2:
        series1 = new XYSeries("Improved Euler's Method");
        series1.add(x, y);
        series2 = new XYSeries("Improved Euler's Method Error");
        series2.add(x, y);
        float e = 2.71828f;
        for(float i = x+step; i < xf; i += step){
            float k1 = step*my_function(y,x);
            float k2 = step*my_function(y+k1/2, x + step/2);
            y+=k2;
            series1.add(i, y);
            series2.add(i,Math.abs(y - Math.pow((2*Math.pow(e,i)-1),2) ));
        }
    }
    public float my_function(double y,float x){
        float e = 2.71828f;
        double f = 2*y+2*Math.sqrt(y);
        return (float)f;
    }
}