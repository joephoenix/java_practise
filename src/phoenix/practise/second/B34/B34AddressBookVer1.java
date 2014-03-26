package phoenix.practise.second.B34;

public class B34AddressBookVer1 implements B34AddressBook {

	private static final int DEFAULT_SIZE = 25;
	private static final int NOT_FOUND = -1;
	private B34Person[] entry;
	private int count;

	public B34AddressBookVer1() {
		this(DEFAULT_SIZE);
	}

	public B34AddressBookVer1(int size) {
		count = 0;
		if (size <= 0) {
			throw new IllegalArgumentException("size must be positive!");
		}
		entry = new B34Person[size];
	}

	@Override
	public void add(B34Person newPerson) {
		if (count == entry.length) {
			enlarge();
		}
		entry[count] = newPerson;
		count++;
	}

	@Override
	public boolean delete(String searchName) {
		boolean status;
		int loc;
		loc = findIndex(searchName);
		if (loc == NOT_FOUND) {
			status = false;
		} else {
			entry[loc] = entry[count - 1];
			status = true;
			count--;
		}
		return status;
	}

	@Override
	public B34Person search(String searchName) {
		B34Person foundPerson;
		int loc = 0;
		while (loc < count && !searchName.equals(entry[loc].getName())) {
			loc++;
		}
		if (loc == count) {
			foundPerson = null;
		} else {
			foundPerson = entry[loc];
		}
		return foundPerson;
	}

	@Override
	public B34Person[] sort(int attribute) {
		if (!(attribute == B34Person.NAME || attribute == B34Person.AGE)) {
			throw new IllegalArgumentException();
		}
		B34Person[] sortedList = new B34Person[count];
		B34Person p1, p2, temp;

		// copy references to sortedList
		for (int i = 0; i < count; i++) {
			sortedList[i] = entry[i];
		}

		// set the comparison attribute
		entry[0].setCompareAttribute(attribute);

		// begin the bubble sort on sortedList
		int bottom, comparisonResult;
		boolean exchanged = true;

		bottom = sortedList.length - 2;

		while (exchanged) {
			exchanged = false;
			for (int i = 0; i <= bottom; i++) {
				p1 = sortedList[i];
				p2 = sortedList[i + 1];

				// comparisonResult
				comparisonResult = p1.compareTo(p2);
				if (comparisonResult > 0) {
					sortedList[i] = p2;
					sortedList[i + 1] = p1;
					exchanged = true;
				}
			}
			bottom--;
		}
		return sortedList;
	}

	private void enlarge() {
		// create a new array whose size is 150% of the current array
		int newLength = (int) (1.5 * entry.length);
		B34Person[] temp = new B34Person[newLength];

		// now copy the date to the new array
		for (int i = 0; i < entry.length; i++) {
			temp[i] = entry[i];
		}

		// finally set the variable entry to point to the new array
		entry = temp;
	}

	private int findIndex(String searchName) {
		int loc = 0;
		while (loc < count && !searchName.equals(entry[loc].getName())) {
			loc++;
		}
		if (loc == count) {
			loc = NOT_FOUND;
		}
		return loc;
	}
}
