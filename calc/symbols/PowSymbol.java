package calc.symbols;

import calc.Symbol;

import javax.swing.JTextField;

public class PowSymbol implements Symbol {
    private String symbol;

    public PowSymbol(String symbol) {
        this.symbol = symbol; 
    }

    @Override
    public void process(JTextField resultField, JTextField formulaField) {
        String converedStr = symbol;

        if(converedStr.equals("<html>x<sup>2</sup></html>"))
            converedStr = "^2";
        else if(converedStr.equals("<html>x<sup>3</sup></html>"))
            converedStr = "^3";
        else if(converedStr.equals("<html>10<sup>x</sup></html>"))
            converedStr = "10^";
        else if(converedStr.equals("<html>e<sup>x</sup></html>"))
            converedStr = "e^";
        else
            converedStr = "^";

        if(isNumber(""+formulaField.getText().charAt(formulaField.getText().length() - 1)))
            formulaField.setText(formulaField.getText() + converedStr);
        if((converedStr.equals("10^") | converedStr.equals("e^")) && formulaField.getText().endsWith(" "))
            formulaField.setText(formulaField.getText() + converedStr);
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
