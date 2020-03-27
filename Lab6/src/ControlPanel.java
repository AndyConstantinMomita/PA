import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveButtton = new JButton("Save");
    JButton loadButton = new JButton("Load");
    JButton resetButton = new JButton("Reset");
    JButton exitButton = new JButton("exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        saveButtton.addActionListener(this::save);
        loadButton.addActionListener(this::load);
        resetButton.addActionListener(this::reset);
        exitButton.addActionListener(this::exit);

        add(saveButtton);
        add(loadButton);
        add(resetButton);
        add(exitButton);
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("c:\\test.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void load(ActionEvent e) {
        try {
            frame.canvas.image = ImageIO.read(new File("c:\\test.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

    private void reset(ActionEvent e) {
        frame.canvas.graphics.setPaint(Color.white);
        frame.canvas.graphics.fillRect(0, 0, 800, 600);
        frame.canvas.graphics.setPaint(Color.black);
        repaint();
    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }
}
