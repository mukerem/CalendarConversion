package calendar;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class SearchDateInHabesha extends CalendarClass {
	private JTextField textField;
	 String [] week;
	int day , date1  , month1 , year1;
	JButton btnShowDay;
	JLabel lblSearchDay ;
	public SearchDateInHabesha() {
	    	   
		}

	public void searchInHabesha() {
	    listOfYear();
	    listOfYearPosition();
		monthInHabesha();
		dateOfMonth();
		display();
		searchDay();
		show();
   }	
	public void searchInAmharic(){
		week = new String[]{"እሁድ","ሰኞ","ማክሰኞ","ረቡዕ","ሐሙስ","አርብ","ቅዳሜ"};		
	}
	
	public void searchInOromiffa(){
		week = new String[]{"Dilbata","Wixata","Kibxata","Roobii","Kamisa","Jimaata","Sanbata"};
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"Fulbaana","Onkoloolessa","Sadaasa","Muddee","Ammajii","Gurraandhala","Bitootessa","Ebla","Caamsaa","Waxabajjii",
			"Adoolessa","Hagayya ","Paagumee"}));	
		btnShowDay.setText("Mul'isi");
		lblSearchDay.setText("Guy Galchi");
		lblSearchDay.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 20));
	}
	
	public void searchInTigrinya(){
		week = new String[]{"ሰንበት","ሰኑይ","ሠሉስ","ረቡዕ","ኃሙስ","ዓርቢ","ቀዳም"};
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"መስከረም","ጥቅምቲ","ሕዳር","ታሕሳስ","ጥሪ","ለካቲት","መጋቢት","ማዚያ","ግንቦት","ሰኔ",
				"ሓምሌ","ንሓሴ "," ጳጉሜ"}));	
		btnShowDay.setText("ኣርኢ");
		lblSearchDay.setText("መዓልቲ ኣእትው");
	}
	
//  list of years in comboBox
	public void listOfYearPosition(){
		comboBox.setBounds(324, 98,75 , 31);
		comboBox.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 20));


	}
	
	public void searchDay(){
		lblSearchDay = new JLabel("ቀን አስገባ:");
		lblSearchDay.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 24));
		lblSearchDay.setForeground(new Color(51, 102, 153));
		lblSearchDay.setBounds(21, 98, 102, 32);
		frame.getContentPane().add(lblSearchDay);
	}
	 public void display(){
		textField = new JTextField();
		textField.setRequestFocusEnabled(false);
		textField.setForeground(new Color(204, 0, 0));
		textField.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 24));
		textField.setBounds(240, 152, 108, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	 }
	 public void calculateDate(){
		 date1=comboBox_8.getSelectedIndex()+1;
		 month1=comboBox_9.getSelectedIndex()+1;
		 year1=comboBox.getSelectedIndex()+1900;
		 day=(2*month1+date1+(5*year1/4-1)%7)%7;
	 }
	 public void show(){
		 btnShowDay = new JButton("አሳይ :");
		btnShowDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateDate();
				textField.setText(week[day]);
				}
		});
		btnShowDay.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 24));
		btnShowDay.setForeground(new Color(0, 102, 153));
		btnShowDay.setBounds(128, 152, 102, 35);
		frame.getContentPane().add(btnShowDay);
		
	}
}

