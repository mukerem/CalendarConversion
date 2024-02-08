package calendar;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.InputEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

public class EthiopianCalendar  {
			 
	
	public static int year = 2009 , month =1   ,start , constant , count ;
	public static int calendarchoice , dayconstant ;
	 int  currentdate , currentmonth , currentyear ,dateArray[];
	public JTextField textField ,textField_3 ,textField_1 ,textField_2;
	public JComboBox comboBox , comboBox_8 , comboBox_9 , comboBox_1 ,comboBox_2;
	public static  JFrame frame = new JFrame();
	public String date [] = new String[42] ;
	public static String mon[]  ;
	public static String week[]  ;
	Component []comp ;

	// main function
	public static void main(String[] args) {
		EthiopianCalendar ethio =new EthiopianCalendar();
		ethio.createFrame();
		ethio.Amharic();
		ethio.currentDay();
		ethio.habeshaCalander();
		calendarchoice =1;
	}
	// ******* end of main function

	// default constructor
	public EthiopianCalendar(){
		}
	
	public void habeshaCalander(){
		menu();
		listOfYear();
		weeklyDays();
		dateOfMonthInHabsha();
		dayOfMonthInLabel();
		markCurrentDayLabel();
		buttons();
		time();
		visibleFrame();
		
	}
	
	public void Oromiffa(){
		weeklyDaysInOromiffa();
		monthOfYearInOromiffa();
	}
	public void Amharic(){
		weeklyDaysInAmharic();
		monthOfYearInAmharic();
	}
	
