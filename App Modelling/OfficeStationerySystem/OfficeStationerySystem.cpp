// OfficeStationerySystem.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
using namespace std;

void addToStock();
void removeFromStock();
void displayInventoryReport();
void displayFinancialReport();
void displayTransactionLog();
void displayPersonalUsageReport();
bool containsNumber(string str);

struct Stock //contains all the data the stock holds.
{
	int item_Code;
	string item_Name;
	int quantity;
};

struct Transaction_Log //contains all the data that gets logged after each transaction.
{
	int Transaction_ID;
	string Transaction_Type;
	time_t date;
	int item_Code;
	string item_Name;
	double price_Paid;
	string person_Name;
};

//global vectors of structs.
vector<Transaction_Log> transLog;
vector<Stock> stock;

int main()
{
	int indexChoice;
	string userInput;
	while (true)
	{
		cout << flush;
		system("PAUSE");
		system("CLS");
		cout << "Index:" << endl;
		cout << "1. Add to stock." << endl;
		cout << "2. Remove from stock" << endl;
		cout << "3. Display inventory report" << endl;
		cout << "4. Display financial report" << endl;
		cout << "5. Display Transaction Log" << endl;
		cout << "6. Display personal usage report" << endl;
		cout << "Enter a number that matches your choice in the index, or enter 9 to exit: " << endl;
		cin >> userInput;
		indexChoice = atoi(userInput.c_str()); //Parse the string to an int, 
											   //stops infinite loop issue when a string is entered.
		
		if (indexChoice == 1)
		{
			addToStock();
		}

		if (indexChoice == 2)
		{
			removeFromStock();
		}

		if (indexChoice == 3)
		{
			displayInventoryReport();
		}

		if (indexChoice == 4)
		{
			displayFinancialReport();
		}

		if (indexChoice == 5)
		{
			displayTransactionLog();
		}

		if (indexChoice == 6)
		{
			displayPersonalUsageReport();
		}

		if (indexChoice == 9)
		{
			return 0;
		}
	}
}

//checking if a string contains a number.
bool containsNumber(string str)
{
	return (str.find_first_of("0123456789") == string::npos);
}

//Add stock to the stock vector.
void addToStock()
{
	//Initialisea variables for struct creation.
	bool inputOkay = false;
	int size = transLog.size();
	int itemCode;
	string itemName;
	int itemQuantity;
	double pricePaid;

	cout << "Enter the item code: " << endl;
	cin >> itemCode;

	if (cin.fail())
	{
		cin.clear(); //This corrects the stream.
		cin.ignore(); //This skips the left over stream data.
		cout << "Input is not a number. Returning to index." << endl;
		return;
	}

	//Check if the item code entered already exists.
	for (int i = 0; i < stock.size(); i++)
	{
		//Check if item exists already.
		if (itemCode == stock.at(i).item_Code)
		{
			string reply;
			cout << "Item code " << itemCode << " belongs to " << stock.at(i).item_Name << ". Do you wish to add to this stock?" << endl;
			cin >> reply; 

			//Check if user wishes to add stock to already existing item.
			if ( reply == "yes" || reply == "Yes" )
			{
				cout << "Enter quantity to be added to stock item '" << stock.at(i).item_Name << "':" << endl;
				cin >> itemQuantity; //Get quantity to add.

				stock.at(i).quantity = stock.at(i).quantity + itemQuantity;

				cout << "Enter the price paid: " << endl;
				cin >> pricePaid; //Get price paid.

				//Create Transaction_Log Struct.
				Transaction_Log tlog;
				tlog.Transaction_ID = transLog.size();
				tlog.Transaction_Type = "Add";
				tlog.item_Code = stock.at(i).item_Code;
				tlog.item_Name = stock.at(i).item_Name;
				tlog.price_Paid = pricePaid;
				tlog.person_Name = "N/A";
				tlog.date = time(0);
				//Add to the list of transactions.
				transLog.push_back(tlog);
				return;
			}

			//If they answer no, the user will be returned to the index.
			else
			{
				cout << "Item already exists, cannot create new item with existing code. Returning to index." << endl;
				return;
			}
		}
	}

	//Validate the item name contains no numbers.
	while (!inputOkay)
	{
		cout << "Enter the item name: " << endl;
		cin >> itemName;

		if (!containsNumber(itemName))
		{
			cout << "Item name should not contain numbers." << endl;
		}
		else
			inputOkay = true;
	}


	cout << "Enter quantity of items being added to stock: " << endl;
	cin >> itemQuantity;
	cout << "Enter the total price paid for the item(s): $";
	cin >> pricePaid;

	if (cin.fail())
	{
		cin.clear(); //This corrects the stream.
		cin.ignore(); //This skips the left over stream data.
		cout << "Input is not a number. Returning to index." << endl;
		return;
	}

	//Create new Stock struct from data.
	Stock s;
	s.item_Code = itemCode;
	s.item_Name = itemName;
	s.quantity = itemQuantity;

	//Create new Transaction_Log struct from data.
	Transaction_Log tlog;
	tlog.Transaction_ID = transLog.size();
	tlog.Transaction_Type = "Add";
	tlog.item_Code = itemCode;
	tlog.item_Name = itemName;
	tlog.price_Paid = pricePaid;
	tlog.person_Name = "N/A";
	tlog.date = time(0);

	//Adding new structs to the struct vectors.
	stock.push_back(s);
	transLog.push_back(tlog);
}



