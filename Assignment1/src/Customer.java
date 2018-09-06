import java.util.Scanner;

// -----------------------------------------------------
// Assignment 1
// Question: part 1
// Written by: Mustafa Omran, 26745954
// ----------------------------------------------------- 

/**
 * @author Mustafa Omran 26745954
 *         <p>
 *         Comp 249
 *         <p>
 *         Assignment # 1
 *         <p>
 *         Due Date 15 /07/ 2018
 *         <p>
 *         Customer tracer Service
 *         <p>
 *         This class will contain all variables for Customer, which user can
 *         modify and call. The constructors will initiate variables and
 *         increment Customer count by 1 every time its called.
 *         <p>
 *         Static methods is used to compare as well as return the value of the
 *         Customer number count.
 * 
 */

public class Customer {

	static Scanner key = new Scanner(System.in);
	private String name;
	private int streetNumber;
	private String streetName;
	private String city;
	private static int NUMBER_CUSTOMERS = 0;

	/**
	 * Default Constructor, Initializing all variables. Increment number of
	 * Customers created.
	 * 
	 * @param name
	 *            Customer name.
	 * @param streetNumber
	 *            Customer Street number.
	 * @param streetName
	 *            Customer Street name
	 * @param city
	 *            Customer city
	 */
	public Customer(String name, int streetNumber, String streetName, String city) {
		this.name = name;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		NUMBER_CUSTOMERS++;

	}

	/**
	 * Copy Constructor, copy a passed Customer class. Increment number of Customers
	 * created.
	 * 
	 * @param copy
	 *            passed by user.
	 */
	public Customer(Customer copy) {
		name = copy.name;
		streetNumber = copy.streetNumber;
		streetName = copy.streetName;
		city = copy.city;
		NUMBER_CUSTOMERS++;
	}

	/**
	 * get Customer name
	 * 
	 * @return name of Customer
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name.
	 *            Set name of Customer
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the Street number
	 * 
	 * @return The customer Street number.
	 */
	public int getStreetNumber() {
		return streetNumber;
	}

	/**
	 * Set street Number.
	 * 
	 * @param streetNumber
	 */
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * get Street name
	 * 
	 * @return name of Street.
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * Setting Street name
	 * 
	 * @param streetName
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * get City
	 * 
	 * @return City
	 */

	public String getCity() {
		return city;
	}

	/**
	 * Set the City name.
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Static method to find the number of customers created
	 * 
	 * @return
	 */
	public static int findNumberOfCreatedCustomers() {
		return NUMBER_CUSTOMERS;
	}

	/**
	 * 
	 * @param compare
	 *            passed by user of class Customer.
	 * @return true if both have the same Street name and city.
	 */

	public boolean equals(Customer compare) {
		return streetName.equalsIgnoreCase(compare.streetName) && city.equalsIgnoreCase(compare.city);
	}

	/**
	 * @return String including all information of the Customer.
	 */
	public String toString() {
		return "Customer Name: " + name + "\n Street number: " + streetNumber + "\n Street name: " + streetName
				+ "\n City: " + city;
	}

	/**
	 * Static method to find the Customers in the array which have the same Street
	 * name as entered, then print them. Print a message if there are no matching
	 * results.
	 * 
	 * @param compare
	 *            passed by user to specify which Street name they want to compare.
	 * @param userDatabase
	 *            passed by system, to which array of class Customer is used.
	 */
	public static void findCustomerBy(String compare, Customer[] userDatabase) {
		System.out.println("Here what we found :");

		int k = 0;

		for (int i = 0; i < userDatabase.length; i++) {
			if (userDatabase[i].getStreetName() != null) {
				if (userDatabase[i].getStreetName().equalsIgnoreCase(compare)) {
					System.out.println(userDatabase[i]);
					k++;
				}
			}
		}

		if (k == 0)
			System.out.println("There are no matching results. Please try again ");

	}

	/**
	 * Static method to find the Customers in the array which have the same city as
	 * entered, then print them. Print a message if there are no matching results.
	 * 
	 * @param compare
	 *            passed by user to specify which city they want to compare.
	 * @param userDatabase
	 *            passed by system, to which array of class Customer is used.
	 */

	public static void findCustomersFromCity(String compare, Customer[] userDatabase) {
		System.out.println("Here what we found :");

		int k = 0;

		for (int i = 0; i < userDatabase.length; i++) {

			if (userDatabase[i].getCity() != null) {
				if (userDatabase[i].getCity().equalsIgnoreCase(compare)) {
					System.out.println(userDatabase[i]);
					k++;
				}
			}
		}

		if (k == 0)
			System.out.println("There are no matching results. Please try again ");
	}

	/**
	 * Static method that add number of Customers of an array.
	 * 
	 * @param entary
	 *            the value entered.
	 * @param i
	 *            the location in the array where the customer will be stored.
	 * @param userDatabase
	 *            array of Customers.
	 */
	public static void addCustomers(int entary, int i, Customer[] userDatabase) {
		for (int k = 0; k < entary; i++, k++) {
			System.out.println("\nPlease enter customer " + (k + 1) + " information ");

			System.out.print("\tEnter the customer name : ");
			String name = key.next();

			System.out.print("\tEnter the Street number : ");
			int streetNumber = key.nextInt();

			System.out.print("\tEnter the Street Name : ");
			String streetName = key.next();

			System.out.print("\t Enter the City : ");
			String city = key.next();

			userDatabase[i] = new Customer(name, streetNumber, streetName, city);
		}
	}

}
