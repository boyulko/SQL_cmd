package com.company.Command;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by yulia on 06.11.16.
 */
public interface Command {
    boolean shouldProcess(String command);
    void process(String command)throws SQLException, ClassNotFoundException;
}
