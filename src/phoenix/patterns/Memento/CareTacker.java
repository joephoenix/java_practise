package phoenix.patterns.Memento;

import java.util.ArrayList;
import java.util.List;

public class CareTacker {

	public ContactMemento contactMemento;

	public ContactMemento getContactMemento() {
		return contactMemento;
	}

	public void setContactMemento(ContactMemento contactMemento) {
		this.contactMemento = contactMemento;
	}

	public void tackerInit() {
		List<ContactPerson> persons = new ArrayList<ContactPerson>();
		ContactPerson cp1 = new ContactPerson();
		cp1.setName("Learing Hard");
		cp1.setMobileNum("124556464");
		persons.add(cp1);
		ContactPerson cp2 = new ContactPerson();
		cp2.setName("Tony Smith");
		cp2.setMobileNum("3323424242");
		persons.add(cp2);
		ContactPerson cp3 = new ContactPerson();
		cp3.setName("Jock Port");
		cp3.setMobileNum("55344353535");
		persons.add(cp3);

		MobileOwner mo = new MobileOwner(persons);
		mo.show();

		// 创建备忘录并保存对象
		CareTacker ct = new CareTacker();
		ct.setContactMemento(mo.CreateMemento());
		// 更改发起人联系人列表
		System.out.println("------------移除一个联系人----------");
		mo.ContactPersons.remove(2);
		mo.show();

		// 恢复到原始状态
		System.out.println("------------恢复联系人列表----------");
		mo.RestoreMemento(ct.getContactMemento());
		mo.show();
	}

}
