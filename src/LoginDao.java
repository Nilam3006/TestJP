import java.sql.*;
import java.util.Objects;

public class LoginDao {

public static boolean validate(String instructionDate,String settlementDate, String currency){
boolean status=false;
try{
	if((Objects.equals(instructionDate, "Mon") || Objects.equals(instructionDate, "Tue")||
			Objects.equals(instructionDate, "Wed") ||Objects.equals(instructionDate, "Thu")||
		    Objects.equals(instructionDate, "Fri") )&& (currency.toString()!="AED")||(currency.toString()!="SAR"))
			return true;
	
	
}catch(Exception e){System.out.println(e);}
return status;
}
}
