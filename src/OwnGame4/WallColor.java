package OwnGame4;

public enum WallColor {
	GRAY(1, "..\\Test\\BreakOut_figure\\wallGRAY.png", 50, "..\\Test\\BreakOut_figure\\fragGRAY.png"),
	YELLOW(2, "..\\Test\\BreakOut_figure\\wallYELLOW.png", 100, "..\\Test\\BreakOut_figure\\fragYELLOW.png"),
	GREEN(3, "..\\Test\\BreakOut_figure\\wallGREEN.png", 150, "..\\Test\\BreakOut_figure\\fragGREEN.png"),
	ORANGE(4, "..\\Test\\BreakOut_figure\\wallORANGE.png", 200, "..\\Test\\BreakOut_figure\\fragORANGE.png"),
	RED(5, "..\\Test\\BreakOut_figure\\wallRED.png", 250, "..\\Test\\BreakOut_figure\\fragRED.png");
	
	int floorNum;
	String path;
	int point;
	String fragPath;
	
	private WallColor(int floorNum, String path, int point, String fragPath) {
		this.floorNum = floorNum;
		this.path = path;
		this.point = point;
		this.fragPath = fragPath;
	}
}
