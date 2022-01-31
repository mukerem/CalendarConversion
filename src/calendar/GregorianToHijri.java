package calendar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GregorianToHijri extends CalendarClass{
	int hijridate ,  hijrimonth ,  hijriyear, dayconstant, monthconstant , totaldate , date ;
	int dateArray[];
	public GregorianToHijri() {	
	}
	
	public void toHijriChange() {
		dayOfMonthInGoregorian();
		monthOfYear();
	    listOfYear();
		listOfYearPosition();
		monthOfHijriInEnglish();
		displayDate();
		labelAndButton();
		time();
	}
	
	public void labelAndButton(){
		
		JLabel lblSearchDay = new JLabel("Gregorian ");
		lblSearchDay.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
		lblSearchDay.setForeground(new Color(255, 102, 0));
		lblSearchDay.setBounds(16, 82, 112, 36);
		frame.getContentPane().add(lblSearchDay);
		JLabel lblSearchDay_1 = new JLabel("Calendar:");
		lblSearchDay_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
		lblSearchDay_1.setForeground(new Color(255, 102, 0));
		lblSearchDay_1.setBounds(16, 107, 112, 36);
		frame.getContentPane().add(lblSearchDay_1);
		
	   	JButton btnGoregorian = new JButton("Hijri Calendar:");
	   	btnGoregorian.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		GregorianToHabesha gre = new GregorianToHabesha();
	   		HabeshaToHijri hijri = new HabeshaToHijri();
	   		date=comboBox_1.getSelectedIndex()+1;
			month=comboBox_2.getSelectedIndex()+1;
		   	year=comboBox.getSelectedIndex()+1900;
	  		dateArray =new int[]{date , month , year};
	   		dateArray=gre.gregorianToHabeshaCalculate(dateArray);
	   		dateArray=hijri.habeshaToHijriCalculate(dateArray);
	   		hijridate = dateArray[0];hijrimonth= dateArray[1];hijriyear = dateArray[2];
	  		textField_3.setText(String.format("%d",hijridate));
	   		textField_1.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 24));
	  		textField_1.setText(mon[hijrimonth-1]);
	  		textField_2.setText(String.format("%d",hijriyear));
	   		}
	   	});
	   	btnGoregorian.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
	  	btnGoregorian.setForeground(new Color(255, 102, 0));
	 	btnGoregorian.setBounds(16, 162, 167, 46);
		frame.getContentPane().add(btnGoregorian);
	}
	
	 
	 //list of years in comboBox
		public void listOfYearPosition(){
			comboBox.setBounds(323, 98,85 , 31);
			comboBox.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 20));
		}
}
