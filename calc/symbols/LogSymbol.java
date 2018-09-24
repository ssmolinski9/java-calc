package calc.symbols;

import calc.Symbol;

import javax.swing.JTextField;

public class LogSymbol implements Symbol {
    private String symbol;

    public LogSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void process(JTextField resultField, JTextField formulaField) {
        if(formulaField.getText().endsWith(" "))
            formulaField.setText(formulaField.getText() + symbol);
    }

    public String toString() {
        return symbol;
    }
}
