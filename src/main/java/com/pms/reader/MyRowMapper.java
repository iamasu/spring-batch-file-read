package com.pms.reader;

import com.pms.model.Report;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Asu
 */
public class MyRowMapper implements RowMapper<Report> {

    @Override
    public Report mapRow(ResultSet rs, int i) throws SQLException {
        Report r = new Report();
        r.setId(rs.getLong("id"));
        r.setImpressions(rs.getString("impressions"));
        return r;
    }

}
