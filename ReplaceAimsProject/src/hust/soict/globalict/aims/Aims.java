package hust.soict.globalict.aims;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.order.Order;

public class Aims {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		MemoryDaemon md = new MemoryDaemon();
		Thread md1 = new Thread(md);
		md1.setDaemon(true);
	//	Order anOrder = new Order();
		showMenu();
		md.run();
		md1.setDaemon(false);
		md.run();
//		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
//		dvd1.setCategory ("Animation");
//		dvd1.setCost (19.95f);
//		dvd1.setDirector ("Roger Allers");
//		dvd1.setLength (87);
//		
//		anOrder.addMedia(dvd1);
//		
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
//		dvd2.setCategory ("Science Fiction");
//		dvd2.setCost (24.95f);
//		dvd2.setDirector ("George Lucas");
//		dvd2.setLength (124);
//		anOrder.addMedia(dvd2);
//		
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
//		dvd3.setCategory ("Animation");
//		dvd3.setCost (18.99f);
//		dvd3.setDirector ("John Musker");
//		dvd3.setLength (90);
//		
//		anOrder.addMedia(dvd3);
//		
//		// System.out.println("Total Cost is: " + anOrder.totalCost());
//		
//		// anOrder.removeDigitalVideoDisc(dvd1);
//		// System.out.println("Total Cost is: " + anOrder.totalCost());
//		anOrder.printOrder();
//		
//		Order anOrder1 = new Order();
//		
//		DigitalVideoDisc dvd21 = new DigitalVideoDisc("The Lion King");
//		dvd21.setCategory ("Animation");
//		dvd21.setCost (19.95f);
//		dvd21.setDirector ("Roger Allers");
//		dvd21.setLength (87);
//		
//		anOrder1.addMedia(dvd21);
//		
//		DigitalVideoDisc dvd22 = new DigitalVideoDisc("Star Wars");
//		dvd22.setCategory ("Science Fiction");
//		dvd22.setCost (24.95f);
//		dvd22.setDirector ("George Lucas");
//		dvd22.setLength (124);
//		anOrder1.addMedia(dvd22);
//		
//		DigitalVideoDisc dvd23 = new DigitalVideoDisc("Aladdin");
//		dvd23.setCategory ("Animation");
//		dvd23.setCost (18.99f);
//		dvd23.setDirector ("John Musker");
//		dvd23.setLength (90);
//		
//		anOrder1.addMedia(dvd23);
//		anOrder1.printOrder();
//		
//		Order anOrder2 = new Order();
//		anOrder2.addMedia(dvd1);
//		anOrder2.printOrder();
//		Order anOrder3 = new Order();
//		anOrder3.addMedia(dvd2);
//		anOrder3.printOrder();
//		Order anOrder4 = new Order();
//		anOrder4.addMedia(dvd23);
//		anOrder4.printOrder();
//		Order anOrder5 = new Order();
//		anOrder5.addMedia(dvd1);
//		anOrder5.printOrder();
	}
	
	public static void showMenu() {
		Order newOrder = new Order();
		System.out.println("Order Management Application:");
		System.out.println("-----------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		int i = 1;
		while(i!=0) {
			i = sc.nextInt();
			switch(i) {
				case 0: break; 
				case 1:
					newOrder = new Order();
					System.out.println("Created new order");
					break;
				case 2:
					System.out.println("What do you want to add?");
					System.out.println("1. Book 2. Compact Disc 3. DigitalVideoDisc");
					
					int ii = sc.nextInt();
					switch(ii) {
						case 1: 
							System.out.println("Id: ");
							int id = sc.nextInt();
							System.out.println("Title: ");
							String title = sc.next();
							System.out.println("Category: ");
							String cate = sc.next();
							System.out.println("Cost: ");
							float cost = sc.nextFloat();
							System.out.println("Authors: ");
							String author = null;
							List<String> authors = new ArrayList<String>();
							System.out.println("How many elements in your Authors?");
							int ele1 = sc.nextInt();
							int eletm1 = 0;
							do {
								author = sc.next();
								authors.add(author);
								eletm1 ++;
							}while(eletm1 < ele1);
							Book item = new Book(id, title, cate, cost, authors);
							newOrder.addMedia(item);
							System.out.println("Added Book");
							break;
						case 2:
							System.out.println("Id: ");
							int id1 = sc.nextInt();
							System.out.println("Title: ");
							String title1 = sc.next();
							System.out.println("Category: ");
							String cate1 = sc.next();
							System.out.println("Cost: ");
							float cost1 = sc.nextFloat();
							System.out.println("Artist: ");
							String artist = sc.next();
							System.out.println("Tracks: ");
							Track track = null;
							ArrayList<Track> tracks = new ArrayList<Track>();
							System.out.println("How many elements in your tracks?");
							int ele = sc.nextInt();
							int eletm = 0;
							do {
								String trackTitle;
								System.out.println("Title: ");
								trackTitle = sc.next();
								System.out.println("Length: ");
								int trackLength = sc.nextInt();
								track = new Track(trackTitle, trackLength);
								tracks.add(track);
								eletm ++;
							}while(eletm < ele);
							CompactDisc item1 = new CompactDisc(id1, title1, cate1, cost1, artist, tracks);
							newOrder.addMedia(item1);
							System.out.println("Added Compact Disc");
							break;
						case 3:
							System.out.println("Id: ");
							int id2 = sc.nextInt();
							System.out.println("Title: ");
							String title2 = sc.next();
							System.out.println("Category: ");
							String cate2 = sc.next();
							System.out.println("Cost: ");
							float cost2 = sc.nextFloat();
							System.out.println("Length: ");
							int length = sc.nextInt();
							System.out.println("Director: ");
							String direc = sc.next();
							DigitalVideoDisc item2 = new DigitalVideoDisc(id2, title2, cate2, cost2, length, direc);
							newOrder.addMedia(item2);
							System.out.println("Added Digital Video Disc");
							System.out.println("Do you want to play this DVD");
							System.out.println("1. Yes !1. No");
							int iii = sc.nextInt();
							if(iii == 1) item2.play();
							break;

					}
					break;
				case 3:
					System.out.println("Id: ");
					int id1 = sc.nextInt();
					newOrder.removeMedia(id1);
					System.out.println("Removed media");
					break;
				case 4:
					newOrder.printOrder();
					break;
			}
					
		}
	}

}
