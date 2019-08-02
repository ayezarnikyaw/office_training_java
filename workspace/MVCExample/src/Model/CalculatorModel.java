package Model;

public class CalculatorModel {
	private int sum;
	public void addTwoNumbers(int firstNumber,int secondNumber){
		sum = firstNumber + secondNumber;
	}
	public int getCalculationValue(){
		return sum;
	}
	public static void main(String[] args) {
		
	}
}
