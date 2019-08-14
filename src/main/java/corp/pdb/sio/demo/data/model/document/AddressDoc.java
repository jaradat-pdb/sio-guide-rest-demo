package corp.pdb.sio.demo.model.data.document;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import lombok.EqualsAndHashCode;

/**
 * A document type model representation of an <code>ADDRESS</code>.
 * 
 * @author jaradat-pdb
 *
 */
@EqualsAndHashCode(callSuper = true)
@Document
public class AddressDoc extends BaseDoc {
    private String textAssertionErrorTemplate = "Text assertion of provided variable {%s} failed";
    private String buildingNumber;
    private String streetName;
    private String city;
    private String governate;
    private String country;
    private String postalCode;

    protected AddressDoc() {}

    /**
     * Creates a new {@link AddressDoc} from the given buildingNumber, streetName, city, and country.
     * 
     * @param buildingNumber
     * @param streetName
     * @param city
     * @param country
     */
    public AddressDoc(String buildingNumber, String streetName, String city, String country) {
        Assert.hasText(buildingNumber, String.format(textAssertionErrorTemplate, "buildingNumber"));
        Assert.hasText(streetName, String.format(textAssertionErrorTemplate, "streetName"));
        Assert.hasText(city, String.format(textAssertionErrorTemplate, "city"));
        Assert.hasText(country, String.format(textAssertionErrorTemplate, "country"));
        
        this.buildingNumber = buildingNumber;
        this.streetName = streetName;
        this.city = city;
        this.country = country;
    }
    /**
     * Creates a new {@link AddressDoc} from the given buildingNumber, streetName, city, country, and governate.
     * 
     * @param buildingNumber
     * @param streetName
     * @param city
     * @param country
     * @param governate
     */
    public AddressDoc(String buildingNumber, String streetName, String city, String country, String governate) {
        this(buildingNumber, streetName, city, country);
        
        if(!StringUtils.isEmpty(governate)) {
            Assert.hasText(governate, String.format(textAssertionErrorTemplate, "governate"));
            this.governate = governate;
        }
    }
    /**
     * Creates a new {@link AddressDoc} from the given buildingNumber, streetName, city, country, governate, and postalCode.
     * 
     * @param buildingNumber
     * @param streetName
     * @param city
     * @param country
     * @param governate
     */
    public AddressDoc(String buildingNumber, String streetName, String city, String country, String governate, String postalCode) {
        this(buildingNumber, streetName, city, country, governate);
        
        if(!StringUtils.isEmpty(postalCode)) {
            Assert.hasText(postalCode, String.format(textAssertionErrorTemplate, "postalCode"));
            this.governate = postalCode;
        }
    }

    /**
     * @return the buildingNumber
     */
    public String getBuildingNumber() {
        return buildingNumber;
    }
    /**
     * @param buildingNumber the buildingNumber to set
     */
    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }
    /**
     * @param streetName the streetName to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the governate
     */
    public String getGovernate() {
        return governate;
    }
    /**
     * @param governate the governate to set
     */
    public void setGovernate(String governate) {
        this.governate = governate;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }
    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }
    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
