package core.task_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;





public class Sorting {

    public static class Address {
        private String country;
        private String region;
        private String city;
        private String street;
        private String house;
        private String apartment;



        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getHouse() {
            return house;
        }

        public void setHouse(String house) {
            this.house = house;
        }

        public String getApartment() {
            return apartment;
        }

        public void setApartment(String apartment) {
            this.apartment = apartment;
        }

        public Address(String country, String region, String city, String street, String house, String apartment) {
            this.country = country;
            this.region = region;
            this.city = city;
            this.street = street;
            this.house = house;
            this.apartment = apartment;
        }

    }

    public static void main(String[] args) {


        List<Address> addresses = readAddressesFromFile("C:\\Users\\AndromedA\\IdeaProjects\\Tasks\\src\\main\\java\\core\\task_3\\addresses.txt");

      //  Collections.sort(addresses);
        Collections.sort(addresses, (a1, a2) -> {
            int countryCompare = a1.getCountry().compareTo(a2.getCountry());
            if (countryCompare != 0) {
                return countryCompare;
            }

            int regionCompare = a1.getRegion().compareTo(a2.getRegion());
            if (regionCompare != 0) {
                return regionCompare;
            }

            int cityCompare = a1.getCity().compareTo(a2.getCity());
            if (cityCompare != 0) {
                return cityCompare;
            }

            int streetCompare = a1.getStreet().compareTo(a2.getStreet());
            if (streetCompare != 0) {
                return streetCompare;
            }

            try {
                int house1 = Integer.parseInt(a1.getHouse().replaceAll("/.+", ""));
                int house2 = Integer.parseInt(a2.getHouse().replaceAll("/.+", ""));
                int houseCompare = Integer.compare(house1, house2);
                if (houseCompare != 0) {
                    return houseCompare;
                }
            } catch (NumberFormatException n) {
                String house1 = a1.getHouse();
                String house2 = a2.getHouse();
                int houseNumberCompare = house1.replaceAll("/.+", "").compareTo(house2.replaceAll("/.+", ""));
                if (houseNumberCompare != 0) {
                    return houseNumberCompare;
                }
            }



            return a1.getApartment().compareTo(a2.getApartment());
        });

        writeAddressesToFile("C:\\Users\\AndromedA\\IdeaProjects\\Tasks\\src\\main\\java\\core\\task_3\\sorted_addresses.txt", addresses);
    }

    private static List<Address> readAddressesFromFile(String filename) {
        List<Address> addresses = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {

                Address address = parseAddress(line);
                addresses.add(address);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return addresses;
    }

    private static Address parseAddress(String line) {

        String[] parts = line.split(", ");
        String country = parts[0].split(": ")[1];
        String region = parts[1].split(": ")[1];
        String city = parts[2].split(": ")[1];
        String street = parts[3].split(": ")[1];
        String house = parts[4].split(": ")[1];
        String apartment = parts[5].split(": ")[1];

        return new Address(country, region, city, street, house, apartment);
    }

    private static void writeAddressesToFile(String filename, List<Address> addresses) {
        try (PrintWriter writer = new

                PrintWriter(new FileWriter(filename))) {
            for (Address address : addresses) {

                writer.println("Страна: " + address.getCountry() + ", Субъект Федерации: " + address.getRegion() +
                        ", Город: " + address.getCity() + ", Улица: " + address.getStreet() +
                        ", Дом: " + address.getHouse() + ", Квартира: " + address.getApartment());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


