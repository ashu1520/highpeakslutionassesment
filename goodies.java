import java.util.*;
import java.io.*;
public class goodies {
			
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		String input_file="sample_input.txt";
		String output_file="sample_output.txt";

		 FileReader file=new FileReader(input_file);
		 BufferedReader bf=new BufferedReader(file);
		 FileWriter output=new FileWriter(output_file,true);
		 BufferedWriter bw=new BufferedWriter(output);
		
		int price[]=new int [10];
		String goodies[]=new String[10];
		String st=bf.readLine();
		
		for(int i=0;i<10;i++)
		{  
			if((st=bf.readLine())!=null){
			StringTokenizer stn=new StringTokenizer(st,":");
			String s1=stn.nextToken();
			
			int p1=Integer.parseInt(stn.nextToken());
			goodies[i]=s1;
			price[i]=p1;
			}
			
		}
		
		goodies_price(price,goodies);
		
		System.out.println("Enter number of Employees");
		int n=sc.nextInt();
		
		int val=find(price,n);
		bw.write("Enter number of Employees "+Integer.toString(n));
		bw.newLine();
		bw.write("Here the goodies that are selected for distribution are :");
		bw.newLine();
		for(int j=val;j<val+n;j++)
		{
			
			
			bw.write(goodies[j]+":");
			String str1=Integer.toString(price[j]);
			bw.write(str1);
			bw.newLine();
			
		}
		int d=price[val+n-1]-price[val];
		bw.write("And the diffrent between the chosen goodie with highest price and the lowest price is "+Integer.toString(d)+"\n\r");
		System.out.println();
		bw.close();
	
		
	}
	private static void goodies_price(int[] price, String[] goodies) {
		
		int len=price.length;
		for(int i=0;i<len-1;i++)
		{
			int min_index=i;
			for(int j=i+1;j<len;j++)
			  if(price[j]<price[min_index])
				  min_index=j;
			
			
			int temp=price[min_index];
			price[min_index]=price[i];
			price[i]=temp;
			
			String temp1=goodies[min_index];
			goodies[min_index]=goodies[i];
			goodies[i]=temp1;
			
		}
	}

	private static int find(int[] price,int n) {
		int b=Integer.MAX_VALUE;
		int position=-1;
		for(int i=0;i<price.length-n+1;i++)
		{
			int n1=price[i+n-1]-price[i];
			if(b>n1)
			{
				position=i;
				b=n1;
			}
		}
		return position;
	}
}
