package csulb.cecs323.model;

/**
 * Individual, physical automobiles that someone can drive on land to transport one or more passengers
 * and a limited amount of cargo around.  Cars have four wheels and usually travel on paved roads.
 */
import org.eclipse.persistence.annotations.PrimaryKey;

import javax.persistence.*;

@Entity
public class Cars {
    /** The unique ID of the vehicle.  Limited to 17 characters. */
    @Id
    @Column(nullable = false, length = 17, unique = true)
    private String VIN;

    /** The name of the corporation which manufactured the vehicle.  Limited to 40 characters. */
    @Column(nullable = false, length = 40)
    private String manufacturer;

    /** The popular name of the vehicle, like the Prius for Toyota.  Limited to 20 characters. */
    @Column(nullable = false, length = 20)
    private String model;

    /** The year that the vehicle was manufactured.  For now, do not worry about validating this #. */
    @Column(nullable = false)
    private int model_year;

    @ManyToOne
    @JoinColumn(name = "auto_body_style_name", referencedColumnName = "name", nullable = false)
    private auto_body_styles auto_body_styles;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owners owner;

    public Cars (String VIN, String manufacturer, String model, int model_year) {
        this.setOwner(owner);
        this.setAuto_body_style(auto_body_styles);
        this.setVIN(VIN);
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setModel_year(model_year);
    }

    public Cars () {}

    public String getVIN() { return VIN; }

    public void setVIN(String VIN) { this.VIN = VIN; }

    public String getManufacturer() { return manufacturer; }

    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public int getModel_year() { return model_year; }

    public void setModel_year(int model_year) { this.model_year = model_year; }

    public Owners getOwner() { return owner; }

    public void setOwner(Owners owner) { this.owner = owner; }

    public auto_body_styles getAuto_body_style() { return auto_body_styles; }

    public void setAuto_body_style(auto_body_styles auto_body_style) { this.auto_body_styles = auto_body_style; }

    @Override
    public String toString () {
        return "Cars - VIN: " + this.VIN + " Manufacturer: " + this.manufacturer +
                " Model: " + this.model + " year: " + this.model_year;
    }
}
