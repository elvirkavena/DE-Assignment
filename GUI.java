import javax.swing.*;
import org.jfree.data.xy.XYSeries;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class GUI extends JFrame {   //JFrame for GUI

    public GUI(String step, String x, String y, String xf) {
        super("GUI");                                    //
        this.setSize(1390, 500);                   //
        this.setLocationRelativeTo(null);  // SOME STANDART STUFF IN MAKING GUI WINDOW
        this.setResizable(false);                 //
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//
        this.setVisible(true);                      //
        Container container = this.getContentPane();   // Adding container for this window
        container.setLayout(new FlowLayout());

        EulerMethod euler = new EulerMethod();
        euler.funct(Float.valueOf(step), Float.valueOf(x), Float.valueOf(y), Float.valueOf(xf));
        ImprovedEuler improvedEuler = new ImprovedEuler();
        improvedEuler.funct(Float.valueOf(step), Float.valueOf(x), Float.valueOf(y), Float.valueOf(xf));
        RungeKutta rungeKutta = new RungeKutta();
        rungeKutta.funct(Float.valueOf(step), Float.valueOf(x), Float.valueOf(y), Float.valueOf(xf));
        Exact exact = new Exact();
        exact.funct(Float.valueOf(step), Float.valueOf(x), Float.valueOf(y), Float.valueOf(xf));

        LinkedList<XYSeries> linkedListMethods = new LinkedList(); // Creating Linked List for methods solutions for chart
        linkedListMethods.addLast(euler.series1);
        linkedListMethods.addLast(improvedEuler.series1);
        linkedListMethods.addLast(rungeKutta.series1);
        linkedListMethods.addLast(exact.series1);

        Chart chartMethods = new Chart(); //Making chart for solution
        chartMethods.createChart(linkedListMethods, "Methods"); //Adding solutions to chart and name it Methods
        container.add(chartMethods.chartPanel);

        LinkedList<XYSeries> linkedListErrors = new LinkedList();
        linkedListErrors.addLast(euler.series2);
        linkedListErrors.addLast(improvedEuler.series2);
        linkedListErrors.addLast(rungeKutta.series2);

        Chart chartErrors = new Chart();
        chartErrors.createChart(linkedListErrors, "Errors");
        container.add(chartErrors.chartPanel);


    }
}