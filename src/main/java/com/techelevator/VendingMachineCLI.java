package com.techelevator;

import com.techelevator.view.VendingMenu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;


public class VendingMachineCLI {
	public static String[] itemLine = {""};
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_SECRET_OPTION = "*Sales Report";

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_SECRET_OPTION};
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private VendingMenu menu;

	public VendingMachineCLI(VendingMenu menu) {
		this.menu = menu;

	}

	public void run() {
		List<Item> vendingInventory = new ArrayList<>();
		List<String> itemIdentifiers = new ArrayList<>();
		File logFile = new File("src/main/resources","log.txt");
		//public static String[] itemLine = {""};
		File vendingMachine = new File("vendingmachine.csv");
		try {
			Scanner fileScanner = new Scanner(vendingMachine);
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				itemLine = line.split("\\|");
				if (itemLine[3].equals("Chip")) {
					Chip chip = new Chip(itemLine[1], Double.parseDouble(itemLine[2]), 5, itemLine[0]);
					vendingInventory.add(chip);
					itemIdentifiers.add(itemLine[0]);
				} else if (itemLine[3].equals("Candy")) {
					Candy candy = new Candy(itemLine[1], Double.parseDouble(itemLine[2]), 5, itemLine[0]);
					vendingInventory.add(candy);
					itemIdentifiers.add(itemLine[0]);
				} else if (itemLine[3].equals("Gum")) {
					Gum gum = new Gum(itemLine[1], Double.parseDouble(itemLine[2]), 5, itemLine[0]);
					vendingInventory.add(gum);
					itemIdentifiers.add(itemLine[0]);
				} else if (itemLine[3].equals("Beverage")) {
					Beverage beverage = new Beverage(itemLine[1], Double.parseDouble(itemLine[2]), 5, itemLine[0]);
					vendingInventory.add(beverage);
					itemIdentifiers.add(itemLine[0]);
				}
			}


//			Item[] vendingArray = (Item[]) vendingInventory.toArray();

			//VendingMenu menu = new VendingMenu(System.in, System.out);
			/**
			 String[] optionsArray = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_SECRET_OPTION};
			 if (menu.getChoiceFromOptions(MAIN_MENU_OPTIONS).equals(MAIN_MENU_OPTION_DISPLAY_ITEMS))  {
			 System.out.printf("Identifier|Name|Price|Inventory\n");
			 for(Item item : vendingInventory) {
			 System.out.printf("%s|%s|$%.2f|%d\n", item.getIdentifier(), item.getName(), item.getPrice(), item.getInventory());
			 }
			 }
			 **/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		boolean running = true;
		//String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
		//String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
		while (running) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			MoneyCounter moneyCount = new MoneyCounter(0, 0);
			// A switch statement could also be used here.  Your choice.
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.printf("Identifier|Name|Price|Inventory\n");
				for (Item item : vendingInventory) {
					System.out.printf("%s|%s|$%.2f|%d\n", item.getIdentifier(), item.getName(), item.getPrice(), item.getInventory());
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				 boolean running2 = true;
				 while(running2) {
					 Format f = new SimpleDateFormat("MM/dd/yyyy");
					 Format h = new SimpleDateFormat("hh:mm:ss a");
					 String strTime = h.format(new Date());
					 System.out.println(strTime);
					 String strDate = f.format(new Date());
					 System.out.println(strDate);

					 Scanner userInput = new Scanner(System.in);
					/**
					 try(PrintWriter writer = new PrintWriter(logFile)) {
						 //writer.append(" " + "text");
						 writer.append(strDate + " " + strTime + "\n");
						 writer.write(System.lineSeparator());
					 } catch (FileNotFoundException e) {
						 e.printStackTrace();
					 }
					**/
					 String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					 if (choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						 System.out.println("Please enter whole dollar amount to add to Vending Machine.");
						 int moneyToAdd = userInput.nextInt();
						 moneyCount.feedMoney(moneyToAdd);
						 if (moneyToAdd > 0) {
							 try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {
								 //writer.append(" " + "text");
								 String appendFeedMoney = String.format("%s %s FEED MONEY: $%d.00 " +
										 "$%.2f ", strDate, strTime, moneyToAdd, moneyCount.getCurrentBalance());
								 // writer.append(strDate + " " + strTime + " " + "FEED MONEY:" + );
								 writer.append(appendFeedMoney);
								 writer.write(System.lineSeparator());
							 } catch (FileNotFoundException e) {
								 e.printStackTrace();
							 }
						 }
						 System.out.printf("Current balance: $%.2f \n", moneyCount.getCurrentBalance());
						 System.out.printf("Current amount provided: $%d\n", moneyCount.getMoneyProvided());
					 } else if (choice2.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						 System.out.println("Testing 2");
						 //show the list of products
							 System.out.printf("Identifier|Name|Price|Inventory\n");
							 for (Item item : vendingInventory) {
								 System.out.printf("%s|%s|$%.2f|%d\n", item.getIdentifier(), item.getName(), item.getPrice(), item.getInventory());
							 }
						 //user selects based on the code "identifier"
						 System.out.println("Please enter the code of the item you would like to purchase:");
						 String code = userInput.nextLine();

						 for (Item item : vendingInventory) {
							 if (!itemIdentifiers.contains(code)) {
								 System.out.println("There is no item with that code!");
								 break;
							 }
							 //System.out.println(item.toString());
							 if (item.getIdentifier().equals(code)) {
								 if (item.getInventory() == 0) {
									 System.out.println("Sorry, this item is sold out");
									 break;
								 } else if (item.getInventory() > 0) {
									 if (item.getPrice() > moneyCount.getCurrentBalance()) {
										 System.out.println("You cannot afford this item with your current balance.");
										 break;
									 } else {
										 moneyCount.setCurrentBalance(moneyCount.getCurrentBalance()-item.getPrice());
										 item.setInventory(item.getInventory() - 1);
										 System.out.println(item.getInventory() + " " + item.getName());
										 System.out.printf("You have purchased %s for $%.2f.\n", item.getName(), item.getPrice());
										 System.out.printf("Total remaining %s: %d.\n", item.getName(), item.getInventory());
										 System.out.printf("Balance remaining: $%.2f\n", moneyCount.getCurrentBalance());
										 item.getSound();
										 try(PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {
											 //writer.append(" " + "text");
											 String appendSelectProduct = String.format("%s %s %s %s $%.2f " +
													 "$%.2f ", strDate, strTime,item.getName(), item.getIdentifier(), item.getPrice(),moneyCount.getCurrentBalance());
											 // writer.append(strDate + " " + strTime + " " + "FEED MONEY:" + );
											 writer.append(appendSelectProduct);
											 writer.write(System.lineSeparator());
										 } catch (FileNotFoundException e) {
											 e.printStackTrace();
										 }
										 break;
									 }
								 }
							 } else {
								 continue;
							 }
						 }
					 } else if (choice2.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						 moneyCount.finishTransaction();
						 System.out.printf("Current balance: $%.2f \n", moneyCount.getCurrentBalance());
						 try(PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {
							 //writer.append(" " + "text");
							 String appendGiveChange = String.format("%s %s GIVE CHANGE: $%d.00 " +
									 "$%.2f ", strDate, strTime, moneyCount.getMoneyProvided(),moneyCount.getCurrentBalance());
							 // writer.append(strDate + " " + strTime + " " + "FEED MONEY:" + );
							 writer.append(appendGiveChange);
							 writer.write(System.lineSeparator());
						 } catch (FileNotFoundException e) {
							 e.printStackTrace();
						 }
						 running2 = false;

					 }
				 }

				}
			else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
					running = false;
				}

			}

		}
		public static void main (String[]args){
			VendingMenu menu = new VendingMenu(System.in, System.out);
			VendingMachineCLI cli = new VendingMachineCLI(menu);


			cli.run();
		}
	}

