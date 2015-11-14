package smartgrabber.concurrency.my_synchronized_collection;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by randriyanov on 25.10.15.
 */
public class TestSynchronizedRGB {

    private SynchronizedRGB color;

    @Before
    public void ini() {
        color = new SynchronizedRGB(255, 0, 0, "red");
    }

    @Test
    public void testSetRGBinOneThread() {
        System.out.println("myColorInt: " + color.getRGB() + " / myColorName: " + color.getName());

        int myColorInt = color.getRGB();      //Statement 1
        color.setRGB(0, 255, 0, "green");
        String myColorName = color.getName(); //Statement 2

        System.out.println("myColorInt: " + myColorInt + " / myColorName: " + myColorName);
        System.out.println("Actually color.getRGB() is: " + color.getRGB());
    }

    // If another thread invokes color.setRGB after Statement 1 but before Statement 2,
    // the value of myColorInt won't match the value of myColorName.
    @Test
    public void testSetRgbFromOtherThread() throws InterruptedException {
        System.out.println("myColorInt: " + color.getRGB() + " / myColorName: " + color.getName());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Change color
                color.setRGB(0, 0, 255, "blue");
                // Pause for 0.5 second
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        int myColorInt = color.getRGB();       //Statement 1
        t1.start();
        color.setRGB(255, 255, 0, "yellow");
        myColorInt = color.getRGB();       //Statement 1
        String myColorName = color.getName();  //Statement 2
        System.out.println("myColorInt: " + myColorInt + " / myColorName: " + myColorName);

        Thread.sleep(1000);
        color.setRGB(0, 255, 0, "green");
        myColorName = color.getName();  //Statement 2
        System.out.println("myColorInt: " + myColorInt + " / myColorName: " + myColorName);
        System.out.println("Actually color.getRGB() is: " + color.getRGB());

        Thread.sleep(1000);
        // To avoid this outcome, the two statements must be bound together:
        synchronized (color) {
            myColorInt = color.getRGB();      //Statement 1
            myColorName = color.getName();    //Statement 2
        }

        System.out.println("myColorInt: " + myColorInt + " / myColorName: " + myColorName);
    }
}