import java.util.Arrays;

public class Variable {
	String name ; 
	int value ; 
	int numberofsetsforvariable ; 
	public FuzzySets [] fuzzyset; 
	public Variable(String name, int v , int numberofsetsforvariable ) {
		 this.numberofsetsforvariable = numberofsetsforvariable;
	     fuzzyset = new FuzzySets[numberofsetsforvariable];
        this.name  = name;
       value = v;  
    }
    public Variable() {
		// TODO Auto-generated constructor stub
    	name = " " ; 
    	value = 0 ; 
    	numberofsetsforvariable = 0 ; 
    	fuzzyset = null ;
	}
	public String GetName() 
    {
    	return this.name ; 
    }
    public int getvalue() 
    {
    	return this.value ; 
    }
    public int numberofsetsforvariable() 
    {
    	return this.numberofsetsforvariable ; 
    }
    @Override
    public String toString() {
        return "Variable{" + "variableName=" + name + ", variableValue=" + value + ", numberofsetsforvariable=" + numberofsetsforvariable + ", fuzzySet=" + Arrays.toString(fuzzyset) + '}';
    }
    public void Fuzzifyingtheinputs() {
        for (FuzzySets s : fuzzyset) {
        	System.out.print(s.FuzzySetName + " = ");
               s.Membership(value);
        }
    }
    public void domain(double d) {
        for (FuzzySets s : fuzzyset) {
        	
            if (d <= s.centroid) 
            {
            	System.out.println("Predicted Value will be " + s.FuzzySetName );
            }

        }
    }
    public double Defuzzification() {
    	double sumofmembershipsvalues =0.0 ;
    	double sumofcentroidmulofmemberships = 0.0 ; 
    	double PredictedValue = 0.0 ; 
        for (FuzzySets s : fuzzyset) {
        	System.out.print(s.FuzzySetName + " ");
               s.GetCentroid(); 
               sumofmembershipsvalues +=s.centroid *s.membership ; 
               sumofcentroidmulofmemberships =sumofcentroidmulofmemberships+ s.membership;

        }
        if (sumofcentroidmulofmemberships != 0 ) {
        PredictedValue = sumofmembershipsvalues/sumofcentroidmulofmemberships ; 
        System.out.println("Predicted Value Risk = " + PredictedValue); 
        }
        return PredictedValue ;   
    }
}
/*Fundingproject
40
4
TeamExperienceLevel
50
3
*/