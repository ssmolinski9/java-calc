package calc;

import calc.symbols.*;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SymbolFactory {
    private String [] numbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Pi", "A", "B", "C", "D", "E", "F" };
    private String [] operators = { "+", "-", "/", "*", "−" };
    private String [] binaryOperators = {"OR", "XOR", "AND", "NOT"};
    private String [] clear = { "CR", "CF", "<-" };
    private String [] pow = { "<html>x<sup>2</sup></html>", "<html>x<sup>n</sup></html>", "<html>10<sup>x</sup></html>", "<html>x<sup>3</sup></html>", "<html>e<sup>x</sup></html>" };
    private String [] sqrt = { "√" };
    private String [] logs = { "log", "ln" };
    private String [] trigonometric = { "sin", "cos", "tan", "<html>sin<sup>-1</sup></html>",  "<html>cos<sup>-1</sup></html>", "<html>tan<sup>-1</sup></html>"};
    private String [] functions = { "n!", "mod" };
    private String [] bracket = { "(", ")" };

    public Symbol createSymbol(String symbol) {
        if(Arrays.asList(numbers).contains(symbol))
            return new NumberSymbol(symbol);
        else if(Arrays.asList(operators).contains(symbol))
            return new OperatorSymbol(symbol);
        else if((Arrays.asList(clear).contains(symbol)))
            return new ClearSymbol(symbol);
        else if((Arrays.asList(pow).contains(symbol)))
            return new PowSymbol(symbol);
        else if((Arrays.asList(sqrt).contains(symbol)))
            return new SqrtSymbol(symbol);
        else if((Arrays.asList(logs).contains(symbol)))
            return new LogSymbol(symbol);
        else if((Arrays.asList(trigonometric).contains(symbol)))
            return new TrigonometricSymbol(symbol);
        else if((Arrays.asList(functions).contains(symbol)))
            return new FunctionSymbol(symbol);
        else if((Arrays.asList(bracket).contains(symbol)))
            return new BracketSymbol(symbol);
        else if((Arrays.asList(binaryOperators).contains(symbol)))
            return new BinarySymbol(symbol);
        else if(symbol.equalsIgnoreCase("="))
            return new EqualsSymbol();
        else if(symbol.equalsIgnoreCase("."))
            return new CommaSymbol();

        return null;
    }
}
