
public class argDetail_Ver1 {

	//Declaration of Variables
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

	/**
	 * Creator method.
	 * 
	 * @param cEntry_Type
	 * @param sPlantingDate
	 * @param iGID
	 * @param sDesignation;
	 * @param iEntry_No 
	 * @param iEh_Cm
	 * @param iPh_cm
	 * @param iDTA_days
	 * @param iDTS_days
	 * @param fMoi_Pct_Std
	 * @param iGW_g_Fieldwb
	 * @param iEarsHvst_Ears_Plot
	 * @param iRLodg_Pl_Plot
	 * @param iRep_No
	 * @param iPlot_No
	 * @param iColumn
	 * @param iRow
	 * @return 
	 */
	
	//Default Constructor
	public argDetail_Ver1()
	{
		
	}
	
	
	//Override the argDetail()
	public argDetail_Ver1(String sEntry_Type,String sPlantingDate,int iGID,String sDesignation,
			int iEntry_No,int iEh_Cm,int iPh_cm,int iDTA_days,int iDTS_days,float fMoi_Pct_Std,
			int iGW_g_Fieldwb,int iEarsHvst_Ears_Plot,int iRLodg_Pl_Plot,int iRep_No,int iPlot_No,
			int iColumn,int iRow) {
		this.sEntry_Type = sEntry_Type;
		this.sPlantingDate = sPlantingDate;
		this.iGID = iGID;
		this.sDesignation = sDesignation;
		this.iEntry_No = iEntry_No;
		this.iEh_Cm = iEh_Cm;
		this.iPh_cm = iPh_cm;
		this.iDTA_days = iDTA_days;
		this.iDTS_days = iDTS_days;
		this.fMoi_Pct_Std = fMoi_Pct_Std;
		this.iGW_g_Fieldwb = iGW_g_Fieldwb;
		this.iEarsHvst_Ears_Plot = iEarsHvst_Ears_Plot;
		this.iRLodg_Pl_Plot = iRLodg_Pl_Plot;
		this.iRep_No = iRep_No;
		this.iPlot_No = iPlot_No;
		this.iColumn = iColumn;
		this.iRow = iRow;
	}
}
