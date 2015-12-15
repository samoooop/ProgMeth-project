package util;

@SuppressWarnings("serial")
public class ScoreParsingException extends Exception{
	   
	private int errorType;
	
	public ScoreParsingException(int errorType){
		this.errorType =  errorType;
	}
	
	public String getMessage(){
		String a  = "";
		if(this.errorType == 0){a+= "No record score";}
		if(this.errorType == 1){a+= "Wrong record format";}
		return a;
	}
}