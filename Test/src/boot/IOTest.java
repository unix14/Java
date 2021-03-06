package boot;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import algorithms.io.MyCompressorOutputStream;
import algorithms.io.MyDecompressorInputStream;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MazeArgInit;

public class IOTest {

	public static void main(String[] args) {
		Maze3d maze = new Maze3d(new MazeArgInit(4, 2, 2));
		// save it to a file
		OutputStream out;
		try {
			out = new MyCompressorOutputStream(new FileOutputStream("1.maz"));
			out.write(maze.toByteArray());
			out.flush();
			out.close();
			InputStream in=new MyDecompressorInputStream(new FileInputStream("1.maz"));
			byte b[]=new byte[maze.toByteArray().length];
			in.read(b);
			in.close();
			Maze3d loaded=new Maze3d(b);
			System.out.println(loaded.equals(maze));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
