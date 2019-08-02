package pack;

public class AccountTest {
	public static void main(String[] args) {
		Account acc = new Account();
		acc.setAcc_no(1000);
		System.out.println("Account No " + acc.getAcc_no());
		acc.setAcc_Name("Aye Zar");
		System.out.println("Account Name " + acc.getAcc_Name());
	}
}
