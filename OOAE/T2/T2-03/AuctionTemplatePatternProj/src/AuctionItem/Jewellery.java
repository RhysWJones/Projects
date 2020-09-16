package AuctionItem;

/**
 * Determines VAT and Commission rates for Jewellery and calculates the cost a
 * buyer will pay, and the amount a seller will receive.
 * @author Rhys Jones
 */
public class Jewellery extends AuctionItem
{

    private final double VAT = 0.2;
    private final double commission = 0.25;
    
    /**
     * Constructs Jewellery Object and sets the item description.
     *
     * @param description
     */
    public Jewellery(String description)
    {
        super.description = description;
    }

    /**
     * Calculates the cost a buyer will pay for an item of Jewellery after VAT.
     *
     * @param hammerPrice
     * @return
     */
    @Override
    public double calculateCostBuyerPaid(double hammerPrice)
    {
        return (hammerPrice * VAT);
    }

    /**
     * Calculates the amount a seller will receive for an item of Jewellery after
     * commission.
     *
     * @param hammerPrice
     * @return
     */
    @Override
    public double calculateAmountSellerReceived(double hammerPrice)
    {
        return (hammerPrice * commission);
    }
}
