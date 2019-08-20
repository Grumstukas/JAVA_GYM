package JAVA_GYM;

import JAVA_GYM.Meniu.Methods.CurrentDate;

public class GymPrograms {
    /**
     * Four methods for generating training schedule depending
     * on calculated clients body mass index.
     */
    public static void chooseProgram(String clientID){
        double bmi = Double.parseDouble(Write_Read_File.findSomethingInLastLine(
                "All_Clients\\" + clientID + "\\" + clientID + ".csv",
                6));
        String clientInfo ="";
        String programName = "";
        if (bmi< 18.5){
            clientInfo = lowerBMI_program (new StringBuilder());
            programName = "lowerBMI_program";
        }else if (bmi< 25){
            clientInfo = normalBMI_program (new StringBuilder());
            programName = "normalBMI_program";
        }else if (bmi< 30){
            clientInfo = littleHigherBMI_program (new StringBuilder());
            programName = "littleHigherBMI_program";
        }else if (bmi>= 30){
            clientInfo = highBMI_program (new StringBuilder());
            programName = "highBMI_program";
        }
        System.out.println("\nJeigu norite isigyti sia treniruociu programa - prasome sumoketi 50eur (iveskite - 50)");
        if (ScannerClass.getIntInputValue() == 50){
            Write_Read_File.deleteFile("All_Clients\\" + clientID + "\\" + clientID + "_program.csv");
            Write_Read_File.writeOtherInfoToClientFileAndDoNotDublicate(clientInfo,
                    "All_Clients\\" + clientID + "\\" + clientID + "_program.csv","Stai, jusu sporto treniruociu tvarkarastis!");
            String info = CurrentDate.currentTime()[0]+","+programName+",50";
            Write_Read_File.writeClientInfoToFile("Data, Programa, Imoka eur",
                    info,
                    "All_Clients\\" + clientID + "\\" + clientID + "_payment_for_programs.csv");
        }else {
            return;
        }
    }

    public static String lowerBMI_program (StringBuilder fileInput) {

        fileInput.append("Stai, jusu sporto treniruociu tvarkarastis!\n" +
                "As your BMI is lower than normal we offer to begin training with base exercises three times per week, " +
                "to stimulate muscle growth.\nHere is your program for a week. Training time suggested - 15 min streaching and " +
                "40 min weights training.Overall - 55 min. Do not hestitate to ask if you have some questions.\n");

        for ( int i = 0; i < WeeklyTrainingProgram.values().length - 2; i+=2 ) {
            fileInput.append(WeeklyTrainingProgram.values()[i] + " - " + WeeklyTrainingProgram.values()[i].getDay() + " | " +
                    WeeklyTrainingProgram.values()[i].getMachineOne() + " - " + WeeklyTrainingProgram.values()[i].getMuscleGrowthTraining()+"\n");
        }
        fileInput.append("\nAnd don't forget our VIP weekend program! Have fun and come back next week alive - we need your money.");

        for ( int j = 5; j < WeeklyTrainingProgram.values().length; j++ ) {
            fileInput.append(WeeklyTrainingProgram.values()[j] + " - " + WeeklyTrainingProgram.values()[j].getDay() + " | " +
                    WeeklyTrainingProgram.values()[j].getMachineOne() + ", " + WeeklyTrainingProgram.values()[j].getMachineTwo() + " - " +
                    WeeklyTrainingProgram.values()[j].getMuscleGrowthTraining() + " :) \n");
        }
        System.out.println(fileInput.toString());
        return fileInput.toString();
    }

    public static String normalBMI_program (StringBuilder fileInput) {
        fileInput.append("Stai, jusu sporto treniruociu tvarkarastis!\n" +
                "Here is your program for a week. Training time suggested - 60 min and 20 min cardio after. "
                + "Overall - 80 min. Do not hestitate to ask if you have some questions.\n\n");

        for (WeeklyTrainingProgram days : WeeklyTrainingProgram.values()) {
            fileInput.append(days+"\t - \t"+ days.getDay() + " - " + days.getMachineOne() + "(" + days.getBalancedTraining()
                    + ")" + ", " + days.getMachineTwo() + "(" + days.getBalancedTraining() + ")\n");
        }
        System.out.println(fileInput.toString());
        return fileInput.toString();
    }

    public static String littleHigherBMI_program (StringBuilder fileInput) {
        fileInput.append("Stai, jusu sporto treniruociu tvarkarastis! \nHere is your program for a week. Training time suggested - 60 min and 20 min cardio after. "
                + "Overall - 80 min. Do not hestitate to ask if you have some questions.\n");
        for ( int k = 0; k < WeeklyTrainingProgram.values().length - 2; k+=2 ) {
            fileInput.append(WeeklyTrainingProgram.values()[k] + " - " + WeeklyTrainingProgram.values()[k].getDay() + " | " +
                    WeeklyTrainingProgram.values()[k].getMachineOne() + " - " + WeeklyTrainingProgram.values()[k].getBalancedTraining()+"\n");
        }
        fileInput.append(WeeklyTrainingProgram.values()[6] + " - " + WeeklyTrainingProgram.values()[1].getDay() + " | " +
                WeeklyTrainingProgram.values()[1].getMachineOne() + " - " + WeeklyTrainingProgram.values()[1].getBalancedTraining());
        System.out.println(fileInput.toString());
        return fileInput.toString();
    }

    public static String highBMI_program (StringBuilder fileInput) {
        fileInput.append("Stai, jusu sporto treniruociu tvarkarastis! \nPrevent common running injuries and build strength "
                + "by adding bodyweight exercises to your weekly workout routine—no fancy "
                + "equipment or expensive gym membership required.\nHere are some of the best "
                + "bodyweight exercises you can do to strengthen your stride and maintain better"
                + " posture through each run.\nThese bodyweight moves will help you target your legs, "
                + "core, and even your upper body.\nThe best part: With summer fast approaching, you can "
                + "bust out these moves outside after a long run.");
        System.out.println(fileInput.toString());
        return fileInput.toString();
    }
}
