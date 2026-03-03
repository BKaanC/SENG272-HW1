import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class ProjectFormPanel extends JPanel {

    private JTextField projectNameField;
    private JTextField teamLeaderField;
    private JComboBox<String> teamSizeBox;
    private JComboBox<String> projectTypeBox;
    private JTextField startDateField;
    private JButton saveButton;
    private JButton clearButton;

    public ProjectFormPanel() {

        setLayout(new GridLayout(7, 2, 5, 5));

       
        add(new JLabel("Project Name:"));
        projectNameField = new JTextField();
        add(projectNameField);

       
        add(new JLabel("Team Leader:"));
        teamLeaderField = new JTextField();
        add(teamLeaderField);

      
        add(new JLabel("Team Size:"));
        String[] teamSizes = {"1–3", "4–6", "7–10", "10+"};
        teamSizeBox = new JComboBox<>(teamSizes);
        add(teamSizeBox);

   
        add(new JLabel("Project Type:"));
        String[] projectTypes = {"Web", "Mobile", "Desktop", "API"};
        projectTypeBox = new JComboBox<>(projectTypes);
        add(projectTypeBox);

    
        add(new JLabel("Start Date (DD/MM/YYYY):"));
        startDateField = new JTextField();
        add(startDateField);

    
        saveButton = new JButton("Save");
        clearButton = new JButton("Clear");
        add(saveButton);
        add(clearButton);

     
        clearButton.addActionListener(e -> {
            projectNameField.setText("");
            teamLeaderField.setText("");
            startDateField.setText("");

            teamSizeBox.setSelectedIndex(0);
            projectTypeBox.setSelectedIndex(0);
        });

      
        saveButton.addActionListener(e -> {

            String projectName = projectNameField.getText();
            String teamLeader = teamLeaderField.getText();
            String startDate = startDateField.getText();

            String teamSize = (String) teamSizeBox.getSelectedItem();
            String projectType = (String) projectTypeBox.getSelectedItem();

         
            if (projectName.isEmpty() || teamLeader.isEmpty() || startDate.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!");
                return;
            }

            try (FileWriter writer = new FileWriter("projects.txt", true)) {

                LocalDateTime now = LocalDateTime.now();

                writer.write("=== Project Entry ===\n");
                writer.write("Project Name : " + projectName + "\n");
                writer.write("Team Leader : " + teamLeader + "\n");
                writer.write("Team Size : " + teamSize + "\n");
                writer.write("Project Type : " + projectType + "\n");
                writer.write("Start Date : " + startDate + "\n");
                writer.write("Record Time : " + now + "\n");
                writer.write("====================\n\n");

                JOptionPane.showMessageDialog(this, "Project saved successfully!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error saving file!");
            }

        });
    }
}