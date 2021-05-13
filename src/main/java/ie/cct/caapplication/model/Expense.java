package ie.cct.caapplication.model;

public class Expense {
	
	private String tripId;
	private Integer amount;
	private String description;
	private String user;
	
	//Constructors	
	public Expense() {
		super();
			}
	public Expense(String tripId, Integer amount, String description, String user) {
		super();
		this.tripId = tripId;
		this.amount = amount;
		this.description = description;
		this.user = user;
	}
	
	//Methods
	public String getTripId() {
		return tripId;
	}
	public void setTripId(String tripId) {
		this.tripId = tripId;
	}
	public int getAmount() {
		return amount;//sum all expenses
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
}
