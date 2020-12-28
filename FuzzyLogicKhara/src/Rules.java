import java.util.ArrayList;

public class Rules {
	int numberofRules ; 
	String rule ; 
    ArrayList<FuzzySets> fuzzysetrule;
    ArrayList<String> operation;
    FuzzySets outputset ; 
    Rules(int numberofRules ,String rule , ArrayList<FuzzySets> fuzzysetrule , ArrayList<String> operation ,FuzzySets outputset )
    {
    	this.numberofRules = numberofRules ; 
    	this.rule = rule  ; 
    	this.fuzzysetrule = fuzzysetrule ; 
    	this.operation=operation ; 
    	this.outputset=outputset; 
    }
    
}
