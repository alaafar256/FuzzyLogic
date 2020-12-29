import java.util.ArrayList;

public class Rules {
	int numberofRules ; 
	String rule ; 
    ArrayList<FuzzySets> x ;
    ArrayList<String> operation ;
    FuzzySets outputset ; 
    Rules(String rule , ArrayList<FuzzySets> x , ArrayList<String> operation ,FuzzySets outputset )
    {
    	this.rule = rule  ; 
    	this.x = x ; 
    	this.operation=operation ; 
    	this.outputset=outputset; 
    }
    public FuzzySets inference()
    {
    	FuzzySets result = new FuzzySets();
    	
        while (operation.size() > 0) {
            if (operation.get(0).equals("and")) {
                result.membership = Math.min(x.get(0).membership, x.get(1).membership);
                x.remove(0);
                x.remove(0);
                x.add(0, result);
                operation.remove(0);

            } else {
                result.membership = Math.max(x.get(0).membership, x.get(1).membership);
                x.remove(0);
                x.remove(0);
                x.add(0, result);
                operation.remove(0);
            }

        }
       outputset.membership=result.membership;
       return outputset;
    }
    
}
