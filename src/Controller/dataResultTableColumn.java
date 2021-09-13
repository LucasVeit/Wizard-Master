package Controller;

import java.util.ArrayList;

public class dataResultTableColumn {
    private final ArrayList<String> columnNames;

    public dataResultTableColumn(ArrayList<String> columnNames) {
        this.columnNames = columnNames;
    }

    public int getNumColumns() {
        return columnNames.size();
    }

    public String getColumnName(int index) {
        return columnNames.get(index);
    }
}


