package calendar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class SearchDateInGregorian extends CalendarClass {
	public int date, day;
	public String week[] ;
	public JTextField textfield_2;
	public SearchDateInGregorian() {
	    	   
	}
	public void searchInGoregorian(){
		dayOfMonthInGoregorian();
		listOfYear();
		listOfYearPosition();
		monthOfYear();
		enterDateLabel();
		displayDay();
		showDayButton();
		time();

	}    	   
  		
	public void searchInEnglish(){
   		week = new String []{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"January","February","March","April","May","June","July","August","September","October","November","December"}));	
	}
	public void searchInFrench(){
   		week = new String []{"dimanche","lundi","mardi","mercredi","juedi","venderdi","samedi"};
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"janvier","février","mars","avril","mai","juin","juillet","aôut","septembre","octobre","novembre","décembre"}));		
	}
	public void searchInPortuguese(){
   		week = new String []{"Domingo","Segunda-feira","Terça-feira","Quarta-feira","Quinta-feira","Sexta-feira","Sábado"};
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"}));	
	}public void searchInSpanish(){
   		week = new String []{"domingo","lunes","martes","miércoles","jueves","viemes","sábado"};
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"}));	
	}public void searchInTurkish(){
   		week = new String []{"Pazar","Pazartesi","Sali","Çarşamba","Perşembe","Cuma","Cumartesi"};
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"ocak","şubat","mart","nisan","mayis","haziran","temmuz","ağustos","eylül","ekim","kasım","aralık"}));	
	}
	public void enterDateLabel(){   		
	   	JLabel lblSearchDay = new JLabel("Enter a Date :");
	   	lblSearchDay.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 20));
	 	lblSearchDay.setForeground(new Color(51, 102, 153));
 		lblSearchDay.setBounds(5, 100, 132, 32);
 		frame.getContentPane().add(lblSearchDay);
	}
	
	public void displayDay(){
		textfield_2 = new JTextField();
		textfield_2.setForeground(new Color(204, 0, 0));
		textfield_2.setRequestFocusEnabled(false);
		textfield_2.setFont(new Font("Nyala", Font.BOLD | Font.ITALIC, 24));
		textfield_2.setBounds(240, 152, 150, 34);
		frame.getContentPane().add(textfield_2);
		textfield_2.setColumns(10);
	}
	
	
//  list of years in comboBox
	public void listOfYearPosition(){
		comboBox.setBounds(334, 98, 78, 31);
		comboBox.setSelectedIndex(117);
		comboBox.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 20));
		

	}
	// *****  end of list of years
	
	
	public void showDayButton(){
		JButton btnShowDay = new JButton("Show :");
	   	btnShowDay.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
			GregoriaCalendar gre = new GregoriaCalendar();
	   		dayconstant = gre.dayConstant();
	   		date=comboBox_1.getSelectedIndex()+1;
	 		month=comboBox_2.getSelectedIndex()+1;
	 		year=comboBox.getSelectedIndex()+1900;   			
	 		day=(2*month+date+(5*year/4+3+dayconstant)%7)%7;
	 		textfield_2.setText(week[day]);
	   		}
	   	});
	   	btnShowDay.setFont(new Font("PMingLiU-ExtB", Font.BOLD | Font.ITALIC, 24));
	   	btnShowDay.setForeground(new Color(0, 102, 153));
	  	btnShowDay.setBounds(98, 152, 132, 35);
	 	frame.getContentPane().add(btnShowDay);
	}  	
}

