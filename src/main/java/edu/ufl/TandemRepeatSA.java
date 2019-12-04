package edu.ufl;
import java.util.Arrays;

public class TandemRepeatSA {

	public static void main(String[] args) {
		String sequences[] = {
				"tactatagaccttatgctgtaaacggtagttggctccactcgggaccgacgcgtagtatgtctgagtggtaatggcggtaaatcgcgaagagtcatgttggtacgcttgctttcctggcggagaccagacatacaggacttggaagttgcctcttttgatttcctcggcaatgacatgagacgaagaggacacgaatgggcgtcttaatagatcccgttcacccggcttatattagccgtgatgtaacaatgcgcggagactcagagatcactaaatggatggctgctttgggtttgaattgtgtagaagtgaaagtatgatacgtctctcaatgcacagaaatcttgagagtaccgaatcagtcctcctctgtagacctgatcaagcggcatcggtact",
				"ttgagagttttgctttacaagcaacaaggccagccgccgagtgagctttagtggaggtagacgcgtagcacagttgcttctcaccctcttgtcgtaatcgctgccgggcttgttagtgttccctctcgtggctcttgtattacaacgaacttttgtcggtcttccgcctattatacccagcttagccgtgggcactaaacttgttgagccaactaagcataagccgaaggggcagtgggtgactagtggcgagtgctcatactgtaattctctcgagacagcccgatacagaaattggacgcggaactcgtcctaatctattacgcgcggagacgagtctttgaagtaggagtcaatgtaaatgacgcttgaactgttccatccataactgaagggccgaatcagactgcaatagactttctgcgccggggtagctaaacaaccatgatctcgttcggtacgtccacgccaatgaccgattactgggttgggttggcgtgcttctaaacccacagtcccggcgaatagagcatacattatcatttcgcagacgctagcatattccatggcagatccccaaggtacgcttctacaaattta",
				"ctgccaagtccattgaccggttagttcagtcactaggggcatgtccattgacacgcgccgtcggtgcgagggagattggtggacaaacgggtgtgggcagaccgtcctgtcgattgtatgttgaggctttggagtgtctctcgtctatcctcccgggcgaatgtaatagaaacgtatcagggctccataattagatcgagattaatgcagcaccattgctccccagtacaatgtcgccaccgtgaattactgaccacccgctgttggcgcccctaaacattagcggtagagccggctatctgggcccccgcgactcatcacccatttttccccccgtaacatattctcgcactactaggttcgaactgaacgacaatagttgtgagccctcgacagtagggcaagcaaggtcttaggtagcatccagggatgtctagccaaaccccctaatgcccacaggacactaccgagcccaccttccgctgttagaacggcccaattttacgcctattgcacggttcatcacgtcgcatcgctaatagcgcgggtcgccccattgccgcaccgatatttatgcgtacctgtctatgcggtgtccgtcgtcatgttaatcgtcaggtctgcgcatctgttagttataccacgccttgacctcgaacgtcagattctgaacgttgatccgatccgcggtgatcagccgtccgctatcgaagagcctcccccggtacggtttgagagtaccagagtcagttggtcaaggctttgataccgaggcgtagttacggctcgctgccatctga",
				"ggtaggggttacctgttcacaggaagttaatttaaactaacagtaaacgggcaattcagctcgcaccaaggctagacagcgggccggagatgctgctgggaaaaaagtttgatgaggatgacgccctggaaatacgtcacattccataggaaacagctctctatagttcccgatacgacggatgacatagtgtagtttccaaacgttgaacaccatttttctgttctcgtggacttcagcatcagtttataacaagtggctatagttctgctcgccatcactggtgtagaagttaccattggactaatggtggacctattgagaccacaaattcccgctcatatgtggcccgagtgggccgtcctgtctaatctacatccatgcctaaagccccgttaagacgtgcagagtcgtcagaacggtttcgcccacattaaatttaagtgaggaaccggctttacttacaagtagtcttcgctctgcgatattaagtgtaccaagccgcgaatgcatatttctacaggtttgcccgcgttaacgtagagggcaggcctcccgtagtagtgatctaatggttcagcagttacggtacgccaaatacccatggtacgcgccaacgtgagtatgtattcaatgtgccgtgtccgtcaaggacctggacacagcaccttcatatgttctatgcttaagaaacaggtccagggcaatctggagcggtaaggtgttacaacttatatcgagcctatgtccggtatgaccttcaccagacttttcctgcaatcacataacacggagtttggcggatggttacttttcatcctcggatgtgttgccgctctggtgacaatggatctccaccatcagcggttctaacggtggagtggaagtgtcgttaagatacactcagttggcagcggtagatggctgctgacatttgtaaatgatcgatacttaagcaaggtggcatagcctgttcttagagctttagagcatagttatt",
				"agactatctatacggtgtcgatagggggagccagcgcccaaaggctggaaagggttggtatcaccgatggaggatgctagacaccttccgaacgcgtccaagtggtatggaaccgctgattactctcggctctgttgtcatcgtatatccgatacaatcatcgcggcgatgagcatctcatatacagatagttaagtacttggaaataatgtaggctcagtaaagaatcccaacacggggcatgttctgctactccgcacgtttgtatcggctacttctgactgaaggtacggacacatggtaatgctttgctaacaggtccgaaagttggggatattcagtgcacagacggtgtcctgctatgcaatccagtgcgtgtacctgggcttcatggtgcgtctagtaggaccactcaattgatgacaattacagacatatcacggggcacaaggacatccttaagattgcctggccatttctagctcatataagttacacgcaccaaccgtcatccggacatgccatgtggaacagagtgggtgtcagttaagtggcggaggccaattagaccgaggagatccggcctcgagcagagtagatcagcccgattgtaagtagtaaacaggttaagtcattgtgcgcaggcgcgccatccgatttcgcgcgcggaccaggaggaacaccgcgatacaccattaaattagatgttatcaaatctcgtactgacaggttcttttggcagtttgtacatgacatgtccaggccgatactcttttaaaatgggcagatatgcgtcccaaaggaaagtccgaatattcgcgcccgacgcgggggggaccaactgagtactacgttgattccaacatgcgccttaagaggcccagagcgttagcctacccgagtcgatgatggcccatagtttttcaagtgtcacggatgggctttcagcatggcccgtatagagttcattggatgttttcagccaaacgagttttgaggcgttacgggaaggccctttcacgcgtgtctagccccttcctggcatatggcgacggcaagacgtcattcttgcctctttgcgacgacaagtggggttaatgcagagttgattgacttacccaatgcggtcgtataacattcgttagaatctcgtcgtttctcttcaaggtggccacctattgaggttgtcctatgggaggg" };

		for (String s : sequences) {
			long start = System.nanoTime();
			processSequence(s);
			System.out.println(s.length() + " - " + (System.nanoTime() - start));
		}
	}

	public static String processSequence(String sequence) {
		String[] suffixArray = generateSuffixArray(sequence);
		String result = new String();
		int maxLength = 0;
		for (int i = 1; i < suffixArray.length; i++) {
			String match = findMaxSubstring(suffixArray[i - 1], suffixArray[i]);
			if (match.length() > maxLength) {
				result = match;
				maxLength = match.length();
			}
		}
		return result;
	}

	public static String[] generateSuffixArray(String sequence) {
		String[] suffixArray = new String[sequence.length()];

		for (int i = sequence.length() - 1; i >= 0; i--) {
			suffixArray[i] = sequence.substring(i, sequence.length());
		}
		Arrays.sort(suffixArray);
		return suffixArray;
	}

	public static String findMaxSubstring(String base, String match) {
		int i = 0;
		for (int j = 0; i < base.length() && j < match.length() && base.charAt(i) == match.charAt(j);) {
			i++;
			j++;
		}
		return base.substring(0, i);
	}

}
