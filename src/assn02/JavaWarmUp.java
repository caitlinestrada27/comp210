package assn02;
import java.util.Scanner;
public class JavaWarmUp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] categoriesList = {"phone", "laptop", "smart_watch"};

        int n = s.nextInt(); // how many items will be entered into the database
        // Date Time1 Category Fee Quantity Time2 AsmCost inputs

        // Create corresponding size arrays
        String[] date = new String[n];
        String[] time1 = new String[n];
        String[] category = new String[n];
        double[] fee = new double[n];
        int[] quantity = new int[n];
        double[] time2 = new double[n];
        double[] asmCost = new double[n];

        // TODO: Fill in the above arrays with data entered from the console.
        for (int i = 0; i < n; i++) {
            date[i] = s.next();
            time1[i] = s.next();
            // TODO fill in the rest here
            category[i] = s.next();
            fee[i] = s.nextDouble();
            quantity[i] = s.nextInt();
            time2[i] = s.nextDouble();
            asmCost[i] = s.nextDouble();
        }

        // Find items with highest and lowest price per unit
        int highestItemIndex = getMaxPriceIndex(fee);
        int lowestItemIndex = getMinPriceIndex(fee);

        // TODO: Print items with highest and lowest price per unit.
        // make sure the format is correct!
        // Your code starts here:
        public int getMaxPriceIndex(int[] fee){
            int highest_price = 0;
            for (int i = 0; i < n; i++){
                if (fee[i] > highest_price){
                    highest_price = fee[i];
                }
            }
            return highest_price;
        }

        public int getMinPriceIndex(int[] fee){
            int lowest_price = fee[0];
            for (int i = 0; i < n; i++){
                if (fee[i] < lowest_price){
                    lowest_price = fee[i];
                }
            }
            return lowest_price;
        }
        // Your code ends here.

        // Calculate the # of batches, total Fee, total Quantity, total Labor and Assembly costs by category.
        // Maintain following category-wise total stats in the following Category Arrays
        int[] numOfBatchesC = new int[categoriesList.length];// so numOfBatchesC[0] = # of batches in category categoriesList[0]
        double[] totFeeC = new double[categoriesList.length]; // total fee of each category = sum(fee * qty)
        int[] totQuantityC = new int[categoriesList.length];    // total qty of each category = sum (qty)
        double[] totLaborCostC = new double[categoriesList.length]; // total labor cost of each category = sum(time2 x 16)
        double[] totAsmCostC = new double[categoriesList.length]; // total Assembly cost of each category = sum(AsmCost)

        // TODO: for each item i, incrementally total the values in the above arrays
        for (int i = 0; i < n; i++) {
            int catIndex = 0;
            // set the value of catIndex for each i to be such that category[i] == categoriesList[catIndex]
            // TODO: Your code for setting catIndex here
            category[i] = categoriesList[catIndex];
            // TODO: fill in rest of the Category arrays here
            fee[i] = totFeeC[catIndex];
            quantity[i] = totQuantityC[catIndex];
            asmCost[i] = toAsmCostC[catIndex];
        }

        // TODO: Calculate & Print Category-wise Statistics
        for (int j = 0; j < categoriesList.length; j++) {
            if (numOfBatchesC[j] > 0) {
                System.out.println( categoriesList[j]);
                // TODO: print the remaining stats

            }
        }
    }

    // TODO: Find index of item with the highest price per unit.
    static int getMaxPriceIndex(double[] priceT){
        // Your code starts here:
        return(0); // modify this as well
        // Your code ends here.
    }

    // TODO: Find index of item with the lowest price per unit.
    static int getMinPriceIndex(double[] priceT){
        // Your code starts here:
        return(0); // modify this as well
        // Your code ends here.
    }
}
