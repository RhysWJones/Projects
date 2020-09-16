package AuctionItem;

/**
 * Template class dictating the required functionality of concrete implementations
 * @author Rhys Jones
 */
public abstract class AuctionItem
{
    
    private double hammerPrice;
    private double costBuyerPaid;
    private double amountSellerReceived;
    protected String description;
    
    public abstract double calculateCostBuyerPaid(double hammerPrice);
    public abstract double calculateAmountSellerReceived(double hammerPrice);
    
    public void auction(double hammerPrice)
    {
        this.hammerPrice = hammerPrice;
        this.costBuyerPaid = hammerPrice + calculateCostBuyerPaid(hammerPrice);
        this.amountSellerReceived = hammerPrice - calculateAmountSellerReceived(hammerPrice);
    }
    
    @Override
    public String toString()
    {
        return "Auction Item \n{" + "\n Hammer Price = " + hammerPrice + "\n Cost Buyer Paid = " + costBuyerPaid + "\n Amount Seller Received = " + amountSellerReceived + "\n Description = " + description + "\n}";
    }
}
