package rs.mihajlojovanovic.spending.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity
public class EntryEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "entry_date")
    private Date entryDate;

    @ColumnInfo
    private double quantity;

    @ColumnInfo
    private double price;

    @ColumnInfo
    private Double distance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(@NonNull Date entryDate) {
        this.entryDate = entryDate;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
