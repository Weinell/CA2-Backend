package facades;

import dtos.JokeAnimalDTO;
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
        facade.getJokeAnimalDTO();
    }




    public JokeAnimalDTO getJokeAnimalDTO() throws ExecutionException, InterruptedException {
        String[] urls = Endpoints.getEndpointList();
        List<String> results = new ArrayList<>();
        ExecutorService es = Executors.newCachedThreadPool();

        for (int i = 0; i < urls.length; i++) {
            Future<String> future = es.submit(new PingURL(urls[i]));
            String response = future.get();
            results.add(response);
        }

        JokeAnimalDTO dto = new JokeAnimalDTO(results.get(0), results.get(1), results.get(2));
        es.shutdown();
        return dto;
    }
}
