package company.vel.gui;

import org.jfree.chart.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import company.vel.PerformanceTest;

public class Graph
{
    JButton buttonTest;
    JPanel panelPerformance;
    ChartPanel chartPanel = null;

    public Graph(JButton buttonTest, JPanel panelPerformance)
    {
        this.buttonTest = buttonTest;
        this.panelPerformance = panelPerformance;
    }

    private void customizeChartDefault(JFreeChart chart)
    {
        XYPlot plot = chart.getXYPlot();
        XYDataset ds = plot.getDataset();

        for (int i = 0; i < ds.getSeriesCount(); i++)
        {
            chart.getXYPlot().getRenderer().setSeriesStroke(i, new BasicStroke(1));
        }

        Font font = buttonTest.getFont();
        chart.getLegend().setItemFont(font);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.getRangeAxis().setTickLabelFont(font);
        plot.getRangeAxis().setLabelFont(font);
        plot.getDomainAxis().setTickLabelFont(font);
        plot.getDomainAxis().setLabelFont(font);
    }

    public void performanceTestDemo(int[] sizes)
    {
        int length = sizes.length;
        double[] result = PerformanceTest.performanceTest(sizes);
        DefaultXYDataset ds = new DefaultXYDataset();
        double[][] data = new double[2][length];
        data[0] = Arrays.stream(sizes).asDoubleStream().toArray();
        System.arraycopy(result, 0, data[1], 0, length);
        ds.addSeries("Shell sort", data);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Быстродействие сортировки",
                "Размерность массива, элементов",
                "Время выполнения, мс",
                ds
        );
        customizeChartDefault(chart);

        if (chartPanel == null)
        {
            chartPanel = new ChartPanel(chart);
            panelPerformance.add(chartPanel, BorderLayout.CENTER);
            panelPerformance.updateUI();
        } else
        {
            chartPanel.setChart(chart);
        }
    }
}
