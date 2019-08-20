package JAVA_GYM;

public enum WeeklyTrainingProgram {
    MONDAY("CHEST-DAY", "Bench Press", "Incline Press"),
    TUESDAY("BACK-DAY", "Deadlift", "Lat pulldown"),
    WEDNESDAY("SHOULDER-DAY", "Cables and pulleys", "Dumbell lift"),
    THURSDAY("ARM-DAY", "Dipping bars", "Preacher-Bench"),
    FRIDAY("Woo-hoo! LEG-DAY", "Squat-rack", "Leg-press"),
    SATURDAY("REST-DAY", "Drink beer", "Get involved into fight."),
    SUNDAY("REST-DAY", "Chop grandma's firewood", "Drink more beer.");

    private String day;
    private String machineOne;
    private String machineTwo;
    private String muscleGrowthTraining = "2 sets, 6-8 reps.";
    private String balancedTraining = "3 sets, 8-12 reps.";

    private WeeklyTrainingProgram(String day, String exerciseOne, String exerciseTwo) {
        this.day = day;
        this.machineOne = exerciseOne;
        this.machineTwo = exerciseTwo;
    }

    public String getDay() {
        return day;
    }

    public String getMachineOne() {
        return machineOne;
    }

    public String getMachineTwo() {
        return machineTwo;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMachineOne(String machineOne) {
        this.machineOne = machineOne;
    }

    public void setMachineTwo(String machineTwo) {
        this.machineTwo = machineTwo;
    }

    public String getMuscleGrowthTraining() {
        return muscleGrowthTraining;
    }

    public String getBalancedTraining() {
        return balancedTraining;
    }

    public void setMuscleGrowthTraining(String muscleGrowthTraining) {
        this.muscleGrowthTraining = muscleGrowthTraining;
    }

    public void setBalancedTraining(String balancedTraining) {
        this.balancedTraining = balancedTraining;
    }
}

