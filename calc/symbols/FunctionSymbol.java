package calc.symbols;

import calc.Symbol;

import javax.swing.JTextField;

public class FunctionSymbol implements Symbol {

    private String symbol;

    public FunctionSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void process(JTextField resultField, JTextField formulaField) {
        if(formulaField.getText().length() > 1 && !symbol.equals("n!")) {
            if (formulaField.getText().endsWith(" "))
                formulaField.setText(formulaField.getText().substring(0, formulaField.getText().length() - 2) + symbol + " ");
            else if (formulaField.getText().endsWith("√")) { }
            else
                formulaField.setText(formulaField.getText() + " " + symbol + " ");
        } else if (formulaField.getText().length() > 1 && symbol.equals("n!")) {
            if(isNumber(formulaField.getText().substring(formulaField.getText().length() - 1, formulaField.getText().length()))) {
                formulaField.setText(formulaField.getText() + "!");
            }
        }
    }

    public String toString() {
        return symbol;
    }

    private boolean isNumber(String ch) {
        try {
            double d = Double.parseDouble(ch);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }

        return true;
    }
}
