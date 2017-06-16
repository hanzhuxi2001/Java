package designPattern;
public class ConcreteObserver implements Observer
{
    /** 观察者的状态 */
    private String observerState;
    
    public void update(String state)
    {
        /** 更新观察者的状态 */
        observerState = state;
        System.out.println("状态为：" + observerState);
    }
}