/* Author: Mirak Bumnanpol 
Student number: 3320409
Start date 14/05/2019
Name of document: Depot.java
Assignment 2 SENG1110*/
import java.io.*;
public class Depot
{
	//Instance Variables
	private String depotName;
	private Product[] productNew = new Product[5];
	private int invalid;
	
	//Depot constructors 
	public Depot ()
	{
		depotName = "Enter in New Depot";
		for (int i=0; i<5; i++)
			productNew[i] = new Product();
	}

	//Getters and Setters 
	public void setDepotName(String newDepotName)
	{
		depotName = newDepotName;
	}

	public String getDepotName()
	{
		return depotName;
	}


	//This method checks for any duplicate product names 
	public int setProductDuplicate(String productName)
	{
		int duplicate = 1;
		if(this.productNew[0].getProductName().equalsIgnoreCase(productName))
		{
			duplicate = 0;
		}
		else if (this.productNew[1].getProductName().equalsIgnoreCase(productName))
		{
			duplicate = 0;
		}

		else if (this.productNew[2].getProductName().equalsIgnoreCase(productName))
		{
			duplicate = 0;
		}

		else if (this.productNew[3].getProductName().equalsIgnoreCase(productName))
		{
			duplicate = 0;
		}

		else if (this.productNew[4].getProductName().equalsIgnoreCase(productName))
		{
			duplicate = 0;
		}
		return duplicate;
	}

	//This method resets the quantity of products after checking for duplicates
	public void setDuplicateUpdateQuantity(String productName, int productQuantity)
	{
		int newProductQuantity = 0;

		if(this.productNew[0].getProductName().equalsIgnoreCase(productName))
		{
			newProductQuantity = productNew[0].getProductQuantity() + productQuantity;
			productNew[0].setProductQuantity(newProductQuantity);
		}
		else if (this.productNew[1].getProductName().equalsIgnoreCase(productName))
		{
			newProductQuantity = productNew[1].getProductQuantity() + productQuantity;
			productNew[1].setProductQuantity(newProductQuantity);
		}
		else if (this.productNew[2].getProductName().equalsIgnoreCase(productName))
		{
			newProductQuantity = productNew[2].getProductQuantity() + productQuantity;
			productNew[2].setProductQuantity(newProductQuantity);
		}
		else if (this.productNew[3].getProductName().equalsIgnoreCase(productName))
		{
			newProductQuantity = productNew[3].getProductQuantity() + productQuantity;
			productNew[3].setProductQuantity(newProductQuantity);
		}
		else if (this.productNew[4].getProductName().equalsIgnoreCase(productName))
		{
			newProductQuantity = productNew[4].getProductQuantity() + productQuantity;
			productNew[4].setProductQuantity(newProductQuantity);
		}
	}
	//This method removes multiple quantities of products
	public String numRemoved(String productName, int productQuantity)
	{
		String displayMessage = "";
		int i=0;
		boolean productFound = false;
		while ( i<productNew.length && !productFound) 
		{
			if (productName.equalsIgnoreCase(productNew[i].getProductName())) 
			{
				productNew[i].setProductQuantity(productNew[i].getProductQuantity()-productQuantity);
				productFound =true;
				displayMessage=(productQuantity+" items of Product "+productName+" has been removed from depot: "+depotName);
				if (productNew[i].getProductQuantity()<=0)
				{
					displayMessage=(productName+" has been removed from depot: "+depotName);
					productNew[i]=new Product ();
				}
			}
			i++;
		}
		return displayMessage;
	}

	//This method queries for a list of products in depot

