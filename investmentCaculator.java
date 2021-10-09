import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class investmentCaculator extends JFrame {

    private JTextField jtfInvestmentAmount;
    private JTextField jtfAnnualInterestRate;
    private JTextField jtfNumberOfYears;
    private JTextField jtfFutureValue;
    private JButton jbtCompute;
    private JButton jbtReset;

    public investmentCaculator() {

        setTitle("Loan Caculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,2,5,5));
        
        JLabel jlInvestmentAmount = new JLabel (" Investment Amount");
        JLabel jlNumberOfYears = new JLabel (" Number Of Years");
        JLabel jlAnnualInterestRate = new JLabel (" Annual Intrest Rate");
        JLabel jlFutureValue = new JLabel (" Future Value");
        
        jtfInvestmentAmount = new JTextField();
        jtfNumberOfYears = new JTextField();
        jtfAnnualInterestRate = new JTextField();
        jtfFutureValue = new JTextField();
        jbtCompute = new JButton("Compute");
        jbtReset = new JButton("Reset");
        jtfFutureValue.setEditable(false);
        
        add (jlInvestmentAmount);
        add (jtfInvestmentAmount);
        add (jlNumberOfYears);
        add (jtfNumberOfYears);
        add (jlAnnualInterestRate);
        add (jtfAnnualInterestRate);
        add (jlFutureValue);
        add (jtfFutureValue);
        add (jbtCompute);
        add (jbtReset);
        
        
        ListenerClass listener = new ListenerClass();
        jbtCompute.addActionListener(listener);
        jbtReset.addActionListener(listener);
        
        setVisible(true);

    }
    
    public static void main(String[] args) {
        new investmentCaculator();    
    }
    
    private void computeValue() {
        try {
            double annualInterestRate = Double.parseDouble(jtfAnnualInterestRate.getText());
            double monthlyInterestRate = annualInterestRate / 1200.0;
            int NumberOfYears = Integer.parseInt(jtfNumberOfYears.getText());
            double investmentAmount = Double.parseDouble(jtfInvestmentAmount.getText());
            double futureValue = investmentAmount * Math.pow(1.0 + monthlyInterestRate, NumberOfYears * 12);
           jtfFutureValue.setText(String.format("%.2f", futureValue));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, " Please enter numeric values.");
      }
    }
    
    private void resetForm() {
        jtfInvestmentAmount.setText("");
        jtfAnnualInterestRate.setText("");
        jtfNumberOfYears.setText("");
        jtfFutureValue.setText("");    
    }
    
    private class ListenerClass implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtCompute) {
                computeValue();
            }
            if (e.getSource() == jbtReset) {
                resetForm();
            }
        }
    }
}


