package de.serviceImpl;

import de.pojo.Firm;
import de.repository.FirmRepository;
import de.service.FirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 * Created by devnull on 17.01.17.
 */
@Service
public class FirmServiceImpl implements FirmService {

    @Autowired
    private FirmRepository firmRepository;

    @Override
    public void save(Firm firm) {
        firmRepository.save(firm);
    }

    @Override
    public Firm findOne(long id) {
        return firmRepository.findOne(id);
    }

    @Override
    public List<Firm> findAll() {
        return firmRepository.findAll();
    }

    @Override
    public void delete(long id) {
        firmRepository.delete(id);
    }

    @Override
    public void updateData() throws IOException {
        List<Firm> firms = findAll();
        for (Firm firm :
                firms) {
            try {
                updateSpalte1(firm);
            } catch (Exception e) {
                firm.setName_s1("n/a");
            }
            try {
                updateSpalte2(firm);
            } catch (Exception e) {
                firm.setKonzurn_s2("n/a");
            }
            try {
                updateSpalte3(firm);
            } catch (Exception e) {
                firm.setPrice_s3("n/a");
            }
            try {
                updateSpalte4(firm);
            } catch (Exception e) {
                firm.setTiefstand_s4("n/a");
            }
            try {
                updateSpalte6(firm);
            } catch (Exception e) {
                firm.setHochstand_s6("n/a");
            }
            try {
                updateSpalte5(firm);
            } catch (Exception e) {
                firm.setKriterium3_s5("n/a");
            }
            try {
                updateSpalte7(firm);
            } catch (Exception e) {
                firm.setMillion_s7("n/a");
            }
            try {
                updateSpalte8(firm);
            } catch (Exception e) {
                firm.setDurchschnittsdivende_s8("n/a");
            }
            try {
                updateSpalte9(firm);
            } catch (Exception e) {
                firm.setDividende_s9("n/a");
                e.printStackTrace();
            }
            try {
                updateSpalte10(firm);
            } catch (Exception e) {
                e.printStackTrace();
                firm.setDividende_k5_s10("n/a");
            }
            firmRepository.save(firm);
        }

    }

    private void updateSpalte1(Firm firm) throws IOException {
        Stock stock = YahooFinance.get(firm.getSymbol());
        firm.setName_s1(stock.getName());
    }

    private void updateSpalte2(Firm firm) throws IOException {
        Stock stock = YahooFinance.get(firm.getSymbol());
        int result = 0, year = Calendar.getInstance().get(Calendar.YEAR)-1, loopExit = 20;
        for(int i = 0; i < 5; i++){
            BigDecimal end, begin;
            Calendar period = Calendar.getInstance();
            period.set(year, 11, 1);
            try{
                end = stock.getHistory(period, period, Interval.DAILY).get(0).getOpen();
                period.set(year, 1, 1);
                begin = stock.getHistory(period, period, Interval.DAILY).get(0).getOpen();
                result += end.compareTo(begin);
            }catch (Exception e){
                e.printStackTrace();
                loopExit--;
                if(loopExit>0){
                    i--;
                }else{
                    break;
                }
            }
            year--;
        }
        if (result > 0) {
            result = 1;
        } else if (result < 0) {
            result = -1;
        }
        System.out.println(result);
        firm.setKonzurn_s2("" + result);
    }

    private void updateSpalte3(Firm firm) throws IOException {
        Stock stock = YahooFinance.get(firm.getSymbol());
        firm.setPrice_s3(""+stock.getQuote(true).getPrice());
        firmRepository.save(firm);
    }

    private void updateSpalte4(Firm firm) throws IOException {
        Stock stock = YahooFinance.get(firm.getSymbol());
        firm.setTiefstand_s4(""+stock.getQuote().getYearLow());
        firmRepository.save(firm);
    }

    private void updateSpalte5(Firm firm) throws IOException {
        Stock stock = YahooFinance.get(firm.getSymbol());
        Double temp6 = Double.parseDouble(firm.getHochstand_s6()),
                temp3 = Double.parseDouble(firm.getPrice_s3());
        firm.setKriterium3_s5(""+temp6/temp3);
        firmRepository.save(firm);
    }

    private void updateSpalte6(Firm firm) throws IOException {
        Stock stock = YahooFinance.get(firm.getSymbol());
        firm.setHochstand_s6(""+stock.getQuote().getYearHigh());
        firmRepository.save(firm);
    }

    private void updateSpalte7(Firm firm) throws IOException {
        Stock stock = YahooFinance.get(firm.getSymbol());
        firm.setMillion_s7(""+stock.getStats(true).getMarketCap().divide(new BigDecimal(1000000)));
        firmRepository.save(firm);
    }

    private void updateSpalte8(Firm firm) throws IOException {
        Stock stock = YahooFinance.get(firm.getSymbol());
        BigDecimal result = new BigDecimal(0);
        int year = Calendar.getInstance().get(Calendar.YEAR)-1, loopExit = 20;
        for(int i = 0; i < 5; i++){
            BigDecimal dividend;
            Calendar period = Calendar.getInstance();
            period.set(year, 11, 1);
            try{
                period.set(year, 1, 1);
                dividend = stock.getHistory(period, period, Interval.DAILY).get(0).getOpen();
                result =  result.add(dividend);
            }catch (Exception e){
                e.printStackTrace();
                loopExit--;
                if(loopExit>0){
                    i--;
                }else{
                    break;
                }
            }
            year--;
        }
        firm.setDurchschnittsdivende_s8(""+Double.parseDouble(result.toString())/5);
        firmRepository.save(firm);
    }

    private void updateSpalte9(Firm firm) throws IOException {
        double result = 10000/Double.parseDouble(firm.getKriterium3_s5());
        result /= Double.parseDouble(firm.getDurchschnittsdivende_s8());
        firm.setDividende_s9(""+result);
        firmRepository.save(firm);
    }

    private void updateSpalte10(Firm firm) throws IOException {
        double x = 700/Double.parseDouble(firm.getDurchschnittsdivende_s8());
        firm.setDividende_k5_s10(""+10000/x);
        firmRepository.save(firm);
    }

    @Override
    public List<Firm> getKriterium1() {
        return firmRepository.getKriterium1();
    }

    @Override
    public List<Firm> getKriterium2() {
        return firmRepository.getKriterium2();
    }

    @Override
    public List<Firm> getKriterium3() {
        return firmRepository.getKriterium3();
    }

    @Override
    public List<Firm> getKriterium5() {
        return firmRepository.getKriterium5();
    }
}
