package phoenix.practise.second.B34;

import javax.swing.*;
import java.util.*;

public class B34CommuList {

	public static void main(String args[]) {
		B34CommuList cl = new B34CommuList();
		cl.start();
	}

	private void start() {
		String[] name = { "ape", "cat", "bee", "bat", "eel", "dog", "gnu",
				"yak", "fox", "cow", "hen", "tic", "man" };

		B34Person p;
		B34AddressBook aab;

		int version = Integer.parseInt(JOptionPane.showInputDialog(null,
				"有三种方法可以实现对象排序，请输入数字（1～3）"));

		switch (version) {
		case 1:
			aab = new B34AddressBookVer1();
			break;
		case 2:
			aab = new B34AddressBookVer2();
			break;
		case 3:
			aab = new B34AddressBookVer3();
			break;
		default:
			aab = new B34AddressBookVer1();
			break;
		}
		System.out.println("输入数据：");
		Random rd = new Random();
		for (int i = 0; i < name.length; i++) {
			int age = rd.nextInt(40) + 10;
			char xxx = rd.nextInt(1) == 0 ? 'M' : 'F';
			p = new B34Person(name[i], age, xxx);
			aab.add(p);
			System.out.println(p.toString());
		}
		System.out.println();

		B34Person[] sortedList = aab.sort(B34Person.AGE);
		System.out.println("按年龄排序：");
		for (int i = 0; i < sortedList.length; i++) {
			System.out.println(sortedList[i].toString());
		}
		System.out.println();

		// sorted by name
		sortedList = aab.sort(B34Person.NAME);
		System.out.println("按名称排序：");
		for (B34Person ap : sortedList) {
			System.out.println(ap.toString());
		}
	}
}
