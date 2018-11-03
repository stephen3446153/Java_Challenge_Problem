import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class readCSVfile {
	//Constant Declaration
	public static final int TOTALARGS = 17;
	
	private static List<argDetail> argInfo = new ArrayList<argDetail>();
	List<argDetail> list = new ArrayList<argDetail>();
	public static String[] readNames() {
		String[] sNames = new String[TOTALARGS];
		try {
			// Read informations from input file, "input-data.csv"
			BufferedReader in = new BufferedReader((new FileReader("input-data.csv")));
			String sLine;
			String[] saLineElements;
			sLine = in.readLine();
			saLineElements = sLine.split(",");
			for(int iI = 0;iI<TOTALARGS;iI++) 
			{
				sNames[iI] = saLineElements[iI];
			}
		}
		catch (IOException e)
		{
			System.out.println("ERROR: Could not read text file!");
		}
		return sNames; 
	}
	
	
	public static List<argDetail> readDetails()
	{
		try
		{
			// Read informations from input file, "input-data.csv"
			BufferedReader in = new BufferedReader((new FileReader("input-data.csv")));
			String sLine;
			String[] saLineElements;
			//Read and skip the first line
			sLine = in.readLine();
			Set<argDetail> Hset = new HashSet<argDetail>();
			
			//Reading line by line
			while((sLine = in.readLine()) != null)
			{
				//Declaration of local variables
				String sEntry_Type = "";
				String sPlantingDate = "";
				int iGID = 0;
				String sDesignation = "";
				int iEntry_No = 0;
				int iEh_Cm = 0;
				int iPh_cm = 0;
				int iDTA_days = 0;
				int iDTS_days = 0;
				float fMoi_Pct_Std = 0.0f;
				int iGW_g_Fieldwb = 0;
				int iEarsHvst_Ears_Plot = 0;
				int iRLodg_Pl_Plot = 0;
				int iRep_No = 0;
				int iPlot_No = 0;
				int iColumn = 0;
				int iRow = 0;
				int flag = 0;
				saLineElements = sLine.split(",");
				
				for (int iI = 0;iI <TOTALARGS;iI ++) {
					if(saLineElements[iI] != null && !saLineElements[iI].isEmpty())
						flag = iI;
						switch (flag) {
						//save the value into local variables
						case 0: sEntry_Type = saLineElements[0];
						break;
						case 1:sPlantingDate = saLineElements[1];
						break;
						case 2:iGID = Integer.valueOf(saLineElements[2]);
						break;
						case 3:sDesignation = saLineElements[3];
						break;
						case 4:iEntry_No = Integer.valueOf(saLineElements[4]);
						break;
						case 5:iEh_Cm = Integer.valueOf(saLineElements[5]);
						break;
						case 6:iPh_cm = Integer.valueOf(saLineElements[6]);
						break;
						case 7:iDTA_days = Integer.valueOf(saLineElements[7]);
						break;
						case 8:iDTS_days = Integer.valueOf(saLineElements[8]);
						break;
						case 9:fMoi_Pct_Std = Float.valueOf(saLineElements[9]);
						break;
						case 10:iGW_g_Fieldwb = Integer.valueOf(saLineElements[10]);
						break;
						case 11:iEarsHvst_Ears_Plot = Integer.valueOf(saLineElements[11]);
						break;
						case 12:iRLodg_Pl_Plot = Integer.valueOf(saLineElements[12]);
						break;
						case 13:iRep_No = Integer.valueOf(saLineElements[13]);
						break;
						case 14:iPlot_No = Integer.valueOf(saLineElements[14]);
						break;
						case 15:iColumn = Integer.valueOf(saLineElements[15]);
						break;
						case 16:iRow = Integer.valueOf(saLineElements[16]);
						break;
						default:break;
					}
					
				}
				//Store the variables into data list
				argDetail tmp_detail = new argDetail();
				tmp_detail.setsEntry_Type(sEntry_Type);
				tmp_detail.setsPlantingDate(sPlantingDate);
				tmp_detail.setiGID(iGID);
				tmp_detail.setsDesignation(sDesignation);
				tmp_detail.setiEntry_No(iEntry_No);
				tmp_detail.setiEh_Cm(iEh_Cm);
				tmp_detail.setiPh_cm(iPh_cm);
				tmp_detail.setiDTA_days(iDTA_days);
				tmp_detail.setiDTS_days(iDTS_days);
				tmp_detail.setfMoi_Pct_Std(fMoi_Pct_Std);
				tmp_detail.setiGW_g_Fieldwb(iGW_g_Fieldwb);
				tmp_detail.setiEarsHvst_Ears_Plot(iEarsHvst_Ears_Plot);
				tmp_detail.setiRLodg_Pl_Plot(iRLodg_Pl_Plot);
				tmp_detail.setiRep_No(iRep_No);
				tmp_detail.setiPlot_No(iPlot_No);
				tmp_detail.setiColumn(iColumn);
				tmp_detail.setiRow(iRow);
				Hset.add(tmp_detail);
			}
			
			argInfo.addAll(Hset);
		}
		catch (IOException e)
		{
			System.out.println("ERROR: Could not read text file!");
		}
		return (List<argDetail>) argInfo;
	}
	

}

