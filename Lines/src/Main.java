public class Main {
    public static void main(String[] args) {
        String testText[] = new String[10];
        testText[0] = "Given$a$text$file$of$many$lines";
        testText[1] = "where$fields$within$a$line$";
        testText[2] = "are$delineated$by$a$single$dollar$character";
        testText[3] = "write$a$progra";
        testText[4] = "that$aligns$each$column$of$fields";
        testText[5] = "by$ensuring$that$words$in$each$";
        testText[6] = "column$are$separated$by$at$least$one$space.";
        testText[7] = "Further,$allow$for$each$word$in$a$column$to$be$either$left$";
        testText[8] = "justified,$right$justified";
        testText[9] = "or$center$justified$within$its$column.";

        int[] max_lengths = new int[20];

// определяем максимальную длину каждого столбца
        for (String line : testText) {
            String[] fields = line.split("\\$");
            for (int i = 0; i < fields.length; i++) {
                if (max_lengths.length < i + 1) {
                    max_lengths[i] = fields[i].length();
                } else {
                    if (fields[i].length() > max_lengths[i]) {
                        max_lengths[i] = fields[i].length();
                    }
                }
            }
        }
// выравниваем каждый столбец
        for (String line : testText) {
            String[] fields = line.split("\\$");
            StringBuilder new_line = new StringBuilder();
            for (int i = 0; i < fields.length; i++) {
                if (i == 0) {
                    new_line.append(String.format("%-" + max_lengths[i] + "s", fields[i]));
                } else {
                    new_line.append(" ");
                    new_line.append(String.format("%-" + max_lengths[i] + "s", fields[i]));
                }
            }
            System.out.println(new_line.toString());
        }

    }
}
