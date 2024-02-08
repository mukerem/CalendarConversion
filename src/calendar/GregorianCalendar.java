package calendar;

class GregorianCalendar extends CalendarClass{
	int last=0,lastdate=0 , dayconstantofyear ,j;
		  
     public void gregorianCalander() {
       	 listOfYear();
 		 weeklyDays();
 		 dateOfMonthInGoregorian();
 		 dayOfMonthInLabel();
 		 markCurrentDayLabel();
 		 buttons();
 		 time();
     }

     // day constant of the year
     public int dayConstant(){	
    	 if(year%4 ==0){
            if(month==1) dayconstantofyear=0;
			else if(month==2||month==4||month==5)dayconstantofyear=1;
			else if(month==6||month==7)dayconstantofyear=2;
			else if(month==8)dayconstantofyear=3;
			else if(month==9||month==10)dayconstantofyear=4;
			else if(month==11||month==12)dayconstantofyear=5;
			else dayconstantofyear=0;
    	 }
    	 else {
    		 if(month==1||month==4||month==5) dayconstantofyear=0;
			else if(month==2||month==6||month==7) dayconstantofyear=1;
			else if(month==8) dayconstantofyear=2;
			else if(month==9||month==10) dayconstantofyear=3;
			else if(month==11||month==12)dayconstantofyear=4;
			else dayconstantofyear=-1;	  
    	 }
    	 return dayconstantofyear;
     }
     // ***** end 
     
     // inserting date of the month 
	
	public void dateOfMonthInGoregorian(){
		dayconstant =dayConstant();
		constant=(5*year/4+3)%7;
		start = (2*month + constant +dayconstant)%7;
		if(month==4||month==6||month==9||month==11)
			last = 30;
		else if(month==2&&year%4==0)
			last = 29;
		else if(month==2 && year%4!=0)
			last = 28;
		else last = 31;
		if(start==6||(start==5&&last==31))
			count=6;     
		else
			count=7+start;
		for(int i=0;i<count;i++)
			date[i]=" ";
		for(j=count;j<count+last;j++){
			date[j]=String.format("%d",j-count+1);
		}
		for(int i=count+last;i<42;i++)
			date[i]=" ";
	}
    // ********* end of inserting date of the month 
}
