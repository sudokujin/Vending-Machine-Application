package com.techelevator;

import com.techelevator.view.VendingMenu;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VendingMachineCLI {
	public static String[] itemLine = {""};
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_SECRET_OPTION = "*Sales Report";

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_SECRET_OPTION };
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private VendingMenu menu;

	public VendingMachineCLI(VendingMenu menu) {
		this.menu = menu;

	}

	public void run() {
		List<Item> vendingInventory = new ArrayList<>();
		//public static String[] itemLine = {""};
		File vendingMachine = new File("vendingmachine.csv");
		try {
			Scanner fileScanner = new Scanner(vendingMachine);
			while(fileScanner.hasNextLine()){
				String line = fileScanner.nextLine();
				itemLine = line.split("\\|");
				if(itemLine[3].equals("Chip")){
					Chip chip = new Chip(itemLine[1], Double.parseDouble(itemLine[2]), 5, itemLine[0]);
					vendingInventory.add(chip);
				} else if(itemLine[3].equals("Candy")){
					Candy candy = new Candy(itemLine[1], Double.parseDouble(itemLine[2]), 5, itemLine[0]);
					vendingInventory.add(candy);
				} else if(itemLine[3].equals("Gum")){
					Gum gum = new Gum(itemLine[1], Double.parseDouble(itemLine[2]), 5, itemLine[0]);
					vendingInventory.add(gum);
				} else if(itemLine[3].equals("Beverage")){
					Beverage beverage = new Beverage(itemLine[1], Double.parseDouble(itemLine[2]), 5, itemLine[0]);
					vendingInventory.add(beverage);
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		boolean running = true;
		while (running) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			// A switch statement could also be used here.  Your choice.
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}

	public static void main(String[] args) {
		VendingMenu menu = new VendingMenu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
