package package1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BatchFileExe 
{
	public static void main(String[] args) 
	{
		try 
		{
			String line;
			String temp1 = "";
			String temp2 = "";
			boolean isExe = true;
			
			Process p = Runtime.getRuntime().exec
					(System.getenv("windir") +"\\system32\\"+"tasklist.exe /v");
			BufferedReader input =
					new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) 
			{
				System.out.println(line);
				if( line.contains("atm") )
				{
					System.out.println(line);
					isExe = false;
				}
			}
 			input.close();
 			
 			System.out.println(isExe);
 			if( isExe )
 			{
 				//exe batch file
 				Runtime.getRuntime().exec("cmd /c start \"\" atm.bat");
 			}
		} 
		catch (Exception err) 
		{
			err.printStackTrace();
		}
	}
}
