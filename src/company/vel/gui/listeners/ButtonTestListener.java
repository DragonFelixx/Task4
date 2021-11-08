package company.vel.gui.listeners;

import company.vel.gui.Graph;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTestListener implements ActionListener
{
    Graph graph;

    public ButtonTestListener(JButton buttonTest, JPanel panelPerformance)
    {
        graph = new Graph(buttonTest, panelPerformance);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int[] sizes = {100, 200, 500, 800, 1000, 2000, 3000, 6000, 7000, 8000, 9000};
        graph.performanceTestDemo(sizes);
    }
}
