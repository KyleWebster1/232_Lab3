/**
 * Created by kylewebster1 on 10/30/17.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AdjacencyMatrix {
    private Scanner reader;
    private Scanner labels;
    private int[][] adj;
    private int length;
    public  AdjacencyMatrix()
    {
        readFile();
        lineLength();
        readAdjacencyMatrix();
        printAdjacencyMatrix();
    }

    private void readFile()
    {
        try{
            reader = new Scanner(new File("adjacency_matrix.txt"));
            labels = new Scanner(new File("labels.txt"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void printAdjacencyMatrix()
    {
        for(int i = 0; i < length; i++)
        {
            for(int j = 0; j < length; j++)
            {
                    System.out.print(adj[i][j]);
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private void readAdjacencyMatrix()
    {
        adj = new int[length][length];
        try{
            while(reader.hasNext()) {
                String a = reader.next();
                String x = "";
                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < length; j++) {
                            adj[i][j] = Integer.valueOf(a);
                            a = reader.next();
                    }
                }
            }
        }catch (NoSuchElementException e){
        }
    }

    private void lineLength()
    {
        if(labels.hasNext()){
            String a = labels.nextLine();
            length = a.length();
            System.out.println(a);
        }
    }

    public int getLength()
    {
        return length;
    }
}
