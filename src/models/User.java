package models;

import java.util.Date;
import java.util.GregorianCalendar;


public class User extends Employee{

	private String my_schedule;
	private int my_procedure;
	private int my_length;
	private int my_year;
	private int my_month;
	private int my_date;
	private Date my_sign_up_date;
	private GregorianCalendar my_calender;
	public User(String the_first_name, String the_last_name,
			String the_password, int the_phone_number, String the_address, 
			String the_schedule,int the_procedure, int the_length, int the_year,
           int the_month, int the_day) {
		super(the_first_name, the_last_name, the_password, the_phone_number, the_address);
		// TODO Auto-generated constructor stub
		  my_calender = new GregorianCalendar(the_year, the_month-1, the_day);
		  my_sign_up_date = my_calender.getTime();
		  my_schedule = the_schedule;
		  my_procedure = the_procedure;
		  my_length = the_length;
		  my_year = the_year;
		  my_month = the_month;
		  my_date = the_day;
	}

	public Date getMy_sign_up_date() {
		return (Date) my_sign_up_date.clone();
	}

	public void setMy_sign_up_date(Date my_sign_up_date) {
		this.my_sign_up_date = my_sign_up_date;
	}

	@Override
	public String toString() {
		return "User [my_schedule=" + my_schedule + ", my_procedure="
				+ my_procedure + ", my_length=" + my_length + ", my_year="
				+ my_year + ", my_month=" + my_month + ", my_date=" + my_date
				+ ", my_sign_up_date=" + my_sign_up_date + ", my_calender="
				+ my_calender + "]";
	}

	public String getMy_schedule() {
		return my_schedule;
	}

	public void setMy_schedule(String my_schedule) {
		this.my_schedule = my_schedule;
	}

	public int getMy_procedure() {
		return my_procedure;
	}

	public void setMy_procedure(int my_procedure) {
		this.my_procedure = my_procedure;
	}

	public int getMy_length() {
		return my_length;
	}

	public void setMy_length(int my_length) {
		this.my_length = my_length;
	}

	public int getMy_year() {
		return my_year;
	}

	public void setMy_year(int my_year) {
		this.my_year = my_year;
	}

	public int getMy_month() {
		return my_month;
	}

	public void setMy_month(int my_month) {
		this.my_month = my_month;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((my_calender == null) ? 0 : my_calender.hashCode());
		result = prime * result + my_date;
		result = prime * result + my_length;
		result = prime * result + my_month;
		result = prime * result + my_procedure;
		result = prime * result
				+ ((my_schedule == null) ? 0 : my_schedule.hashCode());
		result = prime * result
				+ ((my_sign_up_date == null) ? 0 : my_sign_up_date.hashCode());
		result = prime * result + my_year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (my_calender == null) {
			if (other.my_calender != null)
				return false;
		} else if (!my_calender.equals(other.my_calender))
			return false;
		if (my_date != other.my_date)
			return false;
		if (my_length != other.my_length)
			return false;
		if (my_month != other.my_month)
			return false;
		if (my_procedure != other.my_procedure)
			return false;
		if (my_schedule == null) {
			if (other.my_schedule != null)
				return false;
		} else if (!my_schedule.equals(other.my_schedule))
			return false;
		if (my_sign_up_date == null) {
			if (other.my_sign_up_date != null)
				return false;
		} else if (!my_sign_up_date.equals(other.my_sign_up_date))
			return false;
		if (my_year != other.my_year)
			return false;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User user = new User("Edward", "Bassan","pass", 1234556, "134 199th pl",
				"Monday", 9990, 5, 2006,5, 4);
		System.out.println(user.my_date);

	}

}
