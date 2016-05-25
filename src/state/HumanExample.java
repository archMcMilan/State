package state;

/**
 * Created by Артем on 25.05.2016.
 */
//context
public class HumanExample {
    private Activity state;

    public void setState(Activity state) {
        this.state = state;
    }

    public void doSomething(){
        state.doSomething(this);
    }

    public static void main(String[] args) {
        HumanExample human=new HumanExample();
        human.setState(new Work());
        for (int i=0;i<10;i++){
            human.doSomething();
        }
    }

}

//state
interface Activity {
    void doSomething(HumanExample context);
}

//ConcreteState
class Work implements Activity{

    @Override
    public void doSomething(HumanExample context) {
        System.out.println("Arbeiten");
        context.setState(new WeekEnd());
    }
}

class WeekEnd implements Activity{
    private int count=0;

    @Override
    public void doSomething(HumanExample context) {
        if(count<3){
            System.out.println("Relaxing");
            count++;
        }else {
            context.setState(new Work());
        }

    }
}