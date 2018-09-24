package calc.symbols;

import calc.Calculator;
import calc.Symbol;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JTextField;

public class EqualsSymbol implements Symbol {
    private String symbol = "=";

    private ScriptEngineManager manager;
    private ScriptEngine engine;

    public EqualsSymbol() {
        manager = new ScriptEngineManager();
        engine = manager.getEngineByName("js");

        try {
            engine.eval("function fac(n){return(n<2)?1:fac(n-1)*n;}");
        } catch (ScriptException ignored) {}
    }

    @Override
    public void process(JTextField resultField, JTextField formulaField) {
        String correctedFormula = correctFormula(formulaField.getText());

        try {
            String result = engine.eval(correctedFormula).toString();

            switch(Calculator.NUMBER_SYSTEM) {
                case 2:
                    result = result.replaceAll("\\.0", "");
                    resultField.setText(Integer.toBinaryString(Integer.parseInt(result)));
                    break;
                case 8:
                    result = result.replaceAll("\\.0", "");
                    resultField.setText(Integer.toOctalString(Integer.parseInt(result)));
                    break;
                case 16:
                    result = result.replaceAll("\\.0", "");
                    resultField.setText(Integer.toHexString(Integer.parseInt(result)));
                    break;
                case 10:
                    resultField.setText(result);
                    break;
            }


        } catch(ScriptException ex) {
            //ex.printStackTrace();
        }
    }

    public String toString() {
        return symbol;
    }

    private String correctFormula(String formula) {

        formula = formula.replaceAll("−(\\d*.\\d*)", "-($1)");
        formula = formula.replaceAll("√(\\d*.\\d*)", "Math.sqrt($1)");
        formula = formula.replaceAll("(\\d*.\\d*)\\^(\\-*\\d*.\\d*)", "Math.pow($1, $2)");
        formula = formula.replaceAll("log(\\d*.\\d*)", "(Math.log($1) / Math.LN10)");
        formula = formula.replaceAll("ln(\\d*.\\d*)", "Math.log($1)");
        formula = formula.replaceAll("mod", "%");
        formula = formula.replaceAll("e", "Math.E");
        formula = formula.replaceAll("(\\d*.\\d*)!", "fac(Math.round($1))");
        formula = formula.replaceAll("XOR", "^");
        formula = formula.replaceAll("OR", "|");
        formula = formula.replaceAll("AND", "&");
        formula = formula.replaceAll(" (\\d*.\\d*)[(]", "$1 * (");

        if(Calculator.ANGLE_RAD) {
            formula = formula.replaceAll("arcsin(\\d*.\\d*)", "Math.asin($1)");
            formula = formula.replaceAll("[^arc]sin(\\d*.\\d*)", "Math.sin($1)");

            formula = formula.replaceAll("arccos(\\d*.\\d*)", "Math.acos($1)");
            formula = formula.replaceAll("[^arc]cos(\\d*.\\d*)", "Math.cos($1)");

            formula = formula.replaceAll("arctan(\\d*.\\d*)", "Math.atan($1)");
            formula = formula.replaceAll("[^arc]tan(\\d*.\\d*)", "Math.tan($1)");
        } else {
            formula = formula.replaceAll("arcsin(\\d*.\\d*)", "(Math.asin($1) * (180 / Math.PI))");
            formula = formula.replaceAll("[^arc]sin(\\d*.\\d*)", "Math.sin($1 * (Math.PI / 180))");

            formula = formula.replaceAll("arccos(\\d*.\\d*)", "(Math.acos($1) * (180 / Math.PI))");
            formula = formula.replaceAll("[^arc]cos(\\d*.\\d*)", "Math.cos($1 * (Math.PI / 180))");

            formula = formula.replaceAll("arcsin(\\d*.\\d*)", "(Math.asin($1) * (180 / Math.PI))");
            formula = formula.replaceAll("[^arc]tan(\\d*.\\d*)", "Math.tan($1 * (Math.PI / 180))");
        }

        switch(Calculator.NUMBER_SYSTEM) {
            case 2:
                formula = formula.replaceAll("(\\d+)", "parseInt(0+$1, 2)");
                break;
            case 8:
                formula = formula.replaceAll("(\\d+)", "parseInt(0+$1, 8)");
                break;
            case 16:
                formula = formula.replaceAll("(\\w+)", "0x$1");
                break;
        }

        return formula;
    }
}
