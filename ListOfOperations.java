package bridgelabzAddressBook;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOfOperations<listContactInfo> {
	String addressBookName;
	Scanner scan = new Scanner(System.in);
	Map<String, ArrayList<listContactInfo>> map = new HashMap<String, ArrayList<listContactInfo>>();
	ArrayList<ListOfOperations> listContactInfo = new ArrayList<ListOfOperations>();
	public String FirstName;String LastName;String Address;String State;String Zip;
	String PhoneNumber;
	String Email;
	public Map<String, ArrayList<listContactInfo>> innerMap;
	
	public void showAddressBook(int mainMenuChoice) {
		if(mainMenuChoice == 1)
		{
			if(map.size() == 0) {
			System.out.println("Address Book is Not Available");	
			}
			else {
				for(int i=0;i<map.size();i++)
				{
			System.out.println("List of AddressBooks: \n" + map.keySet().toArray()[i]);
				}
			}
		}
	}
	public void createNewAddressBook(int mainMenuChoice) {
		if(mainMenuChoice == 2) //create new Address book
		{
			System.out.println("Please Enter the Address Book name:");
	
			addressBookName = scan.next();
	
			System.out.println("Address Book name:" + addressBookName);
		}
	}
	public void editContactInfo() {
		System.out.println("Enter the First Name to search in order to edit:");
		String searchText = scan.next();
		for(int i=0;i<listContactInfo.size();i++)
		{
			if(searchText.toLowerCase().equals(listContactInfo.get(i).FirstName.toLowerCase()))
			{
				System.out.println("Enter the First Name:");
				listContactInfo.get(i).FirstName = scan.next();
				System.out.println("Enter the Last Name:");
				listContactInfo.get(i).LastName = scan.next();
				System.out.println("Enter the Address:");
				listContactInfo.get(i).Address = scan.next();
				System.out.println("Enter your state:");
				listContactInfo.get(i).State = scan.next();
				System.out.println("Enter the Zip :");
				listContactInfo.get(i).Zip = scan.next();
				System.out.println("Enter the Phone Number:");
				listContactInfo.get(i).PhoneNumber = scan.next();
				System.out.println("Enter your email:");
				listContactInfo.get(i).Email = scan.next();
				System.out.println("Contact Information is Edited Successfully\n");
			}
		}
	}
	public void deleteContactInfo() {
		
		System.out.println("Enter the First Name to delete:");
		String searchText = scan.next();
		for(int i=0;i<listContactInfo.size();i++)
		{
			if(searchText.equals(listContactInfo.get(i).FirstName.toLowerCase()))
			{
				listContactInfo.remove(i);
				System.out.println("Contact Information deleted Successfully\n");
			}
		}
	}
	public void addContactInfo() {
		ListOfOperations listOfOperations = new ListOfOperations();
		Map<String, ArrayList<listContactInfo>> innerMap = new HashMap<String, ArrayList<listContactInfo>>();
		System.out.println("Enter the First Name:");
		listOfOperations.FirstName = scan.next();
		System.out.println("Enter the Last Name:");
		listOfOperations.LastName = scan.next();
		System.out.println("Enter the Address:");
		listOfOperations.Address = scan.next();
		System.out.println("Enter your state:");
		listOfOperations.State = scan.next();
		System.out.println("Enter the Zip :");
		listOfOperations.Zip = scan.next();
		System.out.println("Enter the Phone Number:");
		listOfOperations.PhoneNumber = scan.next();
		System.out.println("Enter your email:");
		listOfOperations.Email = scan.next();
		listContactInfo.add(listOfOperations);
		System.out.println("Number of Contacts :"+listContactInfo.size());
		System.out.println("Contact Information was Added Successfully\n");
		innerMap.put(addressBookName, (ArrayList<listContactInfo>) listContactInfo);
		map.putAll(innerMap);
		
	}
	public void printContactInfo( )
	{
		for(int i=0;i<listContactInfo.size();i++) {
		System.out.println("-----Display Contact Information-----");
		System.out.println("FirstName: "+listContactInfo.get(i).FirstName);
		System.out.println("LastName: "+listContactInfo.get(i).LastName);
		System.out.println("Address: "+listContactInfo.get(i).Address);
		System.out.println("State: "+listContactInfo.get(i).State);
		System.out.println("Zip: "+listContactInfo.get(i).Zip);
		System.out.println("Phone Number: "+listContactInfo.get(i).PhoneNumber);
		System.out.println("E-mail: "+listContactInfo.get(i).Email);
		System.out.print("\n");
		}
	}
	
	public void searchCity() {
		ArrayList<ListOfOperations> listContactInfo = new ArrayList<ListOfOperations>();
		System.out.println("Please enter the City Name to Search");
		String City = scan.next();
		
		ArrayList<ListOfOperations> contactInfo = (ArrayList<ListOfOperations>) listContactInfo.stream()
		.filter(e -> e.State.equalsIgnoreCase(City))
		 .collect(Collectors.toList()); 
		
			System.out.println(City);
		
	}
}