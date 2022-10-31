package com.hillel.crm.repository;

import com.hillel.crm.entity.RecordsOfOrder;

import java.util.List;

public class RecordsOfOrderRepository extends BaseRepository<RecordsOfOrder> {

    private static final String HQL_LIST_SELECT_RECORDS_FROM_TODAY = """
            SELECT NEW RecordsOfOrder(x as product, cast(sum(quantityOfProduct) as integer) as quantityOfProduct )
            FROM Order o
            join o.recordsOfOrder r
            join r.product x
            where o.date=curdate()
            group by x.id""";

    public List<RecordsOfOrder> getAllRecordsFromCurDate() {
        return getListWithoutParameter(HQL_LIST_SELECT_RECORDS_FROM_TODAY, RecordsOfOrder.class);
    }
}
