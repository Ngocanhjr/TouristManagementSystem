import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class ModernDashboardUI extends JFrame {

    public ModernDashboardUI() {
        // Frame settings
        setTitle("Application Dashboard");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Left-side menu panel (Sidebar)
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(new Color(33, 102, 160));  // Blue background
        menuPanel.setPreferredSize(new Dimension(200, getHeight()));
        menuPanel.setBorder(new EmptyBorder(20, 10, 20, 10));

        String[] menuItems = {"Dashboard", "UI Elements", "Components", "Forms Stuff", "Data Table", "My Data",
                "Icons", "Sample Page", "Extra", "More", "Logout"};

        for (String item : menuItems) {
            JButton menuButton = new JButton(item);
            menuButton.setForeground(Color.WHITE);
            menuButton.setBackground(new Color(60, 120, 200));
            menuButton.setFocusPainted(false);
            menuButton.setBorderPainted(false);
            menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            menuButton.setPreferredSize(new Dimension(180, 40));
            menuButton.setMaximumSize(new Dimension(180, 40));
            menuButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
            menuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            menuButton.setBorder(BorderFactory.createLineBorder(new Color(33, 102, 160), 1));
            menuPanel.add(menuButton);
            menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));  // Space between buttons
        }

        add(menuPanel, BorderLayout.WEST);

        // Top panel with stat cards
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(1, 3, 20, 0));  // 3 columns, space between them
        statsPanel.setBorder(new EmptyBorder(20, 20, 20, 20));  // Add margin
        statsPanel.setBackground(Color.WHITE);

        statsPanel.add(createStatCard("Stock Total", "$200000", "Increased by 60%", new Color(100, 149, 237)));  // Blue
        statsPanel.add(createStatCard("Total Profit", "$15000", "Increased by 25%", new Color(147, 112, 219)));  // Purple
        statsPanel.add(createStatCard("Unique Visitors", "$300000", "Increased by 70%", new Color(255, 193, 7))); // Yellow

        add(statsPanel, BorderLayout.NORTH);

        // Center panel for table
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(new EmptyBorder(10, 20, 20, 20));  // Padding around table

        String[] columns = {"Name", "Email", "User Type", "Joined", "Status"};
        Object[][] data = {
                {"1", "11", "Testing", "Testing", "Testing"},
                {"222", "Testing", "Testing", "Testing", "Testing"}
        };

        JTable table = new JTable(data, columns);
        table.setRowHeight(40);  // Increase row height
        table.setFont(new Font("SansSerif", Font.PLAIN, 16));  // Table font
        table.setShowGrid(false);  // Hide grid lines for cleaner look
        table.setIntercellSpacing(new Dimension(0, 0));  // Remove spacing between cells
        table.setFillsViewportHeight(true);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 16));  // Header font
        header.setBackground(new Color(60, 120, 200));
        header.setForeground(Color.WHITE);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);
        add(tablePanel, BorderLayout.CENTER);

        // Set frame visibility
        setVisible(true);
    }

    // Helper method to create stat cards with rounded corners
    private JPanel createStatCard(String title, String value, String subText, Color backgroundColor) {
        JPanel statCard = new RoundedPanel(20, backgroundColor);  // Rounded corners for the card
        statCard.setLayout(new BoxLayout(statCard, BoxLayout.Y_AXIS));
        statCard.setBorder(new EmptyBorder(20, 20, 20, 20));  // Padding inside the card

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setForeground(Color.WHITE);
        valueLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subTextLabel = new JLabel(subText);
        subTextLabel.setForeground(Color.WHITE);
        subTextLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subTextLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        statCard.add(titleLabel);
        statCard.add(Box.createRigidArea(new Dimension(0, 10)));  // Space between title and value
        statCard.add(valueLabel);
        statCard.add(Box.createRigidArea(new Dimension(0, 10)));  // Space between value and subtext
        statCard.add(subTextLabel);

        return statCard;
    }

    // RoundedPanel class for rounded corners
    static class RoundedPanel extends JPanel {
        private final int cornerRadius;
        private final Color backgroundColor;

        public RoundedPanel(int radius, Color bgColor) {
            this.cornerRadius = radius;
            this.backgroundColor = bgColor;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(backgroundColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        }
    }

    public static void main(String[] args) {
        // Run the UI in the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(ModernDashboardUI::new);
    }
}
