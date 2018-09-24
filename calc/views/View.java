package calc.views;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.Font;
import java.awt.GridBagLayout;

public abstract class View extends JPanel {
    protected JTextField formulaField, resultField;
    protected JPopupMenu menu;
    protected String [] symbols;

    public View(String [] symbols) {
        super();

        this.formulaField = new JTextField();
        this.resultField = new JTextField();

        setLayout(new GridBagLayout());
        Font font = new Font("Times New Roman", Font.PLAIN, 18);

        formulaField.setHorizontalAlignment(JTextField.RIGHT);
        formulaField.setText(" ");
        formulaField.setFont(font);
        formulaField.setEditable(false);

        resultField.setHorizontalAlignment(JTextField.RIGHT);
        resultField.setText("0");
        resultField.setFont(font);
        resultField.setEditable(false);

        this.symbols = symbols;
        this.menu = new JPopupMenu();

        Action copy = new DefaultEditorKit.CopyAction();
        copy.putValue(Action.NAME, "Copy");
        copy.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
        menu.add(copy);

        formulaField.setComponentPopupMenu(menu);
        resultField.setComponentPopupMenu(menu);
    }
}
