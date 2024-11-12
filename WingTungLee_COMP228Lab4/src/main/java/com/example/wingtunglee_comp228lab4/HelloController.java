package com.example.wingtunglee_comp228lab4;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.List;
import java.util.ArrayList;

public class HelloController {
    public Button displayButton;
    @FXML private TextField fullNameField;
    @FXML private TextField addressField;
    @FXML private TextField cityField;
    @FXML private TextField provinceField;
    @FXML private TextField postalCodeField;
    @FXML private TextField phoneField;
    @FXML private TextField emailField;
    @FXML private RadioButton csRadioButton;
    @FXML private RadioButton businessRadioButton;
    @FXML private ComboBox<String> courseComboBox;
    @FXML private ListView<String> selectedCoursesList;
    @FXML private CheckBox stdCouncilCheckBox;
    @FXML private CheckBox volunteerCheckBox;
    @FXML private TextArea infoTextArea;


    @FXML
    private void initialize() {
        //set up an array of courses
        String[] courses = {"Python", "Java", "C#"};
        //populate courses to courseComboBox
        courseComboBox.getItems().addAll(courses);
    }

    @FXML
    private void onCourseSelected() {
        String selectedCourse = courseComboBox.getValue();
        //adding the non-empty selected course to the selectedCoursesList if it's not already in the list
        if (selectedCourse!= null &&!selectedCoursesList.getItems().contains(selectedCourse)) {
            selectedCoursesList.getItems().add(selectedCourse);
        }
    }

    @FXML
    private void onDisplayButtonClick() {
        // Collect all input data
        //Basic Information TextFields
        String fullName = fullNameField.getText();
        String address = addressField.getText();
        String city = cityField.getText();
        String province = provinceField.getText();
        String postalCode = postalCodeField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();

        //major radiobuttons
        String major = "";
        if (csRadioButton.isSelected()) major = "Computer Science";
        else if (businessRadioButton.isSelected()) major = "Business";

        //Other activities checkboxes
        List<String> activities = new ArrayList<>();
        if (stdCouncilCheckBox.isSelected()) activities.add("Student Council");
        if (volunteerCheckBox.isSelected()) activities.add("Volunteer Work");

        //course selection list box
        List<String> courses = selectedCoursesList.getItems();

        // Display in TextArea
        infoTextArea.setText(String.format("Student Information:\n%s, %s, %s, %s, %s, %s, %s\nMajor: %s\nActivities: %s\nCourses: %s",
                fullName, address, province, city, postalCode, phone, email, major,
                String.join(", ", activities), String.join(", ", courses)));

        // Clear fields after display
        clearFields();
    }
    private void clearFields() {
        // Clear basic information
        fullNameField.clear();
        addressField.clear();
        cityField.clear();
        provinceField.clear();
        postalCodeField.clear();
        phoneField.clear();
        emailField.clear();

        // Clear major
        csRadioButton.setSelected(false);
        businessRadioButton.setSelected(false);

        // Clear activities
        stdCouncilCheckBox.setSelected(false);
        volunteerCheckBox.setSelected(false);

        // Clear selected courses
        selectedCoursesList.getItems().clear();
    }
}

