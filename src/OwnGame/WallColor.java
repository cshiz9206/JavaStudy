package OwnGame;

public enum WallColor {
	GRAY(1, "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\OwnGame\\wallGRAY.png", 50, "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\OwnGame\\fragGRAY.png"),
	YELLOW(2, "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\OwnGame\\wallYELLOW.png", 100, "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\OwnGame\\fragYELLOW.png"),
	GREEN(3, "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\OwnGame\\wallGREEN.png", 150, "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\OwnGame\\fragGREEN.png"),
	ORANGE(4, "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\OwnGame\\wallORANGE.png", 200, "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\OwnGame\\fragORANGE.png"),
	RED(5, "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\OwnGame\\wallRED.png", 250, "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\OwnGame\\fragRED.png");
	
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
