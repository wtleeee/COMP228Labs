package exercise1;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

    static List<String> questions = new ArrayList<String>();// a list storing questions
    static List<String> answers = new ArrayList<String>();// a list storing answers

    // constructor
    public Test() {
        // add questions to the end of the list questions
        questions.add(
                "Which of the following typically groups related classes so that they could be imported into programs and reused? \nA. Package\nB. Function\nC. Method\nD. IDE");
        questions.add(
                "Method arguments may be___________. \nA. only variables\nB. constants, variables, or expressions\nC. only strings\nD. only constants");
        questions.add(
                "There are variables for which each object of a class does not need its own separate copy. They are called__________.\nA. constants\nB. class variables\nC. instance variables\nD. local variables");
        questions.add("Class variables must be declared as___________.\nA. const\nB. final\nC. static\nD. var");
        questions.add(
                "If a series of method calls occurs, the successive return addresses are pushed onto the method stack in___________.\nA. first-in, first-out order\nB. first-in, last-out out order\nC. last-in, first-out order\nD. random orders");

        // add answers to the end of the list answers
        answers.add("A");
        answers.add("B");
        answers.add("B");
        answers.add("C");
        answers.add("C");
    }

    // method to interact with the user
    public void inputAnswer() {
        int correctAnswers = 0;
        for (int i = 0; i < questions.size(); i++) {
            String inputAnswer = JOptionPane.showInputDialog(simulateQuestion(i)).toUpperCase();// store user input
                                                                                                // answer as upper case
                                                                                                // string
            if (checkAnswer((i), inputAnswer) == true) {// when the user input answer is true
                JOptionPane.showMessageDialog(null, generateMessage(true));
                correctAnswers++;
            } else {
                JOptionPane.showMessageDialog(null, // when the user input answer is wrong
                        generateMessage(false) + "\n" + "The correct answer is: " + answers.get(i));
            }
        }
        // show the correct answer percentage
        JOptionPane.showMessageDialog(null,
                String.format("The percentage of correct answers: %.1f%%", correctAnswers / 5.0 * 100));
    }

    // method to simulate the questions
    public String simulateQuestion(int i) {
        return questions.get(i);
    }

    // method to check the answer
    public Boolean checkAnswer(int i, String answer) {
        return answers.get(i).equals(answer);
    }

    // method to display a random message for the user
    public String generateMessage(Boolean i) {
        // define a random object
        Random randomObject = new Random();
        String randomMessage;
        if (i) { // if user inputs the correct answer, randomly save randomMessage as one of the
                         // below four strings
            switch (randomObject.nextInt(4)) {
                case 0:
                    randomMessage = "Excellent!";
                    break;
                case 1:
                    randomMessage = "Good!";
                    break;
                case 2:
                    randomMessage = "Keep up the good work!";
                    break;
                default:
                    randomMessage = "Nice work!";
                    break;
            }
        } else { // when user inputs the wrong answer
            switch (randomObject.nextInt(4)) {
                case 0:
                    randomMessage = "No. Please try again";
                    break;
                case 1:
                    randomMessage = "Wrong. Try once more";
                    break;
                case 2:
                    randomMessage = "Don't give up!";
                    break;
                default:
                    randomMessage = "No. Keep trying.";
                    break;
            }
        }
        return randomMessage;
    }
}
