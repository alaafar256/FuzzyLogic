import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner (System.in) ;
	public static FuzzySets getfuzzyset (String name , Variable v)
	{
		for (FuzzySets s : v.fuzzyset )
		{ 
			if (s.FuzzySetName.equalsIgnoreCase(name))
			{
				System.out.println("Fuzzy Set  " + s ) ; 
				return s ; 
			}
			
		}
		
		System.out.println("doesnt exist ") ; 
		return null;
		
	}
	public static Variable getvariable (String name , Variable outputs , Variable [] inputs)
	{
		if (outputs.name.equalsIgnoreCase(name))
		{
			return outputs ; 
		}
		else {
			// in case of inputs variables 
			for (Variable v : inputs )
			{ 
				if (v.name.equalsIgnoreCase(name))
				{
					return v ; 
				}
				
			}
		}
			return null ;
		}

 	// parsing the rule
	public static Rules getinformationfromrule (String rule , int x,Variable outputs , Variable [] inputs)
	{
		Variable v  = new Variable() ;
		FuzzySets f = new FuzzySets() ; 
		ArrayList<FuzzySets> fuzzyset = new ArrayList<>(x);
        ArrayList<String> operator = new ArrayList<>(x - 1);
        while (rule.startsWith(" If ")) {
            rule = rule.substring(4);
        }
  //      System.out.println("rule " + rule) ; 
        String[] s = rule.split(" ") ;
  //      System.out.println("rule after spliting " + Arrays.toString(s) ) ; 
  //      System.out.println(s[0] + " " + s[1] + "  " + s[2] + "  " + s[3]) ; 
        v = getvariable(s[0],outputs , inputs) ; 
  //     System.out.println("v =  " + v ) ; 
        f = getfuzzyset(s[2],v) ; 
 //      System.out.println("f =  " + f ) ; 
    	fuzzyset.add(f)  ;  
    	int length = s.length ; 
    //    System.out.println(length) ; 
    	 for (int i = 0; i < length; i++) {

             if (s[i].equals("and") || s[i].equals("or")) {

                 v = getvariable(s[i + 1],outputs , inputs);
                 f = getfuzzyset(s[i + 3], v);
                 fuzzyset.add(f);
             }
             if (s[i].equalsIgnoreCase("then")) {
                 v = getvariable(s[i + 1],outputs , inputs);
                 f = getfuzzyset(s[i + 3], v);
             }
         }
    	 for (String str :  s) {
             if (str.equals("and")) {
                 operator.add("and");
             } else if (str.equals("or")) {
                 operator.add("or");
             }
         }
    //     String outputname = s[s.length - 1];
         
         FuzzySets ou = f;
         Rules result = new Rules(rule, fuzzyset, operator, ou);
    //     System.out.println("rule "  + result) ; 
         return result;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println("Welcome To Support System For Project Team Formation ") ;
		 int NumberOfvariables ; 
		Rules [] rules ; 
		String Variablename ; 
	    int VariableValue  ; 
	    int numberofsetsinvariable ; 
	    String SetName ; 
	    String shape ; 
	    Variable outputset  ; 
	    int numberofsetsinTeamExperienceLevel ; 
	    int numberofRules ;
		 String rulestatment; 

		System.out.println("Enter the number of variables ") ; 
		NumberOfvariables = scan.nextInt() ; 
		Variable [] variables = new Variable [NumberOfvariables] ; 

		System.out.println("1-Enter the Name of variables ") ; 
		System.out.println("2-Enter the value of variables ") ; 
		System.out.println("3-Enter the number sets in variables ") ; 
		System.out.println("4-Enter the Name of set ") ; 
		System.out.println("5-Enter the shape of set ") ; 
		System.out.println("6-Enter the points of set ") ; 
        System.out.println("The format for This one NameofVariable ValueofVariable NumberofSets") ;
        System.out.println("NameofSet shape Points ") ;
		for (int i = 0 ; i < NumberOfvariables; i++ )
		{
			Variablename= scan.next() ; 
			VariableValue=scan.nextInt() ; 
			numberofsetsinvariable=scan.nextInt()  ; 
		//	System.out.println("i" + i++) ; 
		//	System.out.print(Variablename+" " + VariableValue + "  " +numberofsetsinvariable );
			variables[i] = new Variable(Variablename,VariableValue,numberofsetsinvariable) ; 
			for (int j = 0; j <numberofsetsinvariable; j++ )
			{
				SetName=scan.next() ; 
				shape=scan.next() ; 
//				System.out.print(SetName+" " + shape  );

				variables[i].fuzzyset[j]=new FuzzySets(SetName ,shape) ;  
				 int point ;
				 int length = variables[i].fuzzyset[j].numberofvaluesofset.length ;
		//		 System.out.println("length : " + length ) ;
                for (int m = 0; m < length; m++) {
                    point = scan.nextInt();
                    variables[i].fuzzyset[j].numberofvaluesofset[m] = point;
                } 

			}
			System.out.println("-------------------------------------------------") ; 

			
		}
		System.out.println("1-Enter Name of variable of output FuzzyLogic Set ")  ; 
		Variablename = scan.next() ; 
		System.out.println("2-Enter the number sets in variables ") ; 
		numberofsetsinvariable=scan.nextInt() ; 
        outputset = new Variable(Variablename, 0, numberofsetsinvariable); 
		System.out.println("3-Enter the Name of set ") ; 
		System.out.println("4-Enter the shape of set ") ; 
		System.out.println("5-Enter the points of set ") ; 
        for (int i = 0; i < numberofsetsinvariable; i++) {
            SetName = scan.next();
            shape = scan.next();
            outputset.fuzzyset[i] = new FuzzySets(SetName, shape);
            for (int j = 0; j < outputset.fuzzyset[i].numberofvaluesofset.length; j++) {
                VariableValue = scan.nextInt();
                outputset.fuzzyset[i].numberofvaluesofset[j] = VariableValue;
            }
        }
       
	    System.out.println("-------------------------------------------------") ; 
	    
	   
	    System.out.println("Enter The Number of The rules : ") ; 
	    numberofRules = scan.nextInt() ; 
	    rules = new Rules[numberofRules] ; 
	    int  x ;  
	    System.out.println("1-Enter The Number statment in each rule : ") ; 
	    System.out.println("2-Enter The Rule : ") ; 
	    for (int i = 0 ; i < numberofRules ; i++ )
	    {
	           x = scan.nextInt() ;
	           rulestatment = scan.nextLine() ; 
		       rules[i]  = getinformationfromrule(rulestatment,x,outputset,variables);
		     
	    }
	    System.out.println("\n-------------------------------------------------\n") ; 

	     System.out.println("******************Fuzzifying the inputs******************") ; 
	        for (Variable variable : variables) {
	        	System.out.println("membership of sets of " + variable.GetName());
	            variable.Fuzzifyingtheinputs() ;
	        }
	        
		System.out.println("\n-------------------------------------------------\n") ; 

		System.out.println("******************The Inference******************") ; 

	    for (Rules r : rules) {
           System.out.println(r.inference());
        }
	    System.out.println("\n-------------------------------------------------\n") ; 

	    System.out.println("\n******************Defuzzification the output******************") ; 
     //   outputset.Defuzzification(); 
        outputset.domain(outputset.Defuzzification()); 

}
}

