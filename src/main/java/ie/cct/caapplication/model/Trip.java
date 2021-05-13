package ie.cct.caapplication.model;

public class Trip {
	
	private String name;
	private int expense;
	private int sumExpense;
	
	
	public Trip(String name, int expense, int sumExpense) {
		super();
		this.name = name;
		this.expense = expense;
		this.sumExpense = sumExpense;
	}
	public Trip() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExpense() {
		
		return expense;
	}
	public void setExpense(int sumExpense) {
		this.expense = sumExpense;
	}
	public int getSumExpense() {
		return sumExpense;
	}
	public void setSumExpense(int sumExpense) {
		this.sumExpense = sumExpense;
	}

	
}
