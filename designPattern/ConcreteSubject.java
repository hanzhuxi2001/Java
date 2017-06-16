package designPattern;
public class ConcreteSubject extends Subject
{
    private String state;
    
    public String getState()
    {
        return state;
    }
    
    public void change(String newState)
    {
        state = newState;
        System.out.println("主题状态为：" + state);
        
        // 状态发生改变时，通知各个观察者
        this.notifyObservers(state);
    }
}