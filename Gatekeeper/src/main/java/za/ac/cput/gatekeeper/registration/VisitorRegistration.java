

package za.ac.cput.gatekeeper.registration;

//AWT imports
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//Swing imports
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//Webcam imports
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

//Image and File imports
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 * User Registration
 * @author: 216049245
 *
 */
public class VisitorRegistration extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    private JPanel border;
    private JPanel secondBorder;
    private JPanel thirdBorder;
    private JLabel lblIcon;
    private JLabel label;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField company;
    private JTextField mob;
    private JButton btnNewButton;
    
    private JFrame window;
    
    private JButton webcamBtn;
    
    private JButton btnReturn;
    
    
    /**
     * Launch the application.
     * Main method
     */
   
    public JFrame verifyIdentityWindow()
    {
        JFrame webcamWindow = new JFrame("Camera");
        
        JButton takePic = new JButton("Take picture");
        JButton exitCam = new JButton("Exit camera");
        
        webcamWindow.getContentPane();
        webcamWindow.setSize(450, 550);
        webcamWindow.setLocationRelativeTo(null);
        webcamWindow.setVisible(true);
        
        webcamWindow.getContentPane().setLayout(null);
        
        Webcam w = Webcam.getDefault();
        
        //setting the size of the webcam display, then add the display to the frame
        w.setViewSize(WebcamResolution.VGA.getSize());
        WebcamPanel p = new WebcamPanel(w);
        p.setSize(450, 450);
        webcamWindow.add(p);
        
        //setting button size & position, then adding the buttons to the frame
        takePic.setBounds(70, 460, 150, 30);
        exitCam.setBounds(240, 460, 150, 30);
        webcamWindow.add(takePic);
        webcamWindow.add(exitCam);
        
        takePic.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                try
                {
                    /*
                    writes the image that was recieved from the time the webcam was opened
                    and saves it
                    */
                    
                    ImageIO.write(w.getImage(), "jpg", new File("images\\image.jpg"));
                    webcamWindow.setVisible(false);
                }
                
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
        
        exitCam.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                webcamWindow.setVisible(false);
                w.close();//switches off the webcam
            }
        });
        
        return webcamWindow;
    }
    
    /**
     * Create the frame.
     */

    public void VisitorRegistrationGUI() {
        window = new JFrame();
        window.setSize(876, 497);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        border = new JPanel();
        border.setSize(876, 497);
        border.setLayout(null);
        window.add(border);
        
        lblIcon = new JLabel();
        
        secondBorder = new JPanel();
        secondBorder.setBounds(50,37,450,385);
        secondBorder.setLayout(null);
        border.add(secondBorder);
        secondBorder.add(lblIcon);
        iconImg();
        
        label = new JLabel();
        thirdBorder = new JPanel();
        thirdBorder.setBounds(525,37,290,385);
        thirdBorder.setLayout(null);
        border.add(thirdBorder);
        thirdBorder.add(label);
        

        JLabel lblNewUserRegister = new JLabel("Gatekeeper Visitor Registration");
        lblNewUserRegister.setFont(new Font("SourceSansPro", Font.BOLD, 25));
        lblNewUserRegister.setForeground(Color.BLACK);
        lblNewUserRegister.setBounds(60, 5, 500, 50);
        secondBorder.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First Name");
        lblName.setFont(new Font("SourceSansPro", Font.BOLD, 18));
        lblName.setForeground(Color.BLACK);
        lblName.setBounds(32,200,100,30);
        secondBorder.add(lblName);

        firstname = new JTextField();
        firstname.setFont(new Font("SourceSansPro", Font.BOLD, 12));
        firstname.setBounds(140,200,200, 26);
        secondBorder.add(firstname);
        firstname.setColumns(10);
        
        JLabel lblLName = new JLabel("Last name");
        lblLName.setFont(new Font("SourceSansPro", Font.BOLD, 18));
        lblLName.setForeground(Color.BLACK);
        lblLName.setBounds(32,240,100,30);
        secondBorder.add(lblLName);
        
        lastname = new JTextField();
        lastname.setFont(new Font("SourceSansPro", Font.BOLD, 12));
        lastname.setBounds(140,240,200,26);
        secondBorder.add(lastname);
        lastname.setColumns(10);
        
        JLabel lblMobileNumber = new JLabel("Mobile No");
        lblMobileNumber.setFont(new Font("SourceSansPro", Font.BOLD, 18));
        lblMobileNumber.setForeground(Color.BLACK);
        lblMobileNumber.setBounds(32,280,100,30);
        secondBorder.add(lblMobileNumber);
        
        mob = new JTextField();
        mob.setFont(new Font("SourceSansPro", Font.BOLD, 12));
        mob.setBounds(140,280,200,26);
        secondBorder.add(mob);
        mob.setColumns(10);
        
        JLabel lblCompany = new JLabel("Company");
        lblCompany.setFont(new Font("SourceSansPro", Font.BOLD, 18));
        lblCompany.setForeground(Color.BLACK);
        lblCompany.setBounds(32,320,100,30);
        secondBorder.add(lblCompany);

        company = new JTextField();
        company.setFont(new Font("SourceSansPro", Font.BOLD, 12));
        company.setBounds(140,320,200,26);
        secondBorder.add(company);
        company.setColumns(10);
        
        
        //----------------------------------------------------------------------third panel design
        //----------------------------------------------------------------------image
        //image to be replaced with the current image being taken by the user will be modified once the images are saved to the database
        ImageIcon userimage = new ImageIcon("images\\default.jpg");
        label.setBounds(58, 30, 180, 160);
        label.setBorder(BorderFactory.createLineBorder(new Color(0xffffff), 3));
        Image img = userimage.getImage();
        Image imgScale = img.getScaledInstance(180, 160, Image.SCALE_SMOOTH);
        ImageIcon ScaledIcon = new ImageIcon(imgScale);
        label.setIcon(ScaledIcon);
        thirdBorder.add(label);
        
        
        webcamBtn = new JButton("Verify your identity");
        webcamBtn.setFont(new Font("SourceSansPro", Font.BOLD, 14));
        webcamBtn.setBounds(58, 210, 180, 37);
        thirdBorder.add(webcamBtn);
        
        btnNewButton = new JButton("Register");
        btnNewButton.setFont(new Font("SourceSansPro", Font.BOLD, 14));
        btnNewButton.setBounds(90, 260, 120, 37);
        thirdBorder.add(btnNewButton);
        
        btnReturn = new JButton("Return");
        btnReturn.setBounds(90,310,120, 37);
        btnReturn.addActionListener(this);
        thirdBorder.add(btnReturn);
        //----------------------------------------------------------------------Color button
        webcamBtn.setBorder(BorderFactory.createLineBorder(new Color(0xffffff), 3));
        btnReturn.setBorder(BorderFactory.createLineBorder(new Color(0xffffff), 3));
        btnNewButton.setBorder(BorderFactory.createLineBorder(new Color(0xffffff), 3));
        webcamBtn.setBackground(new Color(0x424242));
        btnReturn.setForeground(Color.WHITE);
        btnNewButton.setBackground(new Color(0x424242));
        webcamBtn.setForeground(Color.WHITE);
        btnReturn.setBackground(new Color(0x424242));
        btnNewButton.setForeground(Color.WHITE);

        webcamBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //Hover colour change when the cursor hovers over the Login Jbutton
        webcamBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                webcamBtn.setBackground(new Color(0x005ba3));
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                webcamBtn.setBackground(new Color(0x424242));
            }
        });
        btnReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnReturn.setBackground(new Color(0x005ba3));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnReturn.setBackground(new Color(0x424242));
            }
        });
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnNewButton.setBackground(new Color(0x005ba3));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnNewButton.setBackground(new Color(0x424242));
            }
        });

        
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String Company = company.getText();
                String mobileNumber = mob.getText();
                
                
                int len = mobileNumber.length();
               
                String msg = "" + firstName;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }
                
                //Inserts registration form data into database.

                try {
                    Class.forName("org.sqlite.JDBC");
                    Connection connection = DriverManager.getConnection("jdbc:sqlite:Database\\visitors.db");
                    System.out.println("Connection established");
                    String query = "INSERT INTO visitors values('" + firstName + "','" + lastName + "','" + mobileNumber + "','" + Company + "')";
                    
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This user already exists");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                    }
                    //Catch error if the mobile number is in use by another user.
                    connection.close();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(btnNewButton, "Mobile number in use by another user.");
                    exception.printStackTrace();
                    
                }
            }
        });
        
        
        
        
        webcamBtn.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                VisitorRegistration v = new VisitorRegistration();
                v.verifyIdentityWindow();
            }
        });
        
       
        
       
        
        
        //----------------------------------------------------------------------Design
        border.setBackground(new Color(0x005ba3));
        secondBorder.setBackground(new Color(0x03a9f4));
        secondBorder.setBorder(BorderFactory.createLineBorder(new Color(0xffffff), 3));
        thirdBorder.setBackground(new Color(0x03a9f4));
        thirdBorder.setBorder(BorderFactory.createLineBorder(new Color(0xffffff), 3));
        
        //-----------------------------------------------textboxes
        firstname.setBorder(BorderFactory.createLineBorder(new Color(0xffffff), 3));
        firstname.setBackground(new Color(0x424242));
        firstname.setForeground(Color.WHITE);
        firstname.setCaretColor(Color.WHITE);
        firstname.setCaretColor(Color.WHITE);
        
        lastname.setBorder(BorderFactory.createLineBorder(new Color(0xffffff), 3));
        lastname.setBackground(new Color(0x424242));
        lastname.setForeground(Color.WHITE);
        lastname.setCaretColor(Color.WHITE);
        lastname.setCaretColor(Color.WHITE);
        
        mob.setBorder(BorderFactory.createLineBorder(new Color(0xffffff), 3));
        mob.setBackground(new Color(0x424242));
        mob.setForeground(Color.WHITE);
        mob.setCaretColor(Color.WHITE);
        mob.setCaretColor(Color.WHITE);
        
        company.setBorder(BorderFactory.createLineBorder(new Color(0xffffff), 3));
        company.setBackground(new Color(0x424242));
        company.setForeground(Color.WHITE);
        company.setCaretColor(Color.WHITE);
        company.setCaretColor(Color.WHITE);
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
    }
    
     public void iconImg() {
        
        ImageIcon userimage = new ImageIcon("images\\icon.png");
        lblIcon.setBounds(130, 30, 180, 170);
        
        Image img = userimage.getImage();
        Image imgScale = img.getScaledInstance(200, 190, Image.SCALE_SMOOTH);
        ImageIcon ScaledIcon = new ImageIcon(imgScale);
        lblIcon.setIcon(ScaledIcon);
        secondBorder.add(lblIcon);

        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
                
                window.setVisible(false);
                Main rg = new Main();
                rg.startProgram();
                dispose();
    }
}