	public void Tigrinya(){
		weeklyDaysInTigrinya();
		monthOfYearInTigrinya();
	}
	
		
	// create frame
	public void createFrame(){
		
		frame.getContentPane().setBackground(UIManager.getColor("InternalFrame.borderColor"));
		frame.getContentPane().setForeground(UIManager.getColor("InternalFrame.borderColor"));
		frame.setBounds(100, 100, 524, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	// *****  end of create frame
	
	// current day
	public void currentDay(){
		GoregorianToHabesha gre = new GoregorianToHabesha();
		Calendar currentday = Calendar.getInstance();
		currentday.setTime(new Date());
		currentdate = currentday.get(Calendar.DAY_OF_MONTH);
		currentyear = currentday.get(Calendar.YEAR);
		currentmonth = currentday.get(Calendar.MONTH)+1;
   		dateArray =new int[]{currentdate , currentmonth , currentyear};
   		dateArray=gre.calculateDateInGregorian(dateArray);
   		currentdate = dateArray[0];currentmonth= dateArray[1];currentyear = dateArray[2];

   		month= currentmonth;year = currentyear;
   	}
	//  ***** end of current day
				
	// create menu bar
	public void menu(){
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mntmEthiopianCalender = new JMenu("Ethiopian Calender");
		mnFile.add(mntmEthiopianCalender);
			
		JMenuItem mntmInAmharic = new JMenuItem("አማርኛ");
		mntmInAmharic.setFont(new Font("Nyala", Font.PLAIN, 12));
		mntmInAmharic.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));
		mntmEthiopianCalender.add(mntmInAmharic);
		mntmInAmharic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendarchoice = 1;
				deleteComponent();
				Amharic();
				currentDay();
				habeshaCalander();
			}
		});
		
		JMenuItem mntmInOromiffa = new JMenuItem("Oromiffa");
		mntmInOromiffa.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmInOromiffa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK));
		mntmEthiopianCalender.add(mntmInOromiffa);
		mntmInOromiffa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendarchoice = 1;
				deleteComponent();
				Oromiffa();
				currentDay();
				habeshaCalander();
			}
		});
		
		JMenuItem mntmInTigrinya = new JMenuItem("ትግርኛ");
		mntmInTigrinya.setFont(new Font("Nyala", Font.PLAIN, 12));
		mntmInTigrinya.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_MASK));
		mntmEthiopianCalender.add(mntmInTigrinya);
		mntmInTigrinya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendarchoice = 1;
				deleteComponent();
				Tigrinya();
				currentDay();
				habeshaCalander();
			}
		});
		
	
		JMenuItem mntmHijriCalender = new JMenuItem("Hijri Calender");
		mntmHijriCalender.setSelected(true);
		mnFile.add(mntmHijriCalender);
		mntmHijriCalender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendarchoice = 3;	
		   	 	//year=1438;
		   	 	month = 1;
		   		deleteComponent();
				Hijri object2 = new Hijri();
				//object2.currentDayInHijri();
				object2.hijraCalander();
			}
		});
		
		JMenuItem mntmGerogorianCalender = new JMenuItem("Gerogorian Calender");
		mnFile.add(mntmGerogorianCalender);
		mntmGerogorianCalender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendarchoice = 2;	
		   		deleteComponent();
				Goregorian object2 = new Goregorian();
				object2.English();
				object2.currentDayInGoregorian();
				object2.goregorianCalander();
			}
		});
		
		
		JMenu mnSearchDay = new JMenu("Search day");
		mnFile.add(mnSearchDay);
		
		JMenu mntmInHabeshaCalender = new JMenu("in Habesha Calender");
		mnSearchDay.add(mntmInHabeshaCalender);

		JMenuItem mntmInAmharicSearch = new JMenuItem("አማርኛ");
		mntmInAmharicSearch.setFont(new Font("Nyala", Font.PLAIN, 12));
		mntmInAmharicSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_MASK));
		mntmInHabeshaCalender.add(mntmInAmharicSearch);
		mntmInAmharicSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchDateInHabesha object1 = new SearchDateInHabesha();
				deleteComponent();	
				object1.searchInHabesha();
				object1.searchInAmharic();
			}
		});
		
		JMenuItem mntmInOromiffaSearch = new JMenuItem("Oromiffa");
		mntmInOromiffaSearch.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmInOromiffaSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, InputEvent.CTRL_MASK));
		mntmInHabeshaCalender.add(mntmInOromiffaSearch);
		mntmInOromiffaSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchDateInHabesha object1 = new SearchDateInHabesha();
				deleteComponent();	
				object1.searchInHabesha();
				object1.searchInOromiffa();
			}
		});
		
		JMenuItem mntmInTigrinyaSearch = new JMenuItem("ትግርኛ");
		mntmInTigrinyaSearch.setFont(new Font("Nyala", Font.PLAIN, 12));
		mntmInTigrinyaSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, InputEvent.CTRL_MASK));
		mntmInHabeshaCalender.add(mntmInTigrinyaSearch);
		mntmInTigrinyaSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchDateInHabesha object1 = new SearchDateInHabesha();
				deleteComponent();	
				object1.searchInHabesha();
				object1.searchInTigrinya();
			}
		});
		
		
		JMenuItem mntmInGoregorianCalender = new JMenuItem("in Goregorian Calender");
		mnSearchDay.add(mntmInGoregorianCalender);
		mntmInGoregorianCalender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchDateInGoregorian object1 = new SearchDateInGoregorian();
				deleteComponent();	
				object1.searchInGoregorian();
			}
		});
		
		JMenu mnDay = new JMenu("Day  converter");
		mnFile.add(mnDay);
		
		JMenuItem mntmFromEcTo = new JMenuItem("from E.C to  G.C.");
		mnDay.add(mntmFromEcTo);
		mntmFromEcTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HabeshaToGoregorian object2 = new HabeshaToGoregorian();
				deleteComponent();	
				object2.toGoregorianChange();
			}
		});
		
		JMenuItem mntmFromGcTo = new JMenuItem("from G.C. to E.C.");
		mnDay.add(mntmFromGcTo);
		mntmFromGcTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoregorianToHabesha object3 = new GoregorianToHabesha();
				deleteComponent();	
				object3.toHabeshaChange();
			}
		});
		JMenuItem mntmFromHijriTo = new JMenuItem("from Hijri to E.C.");
		mnDay.add(mntmFromHijriTo);
		mntmFromHijriTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HijriToHabesha object = new HijriToHabesha();
				deleteComponent();	
				object.toHabeshaChange();
			}
		});
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		frame.getContentPane().setLayout(null);
	}
	//  ***** end of create menu bar
	
	// create week day labels
	public void weeklyDays(){
		JLabel lblSun = new JLabel(week[0]);
		lblSun.setBounds(10, 76, 44, 14);
		lblSun.setForeground(Color.RED);
		lblSun.setFont(new Font("Nyala", Font.BOLD, 18));
		frame.getContentPane().add(lblSun);
		
		JLabel lblMon = new JLabel(week[1]);
		lblMon.setBounds(79, 78, 39, 14);
		lblMon.setForeground(Color.RED);
		lblMon.setFont(new Font("Nyala", Font.BOLD, 18));
		frame.getContentPane().add(lblMon);
		
		JLabel lblTue = new JLabel(week[2]);
		lblTue.setBounds(150, 78, 49, 14);
		lblTue.setForeground(Color.RED);
		lblTue.setFont(new Font("Nyala", Font.BOLD, 18));
		frame.getContentPane().add(lblTue);
		
		JLabel lblWed = new JLabel(week[3]);
		lblWed.setBounds(230, 78, 39, 14);
		lblWed.setForeground(Color.RED);
		lblWed.setFont(new Font("Nyala", Font.BOLD, 18));
		frame.getContentPane().add(lblWed);
		
		JLabel lblThr = new JLabel(week[4]);
		lblThr.setBounds(308, 78, 49, 14);
		lblThr.setForeground(Color.RED);
		lblThr.setFont(new Font("Nyala", Font.BOLD, 18));
		frame.getContentPane().add(lblThr);
		
		JLabel lblFri = new JLabel(week[5]);
		lblFri.setBounds(381, 78, 39, 14);
		lblFri.setForeground(Color.RED);
		lblFri.setFont(new Font("Nyala", Font.BOLD, 18));
		frame.getContentPane().add(lblFri);
		
		JLabel lblSat = new JLabel(week[6]);
		lblSat.setBounds(459, 78, 39, 14);
		lblSat.setForeground(Color.RED);
		lblSat.setFont(new Font("Nyala", Font.BOLD, 18));
		frame.getContentPane().add(lblSat);
	}
	// ******* end of create week day labels
	
	//  putting date of month in string array
	public void dateOfMonthInHabsha(){
		constant=((5*year/4)-1)%7;
		start = (2*month+1+constant)%7;
		if(start==6)
			count=6;     
		else{
			count=7+start;
			if(month==12)
				count-=7;
			}
		for(int i=0;i<count;i++)
			date[i]=" ";
		for(int i=count;i<count+30;i++)
			date[i]=String.format("%d",i-count+1);
		for(int i=count+30;i<42;i++)
			date[i]=" ";
		if(month==12){
			for(int i=count+30;i<count+35;i++)
				date[i]=String.format("%d",i-count-29);
			if(year%4==3)
				date[count+35]=String.format("%d",6);
		}
	}
	//  *****  end of put dates of month in string array
		
	
	// create labels to put date of month & putting dates in the label
	public void dayOfMonthInLabel(){
		JLabel label = new JLabel(date[0]);
		label.setBounds(10, 112, 33, 14);
		label.setForeground(new Color(34, 139, 34));
		label.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(date[1]);
		label_1.setBounds(79, 112, 33, 14);
		label_1.setForeground(new Color(34, 139, 34));
		label_1.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel(date[2]);
		label_2.setBounds(150, 112, 33, 14);
		label_2.setForeground(new Color(34, 139, 34));
		label_2.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel(date[3]);
		label_3.setBounds(230, 112, 33, 14);
		label_3.setForeground(new Color(34, 139, 34));
		label_3.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel(date[4]);
		label_4.setBounds(308, 112, 33, 14);
		label_4.setForeground(new Color(34, 139, 34));
		label_4.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel(date[5]);
		label_5.setBounds(381, 112, 33, 14);
		label_5.setForeground(new Color(34, 139, 34));
		label_5.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel(date[6]);
		label_6.setBounds(459, 112, 33, 14);
		label_6.setForeground(new Color(34, 139, 34));
		label_6.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel(date[7]);
		label_7.setBounds(10, 137, 33, 14);
		label_7.setForeground(new Color(34, 139, 34));
		label_7.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel(date[8]);
		label_8.setBounds(79, 137, 33, 14);
		label_8.setForeground(new Color(34, 139, 34));
		label_8.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel(date[9]);
		label_9.setBounds(150, 137, 33, 14);
		label_9.setForeground(new Color(34, 139, 34));
		label_9.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel(date[10]);
		label_10.setBounds(230, 137, 33, 14);
		label_10.setForeground(new Color(34, 139, 34));
		label_10.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel(date[11]);
		label_11.setBounds(308, 137, 33, 14);
		label_11.setForeground(new Color(34, 139, 34));
		label_11.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel(date[12]);
		label_12.setBounds(381, 137, 33, 14);
		label_12.setForeground(new Color(34, 139, 34));
		label_12.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel(date[13]);
		label_13.setBounds(459, 137, 33, 14);
		label_13.setForeground(new Color(34, 139, 34));
		label_13.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel(date[14]);
		label_14.setBounds(10, 162, 33, 14);
		label_14.setForeground(new Color(34, 139, 34));
		label_14.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel(date[15]);
		label_15.setBounds(79, 162, 33, 14);
		label_15.setForeground(new Color(34, 139, 34));
		label_15.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel(date[16]);
		label_16.setBounds(150, 162, 33, 14);
		label_16.setForeground(new Color(34, 139, 34));
		label_16.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel(date[17]);
		label_17.setBounds(230, 162, 33, 14);
		label_17.setForeground(new Color(34, 139, 34));
		label_17.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel(date[18]);
		label_18.setBounds(308, 164, 33, 14);
		label_18.setForeground(new Color(34, 139, 34));
		label_18.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel(date[19]);
		label_19.setBounds(381, 162, 33, 14);
		label_19.setForeground(new Color(34, 139, 34));
		label_19.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_19);
		
		JLabel label_20 = new JLabel(date[20]);
		label_20.setBounds(459, 162, 33, 14);
		label_20.setForeground(new Color(34, 139, 34));
		label_20.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_20);
		
		JLabel label_21 = new JLabel(date[21]);
		label_21.setBounds(10, 187, 33, 14);
		label_21.setForeground(new Color(34, 139, 34));
		label_21.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_21);
		
		JLabel label_22 = new JLabel(date[22]);
		label_22.setBounds(79, 187, 33, 14);
		label_22.setForeground(new Color(34, 139, 34));
		label_22.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_22);
		
		JLabel label_23 = new JLabel(date[23]);
		label_23.setBounds(150, 187, 33, 14);
		label_23.setForeground(new Color(34, 139, 34));
		label_23.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_23);
		
		JLabel label_24 = new JLabel(date[24]);
		label_24.setBounds(230, 189, 33, 14);
		label_24.setForeground(new Color(34, 139, 34));
		label_24.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_24);
		
		JLabel label_25 = new JLabel(date[25]);
		label_25.setBounds(308, 189, 33, 14);
		label_25.setForeground(new Color(34, 139, 34));
		label_25.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_25);
		
		JLabel label_26 = new JLabel(date[26]);
		label_26.setBounds(381, 189, 33, 14);
		label_26.setForeground(new Color(34, 139, 34));
		label_26.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_26);
		
		JLabel label_27 = new JLabel(date[27]);
		label_27.setBounds(459, 187, 33, 14);
		label_27.setForeground(new Color(34, 139, 34));
		label_27.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_27);
		
		JLabel label_28 = new JLabel(date[28]);
		label_28.setBounds(10, 212, 33, 14);
		label_28.setForeground(new Color(34, 139, 34));
		label_28.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_28);
		
		JLabel label_29 = new JLabel(date[29]);
		label_29.setBounds(79, 212, 33, 14);
		label_29.setForeground(new Color(34, 139, 34));
		label_29.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_29);
		
		JLabel label_30 = new JLabel(date[30]);
		label_30.setBounds(150, 212, 33, 14);
		label_30.setForeground(new Color(34, 139, 34));
		label_30.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_30);
		
		JLabel label_31 = new JLabel(date[31]);
		label_31.setBounds(230, 212, 33, 14);
		label_31.setForeground(new Color(34, 139, 34));
		label_31.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_31);
		
		JLabel label_32 = new JLabel(date[32]);
		label_32.setBounds(308, 212, 33, 14);
		label_32.setForeground(new Color(34, 139, 34));
		label_32.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_32);
		
		JLabel label_33 = new JLabel(date[33]);
		label_33.setBounds(381, 212, 33, 14);
		label_33.setForeground(new Color(34, 139, 34));
		label_33.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_33);
		
		JLabel label_34 = new JLabel(date[34]);
		label_34.setBounds(459, 212, 33, 14);
		label_34.setForeground(new Color(34, 139, 34));
		label_34.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_34);
		
		JLabel label_35 = new JLabel(date[35]);
		label_35.setBounds(10, 237, 33, 14);
		label_35.setForeground(new Color(34, 139, 34));
		label_35.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_35);
		
		JLabel label_36 = new JLabel(date[36]);
		label_36.setBounds(79, 239, 33, 14);
		label_36.setForeground(new Color(34, 139, 34));
		label_36.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_36);
		
		JLabel label_37 = new JLabel(date[37]);
		label_37.setBounds(150, 239, 33, 14);
		label_37.setForeground(new Color(34, 139, 34));
		label_37.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_37);
		
		JLabel label_38 = new JLabel(date[38]);
		label_38.setBounds(230, 239, 33, 14);
		label_38.setForeground(new Color(34, 139, 34));
		label_38.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_38);
		
		JLabel label_39 = new JLabel(date[39]);
		label_39.setBounds(308, 239, 33, 14);
		label_39.setForeground(new Color(34, 139, 34));
		label_39.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_39);
		
		JLabel label_40 = new JLabel(date[40]);
		label_40.setBounds(381, 241, 33, 14);
		label_40.setForeground(new Color(34, 139, 34));
		label_40.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_40);
		
		JLabel label_41 = new JLabel(date[41]);
		label_41.setBounds(459, 239, 33, 14);
		label_41.setForeground(new Color(34, 139, 34));
		label_41.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		frame.getContentPane().add(label_41);
	//  ***** end of creating date labels & putting date in label
		
		// create label for month
		JLabel label_42 = new JLabel(mon[month-1]);
		label_42.setBounds(129, 24, 149, 24);
		label_42.setForeground(new Color(255, 215, 0));
		label_42.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 24));
		frame.getContentPane().add(label_42);
	}


	//  list of years in comboBox
	public void listOfYear(){
		comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100"}));
		comboBox.setMaximumRowCount(20);
		comboBox.setForeground(new Color(51, 204, 0));
		comboBox.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 16));
		comboBox.setBounds(56, 28, 63, 20);
		frame.getContentPane().add(comboBox);
		comboBox.setSelectedIndex(year-1900);
	}
	// *****  end of list of years
	public void dateOfMonth(){
		comboBox_8 = new JComboBox();
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] {"  1", "  2", "  3", "  4", "  5", "  6", "  7 ", "  8", "  9", " 10", " 11", " 12", " 13", 
				" 14", " 15", " 16", " 17", " 18", " 19", " 20", " 21", " 22", " 23", " 24", " 25", " 26", " 27", " 28", " 29", " 30"}));
		comboBox_8.setSelectedIndex(0);
		comboBox_8.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 24));
		comboBox_8.setForeground(new Color(0, 204, 0));
		comboBox_8.setBounds(134, 98, 77, 31);
		frame.getContentPane().add(comboBox_8);
	}

	public void weeklyDaysInEnglish(){
   		week = new String []{"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	}
	
		//Month of year in Gregorian calendar
	public void monthOfYearInEnglish(){
		mon = new String []{"January","February","March","April","May","June","July","August","September","October","November","December"};		
	}
			//*****	end of Month of year in Gregorian calendar

	public void weeklyDaysInOromiffa(){
		week = new String[]{"Dil","Wix","Kib","Rob","Kam","Jim","San"};
	}
	
	public void monthOfYearInOromiffa(){
		mon = new String [] {"Fulbaana","Onkoloolessa","Sadaasa","Muddee","Ammajii","Gurraandhala","Bitootessa","Ebla","Caamsaa","Waxabajjii",
				"Adoolessa","Hagayya fi Paagumee"};	
	}
	
	public void weeklyDaysInAmharic(){
		week = new String[]{"እሁድ","ሰኞ","ማክሰኞ","ረቡዕ","ሐሙስ","አርብ","ቅዳሜ"};
	}
	
	public void monthOfYearInAmharic(){
		mon = new String [] {"መስከረም","ጥቅምት","ህዳር","ታህሳስ","ጥር","የካቲት","መጋቢት","ሚያዚያ","ግንቦት","ሰኔ",
				"ሃምሌ","ነሓሴ እና ጳጉሜ"};	
	}
	public void weeklyDaysInTigrinya(){
		week = new String[]{"ሰንበት","ሰኑይ","ሠሉስ","ረቡዕ","ኃሙስ","ዓርቢ","ቀዳም"};
	}
	
	public void monthOfYearInTigrinya(){
		mon = new String [] {"መስከረም","ጥቅምት","ህዳር","ታህሳስ","ጥር","የካቲት","መጋቢት","ሚያዚያ","ግንቦት","ሰኔ",
				"ሃምሌ","ነሓሴ እና ጳጉሜ"};	
	}
	
	// month of year in ethiopian calendar
	public void monthInHabesha(){
		comboBox_9 = new JComboBox();
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"መስከረም", "ጥቅምት", "ህዳር", "ታህሳስ", "ጥር", "የካቲት", "መጋቢት", "ሚያዚያ", "ግንቦት", "ሰኔ", "ሃምሌ", "ነሓሴ ", "ጳጉሜ"}));
		comboBox_9.setSelectedIndex(0);
		comboBox_9.setForeground(new Color(102, 204, 102));
		comboBox_9.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 24));
		comboBox_9.setBounds(211, 98, 113, 31);
		frame.getContentPane().add(comboBox_9);
	}
	
	public void dayOfMonthInGoregorian(){
		comboBox_1 = new JComboBox();
	   	comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"  1", "  2", "  3", "  4", "  5", "  6", "  7 ", "  8", "  9", " 10", " 11", " 12", " 13",
	   			" 14", " 15", " 16", " 17", " 18", " 19", " 20", " 21", " 22", " 23", " 24", " 25", " 26", " 27", " 28", " 29", " 30","31"}));
	   	comboBox_1.setSelectedIndex(0);
	   	comboBox_1.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 24));
	 	comboBox_1.setForeground(new Color(0, 204, 0));
		comboBox_1.setBounds(147, 98, 77, 31);
		frame.getContentPane().add(comboBox_1);
	}
	
	public void  monthOfYear(){
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"January","February","March","April","May","June","July","August","September","October","November","December"}));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setForeground(new Color(102, 204, 102));
		comboBox_2.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 24));
		comboBox_2.setBounds(222, 98, 113, 31);
		frame.getContentPane().add(comboBox_2);
	}
	
	public void displayDate(){
   		textField_3 = new JTextField();
   		textField_3.setRequestFocusEnabled(false);
   		textField_3.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 24));
   		textField_3.setForeground(new Color(0, 204, 0));
		textField_3.setBounds(203, 168,45, 31);
		frame.getContentPane().add(textField_3);
   		textField_3.setColumns(10); 
   		
   		textField_1 = new JTextField();
   		textField_1.setRequestFocusEnabled(false);
   		textField_1.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 24));
   		textField_1.setForeground(new Color(0, 204, 0));
		textField_1.setBounds(245, 168,110, 31);
		frame.getContentPane().add(textField_1);
   		textField_1.setColumns(10); 
   		
   		textField_2 = new JTextField();
   		textField_2.setRequestFocusEnabled(false);
   		textField_2.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 24));
   		textField_2.setForeground(new Color(0, 204, 0));
		textField_2.setBounds(353, 168,80, 31);
		frame.getContentPane().add(textField_2);
   		textField_2.setColumns(10); 
}
	
	// creating buttons
	public void buttons(){
		//creating previous button
		JButton btnNewButton = new JButton("Previous");
		btnNewButton.setBounds(182, 264, 101, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				actionOfPreviousButton();
				}	
		});
		btnNewButton.setForeground(new Color(105, 105, 105));
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 18));
		frame.getContentPane().add(btnNewButton);
	
		// *****  end of  previous button	
	

		// creating next button
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(308, 264, 101, 23);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionOfNextButton();
				}
		});
		btnNext.setForeground(SystemColor.controlDkShadow);
		btnNext.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 18));
		frame.getContentPane().add(btnNext);
		// ***** end of next button 
		
		// creating show button and action
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				month=1;
				deleteComponent();	
				Hijri hijraobject = new Hijri();
				Goregorian goregorianobject = new Goregorian(); // creating object for Goregorian calendarr
				if(calendarchoice == 1){
					year=comboBox.getSelectedIndex()+1900;
					habeshaCalander();
				}
				else if (calendarchoice == 2){
					year=comboBox.getSelectedIndex()+1900;
					goregorianobject.goregorianCalander();
				}
				else {
					year=comboBox.getSelectedIndex()+1350;
					hijraobject.hijraCalander();
				}
				}
		});
		btnShow.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 24));
		btnShow.setForeground(new Color(102, 0, 0));
		btnShow.setBounds(288, 24, 89, 23);
		frame.getContentPane().add(btnShow);

		//  ***** end of creating show button and action
	}
	//  ***** end of create component of the calendar
		

	
	// decrease the month by one and display the previous month
	public void actionOfPreviousButton(){
		Hijri hijraobject = new Hijri();
		Goregorian goregorianobject = new Goregorian(); // creating object for Goregorian calendarr
		if(month==1){
			year--;
			month=12;
				}
		else 
			month--;
		deleteComponent();	
		if(calendarchoice == 1)
			habeshaCalander();
		else if (calendarchoice == 2){
			goregorianobject.English();
			goregorianobject.goregorianCalander();
		}	
		else 
			hijraobject.hijraCalander();
		}
	// ***** end of previous button action
	

	//	increase the month by one and display the next month
	public void actionOfNextButton(){
		Hijri hijraobject = new Hijri();
		Goregorian goregorianobject = new Goregorian(); // creating object for Goregorian calendarr
		if(month==12){
			year++;
			month=1;
			}
		else 
			month++;
		deleteComponent();	
		if(calendarchoice == 1)
			habeshaCalander();
		else if (calendarchoice == 2){
			goregorianobject.English();
			goregorianobject.goregorianCalander();
		}
		else 
			hijraobject.hijraCalander();
	// ***** end of next button action
	}
	
	public void markCurrentDayLabel(){
    	comp = frame.getContentPane().getComponents();
    	if(month==currentmonth&&year==currentyear)
 			comp[currentdate+count+7].setForeground(new Color(255, 102, 0));

     }
	
	// time label
	public void time(){
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(153, 0, 51));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(400, 0, 108, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		new Timer (0, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Date d= new Date();	
				SimpleDateFormat s =new SimpleDateFormat("hh:mm:ss a");
				lblNewLabel_1.setText(s.format(d));
			}
		}).start();
	}
	//  ***** end of time label	 ***** 		
				
	// to show the frame 
	public void visibleFrame(){
		frame.setVisible(true);
	}
	// ***** end of show frame ***** 
	
	public void deleteComponent(){
		comp = frame.getContentPane().getComponents();
		for(Component com : comp){
		com.setVisible(false);
		}
		frame.getContentPane().removeAll();

	}

}


