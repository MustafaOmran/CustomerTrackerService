
// -----------------------------------------------------
// Assignment 1
// Question: part 2
// Written by: Mustafa Omran, 26745954
// -----------------------------------------------------

import java.util.Scanner;

/**
 * @author Mustafa Omran 26745954 Comp 249
 *         <p>
 *         Assignment # 1
 *         <p>
 *         Due Date 15 /07/ 2018
 *         <p>
 *         Customer tracer Service
 *         <p>
 *         This is the Driver for Customer class, the user will be presented
 *         with choices. After the user Choose one of the options, they can
 *         modify, add or compare an accounts.
 *         <p>
 *         The program will repeat until choice 5 is inserted.
 */

public class Driver {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		Customer[] userDatabase;
		final String password = "password";
		int num_Attempts = 1;
		boolean what_to_do = true;

		int maxNum_Customers;

		// welcome message and ask the user how many Customers do they want

		System.out.println("\t******** Welcome to Mustafa Omran Customer tracker Service ********\n");

		System.out.print("Please Enter the maximum number of Customers: ");
		maxNum_Customers = key.nextInt();

		// Create number of customers based on the input
		userDatabase = new Customer[maxNum_Customers];

		// Loop the program until the attribute change to false.
		while (what_to_do) {
			int choice;
			String check;
			int entary;
			int error = 1;

			// display choices and ask the user for input

			System.out.print("\n What do you want to do?\r\n" + "\t1. Enter new customer (password required)\r\n"
					+ "\t2. Change information of a customer (password required)\r\n"
					+ "\t3. Display all customers residing on the same street\r\n"
					+ "\t4. Display all customers residing in the same city\r\n" + "\t5. Quit\r\n"
					+ "Please enter your choice > ");

			choice = key.nextInt();

			// spacing

			System.out.println();

			// redirect the choices with appropriate methods.
			switch (choice) {
			case 1: {
				// Attribute to exist the loop when it changes to false.
				boolean outerLoop = true;

				while (outerLoop) {
					// ask user for input

					System.out.print("Please enter your password: ");
					check = key.next();

					// spacing
					System.out.println();

					// check the validity of the password and repeat the program until user
					// terminate.
					if (check.equals(password)) {
						while (true) {
							// ask for input and reset the value of number of attempts
							num_Attempts = 0;
							System.out.print("How many Customers do you want to enter? ");
							entary = key.nextInt();

							// validate there is enough space.

							int numb_customers_left = userDatabase.length - Customer.findNumberOfCreatedCustomers();

							int i;

							// assigning i to the place according to the number of customers created.

							if (Customer.findNumberOfCreatedCustomers() == 0) {
								i = 0;
							} else
								i = Customer.findNumberOfCreatedCustomers();

							// ask the user for input if valid and then break out of the loop
							if (numb_customers_left >= entary && entary != 0) {

								Customer.addCustomers(entary, i, userDatabase);
								break;
							}

							// if there are no customers left but its less than entry then ask for another
							// input.

							else if (numb_customers_left != 0) {
								System.out.print("There are only " + numb_customers_left
										+ " left, Do you want to try again? Yes to continue ");
								String answer = key.next();

								if (answer.equalsIgnoreCase("Yes"))
									continue;
								else
									break;
							}

							// if the user reached maximum number allowed then break.
							else {
								System.out.println("You have reached the maximum number of customers allowed");
								break;
							}
						}
					}

					// if password incorrect then repeat the loop, if password entered wrong 3 times
					// then exist the choice and increment number of attempts.
					else {

						if (error < 3) {
							System.out.println("Invalid entary please try again ");
							error++;
							num_Attempts++;
							continue;
						}

						// if the user used 12 attempts then terminate the program.
						else if (num_Attempts > 11) {
							System.out.println(
									"Program detected suspicious activities and will\n" + "terminate immediately");
							System.exit(0);
						}

						else {
							num_Attempts++;
							outerLoop = false;
						}

					}

					outerLoop = false;
				}
				break;
			}

			case 2: {
				// repeat the loop while its true.
				while (true) {
					// ask for user input for the password.
					System.out.print("Please enter your password: ");
					check = key.next();

					// spacing
					System.out.println();

					// check if the password is valid.

					if (check.equals(password)) {
						// using the boolean to repeat the loop until it becomes false.
						boolean repeate = true;

						while (repeate) {
							// asking the user for the customer number in the array.
							System.out.print("Customer: #");
							int cust_num = key.nextInt();

							// if there exist a customer with that id then display information.

							if (userDatabase[cust_num] != null) {
								boolean repeateChoices = true;

								while (repeateChoices) {
									// display the information
									System.out.println("\n" + userDatabase[cust_num]);

									int change;

									// repeat this loop until valid entry
									do {
										System.out.print("\nWhat of the infromation would you like to change? \n"

												+ "\t1. Customer name \n" + "\t2. Street number \n"
												+ "\t3. Street name \n" + "\t4. City\n" + "\t5. Quit\n"
												+ "\tYour choice > ");

										change = key.nextInt();

									} while (change < 1 || change > 5);

									// based on input, ask the user which attribute they want to change, repeat
									// until choice 5 is selected.

									switch (change) {
									case 1: {
										System.out.print("Please enter the name: ");
										String name = key.next();

										userDatabase[cust_num].setName(name);

										break;
									}

									case 2: {
										System.out.print("Please enter Street number ");
										int streetnum = key.nextInt();

										userDatabase[cust_num].setStreetNumber(streetnum);

										break;
									}

									case 3: {
										System.out.print("Please enter the Street name ");
										String streetname = key.next();

										userDatabase[cust_num].setStreetName(streetname);

										break;
									}

									case 4: {
										System.out.print("Please enter the City ");
										String city = key.next();

										userDatabase[cust_num].setCity(city);

										break;
									}

									case 5: {
										repeate = false;
										repeateChoices = false;
										break;

									}
									}

								}

							}

							// if there are no customers created, then ask the user if they want to continue

							else {
								System.out.println("This account number have not been created ? ");
								System.out.print("Do you want to enter another number ? enter a Yes if so. ");
								String ans = key.next();

								if (ans.equalsIgnoreCase("yes"))
									continue;
								else
									break;
							}
						}
					}

					// ask user for password and repeat the loop until 3 failed attempts and then
					// exist the loop.

					else if (error < 3) {
						System.out.println("Invalid entary please try again ");
						error++;
						continue;
					} else
						break;

					break;
				}

				break;

			}

			// using the Static method compare the user input with the array customers.
			case 3: {
				System.out.print("Please enter the street name : ");
				String compareStreetName = key.next();

				Customer.findCustomerBy(compareStreetName, userDatabase);

				break;
			}

			// using the static method, compare the user input with the array customers.
			case 4: {
				System.out.print("Please enter the City name : ");
				String compareCity = key.next();

				Customer.findCustomersFromCity(compareCity, userDatabase);

				break;
			}

			// break the loop
			case 5: {
				what_to_do = false;
				break;
			}

			// in the case of invalid entry repeat the options.
			default:
				System.out.println("Please enter a valid Choice ");
			}

		}
		// good bye message
		System.out.print("\t ******* Thank you for using our services, see you next time *******");

	}

}
