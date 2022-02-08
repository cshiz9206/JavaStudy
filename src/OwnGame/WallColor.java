package OwnGame;

public enum WallColor {
	GRAY(1, "..\\JAVA_edu_Á¤½ÂÇö\\src\\OwnGame\\wallGRAY.png", 50, "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\OwnGame\\fragGRAY.png"),
	YELLOW(2, "..\\JAVA_edu_Á¤½ÂÇö\\src\\OwnGame\\wallYELLOW.png", 100, "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\OwnGame\\fragYELLOW.png"),
	GREEN(3, "..\\JAVA_edu_Á¤½ÂÇö\\src\\OwnGame\\wallGREEN.png", 150, "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\OwnGame\\fragGREEN.png"),
	ORANGE(4, "..\\JAVA_edu_Á¤½ÂÇö\\src\\OwnGame\\wallORANGE.png", 200, "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\OwnGame\\fragORANGE.png"),
	RED(5, "..\\JAVA_edu_Á¤½ÂÇö\\src\\OwnGame\\wallRED.png", 250, "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\OwnGame\\fragRED.png");
	
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
