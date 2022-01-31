package calendar;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class HijriToHabesha extends CalendarClass{

	
		 int dateArray[] ,date,habeshadate,habeshamonth,habeshayear , dayconstant;
		 int yeardate, totaldate ,remaindate ;
		public HijriToHabesha() {	
		}
		
		public void toHabeshaChange() {
			dateOfMonth();
			monthOfYear();
			monthInHijriModification();
		    listOfYearInHijri();
			listOfYearPosition();
			displayDate();
			monthOfYearInAmharic();
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
			
		   	JButton btnGoregorian = new JButton("Ethio.\r\n Calendar\r\r\n :");
		   	btnGoregorian.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		date=comboBox_8.getSelectedIndex()+1;
				month=comboBox_2.getSelectedIndex()+1;
				year=comboBox_3.getSelectedIndex()+1350;
				dateArray =new int[]{date , month , year};
		   		dateArray=hijriToHabeshaCalculate(dateArray);
		   		habeshadate = dateArray[0];habeshamonth= dateArray[1];habeshayear = dateArray[2];
		  		textField_3.setText(String.format("%d",habeshadate));
		   		textField_1.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 24));
		  		textField_1.setText(mon[habeshamonth-1]);
		  		textField_2.setText(String.format("%d",habeshayear));
		   		}
		   	});
		   	btnGoregorian.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		  	btnGoregorian.setForeground(new Color(51, 102, 153));
		 	btnGoregorian.setBounds(16, 162, 167, 46);
			frame.getContentPane().add(btnGoregorian);
		}
		
		//***** calculate the habesha day
		public int[] hijriToHabeshaCalculate(int []array){
		   	date =array[0];month=array[1];year=array[2];
			yeardate= (int) (year*354.36666667);
			if(year%30==8||year%30==19||year%30==27) yeardate++;
			 totaldate = 224201+date+month*30-(month-1)/2+yeardate;
			 habeshayear = (int) ((totaldate-1)/365.25);
			 remaindate=(int) (totaldate -habeshayear*365.25);	
			 if(habeshayear%4==0){
				 remaindate--; 
				 if(remaindate==0){
					 habeshayear--;
					 remaindate=366;
				 }
			 }
			 habeshamonth=(remaindate-1)/30 +1;
			 habeshadate=remaindate%30;
			 if(habeshadate==0)habeshadate=30;
			 //*********
			array =new int[]{habeshadate,habeshamonth,habeshayear};
			return array;
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

