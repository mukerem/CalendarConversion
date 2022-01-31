package calendar;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class HijriToGregorian extends CalendarClass{

	
		 int dateArray[] ,date,gregoriandate,gregorianmonth,gregorianyear , dayconstant;
		 int yeardate, totaldate ,remaindate ;
		public HijriToGregorian() {	
		}
		
		public void toGregorianChange() {
			dateOfMonth();
			monthOfYear();
			monthInHijriModification();
		    listOfYearInHijri();
			listOfYearPosition();
			displayDate();
			monthOfYearInEnglish();
			labelAndButton();
			time();
		}
		
		public void labelAndButton(){
		
			JLabel lblSearchDay = new JLabel("Hijri\r\n ");
			lblSearchDay.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
			lblSearchDay.setForeground(new Color(51, 102, 153));
			lblSearchDay.setBounds(16, 82, 112, 36);
			frame.getContentPane().add(lblSearchDay);
			JLabel lblSearchDay_1 = new JLabel("Calendar\r\r\n:");
			lblSearchDay_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
			lblSearchDay_1.setForeground(new Color(51, 102, 153));
			lblSearchDay_1.setBounds(16, 107, 112, 36);
			frame.getContentPane().add(lblSearchDay_1);
			
		   	JButton btnGoregorian = new JButton("Gre.\r\n Calendar\r\r\n :");
		   	btnGoregorian.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		HijriToHabesha hijra=new HijriToHabesha();
		   		HabeshaToGregorian habesha = new HabeshaToGregorian();
		   		date=comboBox_8.getSelectedIndex()+1;
				month=comboBox_2.getSelectedIndex()+1;
				year=comboBox_3.getSelectedIndex()+1350;
				dateArray =new int[]{date , month , year};
		   		dateArray=hijra.hijriToHabeshaCalculate(dateArray);
		   		dateArray=habesha.habehsaToGregorianCalculate(dateArray);		   		
		   		gregoriandate = dateArray[0];gregorianmonth= dateArray[1];gregorianyear = dateArray[2];
		  		textField_3.setText(String.format("%d",gregoriandate));
		  		textField_1.setText(mon[gregorianmonth-1]);
		  		textField_2.setText(String.format("%d",gregorianyear));
		   		}
		   	});
		   	btnGoregorian.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		  	btnGoregorian.setForeground(new Color(51, 102, 153));
		 	btnGoregorian.setBounds(16, 162, 167, 46);
			frame.getContentPane().add(btnGoregorian);
		}
		
		
		
	//  list of years in comboBox
		public void listOfYearPosition(){
			comboBox_3.setBounds(344, 98,85 , 31);
			comboBox_3.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 20));
		}
		public void monthInHijriModification(){
			comboBox_2.setBounds(210, 98, 140, 31);
			comboBox_2.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 20));
			comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Muharram","Safar","Rabi al-awwal","Rabi' ath-thani","Jumada al-ula","Jumada al-akhirah",
					"Rajab","Sha'ban","Ramadan","Shawwal","Dhul al-Qa'dah","Dhul al-Hijjah"}));
			comboBox_2.setSelectedIndex(month-1);

		} 		
		
	}

