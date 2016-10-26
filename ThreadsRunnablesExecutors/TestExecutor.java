
package ThreadsExecutors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestExecutor {
    ArrayList<ArrayList<Double>> randomNumList = new ArrayList<>();
    
    public void testArray() {
        
        for (int i = 0; i < 10; i++)
        {
            randomNumList.add(new ArrayList<>());
        }
    
        for (int i = 0; i < randomNumList.size(); i++) 
        {
            ArrayList<Double> nonInit = randomNumList.get(i);
            for (int j = 0; j < 1000; j++)
            {
                nonInit.add(Math.random() * 100);
            }    
        }    
        
        long startTime = System.currentTimeMillis();
        
        ArrayList<Callable<ArrayList<Double>>> call = new ArrayList<>();
        randomNumList.stream().forEach((listToSort) ->
        {
            call.add(() ->
            {
                Collections.sort(listToSort);
                return listToSort;
            });        
        });
    
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try {
            List<Future<ArrayList<Double>>> out = service.invokeAll(call);
            service.shutdown();
            out.stream().forEach((futureItem) ->
            {
                try {
                    futureItem.get();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TestExecutor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    Logger.getLogger(TestExecutor.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (InterruptedException ex) {
            Logger.getLogger(TestExecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        System.out.println("Program took: " + (System.currentTimeMillis() - startTime) + " milliseconds");
    
    }

    
}
