/* Author: Mirak Bumnanpol 
Student number: 3320409
Start date 14/05/2019
Name of document: Interface.java
Assignment 2 SENG1110*/
import java.util.*;
import java.io.*;
public class Interface 
{	
	//Instance Variables	
	private static Depot[] depotNew = new Depot[4];
	private static String productName, depotName, depotDeletion;
	private static double productPrice, productWeight;
	private static int productQuantity;
	private static Scanner keyboard = new Scanner(System.in);

	//Instantiation of arrays
	public Interface()
	{
		for(int i=0; i<4; i++)
			depotNew[i] = new Depot();
	}

	public static void main (String[] args)
	{
		Interface intFace = new Interface();
		intFace.run();
	}

	private void run(){
		System.out.println("Alcoworths Supermarket System");
		int a, b, counter;
		counter = 4;
		do
		{
			//This is the main menu
			System.out.println("\n******MAIN MENU******");
			System.out.println("\nEnter the number next to the action you require to proceed");
			System.out.println(" (1) Add/Remove a Depot");
			System.out.println(" (2) Add/Remove a Product");
			System.out.println(" (3) Depot List");
			System.out.println(" (4) Product List");
			System.out.println(" (5) Cumulative Value");
			System.out.println(" (6) Export Depot and Product Information");
			System.out.println(" (7) Import Depot and Product Information");
			System.out.println(" (8) Close Program");
			a = keyboard.nextInt();
			//This is the switch for the main menu
			switch(a)
			{
				case 1:
					System.out.println("******ADD/REMOVE DEPOT******");
					System.out.println("\nEnter the number next to the action you require to proceed");
					System.out.println("Selecting the number next to an existing Depot will create it");
					System.out.println("(1)" + depotNew[0].getDepotName());
					System.out.println("(2)" + depotNew[1].getDepotName());
					System.out.println("(3)" + depotNew[2].getDepotName());
					System.out.println("(4)" + depotNew[3].getDepotName());
					System.out.println("Remove a depot (5)");
					System.out.println("Return to menu page (0)");
					b = keyboard.nextInt();
					//This looks for a depot duplicate
					if((!depotNew[0].getDepotName().equalsIgnoreCase("Enter in New Depot")&&(b==1))||(!depotNew[1].getDepotName().equalsIgnoreCase("Enter in New Depot"))&&(b==2)||(!depotNew[2].getDepotName().equalsIgnoreCase("Enter in New Depot"))&&(b==3)||(!depotNew[3].getDepotName().equalsIgnoreCase("Enter in New Depot"))&&(b==4))
					{
						System.out.println("There is already a depot created");

					}
					else
					{
						changeDepot(b);
					}
					break;

				case 2:
					System.out.println("******ADD/REMOVE PRODUCT******");
					System.out.println("\nEnter the number next to the action you require to proceed");
					System.out.println("Add a product (1)");
					System.out.println("Remove a product (2)");
					System.out.println("Return to menu page (0)");
					b = keyboard.nextInt();
					changeProductDepot(b);
					break;

				case 3:
					System.out.println("******DEPOT LIST*******");
					System.out.println("\nEnter the number next to the action you require to proceed");
					System.out.println("See all Depots (1)");
					System.out.println("Search for Depots by name (2)");
					System.out.println("Return to menu page (0)");
					b = keyboard.nextInt();
					depotList(b);
					break;

				case 4:
					System.out.println("******PRODUCT LIST******");
					System.out.println("\nEnter the number next to the action you require to proceed");
					System.out.println("Search Products in Depots (1)");
					System.out.println("Search for Products by name (2)");
					System.out.println("Return to menu page (0)");
					b = keyboard.nextInt();
					productList(b);
					break;

				case 5:
					System.out.println("******CUMULATIVE VALUE******");
					System.out.println("\nEnter in the Depot Name");
					depotName = keyboard.next();
					//This multiplies each respective depot's product's price to quantity 
					if(depotName.equalsIgnoreCase(depotNew[0].getDepotName()) || depotName.equalsIgnoreCase(depotNew[1].getDepotName())|| depotName.equalsIgnoreCase(depotNew[2].getDepotName())|| depotName.equalsIgnoreCase(depotNew[3].getDepotName()))
					{
						int depotPostion=0;
						if(depotName.equals(depotNew[0].getDepotName()))
						{
							depotPostion=1;
						}
						else if (depotName.equals(depotNew[1].getDepotName()))
						{
							depotPostion=2;
						}
						else if (depotName.equals(depotNew[2].getDepotName()))
						{
							depotPostion=3;
						}
						else if (depotName.equals(depotNew[3].getDepotName()))
						{
						
							depotPostion=4;
						}

						cumulativeValue(depotPostion);
					}
					else
					{
						System.out.println("This Depot does not exist");
					}
					System.out.println("Return to menu page (0)");
					b = keyboard.nextInt();
					break;

				case 6:
					System.out.println("******EXPORTING DEPOT AND PRODUCT INFORMATION******");
					//This exports the depot and product information to a file
					PrintWriter x = openFile();
					for(int i=0; i<4; i++)
					{
						if(!depotNew[i].getDepotName().equals("Enter in New Depot"))
						{
							depotNew[i].printInfo(x);
						}
					}
					x.close();
				break;

				case 7:
					System.out.println("******IMPORTING DEPOT AND PRODUCT INFORMATION******");
					//This imports depot and product information
					String fileName = "information.txt";
					Scanner inputStream = null;
					System.out.println("The file: " + fileName + " contains the following lines: \n");
					try
					{
						inputStream= new Scanner(new File(fileName));
					}
					catch(FileNotFoundException e)
					{
						System.out.println("Error opening file: "+ fileName);
						System.exit(0);
					}
					while(inputStream.hasNextLine())
					{
						String lines = inputStream.nextLine();
						System.out.println(lines);
						takeInfo(lines);
					}
					inputStream.close();
				break;

				case 8:
					System.out.println("******PROGRAM CLOSING******");
					System.exit(0);
					break;

				default: 
					System.out.println("Invalid Input");

				}

		}
		while (counter > 1);
		counter++;		
	}
	//Adding and Removing Depots 
	private static void changeDepot(int b)
	{
		depotName = "";
		switch(b)
		{
			//This is the switch case for adding depot 1 
			case 1:
				System.out.println("******ADDING TO DEPOT 1******");
				while(depotName.equals(""))
				{
					System.out.println("Add First Depot Name");
					depotName = keyboard.next();
					
					int i = 0;
					boolean duplicateDepotName = false;
					while(duplicateDepotName == false && i<=(depotNew.length-1))
					{
						duplicateDepotName=depotNew[i].setDepotDuplicate(depotName);
						i++;
					}
					if(duplicateDepotName)
					{
						System.out.println("This Depot already exists");
					}
					else
					{
						System.out.println("New Depot Added!");
						depotNew[0].setDepotName(depotName);
					}
				}
				break;
			//This is the switch case for adding depot 2
			case 2:
				System.out.println("******ADDING TO DEPOT 2******");
				while(depotName.equals(""))
				{
					System.out.println("Add Second Depot Name");
					depotName = keyboard.next();
					
					int i = 0;
					boolean duplicateDepotName = false;
					while(duplicateDepotName == false && i<=(depotNew.length-1))
					{
						duplicateDepotName=depotNew[i].setDepotDuplicate(depotName);
						i++;
					}
					if(duplicateDepotName)
					{
						System.out.println("This Depot already exists");
					}
					else
					{
						System.out.println("New Depot Added!");
						depotNew[1].setDepotName(depotName);
					}
				}
				break;
				//This is the switch case for adding depot 3
				case 3:
				System.out.println("******ADDING TO DEPOT 3******");
				while(depotName.equals(""))
				{
					System.out.println("Add Third Depot Name");
					depotName = keyboard.next();
					
					int i = 0;
					boolean duplicateDepotName = false;
					while(duplicateDepotName == false && i<=(depotNew.length-1))
					{
						duplicateDepotName=depotNew[i].setDepotDuplicate(depotName);
						i++;
					}
					if(duplicateDepotName)
					{
						System.out.println("This Depot already exists");
					}
					else
					{
						System.out.println("New Depot Added!");
						depotNew[2].setDepotName(depotName);
					}
				}
				break;
				//This is the switch case for adding depot 4
			case 4:
				System.out.println("******ADDING TO DEPOT 4******");
				while(depotName.equals(""))
				{
					System.out.println("Add Fourth Depot Name");
					depotName = keyboard.next();
					
					int i = 0;
					boolean duplicateDepotName = false;
					while(duplicateDepotName == false && i<=(depotNew.length-1))
					{
						duplicateDepotName=depotNew[i].setDepotDuplicate(depotName);
						i++;
					}
					if(duplicateDepotName)
					{
						System.out.println("This Depot already exists");
					}
					else
					{
						System.out.println("New Depot Added!");
						depotNew[3].setDepotName(depotName);
					}
				}
				break;
			//This is the switch case for removing depots 
			case 5:
				System.out.println("******DELETE DEPOTS******");
				
				{
					System.out.println("Enter name of depot you want to delete");
					depotDeletion = keyboard.next();
					if(depotDeletion.equalsIgnoreCase(depotNew[0].getDepotName()))
					{
						depotNew[0] = new Depot();
						break;
					}
					else if(depotDeletion.equalsIgnoreCase(depotNew[1].getDepotName()))
					{
						depotNew[1] = new Depot();
						break;
					}
					else if(depotDeletion.equalsIgnoreCase(depotNew[2].getDepotName()))
					{
						depotNew[2] = new Depot();
						break;
					}
					else if(depotDeletion.equalsIgnoreCase(depotNew[3].getDepotName()))
					{
						depotNew[3] = new Depot();
						break;
					}
					System.out.println("No Depot by that Name");		
				}
				break;

			case 0:
			break;

			default: 
				System.out.println("Invalid Input");
		}

	}

