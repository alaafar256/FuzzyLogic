import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome To Support System For Project Team Formation ") ;
		int NumberOfvariables ; 
		Scanner scan = new Scanner (System.in) ;
		System.out.println("Enter the number of variables ") ; 
		NumberOfvariables = scan.nextInt() ; 
		Variable [] variables = new Variable [NumberOfvariables]  ; 
		String Variablename ; 
		int VariableValue  ; 
		int numberofsetsinvariable ; 
		String SetName ; 
		String shape ; 
		Variable outputset ; 
		int numberofsetsinTeamExperienceLevel ; 
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
		System.out.println("6-Enter the points of set ") ; 
        for (int i = 0; i < numberofsetsinvariable; i++) {
            SetName = scan.next();
            shape = scan.next();
            outputset.fuzzyset[i] = new FuzzySets(SetName, shape);
            for (int j = 0; j < outputset.fuzzyset[i].numberofvaluesofset.length; j++) {
                VariableValue = scan.nextInt();
                outputset.fuzzyset[i].numberofvaluesofset[j] = VariableValue;
            }
        }
        
        System.out.println("******************Fuzzifying the inputs******************") ; 
        for (Variable variable : variables) {
        	System.out.println("membership of sets of " + variable.GetName());
            variable.Fuzzifyingtheinputs() ;
        }
        
	    System.out.println("-------------------------------------------------") ; 
	    
 
 
		

	}

}
/* input 
2
Fundingproject 50 4
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
*/
