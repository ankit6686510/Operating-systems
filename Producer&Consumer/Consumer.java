public class Consumer implements Runnable {
    private Shop shop;


    public Consumer(Shop shop){
        this.shop = shop;

    }
    @Override
    public void run(){
        while(true){
            if(shop.size > 0 ){
                shop.size -= 1;
                System.out.println("Consuming cloth now shop has" + shop.size + " cloths");

            }
        }
    }

}
    

