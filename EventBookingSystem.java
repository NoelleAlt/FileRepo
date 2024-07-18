import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventBookingSystem extends JFrame {
    
    private JTextField nameField;
    private JComboBox<String> dateComboBox;
    private JComboBox<String> roomTypeComboBox;
    private JCheckBox cateringCheckBox;
    private JCheckBox decorationsCheckBox;
    
    public EventBookingSystem() {
        super("Event Booking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        
        // Panel to hold all components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Name input
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(new JLabel("Name:"));
        nameField = new JTextField(20);
        namePanel.add(nameField);
        panel.add(namePanel);
        
        // Date selection
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        datePanel.add(new JLabel("Date:"));
        String[] dates = {"2024-07-08", "2024-07-09", "2024-07-10"}; // Example dates
        dateComboBox = new JComboBox<>(dates);
        datePanel.add(dateComboBox);
        panel.add(datePanel);
        
        // Room type selection
        JPanel roomTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        roomTypePanel.add(new JLabel("Room Type:"));
        String[] roomTypes = {"Small", "Medium", "Large"}; // Example room types
        roomTypeComboBox = new JComboBox<>(roomTypes);
        roomTypePanel.add(roomTypeComboBox);
        panel.add(roomTypePanel);
        
        // Extra amenities checkboxes
        JPanel amenitiesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cateringCheckBox = new JCheckBox("Catering");
        decorationsCheckBox = new JCheckBox("Decorations");
        amenitiesPanel.add(cateringCheckBox);
        amenitiesPanel.add(decorationsCheckBox);
        panel.add(amenitiesPanel);
        
        // Submit button
        JButton submitButton = new JButton("Book Event");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookEvent();
            }
        });
        panel.add(submitButton);
        
        add(panel);
        setVisible(true);
    }
    
    private void bookEvent() {
        // Retrieve user inputs
        String name = nameField.getText();
        String selectedDate = (String) dateComboBox.getSelectedItem();
        String selectedRoomType = (String) roomTypeComboBox.getSelectedItem();
        boolean cateringSelected = cateringCheckBox.isSelected();
        boolean decorationsSelected = decorationsCheckBox.isSelected();
        
        // Example: Print out the details (you can implement actual booking logic here)
        System.out.println("Name: " + name);
        System.out.println("Date: " + selectedDate);
        System.out.println("Room Type: " + selectedRoomType);
        System.out.println("Catering: " + (cateringSelected ? "Yes" : "No"));
        System.out.println("Decorations: " + (decorationsSelected ? "Yes" : "No"));
        
        // Example: Show a confirmation dialog
        JOptionPane.showMessageDialog(this,
                "Event booked for " + name + " on " + selectedDate + "\nRoom Type: " + selectedRoomType +
                        "\nCatering: " + (cateringSelected ? "Yes" : "No") +
                        "\nDecorations: " + (decorationsSelected ? "Yes" : "No"),
                "Booking Confirmation", JOptionPane.INFORMATION_MESSAGE);
        
        // Clear the input fields after booking
        nameField.setText("");
        dateComboBox.setSelectedIndex(0); // Reset to the first item
        roomTypeComboBox.setSelectedIndex(0); // Reset to the first item
        cateringCheckBox.setSelected(false);
        decorationsCheckBox.setSelected(false);
    }
    
    public static void main(String[] args) {
        // Ensure Swing components are initialized on the EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EventBookingSystem();
            }
        });
    }
}
