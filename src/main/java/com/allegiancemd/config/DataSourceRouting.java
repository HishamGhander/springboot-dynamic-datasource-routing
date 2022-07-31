package com.allegiancemd.config;

import com.allegiancemd.constant.DatabaseEnum;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class DataSourceRouting extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDatabaseContext();
    }

    public void initDataSource(DataSource allegianceMd1, DataSource allegianceMd2) {
        Map<Object, Object> dataSourceMap = new HashMap<>();

        dataSourceMap.put(DatabaseEnum.ALLEGIANCEMD1, allegianceMd1);
        dataSourceMap.put(DatabaseEnum.ALLEGIANCEMD2, allegianceMd2);

        this.setTargetDataSources(dataSourceMap);
        this.setDefaultTargetDataSource(allegianceMd1);
    }
}
