package calc.views;

import calc.Symbol;
import calc.SymbolFactory;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class BasicView extends View {

    public BasicView() {
        super(new String[] { "√", "<html>x<sup>2</sup></html>", "<html>x<sup>n</sup></html>", "/",
                "CF", "CR", "<-", "*",
                "7", "8", "9", "-",
                "4", "5", "6", "+",
                "1", "2", "3", "=",
                "−", "0", "."});

        placeTextFields();
        placeButtons();
    }

    private void placeTextFields() {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 2, 0);
        add(formulaField, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.5;
        add(resultField, gbc);
    }

    private void placeButtons() {
        GridBagConstraints gbc = new GridBagConstraints();
        SymbolFactory symbolFactory = new SymbolFactory();
        Font font = new Font("Consolas", Font.PLAIN, 15);

        int i = 0, j = 2;
        for(String symbol : symbols) {

            JButton button;
            if(!symbol.equals("")) {
                Symbol symbolic = symbolFactory.createSymbol(symbol);

                button = new JButton(symbolic.toString());
                button.setFont(font);
                button.addActionListener(e -> {
                    symbolic.process(resultField, formulaField);
                });
            } else {
                button = new JButton("");
            }

            if(!symbol.equals(".")) {
                gbc.weightx = 1;
                gbc.weighty = 0.2;
                gbc.gridwidth = 1;
                gbc.gridx = i;
                gbc.gridy = j;
                gbc.fill = GridBagConstraints.BOTH;
            } else {
                gbc.weightx = 1;
                gbc.weighty = 0.2;
                gbc.gridwidth = 2;
                gbc.gridx = i;
                gbc.gridy = j;
                gbc.fill = GridBagConstraints.BOTH;
            }

            add(button, gbc);

            i = (i == 3) ? 0 : (i+1);
            j = (i == 0) ? (j+1) : j;
        }
    }
}
