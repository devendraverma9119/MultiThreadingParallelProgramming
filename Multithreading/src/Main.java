import java.util.concurrent.CompletableFuture;

public class Main {

    static CompletableFuture<String> helloWorld_withSize(){
        return CompletableFuture.supplyAsync(()->{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("inside");
                    return "helloWorld";
                }).thenApply((result)->result+result.length())
                ;
    }

    public static void main(String[] args) {

        Main.helloWorld_withSize().thenAccept((result)->{
            System.out.println("result is "+ result);}).join();

        /*CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("inside");
            return "hi";
        }).thenApply((result)->result.toUpperCase())
                .thenAccept((result)->{
            System.out.println("result is "+ result);
        }).join();*/
        System.out.println("Done!");
    }


}