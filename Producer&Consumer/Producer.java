public class Producer implements Runnable{
    private Shop shop;

    public Producer(Shop shop){
        this.shop =  shop;
    }
    @Override
    public void run(){
        while (true){
            if(shop.size < 5){
                shop.size += 1;
                System.out.println("producing cloth now shop has" + shop.size + " cloths");
            }
            
            
        }
    }
}
