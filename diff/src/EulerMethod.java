import org.jfree.data.xy.XYSeries;

public class EulerMethod implements AbstractClass{

    public EulerMethod(){}

    //Series of method
    XYSeries series1;
    //Series of method's error
    XYSeries series2;

    public void funct(Float step, Float x, Float y, Float xf){
        //Calculating points that satisfy to Euler's Method and adding them to the series1
        //and points that satisfy to Euler's Method error and adding them to the series2:
        series1 = new XYSeries("Euler's Method");
        series1.add(x, y);
        series2 = new XYSeries("Euler's Method Error");
        series2.add(x, y);
        float e = 2.71828f;
        float sum = 0f;
        for(float i = x; i <= xf; i += step){
            series1.add(i,y + step*my_function(y,i));

            double k = y + step*my_function(y,i);
            System.out.println(i + "  " + k);
            series2.add(i,y + step*my_function(y,i) - Math.pow((2*Math.pow(e,i)-1),2));
            sum +=Math.abs( y + step*my_function(y,i) - Math.pow((2*Math.pow(e,i)-1),2));
            double f = step*my_function(y,i);
            y += (float)f;
        }
        sum/= ((xf-x)/step);
        System.out.println(sum);
    }
    public float my_function(double y,float x){
        float e = 2.71828f;
        double f = 2*y+2*Math.sqrt(y);
        return (float)f;
    }
}