import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

public class LockerApplication extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;

    private String password = null;
    private JPasswordField passwordField;

    public LockerApplication() {
        createUI();
    }

    private void createUI() {
        setTitle("Locker Application");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        passwordField = new JPasswordField(15);
        JButton enterButton = new JButton("Enter");

        enterButton.addActionListener(new EnterButtonListener());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);
        inputPanel.add(enterButton);

        panel.add(inputPanel, BorderLayout.CENTER);

        add(panel);
    }

    private class EnterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputPassword = new String(passwordField.getPassword());

            if (password == null) {
                password = inputPassword;
                JOptionPane.showMessageDialog(LockerApplication.this, "Password Set", "Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (inputPassword.equals(password)) {
                    JOptionPane.showMessageDialog(LockerApplication.this, "Correct Password", "Status", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(LockerApplication.this, "Incorrect Password", "Status", JOptionPane.ERROR_MESSAGE);
                }
            }
            passwordField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LockerApplication lockerApp = new LockerApplication();
                lockerApp.setVisible(true);
            }
        });
    }
}
