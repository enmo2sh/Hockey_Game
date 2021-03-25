package eg.edu.alexu.csd.datastructure.iceHockey;
import java.awt.Point;
import java.util.Scanner;
public class assignment  {

	public static void main(String[] args)  {
		Scanner element=new Scanner(System.in);
		String[] photo=new String[5];
		Point [] result=new Point[50];
		photo[0]="11111";
		photo[1]="1AAA1";
		photo[2]="1A1A1";
		photo[3]="1AAA1";
		photo[4]="11111";
		
	    image check=new image();
	    result=check.findPlayers(photo, 1, 3);
	    for(int i=0;i<result.length;i++)
	    System.out.println(result[i]);

	}

}
