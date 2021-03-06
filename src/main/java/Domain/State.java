package Domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Usuario on 12/01/2017.
 */
@Component
@Entity
@Table(name = "State")
final public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID: ",unique = true, nullable = false, insertable = false, updatable = false)
    private int sID;

    //@Column(name = "Date: ",length = 50)
    private String today;

    @ManyToOne
    @JoinColumn(name = "Country")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "Weather")
    private Weather Today;

    //@Column(name = "Name: ")
    private String name = "";

    //@Column(name = "Acronym:  ")
    private String abbr = "";

    //@Column(name = "Area: ")
    private int area = 0;

    //@Column(name = "Largest City: ")
    private String largest_city = "";

    //@Column(name = "Capital: ")
    private String capital = "";

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return this.abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public int getArea() {
        return this.area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getLargest_city() {
        return this.largest_city;
    }

    public void setLargest_city(String largest_city) {
        this.largest_city = largest_city;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public State(String date, int cID, String cName, String cAlpha2, String cAlpha3, int wTemp, int wMaxTemp, int wMinTemp,
                 String wDesc, int wWSpe, String wWDir, int wAHum, int wAPress, String wAVisibility,
                 String sName, String sAbbr, int sArea, String sLargest_city, String sCapital) {
        this.country = new Country(cID, cName, cAlpha2, cAlpha3);
        this.Today = new Weather(wTemp, wMaxTemp, wMinTemp, wDesc, wWSpe, wWDir, wAHum, wAPress, wAVisibility);
        //this._10Days = new Weather(wMaxTemp, wMinTemp, wDesc);
        this.name = sName;
        this.abbr = sAbbr;
        this.area = sArea;
        this.largest_city = sLargest_city;
        this.capital = sCapital;
        this.today = date;
    }

    public State(String sName, String sAbbr, int sArea, String sLargestCity, String sCapital){
        this.name = sName;
        this.abbr = sAbbr;
        this.area = sArea;
        this.largest_city = sLargestCity;
        this.capital = sCapital;
    }

    public State(){}

    public String toString() {
        return this.country.toString() + "\n" +"Name: " + this.name + "\nShort: " + this.abbr + "\nLargest City: " +
                this.largest_city + "\nCapital: " + this.capital + "\n" + this.Today.toString();
    }
}