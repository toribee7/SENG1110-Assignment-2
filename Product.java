/* Author: Mirak Bumnanpol  
Student number: 3320409
Start date 14/05/2019
Name of document: Product.java
Assignment 2 SENG1110*/
public class Product
{
	//Instance Variables
	private String productName;
	private double productPrice, productWeight;
	private int productQuantity;
	
	//Constructor to set values 
	public Product()
	{
		productName = "";
		productPrice = 0;
		productWeight = 0;
		productQuantity = 0;
	}

	public void setProduct(String newProductName, double newProductPrice, double newProductWeight, int newProductQuantity)
	{
		productName = newProductName.toLowerCase();
		productPrice = newProductPrice;
		productWeight = newProductWeight;
		productQuantity = newProductQuantity;
	}

	// Setters
	public void setProductName(String newProductName)
	{
		productName = newProductName.toLowerCase();
	}

	public void setProductPrice(double newProductPrice)
	{
		productPrice = newProductPrice;
	}

	public void setProductWeight(double newProductWeight)
	{
		productWeight = newProductWeight;
	}

	public void setProductQuantity(int newProductQuantity)
	{
		productQuantity = newProductQuantity;
	}

	//Setters
	public String getProductName()
	{
		return productName;
	}

	public double getProductPrice()
	{
		return productPrice;
	}

	public double getProductWeight()
	{
		return productWeight;
	}

	public int getProductQuantity()
	{
		return productQuantity;
	}

}