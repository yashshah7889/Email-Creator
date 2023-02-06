package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;//private to stop direct access from the api.
	private String lastName;
	private String password;
	private String department;
	private String email;
	private String alternateEmail;
	private int mailboxCapacity = 500;
	private int defaultLength = 10;
	private String companySuffix = "yash.com";
	
	//constructor to receive first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		
		//call method for department
		this.department=setDepartment();
		
		//call a methd returns a random password
		this.password= randompassword(this.defaultLength);
		System.out.println("YOUR PASSWORD IS: "+this.password);
		
		//to create email combine all elements
		email = this.firstName.toLowerCase()+ "."+this.lastName.toLowerCase()+"@"+this.department+"."+companySuffix;
		
	}
	
	
	
	//ask for the department.
	private String setDepartment() {
		System.out.println("Enter the department \n1 for sales \n2 for development \n3 for accounting \n0 for exit \nEnter department code:");
		Scanner sc= new Scanner(System.in);
		int depChoice = sc.nextInt();
		if(depChoice==1) {
			return "sales";
		}else if(depChoice==2) {
			return "development";
		}else if(depChoice==3) {
			return "accounting";
		}else {
			return "";
		}	
	}
	
	//generate random password
	private String randompassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i=0; i<length ;i++) {
			int rand=(int)(Math.random()*passwordSet.length());
			password[i]= passwordSet.charAt(rand);
		}
		return new String(password);//as password is character so to change in string
	}
	
	//set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity=capacity;
	}
	public int getMailBoxCapacity() {
		return mailboxCapacity;
	}
	
	//set alternate email
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	//change password
	public void changePassword(String password) {
		this.password =password;
	}
	public String getPassword()
	{
		return password;
		
	}	
	
	public String showInfo() {
		return "DISPLAY NAME: "+firstName+ " "+lastName +
				"\nCOMPANY EMAIL:"+ email +  
				"\nMAILBOX CAPACITY:" +mailboxCapacity + "mb";
				}
}
