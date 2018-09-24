package calc.symbols;

import calc.Symbol;
import calc.SymbolFactory;

import javax.swing.JTextField;

public class ClearSymbol implements Symbol {
    private String symbol;

    public ClearSymbol(String symbol) {
        this.symbol = symbol; 
    }

    @Override
    public void process(JTextField resultField, JTextField formulaField) {
        String formula = formulaField.getText();
        SymbolFactory factory = new SymbolFactory();

        if(symbol.equalsIgnoreCase("CR")) {
            resultField.setText("0");
            formulaField.setText(" ");
        }
        else if(symbol.equalsIgnoreCase("CF"))
            if(resultField.getText().equals("0"))
                formulaField.setText(" ");
            else
                formulaField.setText(resultField.getText());
        else if (symbol.equalsIgnoreCase("<-") && !formula.equals(" ")) {
            if(!formulaField.getText().equals(" ")) {
                if(formulaField.getText().endsWith(" ") && !formulaField.getText().endsWith(" mod ") && !formulaField.getText().endsWith(" XOR ") && !formulaField.getText().endsWith(" AND ") && !formulaField.getText().endsWith(" OR "))
                    formula = formula.substring(0, formula.length() - 3);
                else if(formulaField.getText().endsWith("arcsin") || formulaField.getText().endsWith("arccos") || formulaField.getText().endsWith("arctan"))
                    formula = formula.substring(0, formula.length() - 6);
                else if(formulaField.getText().endsWith("sin") || formulaField.getText().endsWith("cos") || formulaField.getText().endsWith("tan"))
                    formula = formula.substring(0, formula.length() - 3);
                else if(formulaField.getText().endsWith(" mod "))
                    formula = formula.substring(0, formula.length() - 5);
                else if(formulaField.getText().endsWith(" OR "))
                    formula = formula.substring(0, formula.length() - 4);
                else if(formulaField.getText().endsWith(" XOR ") || formulaField.getText().endsWith(" AND "))
                    formula = formula.substring(0, formula.length() - 5);
                else
                    formula = formula.substring(0, formula.length() - 1);
            }

            formulaField.setText(formula);
        }
    }

    public String toString() {
        return symbol;
    }
}
