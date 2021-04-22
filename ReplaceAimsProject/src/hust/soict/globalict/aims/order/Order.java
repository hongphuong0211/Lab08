package hust.soict.globalict.aims.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.utils.MyDate;

public class Order {
//	private int qtyOrdered = 0;
	private MyDate dateOrdered;
	private List<Media> itemsOrdered = new ArrayList<Media>();
	
	private static int nbOrders = 0;
	
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITTED_ORDERS = 5;

	public Order() {
		dateOrdered = new MyDate(java.time.LocalDate.now().getDayOfMonth(), java.time.LocalDate.now().getMonth().getValue(), java.time.LocalDate.now().getYear());
		if(nbOrders < MAX_LIMITTED_ORDERS) nbOrders ++;
		else {
			System.out.println("The current number of orders is over this limited number");
			nbOrders ++;
			//qtyOrdered = MAX_NUMBERS_ORDERED;
		}
	}

//	public int getQtyOrdered() {
//		return qtyOrdered;
//	}
//
//	public void setQtyOrdered(int qtyOrdered) {
//		this.qtyOrdered = qtyOrdered;
//	}
//	
	public MyDate getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(MyDate dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

//	public void addDigitalVideoDisc(DigitalVideoDisc[] disc) {
//		if(nbOrders <= MAX_LIMITTED_ORDERS)
//		for(int j = 0; j < disc.length; j++) {
//			if(this.qtyOrdered == MAX_NUMBERS_ORDERED) 
//				System.out.println("The order is almost full");
//			else
//				for(int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
//					if(itemsOrdered[i] == null) {
//						itemsOrdered[i] = disc[j];
//						this.qtyOrdered ++;
//						System.out.println("The disc has been added");
//						break;
//					}
//				}
//		}
//		
//	}
	
	public void addMedia(Media media) {
		if(nbOrders <= MAX_LIMITTED_ORDERS)
			if(this.itemsOrdered.size() == MAX_NUMBERS_ORDERED) 
				System.out.println("The order is almost full");
			else
				itemsOrdered.add(media);
	}
		
	public void removeMedia(Media media) {
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).getTitle().equals(media.getTitle()) && itemsOrdered.get(i).getCategory().equals(media.getCategory()) && itemsOrdered.get(i).getCost() == media.getCost())
				itemsOrdered.remove(i);
		}
	}
	
	public void removeMedia(int id) {
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).getId() == id)
				itemsOrdered.remove(i);
		}
	}
	
//	public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
//		if(nbOrders <= MAX_LIMITTED_ORDERS) {
//			if(this.qtyOrdered == MAX_NUMBERS_ORDERED) 
//				System.out.println("The order is almost full, the discs can't be ordered");
//			else
//				for(int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
//					if(itemsOrdered[i] == null) {
//						itemsOrdered[i] = disc1;
//						this.qtyOrdered ++;
//						System.out.println("The first disc has been added");
//						break;
//					}
//				}
//			if(this.qtyOrdered == MAX_NUMBERS_ORDERED) 
//				System.out.println("The order is almost full, the second disc can't be ordered");
//			else
//				for(int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
//					if(itemsOrdered[i] == null) {
//						itemsOrdered[i] = disc2;
//						this.qtyOrdered ++;
//						System.out.println("The second disc has been added");
//						break;
//					}
//				}
//		}
//	}
	
	public float totalCost() {
		float sumCost = 0;
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i) != null) {
				sumCost += itemsOrdered.get(i).getCost();
			}
		}
		return sumCost;
	}
	
	public void printOrder() {
		int j = 1;
		System.out.println("***********************Order***********************");
		System.out.println("Date: "); this.dateOrdered.print();
		System.out.println("Ordered Items:");
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i) != null) {
				System.out.println(j + ". Media - " + itemsOrdered.get(i).getTitle() + " - " + itemsOrdered.get(i).getCategory() + " - " + itemsOrdered.get(i).getCost() + "$");
				j++;
			}
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("***************************************************");
	}
	
	public void getALuckyItem() {
		Random lucky = new Random();
		int i = lucky.nextInt(this.itemsOrdered.size());
		if(itemsOrdered.get(i) instanceof Book) {
			itemsOrdered.set(i, new Book(itemsOrdered.get(i).getId(),itemsOrdered.get(i).getTitle(), itemsOrdered.get(i).getCategory(), 0, ((Book) itemsOrdered.get(i)).getAuthors()));
		}else if(itemsOrdered.get(i) instanceof DigitalVideoDisc) {
			itemsOrdered.set(i, new DigitalVideoDisc(itemsOrdered.get(i).getId(),itemsOrdered.get(i).getTitle(), itemsOrdered.get(i).getCategory(), 0, ((DigitalVideoDisc) itemsOrdered.get(i)).getLength(), ((DigitalVideoDisc) itemsOrdered.get(i)).getDirector()));
		}else if(itemsOrdered.get(i) instanceof CompactDisc) {
			itemsOrdered.set(i, new CompactDisc(itemsOrdered.get(i).getId(),itemsOrdered.get(i).getTitle(), itemsOrdered.get(i).getCategory(), 0, ((CompactDisc) itemsOrdered.get(i)).getArtist(), ((CompactDisc) itemsOrdered.get(i)).getTracks()));
		}
		
		printOrder();		
	}
	
}
