package de.pojo;

import javax.persistence.*;

/**
 * Created by devnull on 17.01.17.
 */
@Entity
public class Firm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Symbol", nullable = false)
    private String symbol;
    @Column(name = "Name")
    private String name_s1;
    @Column(name = "Konzurn_5_Jahre")
    private String konzurn_s2;
    @Column(name = "Preis")
    private String price_s3;
    @Column(name = "Tiefstand_5_Jahre")
    private String tiefstand_s4;
    @Column(name = "Kriterium_3")
    private String kriterium3_s5;
    @Column(name = "Hochstand_5_Jahre")
    private String hochstand_s6;
    @Column(name = "Millionen")
    private String million_s7;
    @Column(name = "Durchschnittsdivende")
    private String durchschnittsdivende_s8;
    @Column(name = "Dividende")
    private String dividende_s9;
    @Column(name = "Dividende_kriterium_5")
    private String dividende_k5_s10;

    public String getName_s1() {
        return name_s1;
    }

    public void setName_s1(String name_s1) {
        this.name_s1 = name_s1;
    }

    public String getKonzurn_s2() {
        return konzurn_s2;
    }

    public void setKonzurn_s2(String konzurn_s2) {
        this.konzurn_s2 = konzurn_s2;
    }

    public String getPrice_s3() {
        return price_s3;
    }

    public void setPrice_s3(String price_s3) {
        this.price_s3 = price_s3;
    }

    public String getTiefstand_s4() {
        return tiefstand_s4;
    }

    public void setTiefstand_s4(String tiefstand_s4) {
        this.tiefstand_s4 = tiefstand_s4;
    }

    public String getKriterium3_s5() {
        return kriterium3_s5;
    }

    public void setKriterium3_s5(String kriterium3_s5) {
        this.kriterium3_s5 = kriterium3_s5;
    }

    public String getHochstand_s6() {
        return hochstand_s6;
    }

    public void setHochstand_s6(String hochstand_s6) {
        this.hochstand_s6 = hochstand_s6;
    }

    public String getMillion_s7() {
        return million_s7;
    }

    public void setMillion_s7(String million_s7) {
        this.million_s7 = million_s7;
    }

    public String getDurchschnittsdivende_s8() {
        return durchschnittsdivende_s8;
    }

    public void setDurchschnittsdivende_s8(String durchschnittsdivende_s8) {
        this.durchschnittsdivende_s8 = durchschnittsdivende_s8;
    }

    public String getDividende_s9() {
        return dividende_s9;
    }

    public void setDividende_s9(String dividende_s9) {
        this.dividende_s9 = dividende_s9;
    }

    public String getDividende_k5_s10() {
        return dividende_k5_s10;
    }

    public void setDividende_k5_s10(String dividende_k5_s10) {
        this.dividende_k5_s10 = dividende_k5_s10;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Firm() {
    }

    public Firm(String symbol) {
        this.symbol = symbol;
    }
}
