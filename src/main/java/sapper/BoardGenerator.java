package sapper;
import sapper.MineNumberWinLose;

public class BoardGenerator{
		

	private Field[][] fields;
	
	public int sizeX, sizeY, numberOfMines;
	
	GameOptions gameOptions = new GameOptions(sizeX, sizeY, numberOfMines);
	
	public Field[][] randomizeMines() {
		int[][] mines = new int[gameOptions.sizeX][gameOptions.sizeY];
		int minesSet = 0;
		while (minesSet < gameOptions.numberOfMines) {
			int x = (int) (Math.random() * gameOptions.sizeX);
			int y = (int) (Math.random() * gameOptions.sizeY);
			if (mines[x][y] != 1) {
				mines[x][y] = 1;
				minesSet++;
			}
		}
		fillArray();
		setMines(mines);
		generateBoard();
		return fields;
	}

	private void fillArray() {
		fields = new Field[gameOptions.sizeX][gameOptions.sizeY];
		for (int i = 0; i < gameOptions.sizeX; i++) {
			for (int j = 0; j < gameOptions.sizeY; j++) {
				fields[i][j] = new NormalField();
			}
		}
	}

	private void setMines(int[][] mines) {
		for (int x = 0; x < mines.length; x++) {
			for (int y = 0; y < mines[0].length; y++) {
				if (mines[x][y] == 1) {
					fields[x][y] = new MineField();
				}
			}
		}
	}

	private void generateBoard() {
		for (int x = 0; x < gameOptions.sizeX; x++) {
			for (int y = 0; y < gameOptions.sizeY; y++) {
				int centerHorizontal = x;
				int centerVertical = y;
				int down = y - 1;
				int up = y + 1;
				int left = x - 1;
				int right = x + 1;
				boolean isThereBoardUp = (up < gameOptions.sizeY);
				boolean isThereBoardDown = (down > -1);
				boolean isThereBoardLeft = (left > -1);
				boolean isThereBoardRight = (right < gameOptions.sizeX);

				if (fields[centerHorizontal][centerVertical].getFieldStatus() == MineNumberWinLose.MINE) {
					if (isThereBoardLeft == true) {
						fields[left][centerVertical].increaseNearMinesNumber();
					}
					if (isThereBoardUp == true) {
						fields[centerHorizontal][up].increaseNearMinesNumber();
					}
					if (isThereBoardDown == true) {
						fields[centerHorizontal][down]
								.increaseNearMinesNumber();
					}
					if (isThereBoardRight == true) {
						fields[right][centerVertical].increaseNearMinesNumber();
					}
					if (isThereBoardLeft == true && isThereBoardUp == true) {
						fields[left][up].increaseNearMinesNumber();
					}
					if (isThereBoardRight == true && isThereBoardUp == true) {
						fields[right][up].increaseNearMinesNumber();
					}
					if (isThereBoardLeft == true && isThereBoardDown == true) {
						fields[left][down].increaseNearMinesNumber();
					}
					if (isThereBoardRight == true && isThereBoardDown == true) {
						fields[right][down].increaseNearMinesNumber();
					}
				}
			}
		}
	}
}
