package org.dalol.semayweather.model;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 4/24/2016
 */
public class Country {

    private String countryName;
    private String countryCodeDigitTwo;
    private String countryCodeDigitThree;
    private String countryDialingCode;
    private int countryNumber;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCodeDigitTwo() {
        return countryCodeDigitTwo;
    }

    public void setCountryCodeDigitTwo(String countryCodeDigitTwo) {
        this.countryCodeDigitTwo = countryCodeDigitTwo;
    }

    public String getCountryCodeDigitThree() {
        return countryCodeDigitThree;
    }

    public void setCountryCodeDigitThree(String countryCodeDigitThree) {
        this.countryCodeDigitThree = countryCodeDigitThree;
    }

    public String getCountryDialingCode() {
        return countryDialingCode;
    }

    public void setCountryDialingCode(String countryDialingCode) {
        this.countryDialingCode = countryDialingCode;
    }

    public int getCountryNumber() {
        return countryNumber;
    }

    public void setCountryNumber(int countryNumber) {
        this.countryNumber = countryNumber;
    }
}
