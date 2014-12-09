package phoenix.patterns.p23Memento;

import java.util.List;

public class ContactMemento {

	public List<ContactPerson> contactPersonBack;

	public List<ContactPerson> getContactPersonBack() {
		return contactPersonBack;
	}

	public void setContactPersonBack(List<ContactPerson> contactPersonBack) {
		this.contactPersonBack = contactPersonBack;
	}

	public ContactMemento(List<ContactPerson> persons) {
		this.contactPersonBack = persons;
	}

}
