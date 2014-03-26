package phoenix.practise.second.B34;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class B34AddressBookVer3 implements B34AddressBook {

	private static final int DEFAULT_SIZE = 25;

	private Map entry;

	public B34AddressBookVer3() {
		this(DEFAULT_SIZE);
	}

	public B34AddressBookVer3(int size) {
		entry = new HashMap(size);
	}

	@Override
	public void add(B34Person newPerson) {
		entry.put(newPerson.getName(), newPerson);
	}

	@Override
	public boolean delete(String searchName) {
		boolean status;
		B34Person p = (B34Person) entry.remove(searchName);
		if (p == null) {
			status = false;
		} else {
			status = true;
		}
		return status;
	}

	@Override
	public B34Person search(String searchName) {
		return (B34Person) entry.get(searchName);
	}

	@Override
	public B34Person[] sort(int attribute) {
		if (!(attribute == B34Person.NAME || attribute == B34Person.AGE)) {
			throw new IllegalArgumentException();
		}

		B34Person[] sortedList = new B34Person[entry.size()];
		entry.values().toArray(sortedList);

		Arrays.sort(sortedList, getComparator(attribute));
		return sortedList;
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
