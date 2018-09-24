package calc.symbols;

import calc.Symbol;

import javax.swing.JTextField;

public class CommaSymbol implements Symbol {
    private String symbol = ".";

    @Override
    public void process(JTextField resultField, JTextField formulaField) {
        if(isNumber(""+formulaField.getText().charAt(formulaField.getText().length() - 1)) && !lastBlockContainsComma(formulaField.getText()))
            formulaField.setText(formulaField.getText() + symbol);
    }

    private boolean isNumber(String ch) {
        try {
            double d = Double.parseDouble(ch);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }

        return true;
    }

    private boolean lastBlockContainsComma(String formula) {
        String [] blocks = formula.split(" ");

        if(blocks[blocks.length - 1].contains("."))
            return true;

        return false;
    }

    public String toString() {
        return symbol;
    }
}
