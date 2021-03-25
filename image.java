package eg.edu.alexu.csd.datastructure.iceHockey;
import java.awt.Point;
import java.util.*;
public class image implements IPlayersFinder {
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		Point [] result=new Point[2500];
		int s=0;
		int c=photo[0].length();
		int r=photo.length;
		
		if((r>0)&&(c>0)) {
		
		char [][] image2=new char[r][c];
		int row=0;
		for (int i=0;i<photo.length;i++) {
			char[]temp=photo[i].toCharArray();
			for (int j=0;j<temp.length;j++) {
				image2[row][j]=temp[j];
			}
			row++;
		}
		double n=(double)threshold/4;
		int least=(int)Math.ceil(n);
		for (int i=0;i<image2.length;i++) {
		for(int j=0;j<image2[0].length;j++) {
			ArrayList <Integer>[] index= new ArrayList [2];
			 for(int k=0;k<2;k++) 
				 index[k]=new ArrayList <Integer>();
			 if (Character.getNumericValue(image2[i][j])==team)
		       groups(index,image2,i,j,team);
			if (index[0].size()>=least) {
			index[0].sort(null);
			index[1].sort(null);
			int x=index[0].get(0)+index[0].get(index[0].size()-1)+1;
			int y=index[1].get(0)+index[1].get(index[1].size()-1)+1;
			Point p=new Point(x,y);
			result[s++]=p;
			}	
			}       
		}			
		for (int i=0;i<s;i++) {
			for (int j=0;j<s-1-i;j++) {
				if (result[j].x>result[j+1].x) {
					int temp=result[j].x;
					result[j].x=result[j+1].x;
					result[j+1].x=temp;
					temp=result[j].y;
					result[j].y=result[j+1].y;
					result[j+1].y=temp;
				}
				else if (result[j].x==result[j+1].x) {
					if (result[j].y>result[j+1].y) {
						int temp=result[j].x;
						result[j].x=result[j+1].x;
						result[j+1].x=temp;
						temp=result[j].y;
						result[j].y=result[j+1].y;
						result[j+1].y=temp;
					}
				}
			}
		}
		}
		return result;
	}
	void groups (ArrayList<Integer>[]index,char image2[][],int i,int j,int team) {
		if ((i<0)||(i>(image2.length)-1)||(j<0)||(j>(image2[0].length)-1))
			return ;
		else if (Character.getNumericValue(image2[i][j])!=team)
			return;
		else {
			index[0].add(j);
			index[1].add(i);
			image2[i][j]='+';
			groups(index,image2,i-1,j,team);
			groups(index,image2,i+1,j,team);
			groups(index,image2,i,j-1,team);
			groups(index,image2,i,j+1,team);
		}
	}
	
}
