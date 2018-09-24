package calc.symbols;

import calc.Symbol;

import javax.swing.JTextField;

public class BinarySymbol implements Symbol {

    private String symbol;

    public BinarySymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void process(JTextField resultField, JTextField formulaField) {
        if(formulaField.getText().length() > 1) {
            if (formulaField.getText().endsWith(" "))
                if(formulaField.getText().endsWith(" OR "))
                    formulaField.setText(formulaField.getText().substring(0, formulaField.getText().length() - 3) + symbol + " ");
                else
                    formulaField.setText(formulaField.getText().substring(0, formulaField.getText().length() - 4) + symbol + " ");
            else if (formulaField.getText().endsWith("√")) {}
            else
                formulaField.setText(formulaField.getText() + " " + symbol + " ");

        }
    }

    public String toString() {
        return symbol;
    }
}
