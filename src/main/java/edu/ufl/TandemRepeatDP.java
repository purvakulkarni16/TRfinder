package edu.ufl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TandemRepeatDP {

	static final int MATCH_SCORE = 1;

	public static void main(String[] args) {
		String sequences[] = {
				"tactatagaccttatgctgtaaacggtagttggctccactcgggaccgacgcgtagtatgtctgagtggtaatggcggtaaatcgcgaagagtcatgttggtacgcttgctttcctggcggagaccagacatacaggacttggaagttgcctcttttgatttcctcggcaatgacatgagacgaagaggacacgaatgggcgtcttaatagatcccgttcacccggcttatattagccgtgatgtaacaatgcgcggagactcagagatcactaaatggatggctgctttgggtttgaattgtgtagaagtgaaagtatgatacgtctctcaatgcacagaaatcttgagagtaccgaatcagtcctcctctgtagacctgatcaagcggcatcggtact",
				"ttgagagttttgctttacaagcaacaaggccagccgccgagtgagctttagtggaggtagacgcgtagcacagttgcttctcaccctcttgtcgtaatcgctgccgggcttgttagtgttccctctcgtggctcttgtattacaacgaacttttgtcggtcttccgcctattatacccagcttagccgtgggcactaaacttgttgagccaactaagcataagccgaaggggcagtgggtgactagtggcgagtgctcatactgtaattctctcgagacagcccgatacagaaattggacgcggaactcgtcctaatctattacgcgcggagacgagtctttgaagtaggagtcaatgtaaatgacgcttgaactgttccatccataactgaagggccgaatcagactgcaatagactttctgcgccggggtagctaaacaaccatgatctcgttcggtacgtccacgccaatgaccgattactgggttgggttggcgtgcttctaaacccacagtcccggcgaatagagcatacattatcatttcgcagacgctagcatattccatggcagatccccaaggtacgcttctacaaattta",
				"ctgccaagtccattgaccggttagttcagtcactaggggcatgtccattgacacgcgccgtcggtgcgagggagattggtggacaaacgggtgtgggcagaccgtcctgtcgattgtatgttgaggctttggagtgtctctcgtctatcctcccgggcgaatgtaatagaaacgtatcagggctccataattagatcgagattaatgcagcaccattgctccccagtacaatgtcgccaccgtgaattactgaccacccgctgttggcgcccctaaacattagcggtagagccggctatctgggcccccgcgactcatcacccatttttccccccgtaacatattctcgcactactaggttcgaactgaacgacaatagttgtgagccctcgacagtagggcaagcaaggtcttaggtagcatccagggatgtctagccaaaccccctaatgcccacaggacactaccgagcccaccttccgctgttagaacggcccaattttacgcctattgcacggttcatcacgtcgcatcgctaatagcgcgggtcgccccattgccgcaccgatatttatgcgtacctgtctatgcggtgtccgtcgtcatgttaatcgtcaggtctgcgcatctgttagttataccacgccttgacctcgaacgtcagattctgaacgttgatccgatccgcggtgatcagccgtccgctatcgaagagcctcccccggtacggtttgagagtaccagagtcagttggtcaaggctttgataccgaggcgtagttacggctcgctgccatctga",
				"ggtaggggttacctgttcacaggaagttaatttaaactaacagtaaacgggcaattcagctcgcaccaaggctagacagcgggccggagatgctgctgggaaaaaagtttgatgaggatgacgccctggaaatacgtcacattccataggaaacagctctctatagttcccgatacgacggatgacatagtgtagtttccaaacgttgaacaccatttttctgttctcgtggacttcagcatcagtttataacaagtggctatagttctgctcgccatcactggtgtagaagttaccattggactaatggtggacctattgagaccacaaattcccgctcatatgtggcccgagtgggccgtcctgtctaatctacatccatgcctaaagccccgttaagacgtgcagagtcgtcagaacggtttcgcccacattaaatttaagtgaggaaccggctttacttacaagtagtcttcgctctgcgatattaagtgtaccaagccgcgaatgcatatttctacaggtttgcccgcgttaacgtagagggcaggcctcccgtagtagtgatctaatggttcagcagttacggtacgccaaatacccatggtacgcgccaacgtgagtatgtattcaatgtgccgtgtccgtcaaggacctggacacagcaccttcatatgttctatgcttaagaaacaggtccagggcaatctggagcggtaaggtgttacaacttatatcgagcctatgtccggtatgaccttcaccagacttttcctgcaatcacataacacggagtttggcggatggttacttttcatcctcggatgtgttgccgctctggtgacaatggatctccaccatcagcggttctaacggtggagtggaagtgtcgttaagatacactcagttggcagcggtagatggctgctgacatttgtaaatgatcgatacttaagcaaggtggcatagcctgttcttagagctttagagcatagttatt",
				"agactatctatacggtgtcgatagggggagccagcgcccaaaggctggaaagggttggtatcaccgatggaggatgctagacaccttccgaacgcgtccaagtggtatggaaccgctgattactctcggctctgttgtcatcgtatatccgatacaatcatcgcggcgatgagcatctcatatacagatagttaagtacttggaaataatgtaggctcagtaaagaatcccaacacggggcatgttctgctactccgcacgtttgtatcggctacttctgactgaaggtacggacacatggtaatgctttgctaacaggtccgaaagttggggatattcagtgcacagacggtgtcctgctatgcaatccagtgcgtgtacctgggcttcatggtgcgtctagtaggaccactcaattgatgacaattacagacatatcacggggcacaaggacatccttaagattgcctggccatttctagctcatataagttacacgcaccaaccgtcatccggacatgccatgtggaacagagtgggtgtcagttaagtggcggaggccaattagaccgaggagatccggcctcgagcagagtagatcagcccgattgtaagtagtaaacaggttaagtcattgtgcgcaggcgcgccatccgatttcgcgcgcggaccaggaggaacaccgcgatacaccattaaattagatgttatcaaatctcgtactgacaggttcttttggcagtttgtacatgacatgtccaggccgatactcttttaaaatgggcagatatgcgtcccaaaggaaagtccgaatattcgcgcccgacgcgggggggaccaactgagtactacgttgattccaacatgcgccttaagaggcccagagcgttagcctacccgagtcgatgatggcccatagtttttcaagtgtcacggatgggctttcagcatggcccgtatagagttcattggatgttttcagccaaacgagttttgaggcgttacgggaaggccctttcacgcgtgtctagccccttcctggcatatggcgacggcaagacgtcattcttgcctctttgcgacgacaagtggggttaatgcagagttgattgacttacccaatgcggtcgtataacattcgttagaatctcgtcgtttctcttcaaggtggccacctattgaggttgtcctatgggaggg" };

		for (String s : sequences) {
			long start = System.nanoTime();
			generateTandemRepeats(s);
			System.out.println(s.length() + " - " + (System.nanoTime() - start));
		}
	}

	private static Set<String> generateTandemRepeats(String sequence) {
		HashSet<String> result = new HashSet<String>();

		int n = sequence.length();
		int[][] table = new int[n + 1][n + 1];
		int max = -1;

		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (sequence.charAt(j - 1) == sequence.charAt(i - 1)) {
					table[i][j] = table[i - 1][j - 1] + MATCH_SCORE;
				}

				if (table[i][j] > max) {
					max = table[i][j];
				}
			}
		}

		List<Location> locationList = findLocations(max, table);
		for (Location location : locationList) {
			result.add(backtrack(location, table, sequence));
		}

		return result;
	}

	private static List<Location> findLocations(int max, int[][] table) {
		List<Location> locationList = new ArrayList<Location>();

		for (int i = 0; i < table.length; i++) {
			for (int j = i + 1; j < table.length; j++) {
				if (table[i][j] == max) {
					locationList.add(new Location(i, j));
				}
			}
		}
		return locationList;
	}

	private static String backtrack(Location location, int[][] table, String sequence) {
		StringBuilder sb = new StringBuilder();
		int row = location.row;
		int col = location.col;

		while (table[row][col] > 0) {
			sb.append(sequence.charAt(row - 1));
			row--;
			col--;
		}

		return sb.reverse().toString();
	}

	static class Location {
		int row;
		int col;

		public Location(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

}
