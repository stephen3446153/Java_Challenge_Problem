import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import org.yaml.snakeyaml.Yaml;

public class CLI_Tool extends JFrame{
	//Constant Declaration
	public static final int TOTALARGS = 17;
	
	//Declare private type of objects
	private JPanel jContentPane = null;
	private JLabel jLabel_Title = null;
	private JLabel jLabel_Detail_Information = null;
	private JLabel jLabel_Tips = null;
	private JLabel jLabel_Selected_Information = null;
	private JScrollPane jScrollPane_Detail_Information = null;
	private JScrollPane jScrollPane_Selected_Information = null;
	private JList jList_Detail_Information = null;
	private JList jList_Selected_Information = null;
	private JButton jButton_Reset = null;
	private JButton jButton_Print = null;
	private JButton jButton_Quit = null;
	
	//Create data class (struc)
	private List<argDetail> argInfo;
	//Global Variable
	public String[] sName = new String[TOTALARGS];
	public ArrayList<Integer> SelectedItem = new ArrayList<Integer>();
	public ArrayList<Integer> OrderList = new ArrayList<Integer>(); 

	
	
	private JLabel jLabel_Selected_Item;
	private JLabel jLabel_Seletected_Item_Value;
	private JLabel jLabel_Print_tips;
	private JButton jButton_Add_Print_Info;
	private JLabel jLabel_Display_Order;
	private JLabel jLabel_Display_Tips;
	private JButton jButton_Add_Order;
	private JScrollPane jScrollPane_Display_Order;
	private JList jList_Display_Order;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CLI_Tool window = new CLI_Tool();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public CLI_Tool() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		this.setBounds(100, 100, 1214, 993);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Read from CSV file and store the variables into Vector 
		sName = readCSVfile.readNames();
		argInfo = new ArrayList<argDetail>();
		argInfo = readCSVfile.readDetails();
		//Initialize all the elements/components in GUI
		this.setContentPane(getJContentPane());
		
