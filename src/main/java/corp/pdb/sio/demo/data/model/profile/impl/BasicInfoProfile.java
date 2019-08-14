package corp.pdb.sio.demo.data.model.profile.impl;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import corp.pdb.sio.demo.data.model.profile.Profile;
import corp.pdb.sio.demo.error.DataProfileMissingRequiredFieldException;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jaradat-pdb
 *
 */
@Document(collection = "profiles")
@EqualsAndHashCode
@Slf4j
public class BasicInfoProfile implements Profile, Serializable {
    private static final long serialVersionUID = 1L;
    private final transient SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
    private boolean bDateStringParseable = false;
    private Date bDate;
    private String fName;
    private String lName;
    private String mName;

    /**
     * 
     * @param fName
     * @param lName
     */
    public BasicInfoProfile(String fName, String lName) {
        this(fName, lName, "", "");
    }
    /**
     * 
     * @param fName
     * @param lName
     * @param mName
     */
    public BasicInfoProfile(String fName, String lName, String mName) {
        this(fName, lName, mName, "");
    }
    /**
     * 
     * @param fName
     * @param lName
     * @param mName
     * @param bDateString
     */
    public BasicInfoProfile(String fName, String lName, String mName, String bDateString) {
        try {
            Assert.hasText(fName, "fName variable null or contains only whitespace characters, user\'s first name must contain text");
            Assert.hasText(fName, "lName variable null or contains only whitespace characters, user\'s last name must contain text");
            
            this.fName = fName;
            this.lName = lName;
            if(StringUtils.isBlank(bDateString)) {
                this.bDate = new Date();
            } else {
                this.bDate = dateFormatter.parse(bDateString);
                bDateStringParseable = true;
            }
            
        } catch(ParseException e) {
            log.warn("Encountered a {} attempting to format [{}] into a Date", e.getClass().getSimpleName(), bDateString);
            log.error("{}\n{}", e.getMessage(), e);
            this.bDate = new Date();
            log.info("Set bDate for [{} {} {}] to {}", fName, mName, lName, bDate.toString());
            
        } catch(IllegalArgumentException e) {
            throw new DataProfileMissingRequiredFieldException(e.getMessage(), e);
        }
        
        if(!StringUtils.isBlank(mName)) {
            this.mName = mName;
        }
    }

    /**
     * @return the bDateStringParseable
     */
    public boolean isbDateStringParseable() {
        return bDateStringParseable;
    }
    /**
     * @param bDateStringParseable the bDateStringParseable to set
     */
    public void setbDateStringParseable(boolean bDateStringParseable) {
        this.bDateStringParseable = bDateStringParseable;
    }

    /**
     * @return the bDate
     */
    public Date getbDate() {
        return bDate;
    }
    /**
     * @param bDate the bDate to set
     */
    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }
    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }
    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return the mName
     */
    public String getmName() {
        return mName;
    }
    /**
     * @param mName the mName to set
     */
    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BasicInfoProfile [bDateStringParseable=").append(bDateStringParseable).append(", ");
        if (bDate != null)
            builder.append("bDate=").append(bDate).append(", ");
        if (fName != null)
            builder.append("fName=").append(fName).append(", ");
        if (lName != null)
            builder.append("lName=").append(lName).append(", ");
        if (mName != null)
            builder.append("mName=").append(mName);
        builder.append("]");
        return builder.toString();
    }
}
