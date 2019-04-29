import java.lang.Math;
import java.text.DecimalFormat;

public class Loan{

	private double principal; //principle amount owing
	private double interest; //interest rate 
	private int term; //amount of years to pay off loan
	
	DecimalFormat fmt = new DecimalFormat("0.##");
	
	public Loan(double principal, double interest, int term){
		this.principal = principal;
		this.interest = interest;
		this.term = term;
	}
	
	public double getPrincipal(){
		return principal;
	}
	
	public double getInterest(){
		return interest;
	}
	
	public int getTerm(){
		return term;
	}
	
	public void setPrincipal(double principal){
		this.principal=principal;
	}
	
	public void setInterest(double interest){
		this.interest = interest;
	}
	
	public void setTerm(int term){
		this.term = term;
	} 
	
	public String payment(double principal, double interest, int term){
		double mi = interest / (12*100); //monthly interest
		double emi = (principal * mi *(double) Math.pow(1 + mi, term)) / (double) (Math.pow(1 + mi, term) -1);
		return fmt.format(emi);
	}
	
	//public double lifetimeInterest(double principal, double interest, double term){
	//	return (

	public static void main(String[] args){
		
		Loan loan = new Loan(40000, 3.5, 120);
			
		System.out.println(loan.payment(loan.getPrincipal(), loan.getInterest(), loan.getTerm()));
	}
	
}



//monthly payments 
//lifetime interest 
