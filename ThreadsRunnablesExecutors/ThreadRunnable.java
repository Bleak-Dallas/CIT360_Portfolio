/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadrunnable;

import ThreadsExecutors.TestExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

class testRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " value: " + i);
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(testRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
public class ThreadRunnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Thread t1 = new Thread(new testRunnable(), "First Thread");
       Thread t2 = new Thread(new testRunnable(), "Second Thread");
       TestExecutor te = new TestExecutor();
       t1.start();
       t2.start();
       te.testArray();
    }
    
}
