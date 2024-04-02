package assn05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MaxBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;

    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */
    public MaxBinHeapER() {
        _heap = new ArrayList<>();
    }

    @Override
    public int size() {
        return _heap.size();
    }

    // TODO (Task 2A): enqueue
    public void enqueue(V value) {
        Patient newPatient = new Patient(value);
        _heap.add(_heap.size(), newPatient);
    }

    // TODO (Task 2A): enqueue
    @Override
    public void enqueue(V value, P priority) {
        Patient newPatient = new Patient(value, priority);
        _heap.add(newPatient);
        bubbleUp(_heap.size() - 1);
    }

    // TODO (Task 2A): dequeue
    @Override
    public V dequeue() {
        if(_heap.size() == 0){
            return null;}

        V value = _heap.get(0).getValue();

        if (_heap.size() == 1) {
            _heap.remove(_heap.get(0));
        }

        else{
            _heap.set(0,_heap.get(_heap.size()-1));
            _heap.remove(size()-1);
            bubbleDown(0);
        }
        return value;
    }

    // TODO (Task 2A): getMax
    @Override
    public V getMax() {
        if (_heap.isEmpty()) {
            return null;
        }
        int highestPriorityIndex = 0;

        for (int i = 1; i < _heap.size(); i++) {
            Prioritized priority1 = _heap.get(i);
            Prioritized priority2 = _heap.get(highestPriorityIndex);

            if (priority1.getPriority().compareTo(priority2.getPriority()) > 0) {
                highestPriorityIndex = i;
            }
        }

        return _heap.get(highestPriorityIndex).getValue();
    }

    // TODO (part 2B) : updatePriority
    public void updatePriority(V value, P newPriority) {
        int index = -1;
        for (int i = 0; i < size(); i++) {
            Prioritized<V, P> patient = _heap.get(i);
            if (patient.getValue().equals(value)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            Prioritized<V, P> updatedPatient = _heap.remove(index);
            updatedPatient = new Patient<>(updatedPatient.getValue(), newPriority); // Create a new patient with updated priority
            _heap.add(updatedPatient); // Re-insert the patient into the heap
            bubbleUp(_heap.size() - 1); // Maintain the heap property
        } else {
            System.out.println("Patient with value " + value + " not found.");
        }
    }

    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO (Task 3): overloaded constructor
    public MaxBinHeapER(Prioritized<V, P>[] initialEntries ) {
        _heap = new ArrayList<>();

        for(int i = 0; i < initialEntries.length; i++){
            enqueue(initialEntries[i].getValue(),initialEntries[i].getPriority());
        }
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }

    public void bubbleUp(int index){
        if (index == 0) {
            return;  // reached the root of the heap
        }

        Prioritized child = _heap.get(index);
        Prioritized parent = _heap.get((index - 1) / 2);

        if (child.getPriority().compareTo(parent.getPriority()) >= 0) {
            // Swap the child and parent nodes
            _heap.set(((index - 1) / 2), child);
            _heap.set(index, parent);
            bubbleUp((index - 1) / 2);  // bubble up with the parent index
        }
    }

    public void bubbleDown(int index){
        Prioritized top = _heap.get(index);

        if (!hasLeftChild(index) && !hasRightChild(index)) {
            return;
        }

        else if (!hasRightChild(index)) {
            Prioritized leftChild = _heap.get(leftChildInd(index));
            if (leftChild.getPriority().compareTo(top.getPriority()) > 0) {
                _heap.set(index, leftChild);
                _heap.set(leftChildInd(index), top);
                bubbleDown(leftChildInd(index));
            }

            else {
                return;
            }
        }

        else {
            Prioritized left = _heap.get(leftChildInd(index));
            Prioritized right = _heap.get(rightChildInd(index));
            if (left.getPriority().compareTo(top.getPriority()) > 0 || right.getPriority().compareTo(top.getPriority()) > 0) {
                if (left.getPriority().compareTo(right.getPriority()) > 0) {
                    _heap.set(index, left);
                    _heap.set(leftChildInd(index), top);
                    bubbleDown(leftChildInd(index));
                }

                else {
                    _heap.set(index, right);
                    _heap.set(rightChildInd(index), top);
                    bubbleDown(rightChildInd(index));
                }
            }

            else {
                return;
            }
        }
    }


    boolean validIndex(int idx){
        if((idx >= 0) && (idx <= size() - 1)){return true;}
        else{return false;}
    }
    static int rightChildInd(int idx){
        return (2*idx + 2);
    }
    static int leftChildInd(int idx){
        return (2*idx + 1);
    }

    boolean hasRightChild(int idx){
        return(validIndex(rightChildInd(idx)));
    }
    boolean hasLeftChild(int idx){
        return(validIndex(leftChildInd(idx)));
    }

}
