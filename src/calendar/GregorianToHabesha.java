package calendar;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GregorianToHabesha extends CalendarClass{
	int habeshadate ,  habeshamonth ,  habeshayear, dayconstant, monthconstant , totaldate , date ;
	int dateArray[];
	public GregorianToHabesha() {	
	}
	
	public void toHabeshaChange() {
		dayOfMonthInGoregorian();
		monthOfYear();
	    listOfYear();
		listOfYearPosition();
		monthOfYearInAmharic();
		displayDate();
		labelAndButton();
		time();	
	}
		
	public void labelAndButton(){
		
		JLabel lblSearchDay = new JLabel("Gregorian\r\n ");
		lblSearchDay.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
		lblSearchDay.setForeground(new Color(255, 102, 0));
		lblSearchDay.setBounds(16, 82, 112, 36);
		frame.getContentPane().add(lblSearchDay);
		JLabel lblSearchDay_1 = new JLabel("Calendar\r\r\n:");
		lblSearchDay_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
		lblSearchDay_1.setForeground(new Color(255, 102, 0));
		lblSearchDay_1.setBounds(16, 107, 112, 36);
		frame.getContentPane().add(lblSearchDay_1);
		
	   	JButton btnGoregorian = new JButton("Ethio.\r\n Calendar\r\r\n :");
	   	btnGoregorian.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		date=comboBox_1.getSelectedIndex()+1;
			month=comboBox_2.getSelectedIndex()+1;
		   	year=comboBox.getSelectedIndex()+1900;
	  		dateArray =new int[]{date , month , year};
	   		dateArray=gregorianToHabeshaCalculate(dateArray);
	   		habeshadate = dateArray[0];habeshamonth= dateArray[1];habeshayear = dateArray[2];
	  		textField_3.setText(String.format("%d",habeshadate));
	   		textField_1.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 24));
	  		textField_1.setText(mon[habeshamonth-1]);
	  		textField_2.setText(String.format("%d",habeshayear));
	   		}
	   	});
	   	btnGoregorian.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
	  	btnGoregorian.setForeground(new Color(255, 102, 0));
	 	btnGoregorian.setBounds(16, 162, 167, 46);
		frame.getContentPane().add(btnGoregorian);
	}
	
	  //***** calculate the Habesha date
	 public int[] gregorianToHabeshaCalculate(int []array){
	 	GregoriaCalendar  gregorian = new GregoriaCalendar(); 
	   	date =array[0];month=array[1];year=array[2];
	   	dayconstant = gregorian.dayConstant();
   		
	   	//***constant for year%4==0 like 2016,2020,...  years
	   	if(year%4==0) {
	   		//month constant
	   		if(month==1||month==3||month==11||month==12) monthconstant =4;
	 		else if(month==2||month==4||month==5)monthconstant =3;
	 		else if(month==6||month==7)monthconstant =2;
	   		else if(month==9||month==10)monthconstant =5;
	  		else monthconstant =1;
	   				
	   		// calculation part 
	   		if(month<9||(month==9&&date<11))  habeshayear=year-8;
	   		else habeshayear=year-7;
	   		totaldate=date+month*30+dayconstant-9;
	   		habeshadate=totaldate%30;
	   		
	 		if(totaldate>275) habeshadate=habeshadate-5;
	   		if(habeshadate==0) habeshadate=30;
	   		
	   		if(date-monthconstant >5) habeshamonth=(month+4)%12;
	   		else habeshamonth=(month+3)%12;
	   		
	   		if(habeshamonth==0){
	   			if(month==9&&date>=11)habeshamonth=1;
				else if(month==9&&6<=date && date<=10)habeshamonth=13;
				else month=12;
	   		}
	   	}   //****** end of 2016
	   					
	   //********* year%4==3 like 2011,2015 ... years
	   	else if(year%4==3) {
	   		//month constant
	   		if(month==1||month==4||month==5)monthconstant =3;
	  		else if(month==2||month==6||month==7)monthconstant =2;
			else if(month==3)monthconstant =4;
			else if(month==9||month==10)monthconstant =6;
	   		else if(month==11||month==12) monthconstant =5;
	   		else monthconstant =1;
	   					
			// calculation part
	   		if(month<9||(month==9&&date<=11)) habeshayear=year-8;
	   		else habeshayear=year-7;
	   		
	   		totaldate=date+month*30+dayconstant-8;
	  		habeshadate=totaldate%30;
	  		if(totaldate>276) 	habeshadate=habeshadate-6;
	   		if(habeshadate==0) habeshadate=30;
	   		
	   		if(date-monthconstant >5) 	habeshamonth=(month+4)%12;
	   		else habeshamonth=(month+3)%12;
	   		
	   		if(habeshamonth==0){
	   			if(month==9&&date>=12)habeshamonth=1;
	   			else if(month==9&&6<=date && date<=11)habeshamonth=13;
	 			else habeshamonth=12;
	   		}
	   	}  // *** end of 2015
	   		   				
	   //******for year%4==2||1
		else {
			//month constant m is month constant
	   		if(month==1||month==4||month==5)monthconstant =3;
	   		else if(month==2||month==6||month==7)monthconstant =2;
	 		else if(month==3||month==11||month==12)monthconstant =4;
	 		else if(month==9)monthconstant =5;
	   		else if(month==10)monthconstant =5;
	 		else monthconstant =1;
	   		
	  		// calculation part
	   		if(month<9||(month==9&&date<11)) habeshayear=year-8;
	   		else habeshayear=year-7;
	   		totaldate=date+month*30+dayconstant-8;
	   		habeshadate=totaldate%30;
	   		
	   		if(totaldate>275) habeshadate=habeshadate-5;
	   		if(habeshadate==0) habeshadate=30;
	   		
	   		if(date-monthconstant >5) habeshamonth=(month+4)%12;
	   		else habeshamonth=(month+3)%12;
	   		
	   		if(habeshamonth==0) {
	  			if(month==9&&date>=11)habeshamonth=1;
	  			else if(month==9&&6<=date && date<=10)habeshamonth=13;
	  			else habeshamonth=12;
	  		}
	  	}   //******end of 2014	   
		array =new int[]{habeshadate,habeshamonth,habeshayear};
	   	return array;
	 }  	
	 
	 //  list of years in comboBox
	 public void listOfYearPosition(){
		comboBox.setBounds(334, 98,105 , 31);
	   	comboBox.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 22));
		comboBox.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 22));

	 }	

}
