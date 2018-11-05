import org.jfree.data.xy.XYSeries;

public class Exact implements AbstractClass{

    public Exact(){}

    //Series of exact solution
    XYSeries series1;

    public void funct(Float step, Float x, Float y, Float xf){
        //Calculating points that satisfy to Exact solution and adding them to the series:
        series1 = new XYSeries("Exact");
        float e = 2.71828f;
        for(float i = x; i <= xf; i += step) {
            double f = Math.pow((2*Math.pow(e,x)-1),2);
            series1.add(i, f);
        }
    }
}