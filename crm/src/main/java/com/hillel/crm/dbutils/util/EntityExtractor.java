package com.hillel.crm.dbutils.util;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface EntityExtractor<T> {

    T extract(ResultSet rs) throws SQLException;

}
