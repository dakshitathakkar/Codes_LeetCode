class Spreadsheet {
    int[][] sheet;
    public Spreadsheet(int rows) {
        sheet = new int[26][rows+1];
    }
    
    public void setCell(String cell, int value) {
        sheet[cell.charAt(0)-'A'][Integer.parseInt(cell.substring(1))]  = value;
    }
    
    public void resetCell(String cell) {
        sheet[cell.charAt(0)-'A'][Integer.parseInt(cell.substring(1))]  = 0;
    }
    
    public int getValue(String formula) {
        int plusIdx = formula.indexOf('+');
                    System.out.println(plusIdx);

        int a = 0;
        System.out.println(formula.substring(1,plusIdx));
        if(formula.substring(1,plusIdx).matches("\\d+")){
            a = Integer.parseInt(formula.substring(1,plusIdx));
            System.out.println(a);
        }
        else{
           a = sheet[formula.charAt(1)-'A'][Integer.parseInt(formula.substring(2,plusIdx))];
            System.out.println(a);
        }

        int b = 0;
        if(formula.substring(plusIdx+1).matches("[0-9]+")){
            b = Integer.parseInt(formula.substring(plusIdx));
            System.out.println(b);
        }
        else{
            b = sheet[formula.charAt(plusIdx+1)-'A'][Integer.parseInt(formula.substring(plusIdx+2))];
        }

       
        
        return a+b;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */