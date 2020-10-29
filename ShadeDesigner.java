import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ShadeDesigner extends JFrame
{
    private String[] styles = {"Regular Shades", "Folding Shades", "Roman Shades"};
    private String[] size = {"25 Inches Wide", "27 Inches Wide",
                              "32 Inches Wide", "40 Inches Wide"};
    private String[] colors = {"Natural", "Blue", "Teal",
                               "Red", "Green"};
    private JLabel banner;// To display a banner
    private JPanel bannerPanel;// To hold the banner
    private JPanel stylesPanel;// 
    private JPanel sizePanel;// 
    private JPanel colorPanel;
    private JPanel buttonPanel;//

    private JList stylesList;
    private JList sizeList;
    private JList colorList;

    private JTextField Styles;
    private JTextField Size;
    private JTextField Color;

    private JButton calcButton;
    private JButton ExitButton; 

    private double totalCharges = 50.00;

    //Constants
    private final int ROWS = 5;
    private final double regularCost = 0.00;//base price for the blinds
    private final double foldingCost = 10.00;//extra cost for folding blinds
    private final double romanCost = 15.00;//extra cost for roman blinds
    private final double twentyfiveInCost = 0.00; //extra cost for 25" blinds
    private final double twentySevenInCost = 2.00;//extra cost for 27" blinds
    private final double thirtyTwoInCost = 4.00;//extra cost for 32" blinds
    private final double fourtyInCost = 6.00;//extra cost for 40" blinds
    private final double naturalColorCost = 5.00;//extra cost for color


    public ShadeDesigner()
    {
        //display a title
        setTitle("Shade Designer");

        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the banner on a panel and add it to the North region.
        buildBannerPanel();
        add(bannerPanel, BorderLayout.NORTH);

        stylesPanel();
        add(stylesPanel, BorderLayout.WEST);

        sizePanel();
        add(sizePanel, BorderLayout.CENTER);

        colorPanel();
        add(colorPanel, BorderLayout.EAST);

        buttonPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    //build the bannerpanel
    private void buildBannerPanel()
    {
        bannerPanel = new JPanel();
        bannerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        banner = new JLabel("Shade Designer");
        banner.setFont(new Font("SanSerif", Font.BOLD, 24));
        bannerPanel.add(banner);
    }

    //stylepanel    
    private void stylesPanel()
    {
        JLabel styleTitle = new JLabel("Select a Style.");
        stylesPanel = new JPanel();
        stylesPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        stylesList = new JList (styles);
        stylesList.setVisibleRowCount(ROWS);
        JScrollPane stylesScrollPane = new JScrollPane(stylesList);
        stylesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        stylesList.addListSelectionListener(new stylesListListener());
        stylesPanel.setLayout(new BorderLayout());
        stylesPanel.add(styleTitle, BorderLayout.NORTH);
        stylesPanel.add(stylesScrollPane, BorderLayout.CENTER);
        Styles = new JTextField (5);
        Styles.setEditable(false);
        //stylesPanel.add(StylesLabel, BorderLayout.CENTER);
        stylesPanel.add(Styles, BorderLayout.SOUTH);
    }
    private class stylesListListener implements ListSelectionListener
    {
        @Override
        public void valueChanged (ListSelectionEvent e)
        {
            String selection = (String) stylesList.getSelectedValue();
            Styles.setText(selection);
        }
    }

    //size panel
    private void sizePanel()
    {
        JLabel sizeTitle = new JLabel("Select a Size.");
        sizePanel = new JPanel();
        sizePanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        sizeList = new JList (size);
        sizeList.setVisibleRowCount(ROWS);
        JScrollPane stylesScrollPane = new JScrollPane(sizeList);
        sizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sizeList.addListSelectionListener(new sizeListListener());
        sizePanel.setLayout(new BorderLayout());
        sizePanel.add(sizeTitle, BorderLayout.NORTH);
        sizePanel.add(stylesScrollPane, BorderLayout.CENTER);
        //sizeLabel = new JLabel("Style Selected: ");
        Size = new JTextField (5);
        Size.setEditable(false);
        //stylesPanel.add(StylesLabel, BorderLayout.CENTER);
        sizePanel.add(Size, BorderLayout.SOUTH);
    }
    private class sizeListListener implements ListSelectionListener
    {
        @Override
        public void valueChanged (ListSelectionEvent e)
        {
            String selection = (String) sizeList.getSelectedValue();
            Size.setText(selection);
        }
    }

    //color panel
    private void colorPanel()
    {
        JLabel colorTitle = new JLabel("Select a Color.");
        colorPanel = new JPanel();
        colorPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        colorList = new JList (colors);
        colorList.setVisibleRowCount(ROWS);
        JScrollPane colorScrollPane = new JScrollPane(colorList);
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        colorList.addListSelectionListener(new colorListListener());
        colorPanel.setLayout(new BorderLayout());
        colorPanel.add(colorTitle, BorderLayout.NORTH);
        colorPanel.add(colorScrollPane, BorderLayout.CENTER);
        //sizeLabel = new JLabel("Style Selected: ");
        Color = new JTextField (5);
        Color.setEditable(false);
        //stylesPanel.add(StylesLabel, BorderLayout.CENTER);
        colorPanel.add(Color, BorderLayout.SOUTH);
    }
    private class colorListListener implements ListSelectionListener
    {
        @Override
        public void valueChanged (ListSelectionEvent e)
        {
            String selection = (String) colorList.getSelectedValue();
            Color.setText(selection);
        }
    }

    //button panel
    private void buttonPanel()
    {
        calcButton= new JButton ("Calculate Charges");
        calcButton.addActionListener(new calcButtonListener());
        ExitButton = new JButton ("Exit");
        ExitButton.addActionListener(new ExitButtonListener());
        buttonPanel = new JPanel();
        buttonPanel.add(calcButton);
        buttonPanel.add(ExitButton);    
    }

    private class calcButtonListener implements  ActionListener
    {
        //actionPerformed method parementer e an actionevent object

    @Override
    public void actionPerformed(ActionEvent e)
    {
             // Create a DecimalFormat object.
             DecimalFormat dollar = new DecimalFormat("#,##0.00");

             // Display the total.
             JOptionPane.showMessageDialog(null, "TotalCharges: $" +
                                                 dollar.format(totalCharges));
          }
       }

       private class ExitButtonListener implements  ActionListener
       {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Exit the applicaiton
                System.exit(0);
            }
       }

    //static void main for the string
    public static void main(String[] args)
       {
          new ShadeDesigner();
       }