void removeFromStock()
{
	//Initialising variables for user input.
	string name;
	int itemCode;
	bool inputOkay = false;

	//Reading name and checking name does not contain numbers.
	while (!inputOkay)
	{
		cout << "Enter your name: " << endl;
		cin >> name;
		if (!containsNumber(name))
		{
			cout << "Name should not contain numbers." << endl;
		}
		else
			inputOkay = true;
	}

	cout << "List of stock: " << endl;

	//Outputting the entire list of stock as an index to choose from.
	for (int i = 0; i < stock.size(); i++)
	{
		cout << "Item Code: " << stock.at(i).item_Code << endl;
		cout << "Item Name: " << stock.at(i).item_Name << endl;
		cout << "Quantity: " << stock.at(i).quantity << endl;
		cout << endl;
	}

	cout << "Enter the item code for the item you wish to take: " << endl;
	cin >> itemCode;

	if (cin.fail())
	{
		cin.clear(); //This corrects the stream.
		cin.ignore(); //This skips the left over stream data.
		cout << "Input is not a number. Returning to index." << endl;
		return;
	}

	//Checking entered item code against the list of stock.
	for (int i = 0; i < stock.size(); i++)
	{
		//checking if the item matches something in the list of stock.
		if (itemCode == stock.at(i).item_Code)
		{
			//Checking if the item is in stock
			if (stock.at(i).quantity > 0)
			{
				//Creating a transaction_log struct
				Transaction_Log tlog;
				tlog.Transaction_ID = transLog.size();
				tlog.Transaction_Type = "Remove";
				tlog.item_Code = stock.at(i).item_Code;
				tlog.item_Name = stock.at(i).item_Name;
				tlog.price_Paid = 0.0;
				tlog.person_Name = name;
				tlog.date = time(0);

				//Decrease the stock quantity by 1.
				stock.at(i).quantity = stock.at(i).quantity - 1;

				//Adding the transaction struct to the list of transactions
				transLog.push_back(tlog);

				cout << "You have taken 1 " << stock.at(i).item_Name << endl;
				return;
			}
		}
	}
	//List didn't contain the item. Returns to index.
	cout << "Item does not exist. Returning to index." << endl;
	return;
}


void displayInventoryReport()
{
	for (int i = 0; i < stock.size(); i++)
	{
		//Output the item code, name, and quantity
		cout << "Item code: " << stock.at(i).item_Code << endl;
		cout << "Item name: " << stock.at(i).item_Name << endl;
		cout << "Item quantity: " << stock.at(i).quantity << endl;
		cout << endl;
	}
}


void displayFinancialReport()
{
	double totalExpenditure = 0.0;
	for (int i = 0; i < transLog.size(); i++)
	{
		//Check if the transaction type is 'add'
		if (transLog.at(i).Transaction_Type == "Add")
		{
			//output each item code, item name and price paid
			cout << "Item code: " << transLog.at(i).item_Code << endl;
			cout << "Item name: " << transLog.at(i).item_Name << endl;
			cout << "Price paid: $" << transLog.at(i).price_Paid << endl;
			cout << endl;

			//store the price paid in the totalExpenditure variable
			totalExpenditure = totalExpenditure + transLog.at(i).price_Paid;
		}
	}
	//output the total of all price paid values as the total expenditure
	cout << "Total expenditure: $" << totalExpenditure << endl;
}


void displayTransactionLog()
{
	for (int i = 0; i < transLog.size(); i++)
	{
		//Check if the transaction type is 'Add'
		if (transLog.at(i).Transaction_Type == "Add")
		{
			//Convert date to string form
			string dateString = ctime(&transLog.at(i).date);
			//output each item code, item name, price paid and the transaction type and date.
			cout << "Transaction type: " << transLog.at(i).Transaction_Type << endl;
			cout << "Transaction date: " << dateString;
			cout << "Item code: " << transLog.at(i).item_Code << endl;
			cout << "Item name: " << transLog.at(i).item_Name << endl;
			cout << "Price paid: $" << transLog.at(i).price_Paid << endl;
			cout << endl;
		}

		//Check if the transaction type is 'Remove'
		if (transLog.at(i).Transaction_Type == "Remove")
		{
			//Convert date to string form
			string dateString = ctime(&transLog.at(i).date);
			//Output each item code, item name and person's name and the transaction type and date.
			cout << "Transaction type: " << transLog.at(i).Transaction_Type << endl;
			cout << "Transaction date: " << dateString;
			cout << "Item code: " << transLog.at(i).item_Code << endl;
			cout << "Item name: " << transLog.at(i).item_Name << endl;
			cout << "Person's name: " << transLog.at(i).person_Name << endl;
			cout << endl;
		}
	}
}


void displayPersonalUsageReport()
{
	//Initialising variables.
	string name;
	bool inputOkay = false;

	//Reading name and checking name does not contain numbers.
	while (!inputOkay)
	{
		cout << "Enter person's name: " << endl;
		cin >> name;
		if (!containsNumber(name))
		{
			cout << "Name should not contain numbers." << endl;
		}
		else
			inputOkay = true;
	}

	cout << "List of items taken by '" << name << "':" << endl;
	cout << endl;

	for (int i = 0; i < transLog.size(); i++)
	{
		//Check if the transaction type is 'Remove'
		if (transLog.at(i).Transaction_Type == "Remove" && name == transLog.at(i).person_Name)
		{
			//Convert date to string form
			string dateString = ctime(&transLog.at(i).date);
			//Output each item code, item name, the transaction type and date taken.
			cout << "Transaction type: " << transLog.at(i).Transaction_Type << endl;
			cout << "Transaction date: " << dateString;
			cout << "Item code: " << transLog.at(i).item_Code << endl;
			cout << "Item name: " << transLog.at(i).item_Name << endl;
			cout << endl;
		}
	}
}

