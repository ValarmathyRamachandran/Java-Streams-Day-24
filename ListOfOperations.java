	package bridgelabzAddressBook;
	import java.lang.reflect.Array;
import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
	import java.util.Map;
	import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
	
	public class ListOfOperations<listContactInfo>  {
		String addressBookName;
		Scanner scan = new Scanner(System.in);
		Map<String, ArrayList<listContactInfo>> map = new HashMap<String, ArrayList<listContactInfo>>();
		ArrayList<ListOfOperations> listContactInfo = new ArrayList<ListOfOperations>();
		public String FirstName;String LastName;String Address;String State;int Zip;
		String PhoneNumber;
		String Email;
	
		public ListOfOperations(String FirstName, String LastName, String State, String PhoneNumber) {
			super();
			this.FirstName = FirstName;
			this.LastName = LastName;
			this.State = State;
			this.PhoneNumber = PhoneNumber;
		}
		
		public ListOfOperations() {
			// TODO Auto-generated constructor stub
		}
		public  String getFirstName() {
			return FirstName;
		}
		public String getLastName() {
			return LastName;
		}
		public String getState() {
			return State;
		}
		public String getPhoneNumber() {
			return PhoneNumber;
		}
		
		public Map<String, ArrayList<listContactInfo>> innerMap;
		private Object i;
		
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
					listContactInfo.get(i).Zip = scan.nextInt();
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
		public void checkDuplicateAndAdd() {
			System.out.println("Enter the first name of person");
            String firstName = scan.next();
            Stream<ListOfOperations> lstFilteredFirstName= listContactInfo.stream()
					.filter(s->s.FirstName.equals(firstName));
			var filteredList=lstFilteredFirstName.toList();
			boolean isExists = filteredList.size()>0?true:false;
			if(isExists) {
				System.out.println("Entered First Name already exists. Please Enter new name");
			}else{
                System.out.println("Entered First Name is unqiue,\nPlease continue to Enter the full contact Informations\n");
                addContactInfo() ;
			}
		}
		public void addContactInfo() {
			ListOfOperations listOfOperations = new ListOfOperations(FirstName, LastName, State, PhoneNumber);
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
			listOfOperations.Zip = scan.nextInt();
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
			System.out.print("\n");// 
			}
		}
		
		public void searchCity() {
			boolean isExists=false;
			System.out.println("Please enter the City Name to Search");
			String City = scan.next();
			Stream<ListOfOperations> lstFilteredItems= listContactInfo.stream()
					.filter(s->s.State.equals(City));
			var filteredList=lstFilteredItems.toList();
			isExists=filteredList.size()>0?true:false;
			if(!isExists) {
				System.out.println("Entered City Name doesnot Match,Please Entry Valid City Name");
			}	
			else
			{
			System.out.println("Search result for List of Persons in a City or State " +City +"\nCount: " +filteredList.size());
			}
			filteredList.forEach((k) -> {
				System.out.println("First Name of the Person: "+k.FirstName + " ");
				});	
		}

		  
		public void sortCity() {
			
			   System.out.println("Before sorting list of Contact Informations : ");
			   printContactInfo();
			   	Collections.sort(listContactInfo, (o1, o2) -> (o1.getState().compareTo(o2.getState())));
			   printContactInfo();
				 System.out.println("After sorting list of Contact Informations : ");
				   
		}
	}
