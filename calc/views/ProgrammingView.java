package calc.views;

import calc.Calculator;
import calc.Symbol;
import calc.SymbolFactory;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ProgrammingView extends View {
    public ProgrammingView() {
        super(new String [] { "OR", "XOR", "AND", "DEC",
                        "CF", "CR", "<-", "/",
                        "7", "8", "9", "*",
                        "4", "5", "6", "-",
                        "1", "2", "3", "+",
                        "A", "0", "B", "=",
                        "C", "D", "E", "(",
                        "−", "F", ")"
                });

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
            if(!symbol.equals("DEC")) {
                Symbol symbolic = symbolFactory.createSymbol(symbol);

                button = new JButton(symbolic.toString());
                button.setFont(font);
                button.addActionListener(e -> {
                    symbolic.process(resultField, formulaField);
                });
            } else {
                button = new JButton("DEC");
                button.addActionListener(e -> {
                    formulaField.setText(" ");

                    long d;
                    try {
                        d = Long.parseLong(resultField.getText());
                    } catch (NumberFormatException | NullPointerException ignored) {
                        d = Long.parseLong(resultField.getText(), 16);
                    }

                    if(button.getText().equals("DEC")) {
                        button.setText("OCT");
                        Calculator.NUMBER_SYSTEM = 8;
                        resultField.setText(Long.toOctalString(d));
                    } else if (button.getText().equals("OCT")) {
                        button.setText("BIN");
                        Calculator.NUMBER_SYSTEM = 2;
                        d = Long.parseLong(d+"", 8);
                        resultField.setText(Long.toBinaryString(d));
                    } else if (button.getText().equals("BIN")) {
                        button.setText("HEX");
                        Calculator.NUMBER_SYSTEM = 16;
                        d = Long.parseLong(d+"", 2);
                        resultField.setText(Long.toHexString(d).toUpperCase());
                    } else if (button.getText().equals("HEX")) {
                        button.setText("DEC");
                        Calculator.NUMBER_SYSTEM = 10;
                        resultField.setText(d+"");
                    }
                });
            }

            if(!button.getText().equals("F")) {
                gbc.weightx = 0.2;
                gbc.weighty = 0.2;
                gbc.gridwidth = 1;
                gbc.gridx = i;
                gbc.gridy = j;
                gbc.fill = GridBagConstraints.BOTH;
            } else {
                gbc.weightx = 0.2;
                gbc.weighty = 0.2;
                gbc.gridwidth = 2;
                gbc.gridx = i;
                gbc.gridy = j;
                gbc.fill = GridBagConstraints.BOTH;
                i++;
            }

            add(button, gbc);

            i = (i == 3) ? 0 : (i+1);
            j = (i == 0) ? (j+1) : j;
        }
    }
}
