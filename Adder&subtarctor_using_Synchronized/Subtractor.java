public class Subtractor implements Runnable{
    private Count count;

    public Subtractor(Count count){
        this.count = count;

    }
    @Override
    public void run(){
        for(int i = 1 ; i <= 10000 ;++i){
            count.addValue(-i);// subtracting by adding negative
        }
        
    }
    
}

/*
aise bhi kiya jaa sakta hai
 @Override
public void run() {
    for (int i = 1; i <= 10000; ++i) {
        synchronized(count) {
            count.addValue(-i);
        }
    }
}

 */
