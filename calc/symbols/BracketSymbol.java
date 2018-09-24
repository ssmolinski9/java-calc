package calc.symbols;

import calc.Symbol;

import javax.swing.JTextField;

public class BracketSymbol implements Symbol {

    private String symbol;

    public BracketSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void process(JTextField resultField, JTextField formulaField) {
        formulaField.setText(formulaField.getText() + symbol);
    }

    public String toString() {
        return symbol;
    }
}
