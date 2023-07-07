A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).

You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you are given an integer k, the maximum number of times you may perform the following operation:

Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.
  Solution:
  class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxFreq = 0;
        int i=0;
        Map<Character, Integer> charCount = new HashMap<>();
         for (int j = 0; j < answerKey.length(); j++) {
            char currentChar = answerKey.charAt(j);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
            maxFreq = Math.max(maxFreq, charCount.get(currentChar));

            if (j - i + 1 > maxFreq + k) {
                charCount.put(answerKey.charAt(i), charCount.get(answerKey.charAt(i)) - 1);
                i++;
            }
        }

        return answerKey.length() - i;
    }
}
