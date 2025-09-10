import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NotificationWindow {
    public static void showNotification(String title, String message) {
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setLayout(new BorderLayout());
        frame.setAlwaysOnTop(true);

        JPanel panel = new JPanel(new BorderLayout(8,8));
        panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        panel.add(new JLabel("<html><b>" + title + "</b></html>"), BorderLayout.NORTH);
        panel.add(new JLabel("<html>" + message + "</html>"), BorderLayout.CENTER);

        JButton openBtn = new JButton("Open");
        openBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Clicked!");
            frame.dispose();
        });
        panel.add(openBtn, BorderLayout.SOUTH);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(scr.width - frame.getWidth() - 20, scr.height - frame.getHeight() - 50);
        frame.setVisible(true);

        new Timer(8000, e -> frame.dispose()).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> showNotification("Hello", "This is a test notification"));
    }
}
