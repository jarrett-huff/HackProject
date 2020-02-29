import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class IDLEProcess {



    public static void main(String[] args) throws InterruptedException {
        int clickAmount = 1;
        int DPS = 10;
        int amount = 0;
        while(true) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(amount);
            amount = amount + DPS;
        }
    }
}
