package interviewProblems.Text_Justification;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>(), line = new ArrayList<>();
        int width = 0, spaces = 0, i = 0;

        while (i < words.length){
            if (line.size() >= 1 && width + words[i].length() + spaces + 1  <= maxWidth){
                line.add(words[i]);
                width += words[i].length();
                spaces += 1;

                if (i == words.length - 1){
                    result.add(justifyLine(line, width, maxWidth, true));
                }

                i++;
            }
            // Add a word to the line
            else if (line.size() == 0 && width + words[i].length() + spaces <= maxWidth){
                line.add(words[i]);
                width += words[i].length();

                if (i == words.length - 1){
                    result.add(justifyLine(line, width, maxWidth, true));
                }

                i++;
            }
            // Compute the justified line
            else {
                // Justify and add
                result.add(justifyLine(line, width, maxWidth, false));
                spaces = 0;
                width = 0;
                line = new ArrayList<>();
            }
        }

        return result;
    }

    private String justifyLine(List<String> words, int width, int maxWidth, boolean last){
        // Amount of spaces between words
        int spacesToFill = words.size() - 1;
        if (spacesToFill == 0) {
            return words.get(0) + nSpace(maxWidth - width);
        } else if (last) {
            StringBuffer buff = new StringBuffer(maxWidth);
            int index = 0;
            for (String word : words){
                buff.append(word);
                if (index < spacesToFill){
                    buff.append(" ");
                }
                index++;
            }
            if (maxWidth - spacesToFill - width > 0)
                buff.append(this.nSpace(maxWidth - spacesToFill - width));
            return buff.toString();
        } else {
            int[] spaceSizes = this.splitIntoParts(maxWidth - width, spacesToFill);
            StringBuffer buff = new StringBuffer(maxWidth);
            int index = 0;
            for (String word : words){
                buff.append(word);
                if (index < spacesToFill){
                    buff.append(this.nSpace(spaceSizes[index]));
                }
                index++;
            }
            return buff.toString();
        }

    }

    private String nSpace(int n){
        StringBuffer outputBuffer = new StringBuffer(n);
        for (int i = 0; i < n; i++){
            outputBuffer.append(" ");
        }
        return outputBuffer.toString();
    }

    private int[] splitIntoParts(int whole, int parts) {
        int[] arr = new int[parts];
        for (int i = 0; i < arr.length; i++)
            whole -= arr[i] = (whole + parts - i - 1) / (parts - i);
        return arr;
    }
}
