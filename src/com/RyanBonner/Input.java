package com.RyanBonner;

import java.util.Scanner;

public class Input {

    Scanner input;

    public Input(Scanner input) {
        this.input = input;
    }

    public static Input initalize(Scanner input) {

        if (input == null) {
            input = new Scanner(System.in);
        }

        return new Input(input);
    }

    public String askName() {
        return validationLoop(Output.WHAT_IS_NAME, null, 15);
    }

    public String askComputerSkillLevel() {
        String[] possibleValues = {"easy", "medium", "hard", "god"};
        return validationLoop(Output.WHAT_COMPUTER_SKILL_LEVEL, possibleValues, -1).toLowerCase();
    }


    public String validationLoop(String askForInput, String[] possibleValues, int maxLength) {
        String inputValue;

        do {

            Output.println(askForInput);


            inputValue = input.nextLine();

            //Check for max length, -1 will allow infinite length
            if (maxLength >= 0 && inputValue.length() > maxLength) {
                Output.println(
                        Output.LENGTH_TOO_LONG,
                        Integer.toString(maxLength)
                );

                continue;
            }

            //Check if it matches a potential correctInputs
            if (possibleValues != null) {
                boolean foundPossibleValue = false;
                //@todo look at using regex
                for (String possibleValue : possibleValues) {
                    if (inputValue.equals(possibleValue)) {
                        foundPossibleValue = true;
                    }
                }

                //Couldn't find a match
                if (!foundPossibleValue) {
                    continue;
                }
            }

            //No other validation rule triggered, allow value through
            break;
        } while (true);

        return inputValue;
    }

}
