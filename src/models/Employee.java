package models;

public class Employee {
	private int id;
	private static int ID = 1;
	private String my_first_name;
	private String my_last_name;
	private String my_password;
	private int my_phone_number;
	private String my_address;

	public Employee(final String the_first_name, final String the_last_name,
			final String the_password, final int the_phone_number, final String the_address){
		my_first_name = the_first_name;
		my_last_name = the_last_name;
		my_password = the_password;
		my_phone_number = the_phone_number;
		my_address = the_address;
		id = 0;
	}

	public void setFirstName(final String the_first_name){
		my_first_name = the_first_name;
	}
	public void setLastName(final String the_last_name){
		my_last_name = the_last_name;
	}
	public void setPassword(final String the_password){
		my_password = the_password;
	}
	public void setPhoneNumber(final int the_phone_number){
		my_phone_number = the_phone_number;
	}
	public void setAddress(final String the_address){
		my_address = the_address;
	}
	public String getFirstName(){
		return my_first_name;
	}
	public String getLastName(){
		return my_last_name;
	}
	public int getPhoneNumver(){
		return my_phone_number;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", my_first_name=" + my_first_name
				+ ", my_last_name=" + my_last_name + ", my_password="
				+ my_password + ", my_phone_number=" + my_phone_number
				+ ", my_address=" + my_address + "]";
	}

	public String getAddress(){
		return my_address;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((my_address == null) ? 0 : my_address.hashCode());
		result = prime * result
				+ ((my_first_name == null) ? 0 : my_first_name.hashCode());
		result = prime * result
				+ ((my_last_name == null) ? 0 : my_last_name.hashCode());
		result = prime * result
				+ ((my_password == null) ? 0 : my_password.hashCode());
		result = prime * result + my_phone_number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (my_address == null) {
			if (other.my_address != null)
				return false;
		} else if (!my_address.equals(other.my_address))
			return false;
		if (my_first_name == null) {
			if (other.my_first_name != null)
				return false;
		} else if (!my_first_name.equals(other.my_first_name))
			return false;
		if (my_last_name == null) {
			if (other.my_last_name != null)
				return false;
		} else if (!my_last_name.equals(other.my_last_name))
			return false;
		if (my_password == null) {
			if (other.my_password != null)
				return false;
		} else if (!my_password.equals(other.my_password))
			return false;
		if (my_phone_number != other.my_phone_number)
			return false;
		return true;
	}
	public void setID(){
		ID = id;
		id++;
	}
	public static int getID(){
		return ID;
	}

	public static void main(String...the_args){
		Employee em = new Employee("Edward","Bassan","pass", 253-465-7374, "3434 100th pl");
		System.out.println(em.toString());
	}

}
