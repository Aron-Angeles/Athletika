package io.github.aronangeles.athletika.model;

import lombok.Getter;

@SuppressWarnings("SpellCheckingInspection")
@Getter
public enum WorkoutNames {


    //CHEST
    DUMBBELL_BENCH_PRESS("Dumbbell bench press"),
    INCLINE_DUMBELL_BENCH_PRESS("Incline Dumbell bench press"),
    CABLE_FLYES("Cable flyes"),

    //SHOULDER
    DUMBBELL_SHOULDER_PRESS("Dumbbell shoulder press"),
    DUMBBELL_LATERAL_RAISE("Dumbbell later raise"),

    //BACK
    LAT_PULLDOWN("Lateral pulldown"),
    BARBELL_ROW("Barbell row"),
    DUMBBELL_SHRUGS("Dumbbell Shrugs"),

    //ARMS
    HAMMER_CURLS("Hammer curls"),
    PREACHER_CURL("Preacher curl"),
    TRICEP_PUSHDOWN("Tricep pushdown"),
    ONE_ARM_TRICEP_EXTENSION("One arm tricep extension"),

    //LEGS
    BULGARIAN_SPLIT_SQUATS("Bulgarian split squats"),
    STIFF_LEG_DEADLIFT_("Stiff leg deadlift"),
    LEG_PRESS("Leg press"),
    CALF_RAISES("Calf raises"),

    //CORE
    HANGING_LEG_RAISES("Hanging leg raises");

    private final String name;

    WorkoutNames(String name) {
        this.name = name;
    }
}
