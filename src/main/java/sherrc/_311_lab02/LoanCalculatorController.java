package sherrc._311_lab02;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoanCalculatorController {

    @FXML
    private TextField interestRateField;

    @FXML
    private TextField numberOfYearsField;

    @FXML
    private TextField loanAmountField;

    @FXML
    private TextField monthlyPaymentField;

    @FXML
    private TextField totalPaymentField;

    @FXML
    protected void onCalculateButtonClick() {
        try {
            // Get values from the input fields
            double annualInterestRate = Double.parseDouble(interestRateField.getText());
            int numberOfYears = Integer.parseInt(numberOfYearsField.getText());
            double loanAmount = Double.parseDouble(loanAmountField.getText());

            // Calculate monthly interest rate
            double monthlyInterestRate = annualInterestRate / 1200;

            // Calculate the number of months
            int numberOfMonths = numberOfYears * 12;

            // Calculate monthly payment using the formula
            double monthlyPayment = (loanAmount * monthlyInterestRate) /
                    (1 - Math.pow(1 + monthlyInterestRate, -numberOfMonths));

            // Calculate total payment
            double totalPayment = monthlyPayment * numberOfMonths;

            // Display results
            monthlyPaymentField.setText(String.format("%.2f", monthlyPayment));
            totalPaymentField.setText(String.format("%.2f", totalPayment));

        } catch (NumberFormatException e) {
            // Handle invalid input (e.g., show an error message)
            monthlyPaymentField.setText("Invalid input");
            totalPaymentField.setText("Invalid input");
        }
    }
}
