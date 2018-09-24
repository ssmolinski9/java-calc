package calc;

import calc.views.BasicView;
import calc.views.ProgrammingView;
import calc.views.ScienceView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Calculator extends JFrame {

    public static boolean ANGLE_RAD = true;
    public static int NUMBER_SYSTEM = 10;

    private JPanel basicPanel;
    private JPanel sciencePanel;
    private JPanel programmingPanel;

    public Calculator() {
        super();

        setWindowLookAndFeel();
        setWindowFeatures();
        setWindowIcon();
        setWindowMenu();

        basicPanel = new BasicView();
        sciencePanel = new ScienceView();
        programmingPanel = new ProgrammingView();

        getContentPane().add(basicPanel, "Basic");
        getContentPane().add(sciencePanel, "Science");
        getContentPane().add(programmingPanel, "Programming");

        setVisible(true);
    }

    public static void main(String [] args) {
        new Calculator();
    }

    private void setWindowLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void setWindowFeatures() {
        setTitle("Calc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(340, 550));
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
        setLayout(new CardLayout());
    }

    private void setWindowMenu() {
        setJMenuBar(new JMenuBar());
        getJMenuBar().add(new JMenu("Calculator"));
        getJMenuBar().getMenu(0).add(new JMenuItem("Standard"));
        getJMenuBar().getMenu(0).add(new JMenuItem("Programming"));
        getJMenuBar().getMenu(0).add(new JMenuItem("Science"));

        getJMenuBar().getMenu(0).getItem(0).addActionListener(e -> {
            ((CardLayout)getContentPane().getLayout()).show(getContentPane(), "Basic");
        });

        getJMenuBar().getMenu(0).getItem(1).addActionListener(e -> {
            ((CardLayout)getContentPane().getLayout()).show(getContentPane(), "Programming");
        });

        getJMenuBar().getMenu(0).getItem(2).addActionListener(e -> {
            ((CardLayout)getContentPane().getLayout()).show(getContentPane(), "Science");
        });
    }

    private void setWindowIcon() {
        String imagePath = "/res/icon.png";
        InputStream imgStream = Calculator.class.getResourceAsStream(imagePath);
        try {
            BufferedImage myImg = ImageIO.read(imgStream);
            this.setIconImage(myImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
