package assn05;

import java.util.ArrayList;
import java.util.List;

public class SimpleEmergencyRoom {
    private List<Patient> patients;

    public SimpleEmergencyRoom() {
        patients = new ArrayList<>();
    }

    // TODO (Task 1): dequeue
    public Patient dequeue() {
        if (patients.isEmpty()) {
            return null;
        }

        int highestPriorityIndex = 0;

        for (int i = 1; i < patients.size(); i++) {
            Patient priority1 = patients.get(i);
            Patient priority2 = patients.get(highestPriorityIndex);

            if (((priority1.getPriority()).compareTo(priority2.getPriority())) > 0) {
                highestPriorityIndex = i;
            }
        }

        Patient highestPriorityPatient = patients.remove(highestPriorityIndex);
        return highestPriorityPatient;
    }

    public <V, P> void addPatient(V value, P priority) {
        Patient patient = new Patient(value, (Integer) priority);
        patients.add(patient);
    }

    public <V> void addPatient(V value) {
        Patient patient = new Patient(value);
        patients.add(patient);
    }

    public ArrayList getPatients() {
        return new ArrayList(patients);
    }

    public int size() {
        return patients.size();
    }

}
