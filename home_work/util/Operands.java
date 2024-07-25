package home_work.util;

public enum Operands {
    
    ADDITION("+"),
    SUBTRACTION("-"),
    DIVISION("/"),
    MULTIPLY("*"),
    EXIT("n");


    private String operand;

    Operands(String operand){
        this.operand = operand;
    }

    public String getOperand() {
        return operand;
    }
}
