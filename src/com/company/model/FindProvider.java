package com.company.model;

import java.sql.SQLException;

/**
 * Created by yulia on 23.02.17.
 */
public class FindProvider {

    public String getSelectedTableName(String[] tableNames, String result, String[] parts, String selectedTableName) throws SQLException {
        FindProperties findProperties = new FindProperties();
        DatabasePropertiesProvider databasePropertiesProvider = new DatabasePropertiesProvider();
        for (String tableName : tableNames) {
            String expectedFirstCase = "find" + " " + tableName;
            if (result.equals(expectedFirstCase)) {
                selectedTableName = tableName;
                break;
            }

        }
        if(selectedTableName == null){
            selectedTableName = findProperties.getLimitOffset(tableNames, result, parts);
            if(selectedTableName == null){
                System.out.println("Can not find table with this name. Try again");
            }
            else {
                databasePropertiesProvider.getTableForView(selectedTableName);
            }
        }
        else {
            databasePropertiesProvider.getTableForView(selectedTableName);
        }
        return selectedTableName;
    }
}
