/**
This program calculates the estimated monthly payment for a loan. 
@author Brynn Haley
*/

import java.lang.Math;
import java.text.DecimalFormat;

public class Loan{

	/**
	The original principal amount owing on the loan before interest is applied.
	*/
	private double principal; 
	/** 
	The annual interest rate of the loan.
	*/
	private double rate; 
	/**
	The amount of years it will take to pay off the loan.
	*/
	private int termYears; 
	/**
	The amount of months it will take to pay off the loan. Calculated as termYears*12
	*/
	private int termMonths;
	/**
	The estimated monthly payment for the loan.
	*/
	private double emi; 
	/**
	The monthly interest rate calculated on the loan.
	*/
	private double mr;
	
	DecimalFormat fmt = new DecimalFormat("0.##");
	
	/**
	Constructs a loan. Can be a student loan, mortgage, car loan, etc.
	@param principal The amount owing on the loan before interest.
	@param interest The annual interest rate of the loan. 
	@param term The amount of months it will take to pay off the loan.
	*/
	public Loan(double principal, double rate, int termYears){
		this.principal = principal;
		this.rate = rate;
		this.termYears = termYears;
	}
	
	/** 
	This method calculates the estimated monthly payment on the loan.
	@param principal
	@param rate
	@param termYears 
	*/
	public String payment(double principal, double rate, int termYears){
		termMonths = termYears*12;
		mr = rate / (12*100); 
		emi = (principal * mr *(double) Math.pow(1 + mr, termMonths)) / (double) (Math.pow(1 + mr, termMonths) -1);
		return fmt.format(emi);
	}
	
	/**
	This method calculates a month's worth of interest on the loan.
	@param emi The monthly payment (generated from payment()).
	@param principal
	@param termYears
	*/
	public double monthlyInterest(double emi, double principal, int termYears){
		termMonths = termYears*12;
		return (rate / (12*100))*principal;
	}
		
	/**This method calculates the total amount of interest that will accumulate over the lifetime of the loan.
	@param emi
	@param principal
	@param termYears
	*/
	public double lifetimeInterest(double emi, double principal, int termYears){
		termMonths = termYears/12;
		double owing = 0;
		for(int i = 0; i<termMonths-1;i++);
			owing = principal + mr;
			
		termMonths = termYears*12;
		
	}

	public static void main(String[] args){
		
		Loan loan = new Loan(40000, 10, 120);
			
		System.out.println(loan.payment(loan.principal, loan.rate, loan.termYears));
		System.out.println(loan.monthlyInterest(loan.emi, loan.principal, loan.termYears));
		System.out.println(loan.lifetimeInterest(loan.emi, loan.principal, loan.termYears));
	}
	
}


