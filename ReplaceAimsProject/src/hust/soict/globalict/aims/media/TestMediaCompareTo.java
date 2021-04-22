package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestMediaCompareTo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Collection collection = new ArrayList();
		List<DigitalVideoDisc> collection = new ArrayList<DigitalVideoDisc>();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(12, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(34, "Star Wars", "Science Fiction", 14.95f, 124, "George Lucas");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(13, "Aladdin", "Animation", 18.99f, 90, "John Musker");
		
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
		
		Iterator iterator = collection.iterator();
		
		System.out.println("--------------------------------");
		System.out.println("The DVDs currently in the order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
		}
		
		Collections.sort((List) collection);
		
		iterator = collection.iterator();
		
		System.out.println("--------------------------------");
		System.out.println("The DVDs currently in the order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
		}
		
		System.out.println("--------------------------------");
		
//		ArrayList<Track> track = new ArrayList<Track>();
//		Track a = new Track("Example", 20);
//		track.add((Track) a);
//		
//		collection = new ArrayList<Media>();
//		CompactDisc cd1 = new CompactDisc(12, "The Lion King", "Animation", 19.95f, "Roger Allers", track);	
//		ArrayList<Track> track1 = new ArrayList<Track>();
//		track1.add(new Track("Example1", 13));
//		CompactDisc cd2 = new CompactDisc(34, "Star Wars", "Science Fiction", 14.95f, "George Lucas", track1);
//		ArrayList<Track> track11 = new ArrayList<Track>();
//		track11.add(new Track("Example2", -15));
//		track11.add(new Track("nnn", 14));
//		CompactDisc cd3 = new CompactDisc(13, "Aladdin", "Animation", 18.99f, "John Musker", track11);
//		
//		collection.add(cd1);
//		collection.add(cd2);
//		collection.add(cd3);
//		
//		iterator = collection.iterator();
//		
//		System.out.println("--------------------------------");
//		System.out.println("The CDs currently in the order are: ");
//		
//		while(iterator.hasNext()) {
//			System.out.println(((CompactDisc) iterator.next()).getTitle());
//		}
//		
//		Collections.sort((List) collection);
//		
//		iterator = collection.iterator();
//		
//		System.out.println("--------------------------------");
//		System.out.println("The CDs currently in the order are: ");
//		
//		while(iterator.hasNext()) {
//			System.out.println(((CompactDisc) iterator.next()).getTitle());
//		}
//		
//		System.out.println("--------------------------------");
	}

}
