package company.vel.gui;

import company.vel.gui.listeners.ButtonSortListener;
import company.vel.gui.listeners.ButtonTestListener;


import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame
{
    private JPanel panel;
    private JTextField inputDataField;
    private JTextField outputDataField;
    private JButton buttonSort;
    private JButton buttonTest;
    private JLabel inputTextLabel;
    private JLabel outputTextLabel;
    private JPanel panelPerformance;

    public Frame()
    {
        super("Shell sort");

        panel = new JPanel();
        buttonSort = new JButton("Sort");
        buttonTest = new JButton("Test performance");
        inputTextLabel = new JLabel("Enter array");
        outputTextLabel = new JLabel("Result");
        inputDataField = new JTextField();
        outputDataField = new JTextField();
        panelPerformance = new JPanel();
        Dimension dimField = new Dimension(600, 24);
        inputDataField.setPreferredSize(dimField);
        outputDataField.setPreferredSize(dimField);

        addActionToButtons();
        addComponentsToPanel();
        initFrame(panel);
    }

    private void addActionToButtons()
    {
        buttonSort.addActionListener(new ButtonSortListener(inputDataField, outputDataField));
        buttonTest.addActionListener(new ButtonTestListener(buttonTest, panelPerformance));
    }

    private void addComponentsToPanel()
    {
        panel.add(inputTextLabel);
        panel.add(inputDataField);
        panel.add(buttonSort);
        panel.add(buttonTest);
        panel.add(outputTextLabel);
        panel.add(outputDataField);
        panel.add(panelPerformance);
    }

    private void initFrame(JPanel panel)
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = 630;
        int height = 300;
        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height) / 2;
        this.setBounds(x, y, width, height);
        this.setContentPane(panel);
    }
}
