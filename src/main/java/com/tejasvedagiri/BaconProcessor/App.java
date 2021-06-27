package com.tejasvedagiri.BaconProcessor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
        	List<String> lines = Files.readAllLines(Paths.get("metadata.csv"));
        	List<String> cmd = new ArrayList<>();
        	for(String line : lines) {
        		String[] a = line.split("\\|");
        		cmd.add("balcon.exe -t \"" + a[2].replace("\"", "'") + "\" -n ScanSoft -w " + a[0] + ".wav");
        		
        	}
        	for(String c:cmd) {
        		Process run = Runtime.getRuntime().exec(c);
        		int a = run.waitFor();
        		System.err.println("Completed " + c + " - " + a);
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
