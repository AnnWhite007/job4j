package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String patient;
    private String diagnose;

    public String getPatient(String patient) {
        this.patient = patient;
        return this.patient;
    }
    public String getDiagnose(String diagnose) {
        this.diagnose = diagnose;
        return this.diagnose;
    }

    public static void card (String[] args) {
    Profession profession = new Profession();
    Doctor doctor = new Doctor();
    }
}