	//Adding and Removing Products within the Depot
	private static void changeProductDepot(int b)
	{
		productName="";
		productPrice=0;
		productWeight=0;
		productQuantity=0;
		switch(b)
		{
			case 1:
				System.out.println("******ADDING PRODUCTS******");
				while(productName.equals(""))
				{
					System.out.println("Add Product Name");
					productName = keyboard.next();
				}
				if((depotNew[0].setProductDuplicate(productName)==0)||(depotNew[1].setProductDuplicate(productName)==0)|| (depotNew[2].setProductDuplicate(productName)==0)||(depotNew[3].setProductDuplicate(productName)==0))
				{	
					while(productQuantity<=0)
					{
						System.out.println("Enter Product's Quantity");
						productQuantity = keyboard.nextInt();
						if(productQuantity <= 0)
						{
							System.out.print("Invalid Input, Please enter a positive Integer");
						}
					}
					for (int i=0; i<depotNew.length; i++ ) 
					{
						depotNew[i].setDuplicateUpdateQuantity(productName,productQuantity);
					}
					break;
				}

				while(productPrice<=0)
				{
					System.out.println("Enter Product's Price");
					productPrice = keyboard.nextDouble();
					if(productPrice <= 0)
					{
						System.out.print("Invalid Input, Please enter a positive Number");
					}
				}

				while(productWeight<=0)
				{
					System.out.println("Enter Product's Weight");
					productWeight = keyboard.nextDouble();
						if(productWeight <= 0)
						{
							System.out.print("Invalid Input, Please enter a positive Number");
						}
				}

				while(productQuantity<=0)
				{
					System.out.println("Enter Product's Quantity");
					productQuantity = keyboard.nextInt();
						if(productQuantity <= 0)
						{
							System.out.print("Invalid Input, Please enter a positive Integer");
						}
				}
				System.out.println("Add Product to Depot: ");
				depotName = keyboard.next();
				System.out.println("New Product Added!");
				if(depotName.equalsIgnoreCase(depotNew[0].getDepotName()))
				{
					System.out.println(depotNew[0].setProductDetails(productName, productPrice, productWeight, productQuantity));	
				}
				else if(depotName.equalsIgnoreCase(depotNew[1].getDepotName()))
				{
					System.out.println(depotNew[1].setProductDetails(productName, productPrice, productWeight, productQuantity));	
				}
				else if(depotName.equalsIgnoreCase(depotNew[2].getDepotName()))
				{
					System.out.println(depotNew[2].setProductDetails(productName, productPrice, productWeight, productQuantity));	
				}
				else if(depotName.equalsIgnoreCase(depotNew[3].getDepotName()))
				{
					System.out.println(depotNew[3].setProductDetails(productName, productPrice, productWeight, productQuantity));	
				}
				else 
				{
					System.out.println("No Depot by that name, try again\n");
				}
				break;
			//This is the switch case for removing products 
			case 2:
				System.out.println("******REMOVING PRODUCTS******");
				System.out.println("What Depot do you wish to remove a product from?: ");
				depotName = keyboard.next();
				int i=0;
				boolean depotFound = false;
				String productDeletionName;
				int productDeletionQuantity;
				while(depotFound == false)
				{
					if(depotNew[i].getDepotName().equals(depotName))
					{
						depotFound = true;
					}
					else if(i>depotNew.length-1)
					{
						System.out.println("Depot does not exist.");
					}
					else
					{
						i++;
					}
				}

				System.out.println("What product would you like to remove?");
				productDeletionName = keyboard.next();
				//This makes sure that if the wrong product name is entered or a negative integer is entered, there will be an error messgae
				if(productDeletionName.equalsIgnoreCase(depotNew[i].getProductByName(productDeletionName)))
				{
					System.out.println("Enter the quantity you want to remove:");
					productDeletionQuantity = keyboard.nextInt();
					if(productDeletionQuantity>0)
					{

						System.out.println(depotNew[i].numRemoved(productDeletionName, productDeletionQuantity));
					}
					else 
					{ 
						while(productDeletionQuantity<=0)
						{
							System.out.print("Invalid Input. Please enter a positive Integer");
							keyboard.nextLine();
							productDeletionQuantity = keyboard.nextInt();
							if(productDeletionQuantity>0)
							{

								System.out.println(depotNew[i].numRemoved(productDeletionName, productDeletionQuantity));
							}
							i++;
						}
					}
				}
				else
				{
					System.out.println("Product does not exist.");
				}
				break;

			case 0:
			break;

			default: 
				System.out.println("Invalid Input");
		}
	}

