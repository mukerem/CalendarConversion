package calendar;

import java.awt.Color;
import java.awt.Font;
import java.time.chrono.HijrahDate;
import javax.swing.JLabel;

public class HijriCalendar extends CalendarClass {
	private static int last;
	protected int yearconstant , leapyear , dhulhijjah ,yearplus;

	// default constructor
	public HijriCalendar(){
		}
	
	public void hijraCalander(){
		listOfYearInHijri();
		weeklyDays();
		dateOfMonthInHijri();
		dayOfMonthInLabel();
		buttons();
		time();
		monthFont();
		markCurrentDayLabel();
	}
	
	void monthFont(){
  		label_42.setFont(new Font("Simplified Arabic", Font.BOLD, 24));
	}
	// create week day labels
	public void weeklyDays(){
		JLabel lblSun = new JLabel(week[0]);
		lblSun.setBounds(10, 76, 39, 14);
		lblSun.setForeground(Color.RED);
		lblSun.setFont(new Font("Simplified Arabic", Font.BOLD, 16));
		frame.getContentPane().add(lblSun);
		
		JLabel lblMon = new JLabel(week[1]);
		lblMon.setBounds(74, 78, 39, 14);
		lblMon.setForeground(Color.RED);
		lblMon.setFont(new Font("Simplified Arabic", Font.BOLD, 16));
		frame.getContentPane().add(lblMon);
		
		JLabel lblTue = new JLabel(week[2]);
		lblTue.setBounds(145, 78, 39, 14);
		lblTue.setForeground(Color.RED);
		lblTue.setFont(new Font("Simplified Arabic", Font.BOLD, 16));
		frame.getContentPane().add(lblTue);
		
		JLabel lblWed = new JLabel(week[3]);
		lblWed.setBounds(225, 78, 39, 14);
		lblWed.setForeground(Color.RED);
		lblWed.setFont(new Font("Simplified Arabic", Font.BOLD, 16));
		frame.getContentPane().add(lblWed);
		
		JLabel lblThr = new JLabel(week[4]);
		lblThr.setBounds(303, 78, 46, 14);
		lblThr.setForeground(Color.RED);
		lblThr.setFont(new Font("Simplified Arabic", Font.BOLD, 16));
		frame.getContentPane().add(lblThr);
		
		JLabel lblFri = new JLabel(week[5]);
		lblFri.setBounds(376, 78, 39, 14);
		lblFri.setForeground(Color.RED);
		lblFri.setFont(new Font("Simplified Arabic", Font.BOLD, 16));
		frame.getContentPane().add(lblFri);
		
		JLabel lblSat = new JLabel(week[6]);
		lblSat.setBounds(454, 78, 39, 14);
		lblSat.setForeground(Color.RED);
		lblSat.setFont(new Font("Simplified Arabic", Font.BOLD, 16));
		frame.getContentPane().add(lblSat);
	}
	// ******* end of create week day labels
	
	public void yearConstantInHijri(){
		leapyear = year%30;
		if(leapyear<3)yearplus=0;
		else if(leapyear<6)yearplus=1;
		else if(leapyear<8)yearplus=2;
		else if(leapyear<11)yearplus=3;
		else if(leapyear<14)yearplus=4;
		else if(leapyear<17)yearplus=5;
		else if(leapyear<19)yearplus=6;
		else if(leapyear<22)yearplus=0;
		else if(leapyear<25)yearplus=1;
		else if(leapyear<27)yearplus=2;
		else yearplus=3;
		
		if(leapyear ==2||leapyear ==5||leapyear ==7||leapyear ==10||leapyear ==13||leapyear ==16||
				leapyear ==18||leapyear ==21||leapyear ==24||leapyear ==26||leapyear ==29)
			dhulhijjah = 30;
		else 
			dhulhijjah = 29;
		
				
	}
	//  putting date of month in string array
	public void dateOfMonthInHijri(){
		yearConstantInHijri();
		if(month%2==1)
			dayconstant=-month/2;
		else
			dayconstant =-( month-1)/2;
		yearplus=(yearplus+year/30*5)%7;
		constant=(year*4 + year/30*6 + yearplus)%7;
		
		start = (2*month+1 + constant +dayconstant -2)%7;
		if(month%2==1||(month==12 && dhulhijjah == 30) )
			last = 30;
		else last = 29;
		if(start==6)
			count=6;     
		else
			count=7+start;
		for(int i=0;i<count;i++)
			date[i]=" ";
		for(int j=count;j<count+last;j++)
			date[j]=String.format("%d",j-count+1);
		for(int i=count+last;i<42;i++)
			date[i]=" ";
	}
	//  *****  end of put dates of month in string array

	// *****  end of list of years
}	
	



