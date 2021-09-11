package Controller;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class dataResultTableRow {
    private final ArrayList<ArrayList<Object>> data;

    public dataResultTableRow(ArrayList<ArrayList<Object>> data) {
        this.data = data;
    }

    public int getNumRows() {
        return data.size();
    }

    public Object getData(int row, int column) {
        return data.get(row).get(column);
    }
    public ArrayList<ArrayList<Object>> getData() {
        return data;
    }


}
