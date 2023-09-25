// Fraction Class
public class Fraction implements INumber{

	// Fields
	int numerator;
	int denominator;
	
	// Constructor
	public Fraction(int num, int den)
	{
		numerator = num;
		denominator = den;
	}

	// Print Method 
	// Colby Cormier
	public void print() 
	{
		System.out.println(this.numerator + "/" + this.denominator);
	}

	// Compare method 
	// Colby Cormier
	public int compare (Fraction F) 
	{
		double num1 = this.numerator;
		double denom1 = this.denominator;
		double num2 = F.numerator;
		double denom2 = F.denominator;
		
		if((num1 / denom1) == (num2 / denom2))
		{
			return 0;
		}
		else if((num1 / denom1) < (num2 / denom2))
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}

	@Override
	// Written by Colby
	public Object plus(Object input) {
		
		// Create a new fraction object to be returned
		Fraction returnFrac = null;
		Fraction frac2 = (Fraction)input;
		
		// First, check whether the denominators are equal. This is the easiest case of
		// fraction addition
		if(this.denominator == frac2.denominator)
		{
			// In this case, we can just add the numerators, and return the fractionValue
			returnFrac = new Fraction(this.numerator + frac2.numerator, this.denominator);
		}
		// If the denominators aren't the same, we need a different process
		// a/b + c/d = (a*d) + (b*c)/(b*d);
		else
		{
			returnFrac = new Fraction((this.numerator * frac2.denominator) + (frac2.numerator * this.denominator), 
					                   this.denominator * frac2.denominator);
		}
		
		// Return the fraction object
		return returnFrac;
	}

	@Override
	// made by Nikan Kadkhodazadeh
	public Object minus(Object input) {

		Fraction returnFrac = null;
		Fraction frac2 = (Fraction)input;
		
		if(this.denominator == frac2.denominator)
		{
			returnFrac = new Fraction(this.numerator - frac2.numerator, this.denominator);
		}
		else
		{
			returnFrac = new Fraction((this.numerator * frac2.denominator) - (frac2.numerator * this.denominator), 
					                   this.denominator * frac2.denominator);
		}
		
		return returnFrac;
	}

	@Override
	//mult method written by: Audrey
	public Object divide(Object input) {
		
		Fraction frac2 = (Fraction)input;
		return new Fraction(this.numerator * frac2.denominator, this.denominator * frac2.numerator);
	}

	@Override
	//mult method written by: Audrey
	public Object multiply(Object input) {
		
		Fraction frac2 = (Fraction)input;
		return new Fraction(this.numerator * frac2.numerator, this.denominator * frac2.denominator);
	}
}
