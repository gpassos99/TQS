import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ExtendWith(MockitoExtension.class)
class StockPortfolioTest {

    @Mock IStockMarket mMarket;
    @InjectMocks StockPortfolio portfolio;

    @BeforeEach
    void setUp() {
        portfolio.setName("Moussa Marega");
    }

    @org.junit.jupiter.api.Test
    void getTotalValue() {
        portfolio.addStock(new Stock("Nvidia", 5));
        portfolio.addStock(new Stock("Apple", 10));
        Mockito.when(mMarket.getPrice("Nvidia")).thenReturn(100.0);
        Mockito.when(mMarket.getPrice("Apple")).thenReturn(150.0);

        double total = 5*100.0 + 10*150.0;
        //assertEquals(portfolio.getTotalValue(),total);
        assertThat(portfolio.getTotalValue(),is(total));

        Mockito.verify(mMarket, Mockito.times(2)).getPrice(Mockito.anyString());

    }
}