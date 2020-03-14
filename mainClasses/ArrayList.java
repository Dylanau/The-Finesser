package mainClasses;

public class ArrayList<TBA extends Comparable> {
	// new Object array
	private Object[] data = new Object[100];
	// counts the index in the array
	private int numElements = 0;

	// shift left moves all the objects in the array one space to the left
	private void shiftLeft(int startIdx) {
		// length of the array for loop
		for (int i = startIdx; i < numElements - 1; i++) {
			// while the for loop is going it will copy the array one space to
			// the left of the other
			data[i] = data[i + 1];
		}
	}

	private void shiftRight(int startIdx) {
		// reverse of shift left
		for (int i = numElements; i >= startIdx; i--) {
			// copies the objects one index to the right of its index
			data[i + 1] = data[i];
		}
	}

	// this method adds an object into the next element of the array
	public void insert(Object input, int index) {
		if (numElements == data.length) {
			// will resize if num elements is filled the array
			resize();
		}
		// will shift all vairables right from the input number
		shiftRight(index);
		// inserts the number at that insert
		data[index] = input;
		// increments num elements
		numElements++;

	}
	public void swap(int idx1, int idx2) {
		TBA temp = (TBA) data[idx1]; 
		// sets a temp variable to first object
		
		
		data[idx1] = data[idx2];
		//swap
		data[idx2] = temp;
	}
	
	public Object objectAt(int index) {
		if (index > numElements) { //if index is more than number of the elements, error
			throw new IllegalArgumentException();
		}
		//return the object at index if in bounds
		return data[index];
	}

	// this method takes out a value and returns it with an exact index
	public Object remove(int index) {
		// gets the object saved that is going to be removed
		Object poppedObject = data[index];
		shiftLeft(index);
		numElements--;
		// returns object
		return poppedObject;
	}

	// resizes and doubles the length of the area
	private void resize() {
		// copies data into temp with double the size of original array
		Object[] temp = new Object[data.length * 2];
		for (int i = 0; i < numElements; i++) {
			// copies all the new data over
			temp[i] = data[i];
		}
		// sets it back to data
		data = temp;
	}

	// returns the size of the array
	public int size() {
		return numElements;
	}

	// returns all the objects in the array in a string
	public String toString() {
		String result = "{";
		// uses a for loop to add to the final result string
		for (int i = 0; i < numElements; ++i) {
			result += "\"" + data[i] + "\"";

			if (i != numElements - 1) {
				result += ",";
			}
		}
		result += "}";
		return result;
	}

	// returns true or false if any of the indexes in the array [[p;p
	public boolean isEmpty() {
		if (numElements <= 0) {
			return true;
		} else {
			return false;
		}
	}

	private int indexOf(Object input) {
		for (int i = 0; i < numElements; i++) {
			if (data[i] == input) {
				return i;
			}
		}
		return -1;
	}

	public boolean equals(ArrayList arr) {
		// compares arrays using the size method
		if (arr.size() != numElements) {
			return false;
		}
		int counter = 0;
		// if the count doesnt add up to the array list the arrays arent equal
		for (int i = 0; i < numElements; i++) {
			if (data[i] == arr.get(i)) {
				counter++;
			}
		}
		// if the counter is equal to the length that means all the objects in
		// both arrays are the same
		if (counter == data.length) {
			return true;
		} else {
			return false;
		}
	}

	// returns an object at a certain index in the array
	public Object get(int index) {
		// returns object
		return data[index];
	}

}