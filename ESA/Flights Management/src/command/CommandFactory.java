package command;

import database.Admin;
import database.Passenger;
import database.Risk;
import model.FlightHandler;
import model.PassengerHandler;
import model.PassengerRisk;
import model.RiskHandler;

public class CommandFactory
{

    public static final int VIEW_ALL_FLIGHT_LABELS = 1;
    public static final int ADD_PASSENGER = 2;
    public static final int VIEW_ALL_PASSENGERS = 3;
    public static final int VIEW_ALL_PASSENGERS_RISKS = 4;
    public static final int SEARCH_PASSENGERS_BY_SURNAME = 5;
    public static final int VIEW_SPECIFIC_PASSENGER = 6;
    public static final int SEARCH_PASSENGERS_BY_PASSPORT_NUM = 7;
    public static final int VIEW_ALL_PASSENGERS_RISKS_WITH_MIN = 8;
    public static final int GET_ALL_RISKS = 9;
    public static final int VIEW_ALL_PASSENGERS_RISKS_WITH_TYPE = 10;
    public static final int VIEW_FLIGHT = 11;
    public static final int GET_ALL_FLIGHT_NUMBERS = 12;
    public static final int LOGIN = 13;
    public static final int ADD_NEW_RISK = 14;
    public static final int CHECK_PASSENGERS_ON_FLIGHT = 15;
    public static final int GET_FLIGHTS_BY_MIN_RISK = 16;
    public static final int GET_ALL_FLIGHTS = 17;

    public static Command create(int typeOfCommand)
    {
        switch (typeOfCommand)
        {
            case VIEW_ALL_FLIGHT_LABELS:
                return new GetAllFlightLabels(new FlightHandler());
            case VIEW_ALL_PASSENGERS:
                return new ViewAllPassengersCommand(new PassengerHandler());
            case VIEW_ALL_PASSENGERS_RISKS:
                return new GetAllPassengersRisks_ByFlight(new PassengerRisk());
            case VIEW_SPECIFIC_PASSENGER:
                return new ViewSpecificPassengerCommand(new PassengerHandler());
            case GET_ALL_RISKS:
                return new GetAllRisksCommand(new PassengerRisk());
            case GET_ALL_FLIGHT_NUMBERS:
                return new GetAllFlightsNums(new FlightHandler());
            case GET_ALL_FLIGHTS:
                return new GetAllFlights(new FlightHandler());
            default:
                return null;
        }
    }

    public static Command create(int typeOfCommand, String string)
    {
        switch (typeOfCommand)
        {
            case SEARCH_PASSENGERS_BY_SURNAME:
                return new GetAllPassengersBySurnameCommand(new PassengerHandler(), string);
            default:
                return null;
        }
    }

    public static Command create(int typeOfCommand, Object object)
    {
        switch (typeOfCommand)
        {
            case LOGIN:
                return new LoginCommand((Admin) object);
            case ADD_NEW_RISK:
                return new AddRiskCommand(new RiskHandler(), (Risk) object);
            case ADD_PASSENGER:
                return new AddPassengerCommand(new PassengerHandler(), (Passenger) object);
            default:
                return null;
        }
    }

    public static Command create(int typeOfCommand, int integer)
    {
        switch (typeOfCommand)
        {
            case SEARCH_PASSENGERS_BY_PASSPORT_NUM:
                return new GetAllPassengersByPassportNumCommand(new PassengerHandler(), integer);
            case VIEW_ALL_PASSENGERS_RISKS_WITH_MIN:
                return new GetAllPassengersRisksWIthMin(new PassengerRisk(), integer);
            case VIEW_ALL_PASSENGERS_RISKS_WITH_TYPE:
                return new GetAllPassengersRisksWIthTypeCommand(new PassengerRisk(), integer);
            case VIEW_FLIGHT:
                return new GetAllFlightsStrings(new FlightHandler(), integer);
            case CHECK_PASSENGERS_ON_FLIGHT:
                return new ViewPassengersOnFlightCommand(new FlightHandler(), integer);
            case GET_FLIGHTS_BY_MIN_RISK:
                return new ViewFlightsByMinRiskCommand(new FlightHandler(), integer);
            default:
                return null;
        }
    }
}
