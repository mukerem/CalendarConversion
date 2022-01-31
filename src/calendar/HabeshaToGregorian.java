package calendar;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HabeshaToGregorian extends CalendarClass {
	 int dateArray[] ,date,gregoriandate,gregorianmonth,gregorianyear , dayconstant;

	public HabeshaToGregorian() {	
	}
	
	public void toGoregorianChange() {
		dateOfMonth();
		monthInHabesha();
	    listOfYear();
		listOfYearPosition();
		displayDate();
		monthOfYearInEnglish();
		labelAndButton();
		time();
		background();
		
	}
	
	public void labelAndButton(){
	
		JLabel lblSearchDay = new JLabel("Ethiopian\r\n ");
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
	   		date=comboBox_8.getSelectedIndex()+1;
			month=comboBox_9.getSelectedIndex()+1;
			year=comboBox.getSelectedIndex()+1900;
			dateArray =new int[]{date , month , year};
	   		dateArray=habehsaToGregorianCalculate(dateArray);
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
	
	//***** calculate the gregorian day
	public int[] habehsaToGregorianCalculate(int []array){
	   	date =array[0];month=array[1];year=array[2];
		//if(month==13&&(year%4==3&&date>6||year%4!=3&&date>5))
				
		 if(year%4!=0){
		   	if(month==1) dayconstant=0;
		   	else if(month==2||month==3||month==6)dayconstant=1;
		  	else if(month==4||month==7||month==8)dayconstant=2;
			else if(month==5||month==9||month==10)dayconstant=3;
	   		else if(month==11)dayconstant=4;
	   		else if(month==12)dayconstant=5;
	   		else dayconstant=6;
		  }
		 else {
		   	if(month==1) dayconstant=-1;
		   	else if(month==2||month==3||month==6)dayconstant=0;
		  	else if(month==4||month==6||month==7||month==8)dayconstant=1;
			else if(month==5||month==7||month==8)dayconstant=2;
	   		else if(month==9||month==10)dayconstant=3;
	   		else if(month==11)dayconstant=4;
	   		else if(month==12)dayconstant=5;
		   	else dayconstant=6;
		 }
		 if(month==1||month==3||month==8||month==10){
		   	gregoriandate=(date-dayconstant+10)%30;
		   	if(gregoriandate==0)gregoriandate=30;
		  }
		else if(month==6){
		    if(year%4==0){
		 	   gregoriandate=(date-dayconstant+9)%29;
		   		if(gregoriandate==0)gregoriandate=29;
		   	}
		   	else{
			   	gregoriandate=(date-dayconstant+8)%28;
		   		if(gregoriandate==0)gregoriandate=28;
	   		}		   		
	    }
   		else {
		 	gregoriandate=(date-dayconstant+11)%31;
			if(gregoriandate==0)gregoriandate=31;
		}
   		if(date-dayconstant<21)
   			gregorianmonth=(month+8)%12;
		else  			
			gregorianmonth=(month+9)%12;
		if(gregorianmonth==0)
			gregorianmonth=12;
		if(month<4||(month==4&&date-dayconstant<=20))
  			gregorianyear=year+7;
		else
  			gregorianyear=year+8;
		   		//*********
		array =new int[]{gregoriandate,gregorianmonth,gregorianyear};
		return array;
	}
	
//  list of years in comboBox
	public void listOfYearPosition(){
		comboBox.setBounds(324, 98,75 , 31);
		comboBox.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 20));
	} 		
	
}

