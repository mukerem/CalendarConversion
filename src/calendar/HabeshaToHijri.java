package calendar;

import java.lang.Math;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class HabeshaToHijri extends CalendarClass{

	
		public	 int dateArray[] ,date,hijradate,hijramonth,hijrayear , dayconstant;
	    int yeardate, totaldate ,remaindate ;
		public HabeshaToHijri() {	
		}
		
		public void toHijriChange() {
			dateOfMonth();
			monthInHabesha();
		    listOfYear();
			listOfYearPosition();
			displayDate();
			monthOfHijriInEnglish();
			labelAndButton();
			time();
			
		}
		
		public void labelAndButton(){
		
			JLabel lblSearchDay = new JLabel("Habesha ");
			lblSearchDay.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
			lblSearchDay.setForeground(new Color(51, 102, 153));
			lblSearchDay.setBounds(16, 82, 112, 36);
			frame.getContentPane().add(lblSearchDay);
			JLabel lblSearchDay_1 = new JLabel("Calendar:");
			lblSearchDay_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
			lblSearchDay_1.setForeground(new Color(51, 102, 153));
			lblSearchDay_1.setBounds(16, 107, 112, 36);
			frame.getContentPane().add(lblSearchDay_1);
			
		   	JButton btnGoregorian = new JButton("Hijri Calendar :");
		   	btnGoregorian.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		date=comboBox_8.getSelectedIndex()+1;
				month=comboBox_9.getSelectedIndex()+1;
				year=comboBox.getSelectedIndex()+1900;
				dateArray =new int[]{date , month , year};
		   		dateArray=habeshaToHijriCalculate(dateArray);
		   		hijradate = dateArray[0];hijramonth= dateArray[1];hijrayear = dateArray[2];
		  		textField_3.setText(String.format("%d",hijradate));
		   		textField_1.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 20));
		  		textField_1.setText(mon[hijramonth-1]);
		  		textField_2.setText(String.format("%d",hijrayear));
		   		}
		   	});
		   	btnGoregorian.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 19));
		  	btnGoregorian.setForeground(new Color(51, 102, 153));
		 	btnGoregorian.setBounds(16, 162, 167, 46);
			frame.getContentPane().add(btnGoregorian);
		}
		
		//***** calculate the habesha day
		public int[] habeshaToHijriCalculate(int []array){
		   	date =array[0];month=array[1];year=array[2];
			yeardate=  Math.round(year*365.25f);
			totaldate = date+month*30+yeardate-224259;
			hijrayear = (int) ((totaldate-1)/354.3666667);
			 remaindate=(int) (totaldate -hijrayear*354.3666667);
			 if((hijrayear%30==8||hijrayear%30==19||hijrayear%30==27)){
				 remaindate--; 
				 if(remaindate==0){
					 hijrayear--;
					 remaindate=355;
				 }
			 }
			 hijramonth=(int) ((remaindate-1)/29.5 +1);
			 hijradate=remaindate%30+((hijramonth-1)/2);
			 if(hijradate==0)hijradate=30-(int) (1+Math.pow(-1, hijramonth))/2;
			 
			 if(remaindate==355){
				 hijradate=30;
				 hijramonth=12;
			 }
			 
			 //*********
			array =new int[]{hijradate,hijramonth,hijrayear};
			return array;
		}
		
	//  list of years in comboBox
		public void listOfYearPosition(){
			comboBox.setBounds(323, 98,85 , 31);
			comboBox.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 20));
		}
		public void monthInHijriModification(){
			comboBox_2.setBounds(210, 98, 140, 31);
			comboBox_2.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 20));
			comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Muharram","Safar","Rabi al-awwal","Rabi' ath-thani","Jumada al-ula","Jumada al-akhirah",
					"Rajab","Sha'ban","Ramadan","Shawwal","Dhul al-Qa'dah","Dhul al-Hijjah"}));

		}
		
	    public void background(){
		   		JLabel label = new JLabel("");
		   		label.setBackground(Color.ORANGE);
		   		label.setBounds(218, 173, 77, 23);
		   		frame.getContentPane().add(label);
		   		
		   		JLabel lblNewLabel = new JLabel("");
		   		lblNewLabel.setIcon(new ImageIcon("D:\\books\\workspace\\javafirst\\src\\javafirst\\images\\images177.jpg"));
		   		lblNewLabel.setBounds(0, 0, 502, 308);
		   		frame.getContentPane().add(lblNewLabel);
		}   		
		
	}

