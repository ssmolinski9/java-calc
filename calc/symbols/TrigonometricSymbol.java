package calc.symbols;

import calc.Symbol;

import javax.swing.JTextField;

public class TrigonometricSymbol implements Symbol {

    private String symbol;

    public TrigonometricSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void process(JTextField resultField, JTextField formulaField) {
        String converedStr = symbol;

        if(converedStr.contains("html"))
            if(converedStr.contains("sin"))
                converedStr = "arcsin";
            else if(converedStr.contains("cos"))
                converedStr = "arccos";
            else
                converedStr = "arctan";

        if(formulaField.getText().endsWith(" "))
            formulaField.setText(formulaField.getText() + converedStr);
    }

    public String toString() {
        return symbol;
    }
}