	public String setProductDetails(String productName, double productPrice, double productWeight, int productQuantity)
	{
		String displayMessage = "";
		invalid = setProductDuplicate(productName);
		if (invalid==1)
		{
			if(this.productNew[0].getProductName().equals(""))
			{
				productNew[0].setProduct(productName, productPrice, productWeight, productQuantity);
				displayMessage =("Product name: " +productName+"\nPrice: "+productPrice+"\nWeight: "+productWeight+"\nQuantity: "+productQuantity);
			}

			else if (this.productNew[1].getProductName().equals(""))
			{
				productNew[1].setProduct(productName, productPrice, productWeight, productQuantity);
				displayMessage =("Product name: " +productName+"\nPrice: "+productPrice+"\nWeight: "+productWeight+"\nQuantity: "+productQuantity);
			}

			else if (this.productNew[2].getProductName().equals(""))
			{
				productNew[2].setProduct(productName, productPrice, productWeight, productQuantity);
				displayMessage =("Product name: " +productName+"\nPrice: "+productPrice+"\nWeight: "+productWeight+"\nQuantity: "+productQuantity);
			}

			else if (this.productNew[3].getProductName().equals(""))
			{
				productNew[3].setProduct(productName, productPrice, productWeight, productQuantity);
				displayMessage =("Product name: " +productName+"\nPrice: "+productPrice+"\nWeight: "+productWeight+"\nQuantity: "+productQuantity);
			}

			else if (this.productNew[4].getProductName().equals(""))
			{
				productNew[4].setProduct(productName, productPrice, productWeight, productQuantity);
				displayMessage =("Product name: " +productName+"\nPrice: "+productPrice+"\nWeight: "+productWeight+"\nQuantity: "+productQuantity);
			}

			else{
			displayMessage=("Only 5 Products per depot can be added. Product filled.");
			}
		}

		else 
		{
			displayMessage = ("This Product already exists");
		}

		return displayMessage;
	}
	//This method displays all the product's details
	public String getProductDetails()
	{
		String displayMessage = "";

			
			if(!productNew[0].getProductName().equals(""))
			{
				displayMessage +=("Product name: " +productNew[0].getProductName()+"\nPrice: "+productNew[0].getProductPrice()+"\nWeight: "+productNew[0].getProductWeight()+"\nQuantity: "+productNew[0].getProductQuantity()+"\n");
			}

			if (!productNew[1].getProductName().equals(""))
			{
				displayMessage +=("Product name: " +productNew[1].getProductName()+"\nPrice: "+productNew[1].getProductPrice()+"\nWeight: "+productNew[1].getProductWeight()+"\nQuantity: "+productNew[1].getProductQuantity()+"\n");
			}

			if (!productNew[2].getProductName().equals(""))
			{
				displayMessage +=("Product name: " +productNew[2].getProductName()+"\nPrice: "+productNew[2].getProductPrice()+"\nWeight: "+productNew[2].getProductWeight()+"\nQuantity: "+productNew[2].getProductQuantity()+"\n");
			}

			if(!productNew[3].getProductName().equals(""))
			{
				displayMessage +=("Product name: " +productNew[3].getProductName()+"\nPrice: "+productNew[3].getProductPrice()+"\nWeight: "+productNew[3].getProductWeight()+"\nQuantity: "+productNew[3].getProductQuantity()+"\n");
			}

			if(!productNew[4].getProductName().equals(""))
			{
				displayMessage +=("Product name: " +productNew[4].getProductName()+"\nPrice: "+productNew[4].getProductPrice()+"\nWeight: "+productNew[4].getProductWeight()+"\nQuantity: "+productNew[4].getProductQuantity()+"\n");
			}

			if(displayMessage.equals(""))
			{
			displayMessage=("No Products In Depot.");
			}

		return displayMessage;
	}
	//This method tests for a product's presence in the depot
	public String getProductsPresenceDepot(String productName)
	{
		String displayMessage = "";
		if(this.productNew[0].getProductName().equalsIgnoreCase(productName))
		{
			displayMessage = ("Depot name: " +depotName+"\nProduct name: " +productNew[0].getProductName()+"\nQuantity: "+productNew[0].getProductQuantity()+"\n");
		}
		else if(this.productNew[1].getProductName().equalsIgnoreCase(productName))
		{
			displayMessage = ("Depot name: " +depotName+"\nProduct name: " +productNew[1].getProductName()+"\nQuantity: "+productNew[1].getProductQuantity()+"\n");
		}
		else if(this.productNew[2].getProductName().equalsIgnoreCase(productName))
		{
			displayMessage = ("Depot name: " +depotName+"\nProduct name: " +productNew[2].getProductName()+"\nQuantity: "+productNew[2].getProductQuantity()+"\n");
		}
		else if(this.productNew[3].getProductName().equalsIgnoreCase(productName))
		{
			displayMessage = ("Depot name: " +depotName+"\nProduct name: " +productNew[3].getProductName()+"\nQuantity: "+productNew[3].getProductQuantity()+"\n");
		}
		else if(this.productNew[4].getProductName().equalsIgnoreCase(productName))
		{
			displayMessage = ("Depot name: " +depotName+"\nProduct name: " +productNew[4].getProductName()+"\nQuantity: "+productNew[4].getProductQuantity()+"\n");
		}
		else 
		{
			displayMessage=("Product does not exist.");
		}
		return displayMessage;
	}
	//This method checks specifically for a product name within the interface
	public String getProductByName(String productName)
	{
		String displayMessage="Product not found";
		boolean productNameFound=false;
		int x=0;
		while(!productNameFound && x<productNew.length)
		{
			if (productName.equals(productNew[x].getProductName())) 
			{
				displayMessage = productNew[x].getProductName();
				productNameFound=true;
			}
			
		x++;
		}
		return displayMessage;
	}

	//This method returns the cumulative total of products in  depot
	public double getCumulative()
	{
		double cumulativeValue = ((this.productNew[0].getProductPrice()*this.productNew[0].getProductQuantity()) + (this.productNew[1].getProductPrice()*this.productNew[1].getProductQuantity()) + (this.productNew[2].getProductPrice()*this.productNew[2].getProductQuantity())+ (this.productNew[3].getProductPrice()*this.productNew[3].getProductQuantity()) + (this.productNew[4].getProductPrice()*this.productNew[4].getProductQuantity()));
		return cumulativeValue;
	}
	//This method finds the number of products 
	public int numberOfProducts()
	{
		int counter = 5;
		if(this.productNew[0].getProductName().equals(""))
		{
			counter--;
		}
		if(this.productNew[1].getProductName().equals(""))
		{
			counter--;
		}
		if(this.productNew[2].getProductName().equals(""))
		{
			counter--;
		}
		if(this.productNew[3].getProductName().equals(""))
		{
			counter--;
		}
		if(this.productNew[4].getProductName().equals(""))
		{
			counter--;
		}
		return counter;
	}

	//This method checks for any duplicate depot names
	public boolean setDepotDuplicate(String depotName)
	{
		if(this.getDepotName().equals(depotName))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	//This method exports depot and product information to a file
	public void printInfo(PrintWriter fileName)
	{
		boolean depotIsEmpty = true;
		for(int i=0; i<4; i++)
		{
			if(!this.productNew[i].getProductName().equals(""))
			{
				fileName.println(depotName + "-depot " + productNew[i].getProductName() + " " + productNew[i].getProductPrice() + " " + productNew[i].getProductWeight() + " " + productNew[i].getProductQuantity());
				depotIsEmpty =false;
			}
		}
		if(depotIsEmpty == true)
		{
			fileName.println(depotName+ "-depot");
		}
	}
}
	