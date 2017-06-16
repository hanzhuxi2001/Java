package designPattern;
public class UseStrategy {

    private Strategy strategy;
    
    public UseStrategy(Strategy strategy) {
        this.strategy= strategy; 
    }
    
    public void function() {
        strategy.opt();
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    
}