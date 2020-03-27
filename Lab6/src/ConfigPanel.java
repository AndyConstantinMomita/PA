import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel;
    JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);
        String[] colors = {"Random", "Black"};
        colorCombo = new JComboBox(colors);

        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }

}
