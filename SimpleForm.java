import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleForm extends JFrame {
private JRadioButton option1;
private JRadioButton option2;
private JRadioButton option3;
private JRadioButton option4;
private JTextField nameField;
private JTextField moneyField;
private JButton submitButton;

public SimpleForm() {
// Set up the frame
setTitle("Simple Form");
setSize(300, 300);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new FlowLayout());

// Create radio buttons for options
option1 = new JRadioButton("Option 1");
option2 = new JRadioButton("Option 2");
option3 = new JRadioButton("Option 3");
option4 = new JRadioButton("Option 4");

// Group the radio buttons
ButtonGroup group = new ButtonGroup();
group.add(option1);
group.add(option2);
group.add(option3);
group.add(option4);

// Create text fields
nameField = new JTextField(15);
moneyField = new JTextField(15);

// Create submit button
submitButton = new JButton("Submit");

// Add action listener to the submit button
submitButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String selectedOption = "";
if (option1.isSelected()) {
selectedOption = "Option 1";
} else if (option2.isSelected()) {
selectedOption = "Option 2";
} else if (option3.isSelected()) {
selectedOption = "Option 3";
} else if (option4.isSelected()) {
selectedOption = "Option 4";
}

String name = nameField.getText();
String money = moneyField.getText();

// Display the input values
JOptionPane.showMessageDialog(null, "Selected: " + selectedOption + "\nName: " + name + "\nMoney: " + money);
}
});

// Add components to the frame
add(option1);
add(option2);
add(option3);
add(option4);
add(new JLabel("Name:"));
add(nameField);
add(new JLabel("Money:"));
add(moneyField);
add(submitButton);
}

public static void main(String[] args) {
// Create and display the form
SwingUtilities.invokeLater(() -> {
SimpleForm form = new SimpleForm();
form.setVisible(true);
});
}
}