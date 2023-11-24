package pac16_Thread_Juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Frank.Tang
 * @date 2023-11-14 11:53
 * @desc
 **/
public class T20_CompletableFuture {


    public static void main(String[] args) throws Exception {
        anyOfOrAllOf();

    }

    private static void then() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(1000L * 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "1";
                })
                .thenApplyAsync(res -> res.repeat(5))
                .exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                });
        System.out.println(future1.get());
    }


    private static void anyOfOrAllOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "f1";
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "f2";
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * 3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "f3";
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });

        /*CompletableFuture<Object> anyOf = CompletableFuture.anyOf(future1, future2, future3);
        System.out.println(anyOf.get());*/
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2, future3);
        allOf.thenRun(() -> {
            String result1 = future1.join();
            String result2 = future2.join();
            String result3 = future3.join();
        });
    }
}
