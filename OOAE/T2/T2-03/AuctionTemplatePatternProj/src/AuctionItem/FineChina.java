package AuctionItem;

/**
 * Determines VAT and Commission rates for Fine China Calculates the cost a buyer
 * will pay, and the amount a seller will receive.
 *
 * @author Rhys Jones
 */
public class FineChina extends AuctionItem
{

    private final double VAT = 0.15;
    private final double commission = 0.2;

    /**
     * Constructs FineChina Object and sets the item description.
     *
     * @param description
     */
    public FineChina(String description)
    {
        super.description = description;
    }

    /**
     * Calculates the cost a buyer will pay for an item of Fine China after VAT.
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
     * Calculates the amount a seller will receive for an item of Fine China
     * after commission.
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
