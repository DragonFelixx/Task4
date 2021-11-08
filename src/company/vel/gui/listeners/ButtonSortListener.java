package company.vel.gui.listeners;

import company.vel.ShellSort;
import company.vel.utils.ArrayUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSortListener implements ActionListener
{
    JTextField inputDataField;
    JTextField outputDataField;

    public ButtonSortListener(JTextField inputDataField, JTextField outputDataField)
    {
        this.inputDataField = inputDataField;
        this.outputDataField = outputDataField;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String inputText = inputDataField.getText();
        Integer[] array = ArrayUtils.toIntegerArray(inputText);
        ShellSort.sort(array, Integer::compare);
        outputDataField.setText(ArrayUtils.toString(array));
    }
}
