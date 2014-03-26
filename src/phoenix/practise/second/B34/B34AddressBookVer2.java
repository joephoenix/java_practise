package phoenix.practise.second.B34;

import java.util.Arrays;
import java.util.Comparator;

public class B34AddressBookVer2 implements B34AddressBook {

	private static final int DEFAULT_SIZE = 25;

	private static final int NOT_FOUND = -1;

	private B34Person[] entry;

	private int count;

	public B34AddressBookVer2() {
		this(DEFAULT_SIZE);
	}

	public B34AddressBookVer2(int size) {
		count = 0;

		if (size <= 0) { // invalid data value, use default
			throw new IllegalArgumentException("Size must be positive");
		}

		entry = new B34Person[size];
	}

	@Override
	public void add(B34Person newPerson) {
		if (count == entry.length) { // no more space left,
			enlarge(); // create a new larger array
		}

		// at this point, entry refers to a new larger array
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

		} else { // found, pack the hole

			entry[loc] = entry[count - 1];

			status = true;
			count--; // decrement count,
						// since we now have one less element
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
		// copy references to sortedList
		for (int i = 0; i < count; i++) {
			sortedList[i] = entry[i];
		}
		Arrays.sort(sortedList, getComparator(attribute));
		return sortedList;
	}

	private void enlarge() {
		// create a new array whose size is 150% of
		// the current array
		int newLength = (int) (1.5 * entry.length);
		B34Person[] temp = new B34Person[newLength];
		// now copy the data to the new array
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

	private Comparator getComparator(int attribute) {
		Comparator comp = null;

		if (attribute == B34Person.AGE) {
			comp = new AgeComparator();

		} else {
			assert attribute == B34Person.NAME : "Attribute not recognized for sorting";
			comp = new NameComparator();
		}
		return comp;
	}

	class AgeComparator implements Comparator {

		private final int LESS = -1;
		private final int EQUAL = 0;
		private final int MORE = 1;

		public int compare(Object p1, Object p2) {
			int comparisonResult;

			int p1age = ((B34Person) p1).getAge();
			int p2age = ((B34Person) p2).getAge();

			if (p1age < p2age) {
				comparisonResult = LESS;
			} else if (p1age == p2age) {
				comparisonResult = EQUAL;
			} else {
				assert p1age > p2age;
				comparisonResult = MORE;
			}

			return comparisonResult;
		}
	}

	class NameComparator implements Comparator {

		public int compare(Object p1, Object p2) {

			String p1name = ((B34Person) p1).getName();
			String p2name = ((B34Person) p2).getName();

			return p1name.compareTo(p2name);

		}
	}

}
