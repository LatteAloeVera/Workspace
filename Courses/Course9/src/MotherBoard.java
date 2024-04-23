/**
 * MotherBoard
 */
public class MotherBoard {

    private String model;
    private String manufacturer;
    private int ramSlots;
    private int cardSlots;
    private String bios;

    public MotherBoard(String model, String manufacturer, int ramSlots, int cardSlots, String bios) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }

    // static nested class
    public static class USB {
        int usb2Slots;
        int usb3Slots;
        int usbCSlots;

        public USB(int usb2Slots, int usb3Slots, int usbCSlots) {
            this.usb2Slots = usb2Slots;
            this.usb3Slots = usb3Slots;
            this.usbCSlots = usbCSlots;
        }

        public void connect() {
            System.out.println("USB is now connected...");
        }
    }

    public void loadProgram(String programName) {
        System.out.println("Program " + programName + " is now loading...");
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getRamSlots() {
        return ramSlots;
    }

    public int getCardSlots() {
        return cardSlots;
    }

    public String getBios() {
        return bios;
    }
}