package facades;

import dtos.AnimalJokeDTO;
import endpoints.Endpoints;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class PingURL implements Callable<String> {
    String url;

    PingURL(String url) {
        this.url = url;
    }

    @Override
    public String call() throws Exception {
        return Endpoints.getStatus(url);
    }
}

public class HomeFacade {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HomeFacade facade = new HomeFacade();
        facade.getAnimalJokeDTO();
    }


    public AnimalJokeDTO getAnimalJokeDTO() throws ExecutionException, InterruptedException {
        String[] urls = Endpoints.getEndpointList();
        List<String> results = new ArrayList<>();
        ExecutorService es = Executors.newCachedThreadPool();

        // We make a list of futures, since they fetch on their own thread.
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < urls.length; i++) {
            Future<String> fut = es.submit(new PingURL(urls[i]));
            futures.add(fut);
        }

        // Loops through all fetched futures.
        // Each are blocking the loop until they finish fetching,
        // so some futures later down the loop CAN finish before the others
        for(Future<String> future : futures) {
            String response = future.get();
            results.add(response);

            System.out.println(response);
        }

        return null;
    }
}