	//This method shows all the Depots in the depot list 
	//!!!! need to re program this so it doesnt show everything
	private static void depotList(int a)
	{
		switch(a)
		{
			case 1:
				System.out.println("******ALL DEPOTS******");
				for (int i=0; i<4 ;i++ ) 
				{
					if(!depotNew[i].getDepotName().equals("Enter in New Depot"))
					{
						System.out.println(depotNew[i].getDepotName()+" has "+depotNew[i].numberOfProducts()+ " products");
					}
				}
			break;

			case 2:
				System.out.println("******SEARCHING FOR DEPOT NAMES******");
				System.out.println("\nEnter the name of the Depot");
				depotName = keyboard.next();
				if(depotName.equalsIgnoreCase(depotNew[0].getDepotName()))
				{
					System.out.println(depotNew[0].getDepotName()+" has "+ depotNew[0].numberOfProducts()+ " products");
				}
				else if(depotName.equalsIgnoreCase(depotNew[1].getDepotName()))
				{
					System.out.println(depotNew[1].getDepotName()+" has "+ depotNew[1].numberOfProducts()+ " products");
				}
				else if(depotName.equalsIgnoreCase(depotNew[2].getDepotName()))
				{
					System.out.println(depotNew[2].getDepotName()+" has "+ depotNew[2].numberOfProducts()+ " products");
				}
				else if(depotName.equalsIgnoreCase(depotNew[3].getDepotName()))
				{
					System.out.println(depotNew[3].getDepotName()+" has "+ depotNew[3].numberOfProducts()+ " products");
				}
				else
				{
					System.out.println("No Depot by that name, try again");
				}
			break;

			case 0:
			break;

			default: 
				System.out.println("Invalid Input");

		}
	}
	//This method shows all the products in their specific depot
	private static void productList(int a)
	{
		switch(a)
		{
			case 1:
				System.out.println("******ALL PRODUCTS******");
				System.out.println("\nEnter the name of the depot that the product is in");
				depotName = keyboard.next();
				if(depotName.equalsIgnoreCase(depotNew[0].getDepotName()))
				{
					System.out.println(depotNew[0].getProductDetails());
				}
				else if(depotName.equalsIgnoreCase(depotNew[1].getDepotName()))
				{
					System.out.println(depotNew[1].getProductDetails());
				}
				else if(depotName.equalsIgnoreCase(depotNew[2].getDepotName()))
				{
					System.out.println(depotNew[2].getProductDetails());
				}
				else if(depotName.equalsIgnoreCase(depotNew[3].getDepotName()))
				{
					System.out.println(depotNew[3].getProductDetails());
				}

				else {
					System.out.println("No Depots by that name, try again");
				}
			break;

			case 2:
				System.out.println("******ALL PRODUCTS******");
				System.out.println("Enter the product name");
				productName = keyboard.next();
				String message ="";
				message = depotNew[0].getProductsPresenceDepot(productName);
				if (message.equals(""))
				{
					message = depotNew[1].getProductsPresenceDepot(productName);
				}
				else if (message.equals(""))
				{
					message = depotNew[2].getProductsPresenceDepot(productName);
				}
				else if (message.equals(""))
				{
					message = depotNew[3].getProductsPresenceDepot(productName);
				}
				else if(message.equals(""))
				{
					System.out.println("Product does not exist");
				}
				else
				{
					System.out.println(message);
				}
			break;

			case 0:
			break;

			default: 
				System.out.println("Invalid Input");

		}
	}
	//This is the method for seeing the cumulative value of a product's quantity and price
	private static void cumulativeValue(int a)
	{
		switch(a)
		{
			case 1:
				System.out.println("******CUMULATIVE VALUE******");
				System.out.println(depotNew[0].getDepotName()+" Cumulative Value is: $" + depotNew[0].getCumulative());
				
			break;

			case 2:
				System.out.println("******CUMULATIVE VALUE******");
				System.out.println(depotNew[1].getDepotName()+" Cumulative Value is: $" + depotNew[1].getCumulative());

			break;

			case 3:
				System.out.println("******CUMULATIVE VALUE******");
				System.out.println(depotNew[2].getDepotName()+" Cumulative Value is: $" + depotNew[2].getCumulative());

			break;

			case 4:
				System.out.println("******CUMULATIVE VALUE******");
				System.out.println(depotNew[3].getDepotName()+" Cumulative Value is: $" + depotNew[3].getCumulative());

			break;

			case 0:
			break;

			default: 
				System.out.println("Invalid Input");
		}
	}
	//This is the method for exporting depot and product information to a file
	private static PrintWriter openFile()
	{
		String fileName = "information.txt";
		PrintWriter outputStream = null;
		try
		{
			outputStream= new PrintWriter(fileName);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening file:"+fileName+". Please retry!");
			System.exit(0);
		}
		return outputStream;
	}
	//This method is for the importation of depot and product info
	private static void takeInfo(String inputMessage)
	{
		String displayMessage="";
		String inboundDepotName = "";
		boolean contentCollected = false;
		int i=0;
		//Grabbing depot name
		while(i<inputMessage.length()&&contentCollected == false)
		{
			if(inputMessage.charAt(i)=='-')
			{
				i+=5;
				contentCollected = true;
			}
			else if(inputMessage.charAt(i)==' ')
			{
				System.out.println("Not valid");
			}
			else
			{
				inboundDepotName = Character.toString(inputMessage.charAt(i));
				i++;
			}
		}
		boolean duplicate =false;
		for (i=0; i<depotNew.length-1;i++ ) 
		{
			if(depotNew[i].setDepotDuplicate(inboundDepotName))
			{
				duplicate=true;
			}
		}
		if(!duplicate)
		{
			boolean depotAdded =false;
			int j=0;
			while(j<depotNew.length && !depotAdded)
			{
				if(depotNew[j].getDepotName().equals("Enter in New Depot"))
				{
					depotNew[j].setDepotName(inboundDepotName);
					depotAdded=true;
				}
				j++;
			}
		}
	}
}