/* input 
2
ProjectFunding 50 4
Verylow trapezoidal 0 0 10 30 
low trapezoidal 10 30 40 60
medium trapezoidal 40 60 70 90
high trapezoidal 70 90 100 100
///////////////////////////////////////////
TeamExperienceLevel 40 3
beginner triangle 0 15 30
intermediate triangle 15 30 45
expert triangle 30 60 60
////////////////////////////////////////////
risk 
3
high triangle 0 25 50
normal triangle 25 50 75
low triangle 50 100 100 
////////////////////////////////////////////
rules 4
2 If ProjectFunding is high or TeamExperienceLevel is expert then risk is low
3 If ProjectFunding is medium and TeamExperienceLevel is intermediate or TeamExperienceLevel is beginner then risk is normal
1 If ProjectFunding is Verylow then risk is high
2 If ProjectFunding is low and TeamExperienceLevel is beginner then risk is high
*/
/////////////////////////////////////////////////////////////////////////////////////////
/* another test 
2
size 20 2  
small triangle 0 0 100 
large triangle 0 100 100
------------------------------------------------------
weight 25 2  
light triangle 0 0 100
heavy triangle 0 100 100 
------------------------------------------------------
quality 
3 
bad triangle 0 0 5 
medium triangle 0 5 10 
good triangle 5 10 10 

------------------------------------------------------
rules 
4
2 If size is small and weight is light then quality is bad
2 If size is small and weight is heavy then quality is medium
2 If size is large and weight is light then quality is medium
2 If size is large and weight is heavy then quality is good
*/
 