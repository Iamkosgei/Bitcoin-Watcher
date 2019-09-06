package me.kosgei.BitcoinSms.model;

public class Data
{
    private int id;

    private String amount;

    private String currency;

    private String base;

    public String getAmount ()
    {
        return amount;
    }

    public void setAmount (String amount)
    {
        this.amount = amount;
    }

    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    public String getBase ()
    {
        return base;
    }

    public void setBase (String base)
    {
        this.base = base;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [amount = "+amount+", currency = "+currency+", base = "+base+"]";
    }
}