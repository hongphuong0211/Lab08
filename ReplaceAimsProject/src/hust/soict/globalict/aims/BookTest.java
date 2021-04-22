package hust.soict.globalict.aims;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> author = new ArrayList<String>();
		author.add("Dan gian");
		Book testBook = new Book(12, "Son Tinh Thuy Tinh", "Co tich", 13, author);
		testBook.setContent("Hung Vuong thu muoi tam co mot nguoi con gai ten la My Nuong, sac dep tuyet tran. My Nuong duoc vua cha yeu thuong het muc. Nha vua muon ken cho nang mot nguoi chong that xung dang.");
		System.out.println(testBook.toString());
	}

}
