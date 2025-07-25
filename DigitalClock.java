import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


    public class DigitalClock extends JFrame {
        JLabel timeLabel;

        public DigitalClock() {
            setTitle("Digital Clock");
            setSize(400, 200);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(null);
            getContentPane().setBackground(Color.BLACK);

            timeLabel = new JLabel();
            timeLabel.setBounds(100, 60, 250, 50);
            timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
            timeLabel.setForeground(Color.GREEN);

            add(timeLabel);

            // Start the clock update thread
            new Thread(() -> {
                while (true) {
                    timeLabel.setText(getCurrentTime());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            setVisible(true);
        }

        public String getCurrentTime() {
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            return time.format(formatter);
        }

        public static void main(String[] args) {
            new DigitalClock();
        }
    }


