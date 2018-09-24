package calc.symbols;

import calc.Symbol;

import javax.swing.JTextField;

public class OperatorSymbol implements Symbol {
    private String symbol;

    public OperatorSymbol(String symbol) {
        this.symbol = symbol; 
    }

    @Override
    public void process(JTextField resultField, JTextField formulaField) {
        if(formulaField.getText().length() > 1 && !symbol.equals("−")) {
            if (formulaField.getText().endsWith(" "))
                formulaField.setText(formulaField.getText().substring(0, formulaField.getText().length() - 2) + symbol + " ");
            else if (formulaField.getText().endsWith("√")) {
            } else
                formulaField.setText(formulaField.getText() + " " + symbol + " ");

        } else if ((formulaField.getText().endsWith(" ") || formulaField.getText().endsWith("^")) && symbol.equals("−")) {
            if(!lastBlockContainsMinus(formulaField.getText()))
                formulaField.setText(formulaField.getText() + symbol);
        }
    }

    public String toString() {
        return symbol;
    }

    private boolean lastBlockContainsMinus(String formula) {
        if(formula.equalsIgnoreCase(" "))
            return false;

        String [] blocks = formula.split(" ");

        if(blocks[blocks.length - 1].contains("–"))
            return true;

        return false;
    }

}
