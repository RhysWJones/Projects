package AuctionItem;

/**
 * Determines VAT and Commission rates for Painting and calculates the cost a
 buyer will pay, and the amount a seller will receive.
 *
 * @author Rhys Jones
 */
public class Painting extends AuctionItem
{

    private final double VAT = 0.0;
    private final double commission = 0.4;
    
    /**
     * Constructs Painting Object and sets the item description.
     *
     * @param description
     */
    public Painting(String description)
    {
        super.description = description;
    }
    
    /**
     * Calculates the cost a buyer will pay for a painting after VAT.
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
     * Calculates the amount a seller will receive for a Painting after
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
