package calendar;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class SearchDateInHijri extends CalendarClass {
	private JTextField textField;
	 String [] week;
	int day , date ;
	JButton btnShowDay;
	JLabel lblSearchDay ;
	public SearchDateInHijri() {
	    	   
		}

	public void searchInHijri() {
		monthOfYear();
	    listOfYearInHijri();
	    listOfYearPosition();
		dateOfMonth();
		display();
		searchDay();
		show();
		time();
   }	
	public void searchInEnglish(){
   		week = new String []{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		comboBox_2.setModel(new DefaultComboBoxModel(new String[]{"Muharram","Safar","Rabi al-awwal","Rabi' ath-thani","Jumada al-ula","Jumada al-akhirah",
				"Rajab","Sha'ban","Ramadan","Shawwal","Dhul al-Qa'dah","Dhul al-Hijjah"}));
		comboBox_2.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 20));
		comboBox_2.setSelectedIndex(month-1);

	}
	public void searchInArabic(){
   		week = new String []{"الأحد","الاثنين","الثلاثاء","الأربعاء","الخميس","الجمعة","السبت"};
		comboBox_2.setModel(new DefaultComboBoxModel(new String[]{"محرم","صفر","ربيع الأول","ربيع الثاني","جمادالأول"," جمادالأخر","رجب"," شعبان","رمضان","شوال","ذوالقعدة","ذوالحجة"}));	
		comboBox_2.setFont(new Font("Simplifed Arabic", Font.BOLD | Font.ITALIC, 18));
		btnShowDay.setText("show");
		lblSearchDay.setText("Insert date");
		textField.setFont(new Font("Simplifed Arabic", Font.BOLD | Font.ITALIC, 20));
		comboBox_2.setSelectedIndex(month-1);
	}
	
//  list of years in comboBox
	public void listOfYearPosition(){
		comboBox_2.setBounds(211, 98, 130, 31);
		comboBox_3.setBounds(340, 98,75 , 31);
		comboBox_3.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 20));
	}
	
		
	public void searchDay(){
		lblSearchDay = new JLabel("Insert date");
		lblSearchDay.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 22));
		lblSearchDay.setForeground(new Color(51, 102, 153));
		lblSearchDay.setBounds(21, 98, 102, 32);
		frame.getContentPane().add(lblSearchDay);
	}
	 public void display(){
		textField = new JTextField();
		textField.setRequestFocusEnabled(false);
		textField.setForeground(new Color(204, 0, 0));
		textField.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 22));
		textField.setBounds(240, 152, 108, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	 }
	 public void calculateDate(){
		 HijriToHabesha hijri = new HijriToHabesha();
		 date=comboBox_8.getSelectedIndex()+1;
		 month=comboBox_2.getSelectedIndex()+1;
		 year=comboBox_3.getSelectedIndex()+1900;
		 dateArray =new int[]{date , month , year};
	   		dateArray=hijri.hijriToHabeshaCalculate(dateArray);
	   		date = dateArray[0];month= dateArray[1];year = dateArray[2];
			 day=(2*month+date+(5*year/4-1)%7)%7;
	 }
	 public void show(){
		 btnShowDay = new JButton("show");
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
