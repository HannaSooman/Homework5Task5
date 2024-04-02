package ee.ut.math.tvt.salessystem.dataobjects;

import ee.ut.math.tvt.salessystem.dao.InMemorySalesSystemDAO;
import org.junit.Test;
import static org.junit.Assert.*;
import ee.ut.math.tvt.salessystem.dataobjects.StockItem;

import java.util.List;

public class InMemoryMT {

    @Test
    public void testFindStockItems() {
        InMemorySalesSystemDAO dao = new InMemorySalesSystemDAO();
        List<StockItem> stockItems = dao.findStockItems();
        assertNotNull(stockItems);
        assertEquals(4, stockItems.size()); // Ensure correct number of stock items
    }

    @Test
    public void testFindStockItem() {
        InMemorySalesSystemDAO dao = new InMemorySalesSystemDAO();
        StockItem item = dao.findStockItem(1L);
        assertNotNull(item);
        assertEquals("Lays chips", item.getName()); // Ensure correct name of the item
    }

    @Test
    public void testSaveStockItem() {
        InMemorySalesSystemDAO dao = new InMemorySalesSystemDAO();
        StockItem stockItem = new StockItem(5L, "Test Item", "Test description", 10.0, 10);
        dao.saveStockItem(stockItem);
        StockItem retrievedItem = dao.findStockItem(5L);
        assertNotNull(retrievedItem);
        assertEquals("Test Item", retrievedItem.getName()); // Ensure the stock item was added
    }



}