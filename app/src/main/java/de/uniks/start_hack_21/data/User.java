package de.uniks.start_hack_21.data;

import java.util.List;

public class User {
    private String name;
    private String lastName;
    private int height;
    private int age;
    private List<StepData> steps;
    private List<SleepData> sleep;
    private List<NutrientsData> nutrition;
    private List<PulseData> pulse;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public List<StepData> getSteps() {
        return steps;
    }

    public List<SleepData> getSleep() {
        return sleep;
    }

    public List<NutrientsData> getNutrition() {
        return nutrition;
    }

    public List<PulseData> getPulse() {
        return pulse;
    }
}
