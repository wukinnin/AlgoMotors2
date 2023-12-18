package algomotors2;

public class CarAvailability {

    // represent availabiity as true or false
    private boolean[] availability;
    // represent renters in a string array
    private String[] renters;

    // constructor
    public CarAvailability(int numCars) {
        // set availability
        availability = new boolean[numCars];
        // set renters
        renters = new String[numCars];

        // initialize all cars as available
        for (int i = 0; i < numCars; i++) {
            availability[i] = true;
        }
    }

    private String getCarModel(int carIndex) {
        switch (carIndex) {
            case 0:
                return "Vios";
            case 1:
                return "Avanza";
            case 2:
                return "Corolla";
            case 3:
                return "Innova";
            case 4:
                return "Hilux";
            case 5:
                return "Fortuner";
            default:
                return null;
        }
    }

    public boolean isCarAvailable(int carIndex) {
        // determine availability based on index
        if (carIndex >= 0 && carIndex < availability.length) {
            return availability[carIndex];
        } else {
            return false;
        }
    }

    private boolean isCorrectCustomer(int carIndex, String customerName) {
        // determine correctness based on index
        return customerName.equals(renters[carIndex]);
    }

    private boolean isCorrectCarModel(int carIndex, String carModel) {
        String rentedModel = getCarModel(carIndex);
        return carModel.equals(rentedModel);
    }

    public void rentCar(int carIndex, String name) throws InvalidRentException {
        if (carIndex >= 0 && carIndex < availability.length && availability[carIndex]) {
            // update availability to false and add name to renters
            availability[carIndex] = false;
            renters[carIndex] = name;
        } else {
            throw new InvalidRentException("Invalid rent: The selected car is not available.");
        }
    }

    public void returnCar(int carIndex, String customerName, String carModel) throws InvalidReturnException {
        if (carIndex >= 0 && carIndex < availability.length
                && !availability[carIndex] && isCorrectCustomer(carIndex, customerName)
                && isCorrectCarModel(carIndex, carModel)) {
            // update availability to true and remove name in renters
            availability[carIndex] = true;
            renters[carIndex] = null;
        } else {
            throw new InvalidReturnException("Invalid return: The car cannot be returned.");
        }
    }

}
