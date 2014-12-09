package phoenix.patterns.p23Memento;

import java.util.ArrayList;
import java.util.List;

public class MobileOwner {

	public List<ContactPerson> ContactPersons;

	public List<ContactPerson> getContactPersons() {
		return ContactPersons;
	}

	public void setContactPersons(List<ContactPerson> contactPersons) {
		ContactPersons = contactPersons;
	}

	public MobileOwner(List<ContactPerson> persons) {
		this.ContactPersons = persons;
	}

	public ContactMemento CreateMemento() {
		return new ContactMemento(new ArrayList<ContactPerson>(
				this.ContactPersons));
	}

	public void RestoreMemento(ContactMemento memento) {
		this.ContactPersons = memento.contactPersonBack;
	}

	public void show() {
		System.out.println("联系人列表中有" + ContactPersons.size() + "个人， 他们是");
		for (ContactPerson cp : ContactPersons) {
			System.out.println("姓名：" + cp.getName() + "，号码："
					+ cp.getMobileNum());
		}
	}

}
