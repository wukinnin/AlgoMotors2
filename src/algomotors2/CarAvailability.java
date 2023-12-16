/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algomotors2;

/**
 *
 * @author nimpad
 */

public class CarAvailability {
    private boolean[] availability;
    private String[] rentedCarCustomers;

    public CarAvailability(int numCarTypes) {
        availability = new boolean[numCarTypes];
        rentedCarCustomers = new String[numCarTypes]; // Initialize the array for storing customer names

        // Initialize all cars as available
        for (int i = 0; i < numCarTypes; i++) {
            availability[i] = true;
        }
    }

    public boolean isCarAvailable(int carIndex) {
        if (carIndex >= 0 && carIndex < availability.length) {
            return availability[carIndex];
        } else {
            return false;
        }
    }
    
    private boolean isCorrectCustomer(int carIndex, String customerName) {
        return customerName.equals(rentedCarCustomers[carIndex]);
    }

    public void rentCar(int carIndex, String customerName) throws InvalidRentException {
        if (carIndex >= 0 && carIndex < availability.length && availability[carIndex]) {
            availability[carIndex] = false;
            rentedCarCustomers[carIndex] = customerName;
        } else {
            throw new InvalidRentException("Invalid rent: The selected car is not available.");
        }
    }

     public void returnCar(int carIndex, String customerName, String carModel) throws InvalidReturnException {
        if (carIndex >= 0 && carIndex < availability.length &&
            !availability[carIndex] && isCorrectCustomer(carIndex, customerName) && isCorrectCarModel(carIndex, carModel)) {
            availability[carIndex] = true;
            rentedCarCustomers[carIndex] = null;
        } else {
            throw new InvalidReturnException("Invalid return: The car cannot be returned.");
        }
    }

    private boolean isCorrectCarModel(int carIndex, String carModel) {
        String rentedModel = getCarModel(carIndex);
        return carModel.equals(rentedModel);
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
                return "";
        }
    }
}
