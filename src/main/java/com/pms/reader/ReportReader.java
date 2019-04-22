package com.pms.reader;

import com.pms.model.Report;
import java.util.List;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 *
 * @author Asu
 */
public class ReportReader implements ItemReader<Report> {

    private List<Report> items;
    private int count = 0;

    @Override
    public Report read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("count=" + getCount());
        if (getCount() < 3) {
            setCount(2);
            Report r = new Report();
            r.setId(System.nanoTime());
            return r;
        }
        return null;
    }

    /**
     * @return the items
     */
    public List<Report> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Report> items) {
        this.items = items;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

}
