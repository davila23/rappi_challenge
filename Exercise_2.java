package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import java.awt.Color;
import java.util.Map.Entry;

class Solution__ {

	public static List<String> closestColor(List<String> pixels) {

		List<String> closestColors = new ArrayList<String>();
		String col = "";

		// System.out.println("pixels" + pixels);

		Color black = Color.black;
		Color white = Color.white;
		Color red = Color.red;
		Color green = Color.green;
		Color blue = Color.blue;

		HashMap<String, Color> colors = new HashMap<String, Color>();
		colors.put("Black", black);
		colors.put("White", white);
		colors.put("Red", red);
		colors.put("Green", green);
		colors.put("Blue", blue);

		for (int i = 0; i < pixels.size(); i++) {

			double min = Double.MAX_VALUE;

			Integer R = Integer.parseInt(pixels.get(i).substring(0, 8), 2);
			Integer G = Integer.parseInt(pixels.get(i).substring(8, 16), 2);
			Integer B = Integer.parseInt(pixels.get(i).substring(16, 24), 2);

			System.out.println("R : " + R + " | " + "G : " + G + " | " + "B : " + B);

			for (Entry<String, Color> color : colors.entrySet()) {

				double distance = Math.sqrt(Math.pow(R - color.getValue().getRed(), 2)
						+ Math.pow(G - color.getValue().getGreen(), 2) + Math.pow(B - color.getValue().getBlue(), 2));

				System.out.println("------------------------------------------------");

				System.out.println("Distance color " + color.getKey() + " : " + distance);

				if (distance == min) {
					min = distance;
					col = "Ambiguous";

				} else if (distance < min) {
					min = distance;
					col = color.getKey();
				}

			}

			System.out.println("----  ----  ----  ----  ----  ----  ----  ----  ");

			System.out.println("Is closest to  : " + col);
			closestColors.add(col);

		}

		return closestColors;

	}
}

public class Exercise_2 {
	public static void main(String[] args) throws IOException {
		List<String> pixels = new ArrayList<String>();

		// pixels.add("101111010110011011100100");
		// pixels.add("110000010101011111101111");
		// pixels.add("100110101100111111101101");
		pixels.add("010111011010010110000011");
		pixels.add("000000001111111111111111");

		Solution__.closestColor(pixels);
	}
}
