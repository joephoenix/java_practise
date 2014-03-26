package phoenix.practise.second.B34;

public interface B34AddressBook {

	public void add(B34Person newPerson);

	public boolean delete(String searchName);

	public B34Person search(String searchName);

	public B34Person[] sort(int attribute);

}