		//Set Names of CSV file in List Box
		jList_Detail_Information.setListData(sName);
		jList_Detail_Information.setSelectedIndex(0);
	}
	
	/**
	 * Name: Method of getJButton_Quit
	 * Purpose: This method initializes jButton_Quit	
	 */
	private JButton getJButton_Quit() {
		if (jButton_Quit == null) {
			jButton_Quit = new JButton("Quit");
			jButton_Quit.setBounds(724, 49, 171, 76);
			jButton_Quit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return jButton_Quit;
	}
	
	
	/**
	 * Name: Method of getJScrollPane_Detail_Information
	 * Purpose: This method initializes jScrollPane_Detail_Information
	 */
	private JScrollPane getJScrollPane_Detail_Information() {
		if (jScrollPane_Detail_Information == null) {
			jScrollPane_Detail_Information = new JScrollPane();
			jScrollPane_Detail_Information.setBounds(72, 244, 294, 433);
			jScrollPane_Detail_Information.setViewportView(getjList_Detail_Information());
		}
		return jScrollPane_Detail_Information;
	}
	
	/**
	 * Name: Method of getjList_Detail_Information
	 * Purpose: This method initializes getjList_Detail_Information
	 */
	private JList getjList_Detail_Information() {
		if (jList_Detail_Information == null) {
			
			jList_Detail_Information = new JList();	
			jList_Detail_Information.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					jLabel_Seletected_Item_Value.setText(sName[jList_Detail_Information.getSelectedIndex()]);
					
				}
			});
		}
		return jList_Detail_Information;
	}
	
	
	/**
	 * Name: Method of getJScrollPane_Selected_Information
	 * Purpose: This method initializes jScrollPane_Selected_Information
	 */
	private JScrollPane getJScrollPane_Selected_Information() {
		if(jScrollPane_Selected_Information == null) {
			jScrollPane_Selected_Information = new JScrollPane();
			jScrollPane_Selected_Information.setBounds(657, 247, 331, 237);
			jList_Selected_Information = new JList();
			jScrollPane_Selected_Information.setViewportView(jList_Selected_Information);
		}
		return jScrollPane_Selected_Information;
	}
	
	
	/**
	 * Name: Method of getJButton_Print
	 * Purpose: This method initializes jButton_Print
	 * 			Print out the selected arguments in order
	 */
	private JButton getJButton_Print() {
		if(jButton_Print == null) {
			jButton_Print = new JButton("Print");
			jButton_Print.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Yaml yaml = new Yaml();
					/*Comparator comparator = Collections.reverseOrder();
					Collections.sort(argInfo(1).cEntry_Type,comparator);*/
					Collections.sort(argInfo,new Comparator<argDetail>(){
						public int compare(argDetail arg0, argDetail arg1) {
							Integer day1 = arg0.getiGID();
							Integer day2 = arg1.getiGID();
							return day1.compareTo(day2);
						}
					});
					for (argDetail u: argInfo) {
						//Debug
						//System.out.println(u.getiColumn());
					}
					String tmp = "Didn't figure out the sort in 2 hours. Left blank for this version";
					try {
						FileWriter writer = new FileWriter("Result_Print_Out.yaml");
						yaml.dump(tmp,writer);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jButton_Print.setBounds(647, 807, 171, 76);
		}
		return jButton_Print;
	}
	
	
	/**
	 * Name: Method of getJButton_Reset
	 * Purpose: This method initializes jButton_Reset
	 * 			Reset the selected items
	 */
	private JButton getJButton_Reset() { 
		if(jButton_Reset == null) {
			jButton_Reset = new JButton("Reset");
			jButton_Reset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] sReset = new String[1];
					sReset[0] =""; 
					jList_Selected_Information.setListData(sReset);
					jList_Display_Order.setListData(sReset);
					//Reset SelectedItem
					SelectedItem.removeAll(SelectedItem);
					OrderList.removeAll(OrderList);
					//jList_Selected_Information.setListData(sSelectedItem);
				}
			});
			jButton_Reset.setBounds(864, 810, 171, 76);
		}
		return jButton_Reset;
	}
	/**
	 * Name: Method of getJContentPane
	 * Purpose: This method initializes getJContentPane
	 * 			Set up the GUI Components
	 */
	
	private JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
			jLabel_Title = new JLabel("CLI Tool Prototype Version");
			jLabel_Title.setFont(new Font("Tahoma", Font.PLAIN, 37));
			jLabel_Title.setBounds(73, 53, 479, 73);
			
			jLabel_Detail_Information = new JLabel("Detail Information");
			jLabel_Detail_Information.setFont(new Font("Tahoma", Font.BOLD, 21));
			jLabel_Detail_Information.setBounds(72, 183, 258, 26);
			
			jLabel_Tips = new JLabel("Please \"click\" on the print out items from the list ");
			jLabel_Tips.setFont(new Font("Tahoma", Font.ITALIC, 15));
			jLabel_Tips.setBounds(70, 215, 353, 26);
			
			jLabel_Selected_Information = new JLabel("Selected Information");
			jLabel_Selected_Information.setFont(new Font("Tahoma", Font.BOLD, 21));
			jLabel_Selected_Information.setBounds(660, 183, 258, 26);
			
			jContentPane.add(jLabel_Title);
			jContentPane.add(jLabel_Detail_Information);
			jContentPane.add(jLabel_Tips);
			jContentPane.add(jLabel_Selected_Information);
			jContentPane.add(getJButton_Quit());
			jContentPane.add(getJScrollPane_Detail_Information());
			jContentPane.add(getJScrollPane_Selected_Information());
			jContentPane.add(getJButton_Print());
			jContentPane.add(getJButton_Reset());
			jContentPane.add(getJLabel_Selected_Item());
			jContentPane.add(getJLabel_Seletected_Item_Value());
			jContentPane.add(getJLabel_Print_tips());
			jContentPane.add(getJButton_Add_Print_Info());
			jContentPane.add(getJLabel_Display_Order());
			jContentPane.add(getJLabel_Display_Tips());
			jContentPane.add(getJButton_Add_Order());
			jContentPane.add(getJScrollPane_Display_Order());
		}
		return jContentPane;
	}
	private JLabel getJLabel_Selected_Item() {
		if (jLabel_Selected_Item == null) {
			jLabel_Selected_Item = new JLabel("Selected item:");
			jLabel_Selected_Item.setBounds(381, 283, 171, 26);
		}
		return jLabel_Selected_Item;
	}
	private JLabel getJLabel_Seletected_Item_Value() {
		if (jLabel_Seletected_Item_Value == null) {
			jLabel_Seletected_Item_Value = new JLabel("");
			jLabel_Seletected_Item_Value.setFont(new Font("Tahoma", Font.PLAIN, 27));
			jLabel_Seletected_Item_Value.setBounds(382, 346, 276, 62);
		}
		return jLabel_Seletected_Item_Value;
	}
	private JLabel getJLabel_Print_tips() {
		if (jLabel_Print_tips == null) {
			jLabel_Print_tips = new JLabel("Display after Press \"Add Print Info\" Button");
			jLabel_Print_tips.setFont(new Font("Tahoma", Font.ITALIC, 15));
			jLabel_Print_tips.setBounds(660, 213, 353, 26);
		}
		return jLabel_Print_tips;
	}
	private JButton getJButton_Add_Print_Info() {
		if (jButton_Add_Print_Info == null) {
			jButton_Add_Print_Info = new JButton("Add Print Info");
			jButton_Add_Print_Info.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SelectedItem.add(Integer.valueOf(jList_Detail_Information.getSelectedIndex()));
					String[] sSelectedItem = new String[SelectedItem.size()];
					for (int iI = 0;iI<SelectedItem.size();iI++) {
						sSelectedItem[iI] = sName[SelectedItem.get(iI)];
					}
					jList_Selected_Information.setListData(sSelectedItem);
				}
			});
			jButton_Add_Print_Info.setBounds(382, 468, 180, 59);
		}
		return jButton_Add_Print_Info;
	}
	private JLabel getJLabel_Display_Order() {
		if (jLabel_Display_Order == null) {
			jLabel_Display_Order = new JLabel("Display Order ");
			jLabel_Display_Order.setFont(new Font("Tahoma", Font.BOLD, 21));
			jLabel_Display_Order.setBounds(660, 501, 258, 26);
		}
		return jLabel_Display_Order;
	}
	private JLabel getJLabel_Display_Tips() {
		if (jLabel_Display_Tips == null) {
			jLabel_Display_Tips = new JLabel("Display after Press \"Add Print Info\" Button");
			jLabel_Display_Tips.setFont(new Font("Tahoma", Font.ITALIC, 15));
			jLabel_Display_Tips.setBounds(660, 531, 353, 26);
		}
		return jLabel_Display_Tips;
	}
	private JButton getJButton_Add_Order() {
		if (jButton_Add_Order == null) {
			jButton_Add_Order = new JButton("Add Order");
			jButton_Add_Order.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					OrderList.add(Integer.valueOf(jList_Detail_Information.getSelectedIndex()));
					String[] sSelectedItem = new String[OrderList.size()];
					for (int iI = 0;iI<OrderList.size();iI++) {
						sSelectedItem[iI] = sName[OrderList.get(iI)];
					}
					jList_Display_Order.setListData(sSelectedItem);
					
				}
			});
			jButton_Add_Order.setBounds(382, 602, 180, 59);
		}
		return jButton_Add_Order;
	}
	private JScrollPane getJScrollPane_Display_Order() {
		if (jScrollPane_Display_Order == null) {
			jScrollPane_Display_Order = new JScrollPane();
			jScrollPane_Display_Order.setBounds(660, 569, 328, 171);
			jScrollPane_Display_Order.setViewportView(getJList_Display_Order());
		}
		return jScrollPane_Display_Order;
	}
	private JList getJList_Display_Order() {
		if (jList_Display_Order == null) {
			jList_Display_Order = new JList();
		}
		return jList_Display_Order;
	}
}

