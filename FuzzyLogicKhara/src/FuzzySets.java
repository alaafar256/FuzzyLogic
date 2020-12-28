import java.util.Arrays;

public class FuzzySets {
	
	String FuzzySetName ; 
	String shape ; 
	double membership ; 
	double centroid ; 
	String triangle = "triangle";
    String trapezoidal = "trapezoidal";
    double numberofvaluesofset [] ; 
    public FuzzySets()
    {
    	shape=" " ; 
    	FuzzySetName=" " ; 
    	membership =0.0 ; 
    	centroid = 0.0  ; 
    }
    public FuzzySets(String FuzzySetName ,String shape ) 
    {
    	this.FuzzySetName = FuzzySetName ; 
    	this.shape = shape ; 
    	this.centroid = 0.0 ; 
    	this.membership = 0.0 ; 
    	if (shape.equals(triangle)) {
    		numberofvaluesofset = new double[3];
        } else if (shape.contains(trapezoidal)) {
        	numberofvaluesofset = new double [4];
        }  	
    }
    @Override
    public String toString() {
        return "FuzzySets{" + "FuzzySetName=" + FuzzySetName + ", shape=" + shape + ", membership=" + membership + ", centroid=" + centroid +  ", numberofvaluesofset=" + Arrays.toString(numberofvaluesofset)+ '}';
    }
    // get centroid for output set . 
    public void GetCentroid(){
    	int length = numberofvaluesofset.length  ; 
        centroid = 0;
        for (int i = 0; i < numberofvaluesofset.length; i++) {
            centroid=centroid + numberofvaluesofset[i];
        }
        centroid = centroid / numberofvaluesofset.length;
        System.out.println("Centroid = " + centroid) ; 
    } 
    /* http://www.dma.fi.upm.es/recursos/aplicaciones/logica_borrosa/web/fuzzy_inferencia/funpert_en.htm for membership functions */ 
    /* 
      Triangular function: defined by a lower limit a, an upper limit b, and a value m, where a < m < b and x is the value of the variable 
      if x <= a so memberfunction is 0 ; 
      if a < x <= m so memberfunction is x-a/m-a 
      if m < x < b so memberfunction is b-x/b-m 
      if x >= b so memberfunction is 0 ; 
      /////////////////////////////////////////////////////////////////////////////////////////
      Trapezoidal function: defined by a lower limit a, an upper limit d, a lower support limit b, and an upper support limit c, where a < b < c < d.
      if x < a  or x > d so membership is 0 
      if a <= x <= b so membership is x-a /b-a
      if b <= x <= c  so membership is 1
      if c <= x <= d so membership is  d-x/d-c  
      
     */
    public void Membership(double valueofVariable) {
        if (shape.equals("triangle")) {
        	if (valueofVariable < numberofvaluesofset[0])
        	{
        		membership = 0  ;  
        	}
        	else if (valueofVariable>numberofvaluesofset[0] && valueofVariable <= numberofvaluesofset[1] )
        	{
        		membership = ((valueofVariable - numberofvaluesofset[0]) / (numberofvaluesofset[1]-numberofvaluesofset[0]));
        	}
        	else if (valueofVariable>numberofvaluesofset[1] &&valueofVariable<numberofvaluesofset[2])
        	{
        		membership = ((numberofvaluesofset[2] - valueofVariable) / (numberofvaluesofset[2]-numberofvaluesofset[1]));
        	}
        	else if (valueofVariable >= numberofvaluesofset[2])
        	{
        		membership = 0 ;
        	}
        	
        }
        
        else if (shape.equals("trapezoidal"))
        {
        	if (valueofVariable < numberofvaluesofset[0] ||valueofVariable > numberofvaluesofset[3] )
        	{
                 membership =0 ;
            }
        	else if (valueofVariable > numberofvaluesofset[0] && valueofVariable < numberofvaluesofset[1]) {
                membership = ((numberofvaluesofset[1] - valueofVariable) / (numberofvaluesofset[1] - numberofvaluesofset[0]));
        	}
        	else if (numberofvaluesofset[1]<=valueofVariable && valueofVariable <= numberofvaluesofset[2])
        	{
        		membership = 1 ;
        	}
        	else if (numberofvaluesofset[2]< valueofVariable && valueofVariable <numberofvaluesofset[3])
        	{
        		membership = ((numberofvaluesofset[3]-valueofVariable)/(numberofvaluesofset[3]-numberofvaluesofset[2]));
        	}	
        }
        System.out.println(membership);
    }
}

    
    


