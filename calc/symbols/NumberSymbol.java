package calc.symbols;

import calc.Calculator;
import calc.Symbol;

import javax.swing.JTextField;

public class NumberSymbol implements Symbol {
    private String symbol;

    public NumberSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void process(JTextField resultField, JTextField formulaField) {

        int number = 99;
        try {
            number = Integer.parseInt(symbol);
        } catch (NumberFormatException | NullPointerException ignored) {}

        if(!formulaField.getText().endsWith("!") && !formulaField.getText().endsWith(")") )
            if(Calculator.NUMBER_SYSTEM == 2 && number < Calculator.NUMBER_SYSTEM)
                formulaField.setText(formulaField.getText() + symbol);
            else if (Calculator.NUMBER_SYSTEM == 8 && number < Calculator.NUMBER_SYSTEM)
                formulaField.setText(formulaField.getText() + symbol);
            else if (Calculator.NUMBER_SYSTEM == 10 && number < Calculator.NUMBER_SYSTEM)
                formulaField.setText(formulaField.getText() + symbol);
            else if (Calculator.NUMBER_SYSTEM == 16)
                formulaField.setText(formulaField.getText() + symbol);

        if(symbol.equals("Pi"))
            formulaField.setText(formulaField.getText() + Math.PI);
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

    private boolean isComma(String ch) {
        return (ch.equals("."));
    }
}
