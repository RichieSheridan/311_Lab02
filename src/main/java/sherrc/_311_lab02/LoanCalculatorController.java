package sherrc._311_lab02;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoanCalculatorController {
    @FXML
    private TextField interestRateField; //These fields are connected to the FXML file
    @FXML
    private TextField numberOfYearsField;
    @FXML
    private TextField loanAmountField;
    @FXML
    private TextField monthlyPaymentField;
    @FXML
    private TextField totalPaymentField;
    @FXML
    protected void onCalculateButtonClick() { //Called when user clicks the button
        try {
            //Get values from the input fields
            double annualInterestRate = Double.parseDouble(interestRateField.getText()); //Parsing for double
            int numberOfYears = Integer.parseInt(numberOfYearsField.getText()); //Parsing for int
            double loanAmount = Double.parseDouble(loanAmountField.getText());

            //Calculate monthly interest rate
            double monthlyInterestRate = annualInterestRate / 1200;

            //Calculate the number of months
            int numberOfMonths = numberOfYears * 12;

            //Calculate monthly payment using the formula I stole off the internet
            double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate,-numberOfMonths));

            //Calculate total payment
            double totalPayment = monthlyPayment * numberOfMonths;

            //Display results, add dollar sign
            monthlyPaymentField.setText(String.format("$%.2f", monthlyPayment));
            totalPaymentField.setText(String.format("$%.2f", totalPayment));

        } catch (NumberFormatException e) {
            //Simple Error Handle
            monthlyPaymentField.setText("Invalid input");
            totalPaymentField.setText("Invalid input");
        }
    }
}
