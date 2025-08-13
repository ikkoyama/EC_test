package bean;

public class ACCOUNTS implements java.io.Serializable {

	private int BALANCE;
	private String ACCOUNT_NUMBER;
	

	public int getBALANCE() {
		return BALANCE;
	}
	public String getACCOUNT_NUMBER() {
		return ACCOUNT_NUMBER;
	}



	public void setBALANCE(int BALANCE) {
		this.BALANCE=BALANCE;
	}
	public void setACCOUNT_NUMBER(String ACCOUNT_NUMBER) {
		this.ACCOUNT_NUMBER=ACCOUNT_NUMBER;
	}
	
}
